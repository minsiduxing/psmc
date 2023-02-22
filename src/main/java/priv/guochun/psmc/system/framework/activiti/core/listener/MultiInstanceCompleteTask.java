package priv.guochun.psmc.system.framework.activiti.core.listener;

import org.activiti.engine.delegate.DelegateExecution;

import java.io.Serializable;

public class MultiInstanceCompleteTask implements Serializable {

    public boolean accessCondition(DelegateExecution execution) {
        //已完成的实例数
        int completedInstance = (int) execution.getVariable("nrOfCompletedInstances");
        //否决判断，一票否决
        if (execution.getVariable("pass") != null && !(boolean) execution.getVariable("pass")) {
                execution.setVariable("paZq", "0");
                return true;
        }else{
            if(completedInstance == 2){
                execution.setVariable("paZq", "1");
                execution.setVariable("paZjl", "ceshi");
                return true;
            }
            return false;
        }

    }
}
