package priv.guochun.psmc.system.framework.activiti.core;

import java.util.List;

import org.activiti.engine.RuntimeService;

import org.activiti.engine.TaskService;
import priv.guochun.psmc.system.framework.activiti.model.TFlowConfig;
import priv.guochun.psmc.system.framework.cache.CacheContants;
import priv.guochun.psmc.system.framework.cache.PsmcCacheFactory;

/**
 * 1、psmc工作流上下文实现类,主要作用是包装发布一些流程相关的基础公共操作
 * 2、对activiti的原生操作对象进行无侵入扩展, 使客户端使用工作流就像使用activiti本身一样
 *  * 3、所有使用工作流的客户端都必须从context获取操作对象 解耦客户端与activiti的关系
 *  * @author Administrator
 *
 */
public class PsmcWorkFlowContextImpl implements PsmcWorkFlowContext {

	
	private RuntimeService	runtimeService;

	private TaskService	taskService;
	private PsmcCacheFactory psmcCacheFactory;
	
	@Override
	public boolean enableEqualize(){
		return true;
	}
	
	@Override
	public boolean enableAudit(){
		return true;
	}

	@Override
	public RuntimeService getRuntimeService() {
		return runtimeService;
	}

	public void setRuntimeService(RuntimeService runtimeService) {
		this.runtimeService = runtimeService;
	}

	@Override
	public TaskService getTaskService() {
		return taskService;
	}

	public void setTaskService(TaskService taskService) {
		this.taskService = taskService;
	}

	@Override
	public Integer getRetryCount() {
		if(enableEqualize()){
			return new Integer(3);
		}else
			return new Integer(0);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TFlowConfig> getWorkFlowDefinition() {
		List<TFlowConfig> list = psmcCacheFactory.getWorkFlow().get(CacheContants.CACHE_SYSTEM_WORKFOLW_DEFINITION,List.class);
		return list;
	}

	public TFlowConfig getWorkFlowDefinition(String formno){
		TFlowConfig result = null;
		List<TFlowConfig> list = getWorkFlowDefinition();
		if(list !=null && list.size()>0){
			for(int i=0;i<list.size();i++){
				TFlowConfig obj = list.get(i);
				if(obj.getFlowNo().equals(formno)){
					result = obj;
					break;
				}
			}
		}
		return result;
	}

	public PsmcCacheFactory getPsmcCacheFactory() {
		return psmcCacheFactory;
	}

	public void setPsmcCacheFactory(PsmcCacheFactory psmcCacheFactory) {
		this.psmcCacheFactory = psmcCacheFactory;
	}

}
