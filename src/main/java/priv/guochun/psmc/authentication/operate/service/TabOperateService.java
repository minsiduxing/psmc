package priv.guochun.psmc.authentication.operate.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import priv.guochun.psmc.authentication.operate.model.TabOperate;

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
	
	/**
	 * 获取某个资源的业务操作排序号
	 * <p>Description:<p>
	 * @return
	 * @author wenxiaoming 2017年7月19日
	 */
	public Integer getTabOperateOrderNum();
	
	/**
	 * 根据资源查询对应的业务操作列表
	 * <p>Description:<p>
	 * @param resourceuuid
	 * @return
	 * @author wenxiaoming 2017年8月7日
	 */
	public List getTabOperatesByResourceUuid(String resourceuuid);
	
	/**
	 * 保存或更新资源的操作配置
	 * <p>Description:<p>
	 * @param tabResourceOperate
	 * @author wenxiaoming 2017年9月2日
	 */
	public void saveOrUpdateResOperateConfig(TabOperate tabResourceOperate);
	
	/**
	 * 根据操作表示查询对应配置角色的个数
	 * <p>Description:<p>
	 * @param operateUuid
	 * @return
	 * @author wenxiaoming 2017年9月3日
	 */
	public int selectRoleCountByOperate(String operateUuid);
	
	/**
	 * 删除操作业务配置
	 * <p>Description:<p>
	 * @param operateUuid
	 * @return
	 * @author wenxiaoming 2017年9月3日
	 */
	public int deleteOperate(String operateUuid);
	
	/**
	 * 根据操作编号查询操作配置的个数
	 * <p>Description:<p>
	 * @param operateUuid
	 * @param operateNo
	 * @return
	 * @author wenxiaoming 2017年10月3日
	 */
	public int selectOperateCountByNo(String operateUuid, String operateNo);
}