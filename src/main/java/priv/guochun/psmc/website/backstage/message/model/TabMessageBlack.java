package priv.guochun.psmc.website.backstage.message.model;

import java.util.Date;

public class TabMessageBlack {
    private String blackUuid;

    private String phone;

    private String reason;

    private Date addTime;

    public String getBlackUuid() {
        return blackUuid;
    }

    public void setBlackUuid(String blackUuid) {
        this.blackUuid = blackUuid == null ? null : blackUuid.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }
}