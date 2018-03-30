package priv.guochun.psmc.system.activiti.test8;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PsmcActivitiTaskListener implements TaskListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected static final  Logger logger  = LoggerFactory.getLogger(PsmcActivitiExecutionListener.class);


	@Override
	public void notify(DelegateTask delegateTask) {
		logger.info("TaskListener json str "+delegateTask!=null?delegateTask.getEventName():"");
		
	}

}
