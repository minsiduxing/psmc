package priv.guochun.psmc.system.common.explain.model;

/**
 * 功能描述
 * @author Administrator
 *
 */
public class TabFunctionExplain {
	/**
	 * uuid
	 */
    private String explainUuid;
    /**
     * 功能编码
     */
    private String functionCode;
    /**
     * 功能名称
     */
    private String functionName;
    /**
     * 描述内容
     */
    private String expainContent;

    public String getExplainUuid() {
        return explainUuid;
    }

    public void setExplainUuid(String explainUuid) {
        this.explainUuid = explainUuid == null ? null : explainUuid.trim();
    }

    public String getFunctionCode() {
        return functionCode;
    }

    public void setFunctionCode(String functionCode) {
        this.functionCode = functionCode == null ? null : functionCode.trim();
    }

    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName == null ? null : functionName.trim();
    }

    public String getExpainContent() {
        return expainContent;
    }

    public void setExpainContent(String expainContent) {
        this.expainContent = expainContent == null ? null : expainContent.trim();
    }
}