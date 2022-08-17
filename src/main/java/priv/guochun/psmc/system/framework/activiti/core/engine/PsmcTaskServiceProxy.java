package priv.guochun.psmc.system.framework.activiti.core.engine;

import org.activiti.engine.TaskService;
import org.activiti.engine.impl.persistence.entity.VariableInstance;
import org.activiti.engine.runtime.DataObject;
import org.activiti.engine.task.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.util.*;


public class PsmcTaskServiceProxy implements TaskService {
	protected static final  Logger logger  = LoggerFactory.getLogger(PsmcTaskServiceProxy.class);

	private TaskService realTaskService;

	public PsmcTaskServiceProxy(){
		
	}

	@Override
	public Task newTask() {
		return realTaskService.newTask();
	}

	@Override
	public Task newTask(String taskId) {
		return realTaskService.newTask(taskId);
	}

	@Override
	public Task saveTask(Task task) {
		return null;
	}

	@Override
	public void deleteTask(String taskId) {
		realTaskService.deleteTask(taskId);
	}

	@Override
	public void deleteTasks(Collection<String> taskIds) {
		realTaskService.deleteTasks(taskIds);
	}

	@Override
	public void deleteTask(String taskId, boolean cascade) {
		realTaskService.deleteTask(taskId,cascade);
	}

	@Override
	public void deleteTasks(Collection<String> taskIds, boolean cascade) {
		realTaskService.deleteTasks(taskIds,cascade);
	}

	@Override
	public void deleteTask(String taskId, String deleteReason) {
		realTaskService.deleteTask(taskId,deleteReason);
	}

	@Override
	public void deleteTask(String taskId, String deleteReason, boolean cancel) {
		realTaskService.deleteTask(taskId,deleteReason,cancel);
	}

	@Override
	public void deleteTasks(Collection<String> taskIds, String deleteReason) {
		realTaskService.deleteTasks(taskIds,deleteReason);
	}

	@Override
	public void deleteTasks(Collection<String> taskIds, String deleteReason, boolean cancel) {
		realTaskService.deleteTasks(taskIds,deleteReason,cancel);
	}

	@Override
	public void claim(String taskId, String userId) {
		realTaskService.claim(taskId,userId);
	}

	@Override
	public void unclaim(String taskId) {
		realTaskService.unclaim(taskId);
	}

	@Override
	public void complete(String taskId) {
		realTaskService.complete(taskId);
	}

	@Override
	public void delegateTask(String taskId, String userId) {
		realTaskService.delegateTask(taskId,userId);
	}

	@Override
	public void resolveTask(String taskId) {
		realTaskService.resolveTask(taskId);
	}

	@Override
	public void resolveTask(String taskId, Map<String, Object> variables) {
		realTaskService.resolveTask(taskId,variables);
	}

	@Override
	public void resolveTask(String taskId, Map<String, Object> variables, Map<String, Object> transientVariables) {
		realTaskService.resolveTask(taskId,variables,transientVariables);
	}

	@Override
	public void complete(String taskId, Map<String, Object> variables) {
		realTaskService.complete(taskId,variables);
	}

	@Override
	public void complete(String taskId, Map<String, Object> variables, Map<String, Object> transientVariables) {
		realTaskService.complete(taskId,variables,transientVariables);
	}

	@Override
	public void complete(String taskId, Map<String, Object> variables, boolean localScope) {
		realTaskService.complete(taskId,variables,localScope);
	}

	@Override
	public void setAssignee(String taskId, String userId) {
		realTaskService.setAssignee(taskId,userId);
	}

	@Override
	public void setOwner(String taskId, String userId) {
		realTaskService.setOwner(taskId,userId);
	}

	@Override
	public List<IdentityLink> getIdentityLinksForTask(String taskId) {
		return realTaskService.getIdentityLinksForTask(taskId);
	}

	@Override
	public void addCandidateUser(String taskId, String userId) {
		realTaskService.addCandidateUser(taskId,userId);
	}

	@Override
	public void addCandidateGroup(String taskId, String groupId) {
		realTaskService.addCandidateGroup(taskId,groupId);
	}

	@Override
	public void addUserIdentityLink(String taskId, String userId, String identityLinkType) {
		realTaskService.addUserIdentityLink(taskId,userId,identityLinkType);
	}

	@Override
	public void addGroupIdentityLink(String taskId, String groupId, String identityLinkType) {
		realTaskService.addGroupIdentityLink(taskId,groupId,identityLinkType);
	}

	@Override
	public void deleteCandidateUser(String taskId, String userId) {
		realTaskService.deleteCandidateUser(taskId,userId);
	}

	@Override
	public void deleteCandidateGroup(String taskId, String groupId) {
		realTaskService.deleteCandidateGroup(taskId,groupId);
	}

	@Override
	public void deleteUserIdentityLink(String taskId, String userId, String identityLinkType) {
		realTaskService.deleteUserIdentityLink(taskId,userId,identityLinkType);
	}

	@Override
	public void deleteGroupIdentityLink(String taskId, String groupId, String identityLinkType) {
		realTaskService.deleteGroupIdentityLink(taskId,groupId,identityLinkType);
	}

	@Override
	public void setPriority(String taskId, int priority) {
		realTaskService.setPriority(taskId,priority);
	}

	@Override
	public void setDueDate(String taskId, Date dueDate) {
		realTaskService.setDueDate(taskId,dueDate);
	}

	@Override
	public TaskQuery createTaskQuery() {
		return realTaskService.createTaskQuery();
	}

	@Override
	public NativeTaskQuery createNativeTaskQuery() {
		return realTaskService.createNativeTaskQuery();
	}

	@Override
	public void setVariable(String taskId, String variableName, Object value) {
		realTaskService.setVariable(taskId,variableName,value);
	}

	@Override
	public void setVariables(String taskId, Map<String, ?> variables) {
		realTaskService.setVariables(taskId,variables);
	}

	@Override
	public void setVariableLocal(String taskId, String variableName, Object value) {
		realTaskService.setVariableLocal(taskId,variableName,value);
	}

	@Override
	public void setVariablesLocal(String taskId, Map<String, ?> variables) {
		realTaskService.setVariablesLocal(taskId,variables);
	}

	@Override
	public Object getVariable(String taskId, String variableName) {
		return realTaskService.getVariable(taskId,variableName);
	}

	@Override
	public <T> T getVariable(String taskId, String variableName, Class<T> variableClass) {
		return null;
	}

	@Override
	public VariableInstance getVariableInstance(String taskId, String variableName) {
		return null;
	}

	@Override
	public boolean hasVariable(String taskId, String variableName) {
		return false;
	}

	@Override
	public Object getVariableLocal(String taskId, String variableName) {
		return null;
	}

	@Override
	public <T> T getVariableLocal(String taskId, String variableName, Class<T> variableClass) {
		return null;
	}

	@Override
	public VariableInstance getVariableInstanceLocal(String taskId, String variableName) {
		return null;
	}

	@Override
	public boolean hasVariableLocal(String taskId, String variableName) {
		return false;
	}

	@Override
	public Map<String, Object> getVariables(String taskId) {
		return null;
	}

	@Override
	public Map<String, VariableInstance> getVariableInstances(String taskId) {
		return null;
	}

	@Override
	public Map<String, VariableInstance> getVariableInstances(String taskId, Collection<String> variableNames) {
		return null;
	}

	@Override
	public Map<String, Object> getVariablesLocal(String taskId) {
		return null;
	}

	@Override
	public Map<String, Object> getVariables(String taskId, Collection<String> variableNames) {
		return null;
	}

	@Override
	public Map<String, Object> getVariablesLocal(String taskId, Collection<String> variableNames) {
		return null;
	}

	@Override
	public List<VariableInstance> getVariableInstancesLocalByTaskIds(Set<String> taskIds) {
		return null;
	}

	@Override
	public Map<String, VariableInstance> getVariableInstancesLocal(String taskId) {
		return null;
	}

	@Override
	public Map<String, VariableInstance> getVariableInstancesLocal(String taskId, Collection<String> variableNames) {
		return null;
	}

	@Override
	public void removeVariable(String taskId, String variableName) {

	}

	@Override
	public void removeVariableLocal(String taskId, String variableName) {

	}

	@Override
	public void removeVariables(String taskId, Collection<String> variableNames) {

	}

	@Override
	public void removeVariablesLocal(String taskId, Collection<String> variableNames) {

	}

	@Override
	public Map<String, DataObject> getDataObjects(String taskId) {
		return null;
	}

	@Override
	public Map<String, DataObject> getDataObjects(String taskId, String locale, boolean withLocalizationFallback) {
		return null;
	}

	@Override
	public Map<String, DataObject> getDataObjects(String taskId, Collection<String> dataObjectNames) {
		return null;
	}

	@Override
	public Map<String, DataObject> getDataObjects(String taskId, Collection<String> dataObjectNames, String locale, boolean withLocalizationFallback) {
		return null;
	}

	@Override
	public DataObject getDataObject(String taskId, String dataObject) {
		return null;
	}

	@Override
	public DataObject getDataObject(String taskId, String dataObjectName, String locale, boolean withLocalizationFallback) {
		return null;
	}

	@Override
	public Comment addComment(String taskId, String processInstanceId, String message) {
		return null;
	}

	@Override
	public Comment addComment(String taskId, String processInstanceId, String type, String message) {
		return null;
	}

	@Override
	public Comment getComment(String commentId) {
		return null;
	}

	@Override
	public void deleteComments(String taskId, String processInstanceId) {

	}

	@Override
	public void deleteComment(String commentId) {

	}

	@Override
	public List<Comment> getTaskComments(String taskId) {
		return null;
	}

	@Override
	public List<Comment> getTaskComments(String taskId, String type) {
		return null;
	}

	@Override
	public List<Comment> getCommentsByType(String type) {
		return null;
	}

	@Override
	public List<Event> getTaskEvents(String taskId) {
		return null;
	}

	@Override
	public Event getEvent(String eventId) {
		return null;
	}

	@Override
	public List<Comment> getProcessInstanceComments(String processInstanceId) {
		return null;
	}

	@Override
	public List<Comment> getProcessInstanceComments(String processInstanceId, String type) {
		return null;
	}

	@Override
	public Attachment createAttachment(String attachmentType, String taskId, String processInstanceId, String attachmentName, String attachmentDescription, InputStream content) {
		return null;
	}

	@Override
	public Attachment createAttachment(String attachmentType, String taskId, String processInstanceId, String attachmentName, String attachmentDescription, String url) {
		return null;
	}

	@Override
	public void saveAttachment(Attachment attachment) {

	}

	@Override
	public Attachment getAttachment(String attachmentId) {
		return null;
	}

	@Override
	public InputStream getAttachmentContent(String attachmentId) {
		return null;
	}

	@Override
	public List<Attachment> getTaskAttachments(String taskId) {
		return null;
	}

	@Override
	public List<Attachment> getProcessInstanceAttachments(String processInstanceId) {
		return null;
	}

	@Override
	public void deleteAttachment(String attachmentId) {

	}

	@Override
	public List<Task> getSubTasks(String parentTaskId) {
		return null;
	}

	public TaskService getRealTaskService() {
		return realTaskService;
	}

	public void setRealTaskService(TaskService realTaskService) {
		this.realTaskService = realTaskService;
	}
}
