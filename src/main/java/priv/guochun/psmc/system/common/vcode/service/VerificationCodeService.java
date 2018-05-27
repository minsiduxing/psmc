package priv.guochun.psmc.system.common.vcode.service;

import priv.guochun.psmc.system.framework.model.MsgModel;

/**
 * 系统短信验证码
 * @author guochun
 *
 */
public interface VerificationCodeService {

	/**
	 * 生成验证码
	 * @param type
	 * @return
	 */
	public String createCode(long type,String customerIp);
	
	
	/**
	 * 校验验证码
	 * remark:调用该方法如果验证码验证成功，该验证码状态则变更为失效状态，二次验证将不通过
	 * @param code
	 * @param type
	 * @return
	 */
	public MsgModel validateCode(String code,long type);
}
