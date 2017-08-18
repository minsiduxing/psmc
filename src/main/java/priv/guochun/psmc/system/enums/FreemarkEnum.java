package priv.guochun.psmc.system.enums;

public enum FreemarkEnum {
	//ftl 版本
	FREEMARKER_VERSIONNO("FREEMARKER_VERSIONNO","2.3.23"),
	//ftl模板路径
	FTL_PATH("FTL_PATH","/ftl");
	private String name;
	private String value;
	
	private FreemarkEnum(String name,String value){
		this.name=name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
}
