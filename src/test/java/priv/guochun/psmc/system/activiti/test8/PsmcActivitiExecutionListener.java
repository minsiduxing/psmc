package priv.guochun.psmc.system.activiti.test8;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.ExecutionListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;

public class PsmcActivitiExecutionListener implements ExecutionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected static final  Logger logger  = LoggerFactory.getLogger(PsmcActivitiExecutionListener.class);

	
	@Override
	public void notify(DelegateExecution execution) {
		Gson gson = new Gson();
		
        logger.info("ActivitiExecution json str "+execution!=null?execution.getEventName():"");
	}

}
