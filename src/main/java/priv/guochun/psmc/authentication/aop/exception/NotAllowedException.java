package priv.guochun.psmc.authentication.aop.exception;

/**
 * 业务系统权限验证异常(未授权操作的异常)
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright ICSS(c) 2017</p>
 * @author <a href="mailTo:Guochun002@chinasofti.com">guochun</a>
 * @version 1.0
 * @history:
 * Created by guochun 2017-3-7
 */
public class NotAllowedException extends RuntimeException
{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    public NotAllowedException(){
        super();
    }
    
    public NotAllowedException(String msg){
        super(msg);
    }

}
