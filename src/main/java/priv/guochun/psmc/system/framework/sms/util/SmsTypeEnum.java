package priv.guochun.psmc.system.framework.sms.util;

import org.json.JSONArray;
import priv.guochun.psmc.system.util.JsonUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum SmsTypeEnum
{
    SmsTypeEnum0("短信发送",0,"0"),
    SmsTypeEnum1("彩信发送",1,"1"),
    SmsTypeEnum2("个性化短信发送",2,"2");

    //中昱平台-陕测职工e家短信验证码 模板id
    public static final String ZY_PLATFORM_SCZGYJ_VERIFICATION_CODE_SMS_ID="12587";


    private String name;
    private int index;
    private String uuid;
    
    private SmsTypeEnum(String name, Integer index, String uuid)
    {
        this.name = name;
        this.index = index;
        this.uuid = uuid;
    }

    public static String getName(Integer index)
    {
        if(index == null) return null;
        
        for (SmsTypeEnum p : SmsTypeEnum.values())
        {
            if (p.getIndex() == index)
            {
                return p.name;
            }
        }
        return null;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getIndex()
    {
        return index;
    }

    public void setIndex(int index)
    {
        this.index = index;
    }

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
}
