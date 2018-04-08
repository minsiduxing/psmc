package priv.guochun.psmc.system.framework.activiti.core.engine;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.activiti.bpmn.model.FlowNode;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.delegate.event.ActivitiEvent;
import org.activiti.engine.delegate.event.ActivitiEventListener;
import org.activiti.engine.delegate.event.ActivitiEventType;
import org.activiti.engine.impl.persistence.entity.VariableInstance;
import org.activiti.engine.runtime.DataObject;
import org.activiti.engine.runtime.Execution;
import org.activiti.engine.runtime.ExecutionQuery;
import org.activiti.engine.runtime.NativeExecutionQuery;
import org.activiti.engine.runtime.NativeProcessInstanceQuery;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.runtime.ProcessInstanceBuilder;
import org.activiti.engine.runtime.ProcessInstanceQuery;
import org.activiti.engine.task.Event;
import org.activiti.engine.task.IdentityLink;
import org.apache.commons.lang.StringUtils;

import priv.guochun.psmc.system.framework.activiti.core.PsmcWorkFlowContext;
import priv.guochun.psmc.system.framework.activiti.core.factory.PsmcActivitiExceptionFactory;

public class PsmcProxyRuntimeService implements RuntimeService {

	//activiti的runtimeService对象
	private RuntimeService realRuntimeService;
	
	private PsmcWorkFlowContext psmcWorkFlowContext;
	
	public PsmcProxyRuntimeService(){
		
	}
	
	@Override
	public ProcessInstanceBuilder createProcessInstanceBuilder() {
		return realRuntimeService.createProcessInstanceBuilder();
	}

	@Override
	public ProcessInstance startProcessInstanceByKey(String processDefinitionKey) {
		throw PsmcActivitiExceptionFactory.createNotAllowUeseApiException();
	}

	@Override
	public ProcessInstance startProcessInstanceByKey(String processDefinitionKey, String businessKey) {
		throw PsmcActivitiExceptionFactory.createNotAllowUeseApiException();
	}

	@Override
	public ProcessInstance startProcessInstanceByKey(String processDefinitionKey, Map<String, Object> variables) {
		String startUserId = variables.get("startUserId").toString();
		String formNo = variables.get("formNo").toString();
		
		ProcessInstance pi = realRuntimeService.startProcessInstanceByKey(processDefinitionKey,variables);
		if(pi == null || StringUtils.isEmpty(pi.getProcessInstanceId())){
			int flag = psmcWorkFlowContext.getRetryCount().intValue();
			while(flag>=1){
				pi = realRuntimeService.startProcessInstanceByKey(processDefinitionKey,variables);
				if(pi == null || StringUtils.isEmpty(pi.getProcessInstanceId()))
					flag--;
				else
					break;
			}
		}
		
		if(pi == null || StringUtils.isEmpty(pi.getProcessInstanceId())){
			// TODO 日志记录重试后无法启动流程
			return null;
		}else{
			// TODO 日志记录
		}
		
		return pi;
	}

	@Override
	public ProcessInstance startProcessInstanceByKey(String processDefinitionKey, String businessKey,
			Map<String, Object> variables) {
		throw PsmcActivitiExceptionFactory.createNotAllowUeseApiException();
	}

	@Override
	public ProcessInstance startProcessInstanceByKeyAndTenantId(String processDefinitionKey, String tenantId) {
		throw PsmcActivitiExceptionFactory.createNotAllowUeseApiException();
	}

	@Override
	public ProcessInstance startProcessInstanceByKeyAndTenantId(String processDefinitionKey, String businessKey,
			String tenantId) {
		throw PsmcActivitiExceptionFactory.createNotAllowUeseApiException();
	}

	@Override
	public ProcessInstance startProcessInstanceByKeyAndTenantId(String processDefinitionKey,
			Map<String, Object> variables, String tenantId) {
		throw PsmcActivitiExceptionFactory.createNotAllowUeseApiException();
	}

	@Override
	public ProcessInstance startProcessInstanceByKeyAndTenantId(String processDefinitionKey, String businessKey,
			Map<String, Object> variables, String tenantId) {
		throw PsmcActivitiExceptionFactory.createNotAllowUeseApiException();
	}

	@Override
	public ProcessInstance startProcessInstanceById(String processDefinitionId) {
		throw PsmcActivitiExceptionFactory.createNotAllowUeseApiException();
	}

	@Override
	public ProcessInstance startProcessInstanceById(String processDefinitionId, String businessKey) {
		throw PsmcActivitiExceptionFactory.createNotAllowUeseApiException();
	}

	@Override
	public ProcessInstance startProcessInstanceById(String processDefinitionId, Map<String, Object> variables) {
		throw PsmcActivitiExceptionFactory.createNotAllowUeseApiException();
	}

	@Override
	public ProcessInstance startProcessInstanceById(String processDefinitionId, String businessKey,
			Map<String, Object> variables) {
		throw PsmcActivitiExceptionFactory.createNotAllowUeseApiException();
	}

	@Override
	public ProcessInstance startProcessInstanceByMessage(String messageName) {
		throw PsmcActivitiExceptionFactory.createNotAllowUeseApiException();
	}

	@Override
	public ProcessInstance startProcessInstanceByMessageAndTenantId(String messageName, String tenantId) {
		throw PsmcActivitiExceptionFactory.createNotAllowUeseApiException();
	}

	@Override
	public ProcessInstance startProcessInstanceByMessage(String messageName, String businessKey) {
		throw PsmcActivitiExceptionFactory.createNotAllowUeseApiException();
	}

	@Override
	public ProcessInstance startProcessInstanceByMessageAndTenantId(String messageName, String businessKey,
			String tenantId) {
		throw PsmcActivitiExceptionFactory.createNotAllowUeseApiException();
	}

	@Override
	public ProcessInstance startProcessInstanceByMessage(String messageName, Map<String, Object> processVariables) {
		throw PsmcActivitiExceptionFactory.createNotAllowUeseApiException();
	}

	@Override
	public ProcessInstance startProcessInstanceByMessageAndTenantId(String messageName,
			Map<String, Object> processVariables, String tenantId) {
		throw PsmcActivitiExceptionFactory.createNotAllowUeseApiException();
	}

	@Override
	public ProcessInstance startProcessInstanceByMessage(String messageName, String businessKey,
			Map<String, Object> processVariables) {
		throw PsmcActivitiExceptionFactory.createNotAllowUeseApiException();
	}

	@Override
	public ProcessInstance startProcessInstanceByMessageAndTenantId(String messageName, String businessKey,
			Map<String, Object> processVariables, String tenantId) {
		throw PsmcActivitiExceptionFactory.createNotAllowUeseApiException();
	}

	@Override
	public void deleteProcessInstance(String processInstanceId, String deleteReason) {
		realRuntimeService.deleteProcessInstance(processInstanceId, deleteReason);
		
	}

	@Override
	public List<String> getActiveActivityIds(String executionId) {
		return realRuntimeService.getActiveActivityIds(executionId);
	}

	@Override
	public void trigger(String executionId) {
		realRuntimeService.trigger(executionId);
		
	}

	@Override
	public void trigger(String executionId, Map<String, Object> processVariables) {
		realRuntimeService.trigger(executionId,processVariables);
		
	}

	@Override
	public void trigger(String executionId, Map<String, Object> processVariables,
			Map<String, Object> transientVariables) {
		realRuntimeService.trigger(executionId,processVariables,transientVariables);
		
	}

	@Override
	public void updateBusinessKey(String processInstanceId, String businessKey) {
		realRuntimeService.updateBusinessKey(processInstanceId, businessKey);
		
	}

	@Override
	public void addUserIdentityLink(String processInstanceId, String userId, String identityLinkType) {
		realRuntimeService.addUserIdentityLink(processInstanceId, userId, identityLinkType);
		
	}

	@Override
	public void addGroupIdentityLink(String processInstanceId, String groupId, String identityLinkType) {
		realRuntimeService.addGroupIdentityLink(processInstanceId, groupId, identityLinkType);
	}

	@Override
	public void addParticipantUser(String processInstanceId, String userId) {
		realRuntimeService.addParticipantUser(processInstanceId, userId);
		
	}

	@Override
	public void addParticipantGroup(String processInstanceId, String groupId) {
		realRuntimeService.addParticipantGroup(processInstanceId, groupId);
		
	}

	@Override
	public void deleteParticipantUser(String processInstanceId, String userId) {
		realRuntimeService.deleteParticipantUser(processInstanceId, userId);
		
	}

	@Override
	public void deleteParticipantGroup(String processInstanceId, String groupId) {
		realRuntimeService.deleteParticipantGroup(processInstanceId, groupId);
		
	}

	@Override
	public void deleteUserIdentityLink(String processInstanceId, String userId, String identityLinkType) {
		realRuntimeService.deleteUserIdentityLink(processInstanceId, userId, identityLinkType);
		
	}

	@Override
	public void deleteGroupIdentityLink(String processInstanceId, String groupId, String identityLinkType) {
		realRuntimeService.deleteGroupIdentityLink(processInstanceId, groupId, identityLinkType);
		
	}

	@Override
	public List<IdentityLink> getIdentityLinksForProcessInstance(String instanceId) {
		return realRuntimeService.getIdentityLinksForProcessInstance(instanceId);
	}

	@Override
	public Map<String, Object> getVariables(String executionId) {
		return realRuntimeService.getVariables(executionId);
	}

	@Override
	public Map<String, VariableInstance> getVariableInstances(String executionId) {
		return realRuntimeService.getVariableInstances(executionId);
	}

	@Override
	public List<VariableInstance> getVariableInstancesByExecutionIds(Set<String> executionIds) {
		return realRuntimeService.getVariableInstancesByExecutionIds(executionIds);
	}

	@Override
	public Map<String, Object> getVariablesLocal(String executionId) {
		return realRuntimeService.getVariablesLocal(executionId);
	}

	@Override
	public Map<String, VariableInstance> getVariableInstancesLocal(String executionId) {
		return realRuntimeService.getVariableInstancesLocal(executionId);
	}

	@Override
	public Map<String, Object> getVariables(String executionId, Collection<String> variableNames) {
		return realRuntimeService.getVariables(executionId,variableNames);
	}

	@Override
	public Map<String, VariableInstance> getVariableInstances(String executionId, Collection<String> variableNames) {
		return realRuntimeService.getVariableInstances(executionId,variableNames);
	}

	@Override
	public Map<String, Object> getVariablesLocal(String executionId, Collection<String> variableNames) {
		return realRuntimeService.getVariablesLocal(executionId,variableNames);
	}

	@Override
	public Map<String, VariableInstance> getVariableInstancesLocal(String executionId,
			Collection<String> variableNames) {
		return realRuntimeService.getVariableInstancesLocal(executionId,variableNames);
	}

	@Override
	public Object getVariable(String executionId, String variableName) {
		return realRuntimeService.getVariable(executionId,variableName);
	}

	@Override
	public VariableInstance getVariableInstance(String executionId, String variableName) {
		return realRuntimeService.getVariableInstance(executionId,variableName);
	}

	@Override
	public <T> T getVariable(String executionId, String variableName, Class<T> variableClass) {
		return realRuntimeService.getVariable(executionId,variableName,variableClass);
	}

	@Override
	public boolean hasVariable(String executionId, String variableName) {
		return realRuntimeService.hasVariable(executionId,variableName);
	}

	@Override
	public Object getVariableLocal(String executionId, String variableName) {
		return realRuntimeService.getVariableLocal(executionId,variableName);
	}

	@Override
	public VariableInstance getVariableInstanceLocal(String executionId, String variableName) {
		return realRuntimeService.getVariableInstanceLocal(executionId,variableName);
	}

	@Override
	public <T> T getVariableLocal(String executionId, String variableName, Class<T> variableClass) {
		return realRuntimeService.getVariableLocal(executionId,variableName,variableClass);
	}

	@Override
	public boolean hasVariableLocal(String executionId, String variableName) {
		return realRuntimeService.hasVariableLocal(executionId,variableName);
	}

	@Override
	public void setVariable(String executionId, String variableName, Object value) {
		realRuntimeService.setVariable(executionId, variableName, value);
		
	}

	@Override
	public void setVariableLocal(String executionId, String variableName, Object value) {
		realRuntimeService.setVariableLocal(executionId, variableName, value);
		
	}

	@Override
	public void setVariables(String executionId, Map<String, ? extends Object> variables) {
		realRuntimeService.setVariables(executionId, variables);
		
	}

	@Override
	public void setVariablesLocal(String executionId, Map<String, ? extends Object> variables) {
		realRuntimeService.setVariablesLocal(executionId, variables);
		
	}

	@Override
	public void removeVariable(String executionId, String variableName) {
		realRuntimeService.removeVariable(executionId, variableName);
	}

	@Override
	public void removeVariableLocal(String executionId, String variableName) {
		realRuntimeService.removeVariableLocal(executionId, variableName);
		
	}

	@Override
	public void removeVariables(String executionId, Collection<String> variableNames) {
		realRuntimeService.removeVariables(executionId, variableNames);
		
	}

	@Override
	public void removeVariablesLocal(String executionId, Collection<String> variableNames) {
		realRuntimeService.removeVariablesLocal(executionId, variableNames);
		
	}

	@Override
	public Map<String, DataObject> getDataObjects(String executionId) {
		return realRuntimeService.getDataObjects(executionId);
	}

	@Override
	public Map<String, DataObject> getDataObjects(String executionId, String locale, boolean withLocalizationFallback) {
		return realRuntimeService.getDataObjects(executionId,locale,withLocalizationFallback);
	}

	@Override
	public Map<String, DataObject> getDataObjectsLocal(String executionId) {
		return realRuntimeService.getDataObjectsLocal(executionId);
	}

	@Override
	public Map<String, DataObject> getDataObjectsLocal(String executionId, String locale,
			boolean withLocalizationFallback) {
		return realRuntimeService.getDataObjectsLocal(executionId,locale,withLocalizationFallback);
	}

	@Override
	public Map<String, DataObject> getDataObjects(String executionId, Collection<String> dataObjectNames) {
		return realRuntimeService.getDataObjects(executionId,dataObjectNames);
	}

	@Override
	public Map<String, DataObject> getDataObjects(String executionId, Collection<String> dataObjectNames, String locale,
			boolean withLocalizationFallback) {
		return realRuntimeService.getDataObjects(executionId,dataObjectNames,locale,withLocalizationFallback);
	}

	@Override
	public Map<String, DataObject> getDataObjectsLocal(String executionId, Collection<String> dataObjects) {
		return realRuntimeService.getDataObjectsLocal(executionId,dataObjects);
	}

	@Override
	public Map<String, DataObject> getDataObjectsLocal(String executionId, Collection<String> dataObjectNames,
			String locale, boolean withLocalizationFallback) {
		return realRuntimeService.getDataObjectsLocal(executionId,dataObjectNames,locale,withLocalizationFallback);
	}

	@Override
	public DataObject getDataObject(String executionId, String dataObject) {
		return realRuntimeService.getDataObject(executionId,dataObject);
	}

	@Override
	public DataObject getDataObject(String executionId, String dataObjectName, String locale,
			boolean withLocalizationFallback) {
		return realRuntimeService.getDataObject(executionId, dataObjectName, locale, withLocalizationFallback);
	}

	@Override
	public DataObject getDataObjectLocal(String executionId, String dataObjectName) {
		return realRuntimeService.getDataObjectLocal(executionId, dataObjectName);
	}

	@Override
	public DataObject getDataObjectLocal(String executionId, String dataObjectName, String locale,
			boolean withLocalizationFallback) {
		return realRuntimeService.getDataObjectLocal(executionId, dataObjectName,locale, withLocalizationFallback);
	}

	@Override
	public ExecutionQuery createExecutionQuery() {
		return realRuntimeService.createExecutionQuery();
	}

	@Override
	public NativeExecutionQuery createNativeExecutionQuery() {
		return realRuntimeService.createNativeExecutionQuery();
	}

	@Override
	public ProcessInstanceQuery createProcessInstanceQuery() {
		return realRuntimeService.createProcessInstanceQuery();
	}

	@Override
	public NativeProcessInstanceQuery createNativeProcessInstanceQuery() {
		return realRuntimeService.createNativeProcessInstanceQuery();
	}

	@Override
	public void suspendProcessInstanceById(String processInstanceId) {
		realRuntimeService.suspendProcessInstanceById(processInstanceId);
	}

	@Override
	public void activateProcessInstanceById(String processInstanceId) {
		realRuntimeService.activateProcessInstanceById(processInstanceId);
		
	}

	@Override
	public void signalEventReceived(String signalName) {
		realRuntimeService.signalEventReceived(signalName);
		
	}

	@Override
	public void signalEventReceivedWithTenantId(String signalName, String tenantId) {
		realRuntimeService.signalEventReceivedWithTenantId(signalName,tenantId);
		
	}

	@Override
	public void signalEventReceivedAsync(String signalName) {
		realRuntimeService.signalEventReceivedAsync(signalName);
	}

	@Override
	public void signalEventReceivedAsyncWithTenantId(String signalName, String tenantId) {
		realRuntimeService.signalEventReceivedAsyncWithTenantId(signalName, tenantId);
	}

	@Override
	public void signalEventReceived(String signalName, Map<String, Object> processVariables) {
		realRuntimeService.signalEventReceived(signalName, processVariables);
	}

	@Override
	public void signalEventReceivedWithTenantId(String signalName, Map<String, Object> processVariables,
			String tenantId) {
		realRuntimeService.signalEventReceivedWithTenantId(signalName,processVariables, tenantId);
	}

	@Override
	public void signalEventReceived(String signalName, String executionId) {
		realRuntimeService.signalEventReceived(signalName, executionId);
		
	}

	@Override
	public void signalEventReceived(String signalName, String executionId, Map<String, Object> processVariables) {
		realRuntimeService.signalEventReceived(signalName);
		
	}

	@Override
	public void signalEventReceivedAsync(String signalName, String executionId) {
		realRuntimeService.signalEventReceivedAsync(signalName,executionId);
		
	}

	@Override
	public void messageEventReceived(String messageName, String executionId) {
		realRuntimeService.messageEventReceived(messageName,executionId);
		
	}

	@Override
	public void messageEventReceived(String messageName, String executionId, Map<String, Object> processVariables) {
		realRuntimeService.messageEventReceived(messageName,executionId,processVariables);
		
	}

	@Override
	public void messageEventReceivedAsync(String messageName, String executionId) {
		realRuntimeService.messageEventReceivedAsync(messageName,executionId);		
	}

	@Override
	public void addEventListener(ActivitiEventListener listenerToAdd) {
		realRuntimeService.addEventListener(listenerToAdd);
	}

	@Override
	public void addEventListener(ActivitiEventListener listenerToAdd, ActivitiEventType... types) {
		realRuntimeService.addEventListener(listenerToAdd, types);
		
	}

	@Override
	public void removeEventListener(ActivitiEventListener listenerToRemove) {
		realRuntimeService.removeEventListener(listenerToRemove);
		
	}

	@Override
	public void dispatchEvent(ActivitiEvent event) {
		realRuntimeService.dispatchEvent(event);
		
	}

	@Override
	public void setProcessInstanceName(String processInstanceId, String name) {
		realRuntimeService.setProcessInstanceName(processInstanceId, name);
		
	}

	@Override
	public List<FlowNode> getEnabledActivitiesFromAdhocSubProcess(String executionId) {
		return realRuntimeService.getEnabledActivitiesFromAdhocSubProcess(executionId);
	}

	@Override
	public Execution executeActivityInAdhocSubProcess(String executionId, String activityId) {
		return realRuntimeService.executeActivityInAdhocSubProcess(executionId,activityId);
	}

	@Override
	public void completeAdhocSubProcess(String executionId) {
		realRuntimeService.completeAdhocSubProcess(executionId);
		
	}

	@Override
	public List<Event> getProcessInstanceEvents(String processInstanceId) {
		return realRuntimeService.getProcessInstanceEvents(processInstanceId);
	}

	public void setRealRuntimeService(RuntimeService realRuntimeService) {
		this.realRuntimeService = realRuntimeService;
	}

	
	
}
