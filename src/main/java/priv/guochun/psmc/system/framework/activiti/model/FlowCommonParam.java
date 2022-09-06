package priv.guochun.psmc.system.framework.activiti.model;

import java.util.Map;

/**
 * 流程公共接收参数对象
 */
public class FlowCommonParam {

    String  pid;
    //任务id
    String  taskId;

    //流程变量对象
    Map<String, Object> variables;

    //流程变量对象（瞬态变量）目前没用
    Map<String, Object> transientVariables;

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
}
