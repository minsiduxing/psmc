package priv.guochun.psmc.inquest.controller;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import priv.guochun.psmc.authentication.login.model.User;
import priv.guochun.psmc.authentication.login.service.LoginService;
import priv.guochun.psmc.authentication.role.service.TabRoleService;
import priv.guochun.psmc.authentication.user.model.TabAccount;
import priv.guochun.psmc.authentication.user.model.TabPerson;
import priv.guochun.psmc.authentication.user.service.TabAccountService;
import priv.guochun.psmc.authentication.user.service.TabPersonService;
import priv.guochun.psmc.inquest.utils.ResultInfo;
import priv.guochun.psmc.system.enums.AccountLockEnum;
import priv.guochun.psmc.system.framework.controller.MyController;
import priv.guochun.psmc.system.util.UUIDGenerator;
import priv.guochun.psmc.website.backstage.util.HttpUtils;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * 微信控制类
 *
 * @author wangtao
 * @date 2022/5/22
 */
@RestController
@RequestMapping("/wechat/wechatController")
public class WechatController extends MyController {

    @Autowired
    private TabAccountService tabAccountService;
    @Autowired
    private TabPersonService tabPersonService;
    @Autowired
    private TabRoleService tabRoleService;
    @Autowired
    private LoginService loginService;

    /**
     * 小程序获取手机号
     * @param access_token
     * @param code
     * @return
     * @throws Exception
     */
    @RequestMapping(params="method=getPhoneNo")
    public ResultInfo getPhoneNo(String access_token, String code) throws Exception{
        Map<String, String> queryMap = new HashMap<>();
        queryMap.put("access_token", access_token);
        queryMap.put("code", code);
        String url = "https://api.weixin.qq.com/wxa/business/getuserphonenumber";
        HttpResponse response = HttpUtils.postForm(url, queryMap);
        String result = EntityUtils.toString(response.getEntity());
        JSONObject resultObj = (JSONObject)JSONObject.parse(result);
        return ResultInfo.ok(resultObj.getString("errmsg"), resultObj.get("phone_info"));
    }

    /**
     * 小程序登录
     * @param appid
     * @param secret
     * @param js_code
     * @throws Exception
     */
    @RequestMapping("/codeToSession")
    public ResultInfo codeToSession(String appid, String secret, String js_code) throws Exception {
        Map<String, String> queryMap = new HashMap<>();
        queryMap.put("appid", appid);
        queryMap.put("secret", secret);
        queryMap.put("js_code", js_code);
        queryMap.put("grant_type", "authorization_code");
        String url = "https://api.weixin.qq.com/sns/jscode2session";
        HttpResponse response = HttpUtils.doGet(url, null, null, new HashMap<>(), null);
        String result = EntityUtils.toString(response.getEntity());
        JSONObject resultObj = (JSONObject)JSONObject.parse(result);
        if (resultObj.getIntValue("errcode") != 0){
            String openId = resultObj.getString("openid");
            String session_key = resultObj.getString("session_key");
            String unionid = resultObj.getString("unionid");
        }
        return ResultInfo.ok("操作成功", resultObj);
    }

    public void wechatLogin(String openId, String mobile){
        User user = null;
        Map map = tabAccountService.getTabAccount(openId, null);
        if (map == null){
            TabAccount account = new TabAccount();
            account.setUuid(UUIDGenerator.createUUID());
            account.setAccountName(openId);
            account.setAccountPass("123456");
            account.setIsLocked(AccountLockEnum.NO_LOCKED.getValue().toString());

            TabPerson person = new TabPerson();
            person.setUuid(UUIDGenerator.createUUID());
            person.setPersonName("");
            person.setTelephone(mobile);
            person.setAccUuid(account.getUuid());
            person.setCity("00");
            person.setGroupid("10000");
            tabPersonService.saveOrUpdate(person);
            tabAccountService.register(account, person, "e8d791272c7e437c8f8a72355bb0c231");
            Map tabRole = tabRoleService.getTabRole("e8d791272c7e437c8f8a72355bb0c231");
            user = new User(JSONObject.parseObject(JSONObject.toJSONString(account), Map.class), JSONObject.parseObject(JSONObject.toJSONString(person), Map.class), tabRole);
        }else {
            user = loginService.buildUser(openId);
        }
        // 登录
        HttpSession httpSession = this.request().getSession();
        httpSession.setAttribute("user",user);
        ServletContext application = httpSession.getServletContext();
        Map<String,HttpSession> sessions = (HashMap<String,HttpSession>)application.getAttribute("sessions");
        if(null == sessions){
            sessions = new HashMap<String,HttpSession>();
        }
        sessions.put(httpSession.getId(), httpSession);
        application.setAttribute("sessions", sessions);
        //获取集合的大小即（在线人数）
        int sessionsNum =sessions.size();
        application.setAttribute("sessionsNum", sessionsNum);
    }

}
