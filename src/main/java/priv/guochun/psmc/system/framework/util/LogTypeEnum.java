package priv.guochun.psmc.system.framework.util;

import java.math.BigDecimal;

public enum LogTypeEnum
{
	LogTypeFlow1("工作流业务",new BigDecimal(1)),
	LogTypeFlow1_1("流程发起",new BigDecimal(1.1)),
	
	
	
	LogTypeSysOper2("系统操作",new BigDecimal(2)),
	LogTypeSysOper2_1("登录",new BigDecimal(2.1)),
	LogTypeSysOper2_2("登出",new BigDecimal(2.2)),
	LogTypeSysOper2_3("日常操作",new BigDecimal(2.3));
    
    
    private String name;
    private BigDecimal index;
    
    private LogTypeEnum(String name, BigDecimal index)
    {
        this.name = name;
        this.index = index;
    }

    public static String getName(BigDecimal index)
    {
        if(index == null) return null;
        
        for (LogTypeEnum p : LogTypeEnum.values())
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

    public BigDecimal getIndex()
    {
        return index;
    }

    public void setIndex(BigDecimal index)
    {
        this.index = index;
    }

	
	
	
}
