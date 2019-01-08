package priv.guochun.psmc.website.backstage.common.realNameAuth;

public interface RealNameAuthService {

	/**
	 * 实名认证
	 * @param name
	 * @param idCard
	 * @return
	 */
	public String realNameAuth(String name, String idCard);
}
