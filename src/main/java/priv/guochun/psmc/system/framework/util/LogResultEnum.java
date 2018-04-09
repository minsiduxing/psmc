package priv.guochun.psmc.system.framework.util;

public enum LogResultEnum
{
	success("成功",(short)1),
	error("失败",(short)2);
    
    
    private String name;
    private short index;
    
    private LogResultEnum(String name, Short index)
    {
        this.name = name;
        this.index = index;
    }

    public static String getName(Short index)
    {
        if(index == null) return null;
        
        for (LogResultEnum p : LogResultEnum.values())
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
