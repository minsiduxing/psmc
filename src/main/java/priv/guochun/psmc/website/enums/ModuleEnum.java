package priv.guochun.psmc.website.enums;

public enum ModuleEnum {
	//未发布
	NOT_RELEASE("NOT_RELEASE","2"),
	//已发布 
	IS_RELEASEED("IS_RELEASEED","1"),
	//禁止发布
	BAN_RELEASEED("BAN_RELEASEED", "3"),
	//未审核
	NOT_AUDITED("NOT_AUDITED","2"),
	//	审核通过
    AUDITED_PASS("AUDITED_PASS","1"),
    //审核未通过
    AUDITED_NOT_PASS("AUDITED_NOT_PASS","3"),
    //模块一级分类-新闻
    ONE_LEVEL_CLASSIFY_NEWS("ONE_LEVEL_CLASSIFY_NEWS","1"),
    // 模块一级分类-微课程
    ONE_LEVEL_CLASSIFY_MICRO_COURSES("ONE_LEVEL_CLASSIFY_MICRO_COURSES","2"),
    //模块一级分类-视频
    ONE_LEVEL_CLASSIFY_VIDEO("ONE_LEVEL_CLASSIFY_VIDEO","3"),
    //模块二级分类-热点新闻
    TOW_LEVEL_HOT_NEWS("TOW_LEVEL_HOT_NEWS","1"),
    //模块二级分类-实时资讯
    TOW_LEVEL_QUOTATION_INFOMATION("TOW_LEVEL_QUOTATION_INFOMATION","2"),
    //模块二级分类-行业动向
    TOW_LEVEL_LATES_TRENDS("TOW_LEVEL_LATES_TRENDS","3"),
    //模块二级分类-行业动向
    TOW_LEVEL_MEMBER_INFORMATION("TOW_LEVEL_MEMBER INFORMATION","4"),
    //部门分类
    DEPT_TYPE_1("创新工作室","1"),
    DEPT_TYPE_2("文体协会","2"),
    ;

	private String name;
	private String value;
	private ModuleEnum(String name,String value){
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
