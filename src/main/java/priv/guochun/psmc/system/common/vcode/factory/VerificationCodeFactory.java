package priv.guochun.psmc.system.common.vcode.factory;

import priv.guochun.psmc.system.common.vcode.algorithm.DefaultVerificationCodeAlgorithm;
import priv.guochun.psmc.system.common.vcode.algorithm.VerificationCodeAlgorithmInte;


public class VerificationCodeFactory {

	
	private static VerificationCodeFactory factory =  new VerificationCodeFactory();
	private VerificationCodeAlgorithmInte algorithmInte = null; 
	
	private VerificationCodeFactory(){
		algorithmInte = new DefaultVerificationCodeAlgorithm();
	}
	
	public synchronized String getCode(){
		return algorithmInte.generateCode();
	}
	
	
	public static VerificationCodeFactory getInstance(){
			return factory;
	}


	public void setAlgorithmInte(VerificationCodeAlgorithmInte algorithmInte) {
		this.algorithmInte = algorithmInte;
	}
	
	
	
}
