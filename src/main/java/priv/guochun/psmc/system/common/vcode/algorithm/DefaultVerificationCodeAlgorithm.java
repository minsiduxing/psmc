package priv.guochun.psmc.system.common.vcode.algorithm;


/**
 * 缺省验证码生成算法
 * @author guochun
 *
 */
public class DefaultVerificationCodeAlgorithm implements VerificationCodeAlgorithmInte {

	@Override
	public String generateCode() {
		return String.valueOf((int)((Math.random()*9+1)*100000));
	}

	public static void main(String[] args){
		System.out.println(new DefaultVerificationCodeAlgorithm().generateCode());
	}
	
}
