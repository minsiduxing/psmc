package priv.guochun.psmc.website.backstage.report.enums;

/**
 * <p>Title: report 的状态枚举</p>
 * <p>Description:</p>
 *
 * @author <a href="mailTo:bingxuewulei@outlook.com">wanglei</a>
 * @version 1.0
 * @history: Created by wanglei on  2018/6/12
 */
public enum ReportEnum {
    REPORT_STAUS_WAIT_REPLY("待回复","2"),
    REPORT_STAUS_REPLY("已回复","1"),
	REPORT_STAUS_SUBMIT("已提交","6");

    private  ReportEnum(String name, String value) {
        this.name = name;
        this.value = value;
    }

    private String name;
    private String value;

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
