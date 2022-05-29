package priv.guochun.psmc.inquest.service.impl;

import com.alibaba.fastjson.JSONObject;
import priv.guochun.psmc.inquest.service.AccessTokenService;
import priv.guochun.psmc.inquest.utils.HttpConnectUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 微信获取accessToken工具类
 *
 * @author wangtao
 * @date 2022/5/24
 */
public class AccessTokenServiceImpl implements AccessTokenService {

    protected volatile String accessToken;
    protected volatile long expiresTime;
    protected Lock accessTokenLock;

    public AccessTokenServiceImpl(){
        this.accessTokenLock = new ReentrantLock();
    }

    /**
     * 获取accessToken
     * @return
     */
    @Override
    public String getAccessToken(String appid, String appSecret) {
        Lock lock = this.accessTokenLock;
        lock.lock();
        try {
            if (this.isAccessTokenExpired()) {
                String url = "https://api.weixin.qq.com/cgi-bin/token";
                Map<String, String> queryMap = new HashMap<>();
                queryMap.put("grant_type", "client_credential");
                queryMap.put("appid", appid);
                queryMap.put("secret", appSecret);
                String result = HttpConnectUtil.get(url,  queryMap);
                JSONObject resultObj = (JSONObject)JSONObject.parse(result);

                if (resultObj != null && resultObj.getIntValue("errcode") == 0) {
                    this.updateAccessToken(resultObj.getString("access_token"), resultObj.getIntValue("expires_in"));
                }
            }
        }
        finally {
            lock.unlock();
        }
        return this.accessToken;
    }

    /**
     * 更新accessToken
     * @param accessToken
     * @param expiresInSeconds
     */
    public synchronized void updateAccessToken(String accessToken, int expiresInSeconds) {
        this.accessToken = accessToken;
        this.expiresTime = System.currentTimeMillis() + (expiresInSeconds - 200) * 1000L;
    }

    public boolean isAccessTokenExpired() {
        return System.currentTimeMillis() > this.expiresTime;
    }
}
