package priv.guochun.psmc.website.backstage.message.model;

import java.io.Serializable;
import java.util.Date;

public class TabMessagePool implements Serializable{
    private String msgUuid;

    private String phone;

    private String tempCode;

    private Date addTime;

    public String getMsgUuid() {
        return msgUuid;
    }

    public void setMsgUuid(String msgUuid) {
        this.msgUuid = msgUuid == null ? null : msgUuid.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getTempCode() {
        return tempCode;
    }

    public void setTempCode(String tempCode) {
        this.tempCode = tempCode == null ? null : tempCode.trim();
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }
}