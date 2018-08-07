package priv.guochun.psmc.website.backstage.activity.service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import priv.guochun.psmc.system.framework.page.MyPage;
import priv.guochun.psmc.website.backstage.activity.model.TabActivityManage;
import priv.guochun.psmc.website.backstage.activity.model.TabSignUpInfo;
import priv.guochun.psmc.website.backstage.module.model.TabModule;

/**
 * 活动管理服务类
 * @author Administrator
 *
 */
public interface TabActivityManageService {

	/**
	 * 查询活动列表
	 * @param page
	 * @return
	 */
	public MyPage queryActivityList(MyPage page);
	
	/**
	 * 根据主键获取活动信息
	 * @param activityUuid
	 * @return
	 */
	public Map<String, Object> getActivityByUuid(String activityUuid);
	
	/**
	 * 添加或修改活动信息
	 * @param activity
	 * @param tabModule
	 */
	public void addOrupdateActivity(TabActivityManage activity, TabModule tabModule);
	
	/**
	 * 删除活动信息
	 * @param activityUuids
	 */
	public void deleteActivity(String activityUuids);
	
	/**
	 * 活动审核
	 * @param activityUuids
	 * @param userId
	 */
	public void executeAudit(String activityUuids, String userId);
	
	/**
	 * 活动发布
	 * @param activityUuid
	 * @param userId
	 * @param publishExpireDate
	 */
	public void executeRelease(String activityUuids, String userId, Timestamp publishExpireDate);
	
	/**
	 * 撤销审核、发布
	 * @param activityUuids
	 * @param module
	 */
	public void executeUndoBusinessMethod(String activityUuids, TabModule module);
	
	/**
	 * 根据部门ID删除活动信息
	 * @param deptUuids
	 */
	public void deleteActivityByDeptUuid(String deptUuids);
	/**
	 * 活动报名
	 * @param signUp
	 */
	public void addSignUpInfo(String activityUuid, String accout);
	
	/**
	 * 取消报名
	 * @param activityUuid
	 * @param accout
	 */
	public void deleteSignInfo(String activityUuid, String accout);
	
	/**
	 * 获取报名人员列表
	 * @param activityUuid
	 * @return
	 */
	public List<Map<String, Object>> querySignUpInfoList(String activityUuid);
	
	/**
	 * 根据活动ID和人员账号获取报名信息
	 * @param activityUuid
	 * @param accout
	 * @return
	 */
	public Map<String, Object> getSignUpByActivityIdAndAccout(String activityUuid, String accout);

}
