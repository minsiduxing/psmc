package priv.guochun.psmc.system.common.vcode.service;

import priv.guochun.psmc.system.common.vcode.model.TabVerificationCode;
import priv.guochun.psmc.system.framework.model.MsgModel;

/**
 * 系统短信验证码
 * @author guochun
 *
 */
public interface VerificationCodeService {

	/**
	 * 生成验证码  如果存在未使用的验证码,则优先使用
	 * @param type
	 * @return
	 */
	public TabVerificationCode createCode(long type,String phone);
	
	
	/**
	 * 校验验证码
	 * remark:调用该方法如果验证码验证成功，该验证码状态则变更为已使用状态，二次验证将不通过
	 * @param code
	 * @param type
	 * @return
	 */
	public MsgModel validateCode(String code,long type);
	
	
	/** 
	 * 校验验证码 state不为空，则将状态重置为该值,否则,只验证不更新验证码状态
 	 * @param code
	 * @param type
	 * @param state 
	 * @return
	 */
	public MsgModel validateCode(String code,long type,Long state);
	
	/**
	 * 删除一条短信验证码
	 * @param uuid
	 * @return
	 */
	public void deleteCode(String uuid);
}
