package priv.guochun.psmc.inquest.service.impl;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import priv.guochun.psmc.authentication.login.model.User;
import priv.guochun.psmc.authentication.login.service.LoginService;
import priv.guochun.psmc.authentication.role.service.TabRoleService;
import priv.guochun.psmc.authentication.user.model.TabAccount;
import priv.guochun.psmc.authentication.user.model.TabPerson;
import priv.guochun.psmc.authentication.user.service.TabAccountService;
import priv.guochun.psmc.authentication.user.service.TabPersonService;
import priv.guochun.psmc.inquest.model.TabYcInquestRecord;
import priv.guochun.psmc.inquest.model.TabYcStage;
import priv.guochun.psmc.inquest.model.vo.TabYcInquestItemCfgVO;
import priv.guochun.psmc.inquest.service.AccessTokenService;
import priv.guochun.psmc.inquest.service.InquestService;
import priv.guochun.psmc.inquest.utils.HttpConnectUtil;
import priv.guochun.psmc.inquest.utils.ResultInfo;
import priv.guochun.psmc.system.common.dict.service.TabDataDictService;
import priv.guochun.psmc.system.enums.AccountLockEnum;
import priv.guochun.psmc.system.util.UUIDGenerator;
import priv.guochun.psmc.website.backstage.common.BaseDao;

import javax.ws.rs.FormParam;
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

    private final static String APP_ID = "wx62223ebfa5229efc";
    private final static String APP_SECRET = "f501a3d21e670c6ba8bdf095df1ee94e";

    @Autowired
    private TabAccountService tabAccountService;
    @Autowired
    private TabPersonService tabPersonService;
    @Autowired
    private TabRoleService tabRoleService;
    @Autowired
    private LoginService loginService;
    @Autowired
    private AccessTokenService accessTokenService;
    @Autowired
    private BaseDao baseDao;
    @Autowired
    private TabDataDictService tabDataDictService;

    @Override
    public ResultInfo getPhoneNo(String code) {
        Map<String, String> queryMap = new HashMap<>();
        queryMap.put("access_token", accessTokenService.getAccessToken(APP_ID, APP_SECRET));
        queryMap.put("code", code);
        String url = "https://api.weixin.qq.com/wxa/business/getuserphonenumber";
        String result = HttpConnectUtil.post(url, queryMap);
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
        queryMap.put("appid", APP_ID);
        queryMap.put("secret", APP_SECRET);
        queryMap.put("js_code", js_code);
        queryMap.put("grant_type", "authorization_code");
        String url = "https://api.weixin.qq.com/sns/jscode2session";
        String result = HttpConnectUtil.get(url, queryMap);
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


    public User executeLogin(String openId, String mobile, String unionid) {
        User user = null;
        Map map = tabAccountService.getTabAccount(openId, null);
        if (map == null) {
            TabAccount account = new TabAccount();
            account.setUuid(openId);
            account.setAccountName(mobile);
            account.setAccountPass("123456");
            account.setIsLocked(AccountLockEnum.NO_LOCKED.getValue().toString());

            TabPerson person = new TabPerson();
            person.setUuid(openId);
            person.setPersonName(unionid);
            person.setTelephone(mobile);
            person.setAccUuid(account.getUuid());
            person.setCity("00");
            person.setGroupid("10000");
            tabAccountService.register(account, person, "e8d791272c7e437c8f8a72355bb0c231");
            tabPersonService.saveOrUpdate(person);
            Map tabRole = tabRoleService.getTabRole("e8d791272c7e437c8f8a72355bb0c231");
            user = new User(JSONObject.parseObject(JSONObject.toJSONString(account), Map.class), JSONObject.parseObject(JSONObject.toJSONString(person), Map.class), tabRole);
        } else {
            user = loginService.buildUser(openId);
        }
        return user;
    }

}
