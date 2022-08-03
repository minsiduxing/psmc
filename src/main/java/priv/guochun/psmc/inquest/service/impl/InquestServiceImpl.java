package priv.guochun.psmc.inquest.service.impl;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.web.bind.annotation.RequestBody;
import priv.guochun.psmc.authentication.login.model.User;
import priv.guochun.psmc.authentication.login.service.LoginService;
import priv.guochun.psmc.authentication.user.model.TabAccount;
import priv.guochun.psmc.authentication.user.model.TabPerson;
import priv.guochun.psmc.authentication.user.service.TabAccountService;
import priv.guochun.psmc.inquest.model.TabYcInquestRecord;
import priv.guochun.psmc.inquest.model.TabYcStage;
import priv.guochun.psmc.inquest.model.TabYcWaitQueueCfg;
import priv.guochun.psmc.inquest.model.vo.TabYcInquestItemCfgVO;
import priv.guochun.psmc.inquest.service.AccessTokenService;
import priv.guochun.psmc.inquest.service.InquestService;
import priv.guochun.psmc.inquest.service.TabYcWaitQueueCfgService;
import priv.guochun.psmc.inquest.utils.HttpConnectUtil;
import priv.guochun.psmc.inquest.utils.ResultInfo;
import priv.guochun.psmc.system.common.dict.service.TabDataDictService;
import priv.guochun.psmc.system.enums.AccountLockEnum;
import priv.guochun.psmc.system.enums.AccountTypeEnum;
import priv.guochun.psmc.system.framework.cache.CacheContants;
import priv.guochun.psmc.system.framework.cache.PsmcCacheFactory;
import priv.guochun.psmc.system.framework.util.MySpringApplicationContext;
import priv.guochun.psmc.system.util.UUIDGenerator;
import priv.guochun.psmc.website.backstage.common.BaseDao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 勘验服务
 *
 * @author wangtao
 * @date 2022/5/24
 */
public class InquestServiceImpl implements InquestService {
    protected static final Logger logger  = LoggerFactory.getLogger(InquestServiceImpl.class);
    @Autowired
    private TabAccountService tabAccountService;
    @Autowired
    private LoginService loginService;
    @Autowired
    private AccessTokenService accessTokenService;
    @Autowired
    private BaseDao baseDao;
    @Autowired
    private TabDataDictService tabDataDictService;
    @Autowired
    private TabYcWaitQueueCfgService tabYcWaitQueueCfgService;

    @Override
    public ResultInfo getPhoneNo(String code) {
        Map<String, String> queryMap = new HashMap<>();
        PsmcCacheFactory psmcCacheFactory = (PsmcCacheFactory) MySpringApplicationContext.getObject("psmcCacheFactory");
        Cache cache = psmcCacheFactory.getCacheSysKeyInfo();
        Map<String, String> map = cache.get(CacheContants.CACHE_SYSTEM_KEY_INFO_KEY, Map.class);
        String wx_appid =map.get("wx_appid").toString();
        String wx_secret =map.get("wx_secret").toString();
        String url =map.get("wx_getuserphonenumber_url").toString()+"?access_token="+accessTokenService.getAccessToken(wx_appid, wx_secret);

        queryMap.put("code", code);
        String result = HttpConnectUtil.postJson(url, queryMap);
        logger.info("微信小程序getPhoneNo参数：wx_appid="+wx_appid+" wx_secret="+wx_secret+" url="+url+" 结果result="+result);
        JSONObject resultObj = (JSONObject)JSONObject.parse(result);
        if (resultObj != null && resultObj.getIntValue("errcode") == 0){
            return ResultInfo.ok("手机号获取成功", resultObj.get("phone_info"));
        }
        return ResultInfo.error("手机号获取失败");
    }

    @Override
    public ResultInfo codeToSession(String js_code, String mobile) {
        User user = null;
        Map<String, String> queryMap = new HashMap<>();
        PsmcCacheFactory psmcCacheFactory = (PsmcCacheFactory) MySpringApplicationContext.getObject("psmcCacheFactory");
        Cache cache = psmcCacheFactory.getCacheSysKeyInfo();
        Map<String, String> map = cache.get(CacheContants.CACHE_SYSTEM_KEY_INFO_KEY, Map.class);
        String wx_appid =map.get("wx_appid").toString();
        String wx_secret =map.get("wx_secret").toString();
        String wx_grant_type =map.get("wx_grant_type").toString();
        String url =map.get("wx_jscode2session_url").toString();

        queryMap.put("appid", wx_appid);
        queryMap.put("secret", wx_secret);
        queryMap.put("js_code", js_code);
        queryMap.put("grant_type", wx_grant_type);
        String result = HttpConnectUtil.get(url, queryMap);
        logger.info("微信小程序codeToSession参数：appid="+wx_appid+" js_code="+js_code+" url="+url+" 结果result="+result);
        JSONObject resultObj = (JSONObject)JSONObject.parse(result);
        if (resultObj != null && resultObj.getIntValue("errcode") == 0){
            String openId = resultObj.getString("openid");
            String session_key = resultObj.getString("session_key");
            String unionid = resultObj.getString("unionid");
            user = executeLogin(openId, mobile, unionid);
            return ResultInfo.ok("登录成功", user);
        }
        return ResultInfo.error("登录失败");

    }

    @Override
    public ResultInfo findInquestItemList(TabYcInquestItemCfgVO tabYcInquestItemCfgVO){
        List<TabYcInquestItemCfgVO> list = baseDao.queryForList("findInquestItemList", tabYcInquestItemCfgVO);
        return ResultInfo.ok("查询成功", list);
    }

    @Override
    public ResultInfo selectStageList(@RequestBody TabYcStage stage){
        List<TabYcStage> list = baseDao.queryForList("selectStageList", stage);
        return ResultInfo.ok("查询成功", list);
    }

    @Override
    public ResultInfo saveOrUpdateInquestRecord(@RequestBody TabYcInquestRecord record){
        if (StringUtils.isBlank(record.getRecordUuid())){
            record.setRecordUuid(UUIDGenerator.createUUID());
            record.setCreateTime(new Date());
            record.setModifyTime(new Date());
            baseDao.insert("insertInquestRecord", record);
        }else {
            record.setModifyTime(new Date());
            baseDao.update("updateInquestRecord", record);
        }
        return ResultInfo.ok("保存成功",record);
    }

    @Override
    public ResultInfo getDictInfo(String dictNo){
        List<Map<?,?>> list = tabDataDictService.getDictDataList(dictNo, null);
        return ResultInfo.ok("查询成功", list);
    }

    @Override
    public ResultInfo selectInquestRecord(String openid) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("userId", openid);
        List<TabYcInquestRecord> list = baseDao.queryForList("selectInquestRecord", paramMap);
        return ResultInfo.ok("查询成功", list);
    }

    @Override
    public ResultInfo selectWaitQueueCfgList(String orgCode){
        List<TabYcWaitQueueCfg> list = tabYcWaitQueueCfgService.selectWaitQueueCfgList(orgCode);
        return ResultInfo.ok("查询成功", list);
    }

    public User executeLogin(String openId, String mobile, String unionid) {
        User user = null;
        Map map = tabAccountService.getTabAccount(openId);
        if (map == null) {
            PsmcCacheFactory psmcCacheFactory = (PsmcCacheFactory) MySpringApplicationContext.getObject("psmcCacheFactory");
            Cache cache = psmcCacheFactory.getCacheSysKeyInfo();
            Map<String, String> cacheMap = cache.get(CacheContants.CACHE_SYSTEM_KEY_INFO_KEY, Map.class);
            String default_pass =cacheMap.get("default_pass").toString();
            String default_city =cacheMap.get("default_city").toString();
            String default_groupid =cacheMap.get("default_groupid").toString();
            String default_roleid =cacheMap.get("default_roleid").toString();

            TabAccount account = new TabAccount();
            account.setUuid(openId);
            account.setAccountName(mobile);
            account.setAccountPass(default_pass);
            account.setIsLocked(AccountLockEnum.NO_LOCKED.getValue().toString());
            account.setAccountType(AccountTypeEnum.WECHAT_USER.getValue().intValue());

            TabPerson person = new TabPerson();
            person.setUuid(openId);
            person.setPersonName(openId);
            person.setTelephone(mobile);
            person.setAccUuid(account.getUuid());
            person.setCityId(default_city);
            person.setGroupid(default_groupid);
            person.setEmail(openId);

            boolean flag = tabAccountService.register(account, person, default_roleid);
            user = loginService.buildUserByPhone(mobile,AccountTypeEnum.WECHAT_USER.getValue().intValue());
        } else {
            user = loginService.buildUser(map.get("ACCOUNT_NAME").toString());
        }
        return user;
    }

}
