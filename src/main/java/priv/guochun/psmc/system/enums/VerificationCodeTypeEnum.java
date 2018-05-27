package priv.guochun.psmc.system.enums;

/**
 * 验证码的分类，主要是不同功能使用验证码进行区分的用处
 * @author guochun
 *
 */
public enum VerificationCodeTypeEnum {
	
	VCODE_REGISTER("注册功能",1),
	VCODE_LOGIN("登录",2);

	private String name;
	private Integer value;
	
	private VerificationCodeTypeEnum(String name,Integer value){
		this.name=name;
		this.value = value;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getValue() {
		return value;
	}
	public void setValue(Integer value) {
		this.value = value;
	}
	
}
