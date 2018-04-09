package priv.guochun.psmc.system.framework.util;

public enum LogTypeEnum
{
	LogTypeFlow("工作流",(short)1);
    
    
    
    private String name;
    private short index;
    
    private LogTypeEnum(String name, Short index)
    {
        this.name = name;
        this.index = index;
    }

    public static String getName(Short index)
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

    public short getIndex()
    {
        return index;
    }

    public void setIndex(short index)
    {
        this.index = index;
    }

	
	
	
}
