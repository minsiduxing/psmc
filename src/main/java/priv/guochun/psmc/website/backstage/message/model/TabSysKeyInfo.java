package priv.guochun.psmc.website.backstage.message.model;

import java.io.Serializable;

public class TabSysKeyInfo implements Serializable{
    private Integer id;

    private String sysKey;

    private String sysValue;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSysKey() {
        return sysKey;
    }

    public void setSysKey(String sysKey) {
        this.sysKey = sysKey == null ? null : sysKey.trim();
    }

    public String getSysValue() {
        return sysValue;
    }

    public void setSysValue(String sysValue) {
        this.sysValue = sysValue == null ? null : sysValue.trim();
    }
}