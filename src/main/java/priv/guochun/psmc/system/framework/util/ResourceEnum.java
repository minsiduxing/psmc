package priv.guochun.psmc.system.framework.util;



public enum ResourceEnum
{
    ResourceType1("系统",1,null),
    ResourceType2("导航模块",2,null),
    ResourceType3("菜单",3,null),
    
    PsmcRootId("系统根节点",0,"e51a8663876f4a3394bb194d89d96735");
    
    
    private String name;
    private int index;
    private String uuid;
    
    private ResourceEnum(String name, Integer index,String uuid)
    {
        this.name = name;
        this.index = index;
        this.uuid = uuid;
    }

    public static String getName(Integer index)
    {
        if(index == null) return null;
        
        for (ResourceEnum p : ResourceEnum.values())
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
