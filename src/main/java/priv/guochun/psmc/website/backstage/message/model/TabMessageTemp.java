package priv.guochun.psmc.website.backstage.message.model;

import java.util.Date;

public class TabMessageTemp {
    private String tempUuid;

    private String tempCode;

    private String tempContent;

    private String type;
    
    private String tempId;

    private Date addTime;

    public String getTempUuid() {
        return tempUuid;
    }

    public void setTempUuid(String tempUuid) {
        this.tempUuid = tempUuid == null ? null : tempUuid.trim();
    }

    public String getTempCode() {
        return tempCode;
    }

    public void setTempCode(String tempCode) {
        this.tempCode = tempCode == null ? null : tempCode.trim();
    }

    public String getTempContent() {
        return tempContent;
    }

    public void setTempContent(String tempContent) {
        this.tempContent = tempContent == null ? null : tempContent.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

	public String getTempId() {
		return tempId;
	}

	public void setTempId(String tempId) {
		this.tempId = tempId == null ? null : tempId.trim();
	}
}