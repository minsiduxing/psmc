package priv.guochun.psmc.authentication.operate.service;

import java.util.List;
import java.util.Map;

public interface TabOperateService {

	
	/**
	 * 获取某一个角色下所有的业务操作
	 * 如果角色为空,则获取的是当前系统的所有业务操作
	 * @param role_uuid
	 * @return
	 */
	
	public List<Map<?,?>> getPermitOperatesByRoleUuid(String role_uuid);
	
	/**
	 * 获取某一个角色、某一个资源下所有的operate
	 * @param role_uuid
	 * @param resource_uuid
	 * @return
	 */
	public List getTabOperatesByRoleUuidAndResourceUuid(String role_uuid,String resource_uuid);
	
	/**
	 * 根据资源ID，删除该资源的所有业务操作
	 * @param resourceUuid
	 */
	public boolean deleteTabOperatesByResourceUuid(String resourceUuid);
	

}
