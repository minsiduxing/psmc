package priv.guochun.psmc.website.backstage.excellentInnovation.service;

import java.sql.Timestamp;
import java.util.Map;

import priv.guochun.psmc.system.framework.page.MyPage;
import priv.guochun.psmc.website.backstage.excellentInnovation.model.TabExcellentInnovation;
import priv.guochun.psmc.website.backstage.module.model.TabModule;

/**
 * 优秀创新成果服务类
 * @author Administrator
 *
 */
public interface ExcellentInnovationService {

	/**
	 * <p>Description:添加或修改优秀成果信息<p>
	 * @param excellentInnovation 
	 * @param tabModule
	 * @author wangtao 2018年5月14日
	 */
	public void saveOrUpdateInnovationBusinessMethod (TabExcellentInnovation excellentInnovation, TabModule tabModule);
	/**
	 * <p>Description:删除优秀成果信息<p>
	 * @param uuids id
	 * @author  wangtao 2018年5月14日
	 */
	public void deleteBusinessMethod(String uuids);
	/**
	 * <p>Description:根据主键获取优秀成果信息<p>
	 * @param uuid主键
	 * @return 
	 * @author  wangtao 2018年5月14日
	 */
	public Map<String,Object> getInnovationByUuidBusinessMethod(String uuid);
	/**
	 * <p>Description:获取优秀成果信息列表<p>
	 * @param myPage
	 * @return 
	 * @author wangtao 2018年5月14日
	 */
	public MyPage getInnovationListBusinessMethod(MyPage myPage);
	
	/**
	 * <p>Description:优秀成果审核<p>
	 * @param 
	 * @return 
	 * @author wangtao 2018年5月14日
	 */
	public void executeAuditBusinessMethod(String uuids, String userId);
	
	/**
	 * <p>Description:优秀成果发布<p>
	 * @param 
	 * @return 
	 * @author wangtao 2018年5月14日
	 */
	public void executeReleaseBusinessMethod(String uuids, String userId, Timestamp publishExpireDate);
	
	/**
	 * 根据部门ID删除优秀创新成果
	 * @param deptUuids
	 */
	public void deleteInnovationByDeptUuid(String deptUuids);
	
	/**
	 * 查看优秀创新详情 - mobile
	 * @param uuid
	 * @return
	 */
	public Map<String,Object> getInnovationDetailToMobile(String uuid);
	
	public MyPage queryInnovationListToMobile(MyPage myPage);
	
}
