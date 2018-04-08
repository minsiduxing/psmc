package priv.guochun.psmc.system.framework.activiti.service;

import java.util.List;

import priv.guochun.psmc.authentication.login.model.User;
import priv.guochun.psmc.system.framework.page.MyPage;

/**
 * PSMC工作流查询服务
 * @author Administrator
 *
 */
public interface PsmcActivitiQueryService {
	
	/**
	 * 待办列表
	 */
	public List<?> getWaitTask(User user,MyPage page);
	
	
}
