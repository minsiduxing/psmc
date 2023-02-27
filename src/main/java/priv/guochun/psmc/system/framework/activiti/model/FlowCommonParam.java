package priv.guochun.psmc.system.framework.activiti.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 流程公共接收参数对象
 */
public class FlowCommonParam {

    String  pid;
    //任务id
    String  taskId;

    //流程变量对象
    Map<String, Object> variables = new HashMap<String, Object>();

    List<Object> variablesList = new ArrayList<Object>();

    //流程变量对象（瞬态变量）目前没用
    Map<String, Object> transientVariables = new HashMap<String, Object>();;

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public Map<String, Object> getVariables() {
        return variables;
    }

    public void setVariables(Map<String, Object> variables) {
        this.variables = variables;
    }

    public Map<String, Object> getTransientVariables() {
        return transientVariables;
    }

    public void setTransientVariables(Map<String, Object> transientVariables) {
        this.transientVariables = transientVariables;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public List<Object> getVariablesList() {
        return variablesList;
    }

    public void setVariablesList(List<Object> variablesList) {
        this.variablesList = variablesList;
    }
}
