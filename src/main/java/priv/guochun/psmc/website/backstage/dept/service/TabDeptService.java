package priv.guochun.psmc.website.backstage.dept.service;

import java.util.List;
import java.util.Map;

import priv.guochun.psmc.system.framework.page.MyPage;
import priv.guochun.psmc.website.backstage.dept.model.TabDept;
import priv.guochun.psmc.website.backstage.module.model.TabModule;

/**
 * 部门信息服务类
 * @author Administrator
 *
 */
public interface TabDeptService {
	
	/**
	 * 查询部门列表
	 * @param page
	 * @return
	 */
	public MyPage findDeptListBusinessMethod(MyPage page);
	
	/**
	 * 根据主键查询部门信息
	 * @param deptUuid
	 * @return
	 */
	public Map<String, Object> queryDeptByUuidBusinessMethod(String deptUuid);
	
	/**
	 * 添加或修改部门
	 * @param dept
	 * @param module
	 */
	public void saveOrUpdateDeptBusinessMethod(TabDept dept, TabModule module);
	
	/**
	 * 删除部门信息
	 * @param ids
	 */
	public void deleteDeptBusinessMethod(String ids);
	
	/**
	 * 审核部门信息
	 * @param uuids
	 * @param userId
	 */
	public void auditDeptBusinessMethod(String uuids, String userId);
	
	/**
	 * 发布部门信息
	 * @param uuids
	 * @param userId
	 */
	public void releaseDeptBusinessMethod(String uuids, String userId);
	
	/**
	 * 根据部门类型获取部门列表（适用于下拉列表）
	 * @param deptType
	 * @return
	 */
	public List<Map<?, ?>> getDeptListByDeptType(String deptType, String groupid);
	
	/**
	 * 查看信息详情 - mobile
	 * @param deptUuid
	 * @return
	 */
	public Map<String,Object> getDeptDetailToMobile(String deptUuid);
	
	/**
	 * 获取信息列表 - mobile
	 * @param mypage
	 * @return
	 */
	public MyPage queryDeptListToMobile(MyPage mypage);

}
