package priv.guochun.psmc.website.enums;

public enum ModelEnum {
	//未审核
	NOT_AUDITED("NOT_AUDITED","0"),
	//	审核通过
    AUDITED_PASS("AUDITED_PASS","1"),
    //审核未通过
    AUDITED_NOT_PASS("AUDITED_NOT_PASS","2"),
    //模块一级分类-新闻
    ONE_LEVEL_CLASSIFY_NEWS("ONE_LEVEL_CLASSIFY_NEWS","1"),
    // 模块一级分类-微课程
    ONE_LEVEL_CLASSIFY_MICRO_COURSES("ONE_LEVEL_CLASSIFY_MICRO_COURSES","2"),
    //模块一级分类-视频
    ONE_LEVEL_CLASSIFY_VIDEO("ONE_LEVEL_CLASSIFY_VIDEO","3"),
    //模块二级分类-公司新闻
    TOW_LEVEL_COMPANY_NEWS("TOW_LEVEL_COMPANY_NEWS","1"),
    //模块二级分类-行情资讯
    TOW_LEVEL_QUOTATION_INFOMATION("TOW_LEVEL_QUOTATION_INFOMATION","2")
    ;

	private String name;
	private String value;
	private ModelEnum(String name,String value){
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
