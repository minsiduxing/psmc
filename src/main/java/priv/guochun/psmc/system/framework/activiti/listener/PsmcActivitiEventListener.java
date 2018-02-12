package priv.guochun.psmc.system.framework.activiti.listener;

import org.activiti.engine.delegate.event.ActivitiEvent;
import org.activiti.engine.delegate.event.ActivitiEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;

/**
 * 自定义Activiti流程事件监听器
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright ICSS(c) 2018</p>
 * @author <a href="mailTo:Guochun002@chinasofti.com">guochun</a>
 * @version 1.0
 * @history:
 * Created by guochun 2018-2-11
 */
public class PsmcActivitiEventListener implements ActivitiEventListener 
{

    protected static final  Logger logger  = LoggerFactory.getLogger(PsmcActivitiEventListener.class);

    @Override
    public boolean isFailOnException()
    {
        logger.debug("isFailOnException ");
        //该isFailOnException()方法确定了在onEvent(..)派发事件时该方法抛出异常的情况下的行为。
        //在false返回的情况下，该例外被忽略。何时true返回，异常不会被忽略，冒泡，有效地使当前正在执行的命令失败。
        //如果事件是API调用的一部分（或任何其他事务操作，例如作业执行），则该事务将被回滚。如果事件侦听器中的行为不是关键业务，
        //则建议返回false。
        return false;
    }

    @Override
    public void onEvent(ActivitiEvent arg0)
    {
    	//Gson gson = new Gson();
        //logger.info("ActivitiEvent json str "+gson.toJson(arg0));
    }

}
