package priv.guochun.psmc.website.enums;

public enum ModelEnum {
	//未审核
	NOT_AUDITED("NOT_AUDITED",0),
	//	审核通过
    AUDITED_PASS("AUDITED_PASS",1),
    //审核未通过
    AUDITED_NOT_PASS("AUDITED_NOT_PASS",2),
    ONE_LECEL_CLASSIFY_NEWS("ONE_LECEL_CLASSIFY_NEWS",1),
    ONE_LEVEL_CLASSIFY_MICRO_COURSES("ONE_LEVEL_CLASSIFY_MICRO_COURSES",2),
    ONE_LECEL_CLASSIFY_VIDEO("ONE_LECEL_CLASSIFY_VIDEO",3)
    ;

	private String name;
	private Integer value;
	private ModelEnum(String name,Integer value){
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
