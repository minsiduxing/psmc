package priv.guochun.psmc.inquest.service.impl;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.Cache;
import priv.guochun.psmc.inquest.service.AccessTokenService;
import priv.guochun.psmc.inquest.utils.HttpConnectUtil;
import priv.guochun.psmc.system.framework.cache.CacheContants;
import priv.guochun.psmc.system.framework.cache.PsmcCacheFactory;
import priv.guochun.psmc.system.framework.util.MySpringApplicationContext;

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
    protected static final Logger logger  = LoggerFactory.getLogger(AccessTokenServiceImpl.class);
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
                PsmcCacheFactory psmcCacheFactory = (PsmcCacheFactory) MySpringApplicationContext.getObject("psmcCacheFactory");
                Cache cache = psmcCacheFactory.getCacheSysKeyInfo();
                Map<String, String> map = cache.get(CacheContants.CACHE_SYSTEM_KEY_INFO_KEY, Map.class);
                String url =map.get("wx_getAccessToken_url").toString();
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
