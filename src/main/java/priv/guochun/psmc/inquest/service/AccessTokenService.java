package priv.guochun.psmc.inquest.service;

/**
 * 获取accessToken
 *
 * @author wangtao
 * @date 2022/5/25
 */
public interface AccessTokenService {

    String getAccessToken(String appid, String appSecret);
}
