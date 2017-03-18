package priv.guochun.psmc.authentication.operate.dao;

import java.util.List;
import java.util.Map;

public interface TabOperateDao {

    public List<Map<?,?>> getTabOperates(String roleUuid,String resourceUuid);
    
	public List<Map<?,?>> getPermitOperatesByRoleUuid(String roleUuid);
	
	public void deleteTabOperatesByResourceUuid(String resourceUuid);
}
