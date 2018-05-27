package priv.guochun.psmc.system.framework.model;


/**
 * 
 * <p>Description: </p>
 * <p>Copyright: Copyright ICSS(c) 2018</p>
 * @author <a href="mailTo:Guochun002@chinasofti.com">guochun</a>
 * @version 1.0
 * @history:
 * Created by guochun 2018-1-17
 */

public class MsgModel implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private MobileReturnModel result;
	private Object data;
	
	private static int success = 1;
	private static int error = 0;
	
	private MsgModel(){
		super();
	}
	

	public static MsgModel buildSuccess(){
		MsgModel obj = new MsgModel();
		MobileReturnModel temp = new MobileReturnModel(success,"");
		obj.result=temp;
		return obj;
	}
	
	public static MsgModel buildSuccess(String msg,Object data){
		MsgModel obj = new MsgModel();
		MobileReturnModel temp = new MobileReturnModel(success,msg);
		obj.result=temp;
		obj.data = data;
		return obj;
	}
	
	public static MsgModel buildSuccess(Object data){
		MsgModel obj = new MsgModel();
		MobileReturnModel temp = new MobileReturnModel(success,"");
		obj.result=temp;
		obj.data = data;
		return obj;
	}
	
	public static MsgModel buildError(){
		MsgModel obj = new MsgModel();
		MobileReturnModel temp = new MobileReturnModel(error,"");
		obj.result=temp;
		return obj;
	}
	
	public static MsgModel buildError(String msg){
		MsgModel obj = new MsgModel();
		MobileReturnModel temp = new MobileReturnModel(error,msg);
		obj.result=temp;
		return obj;
	}

	public boolean isSuccess(){
		if(result != null && result.flag == success)
			return true;
		return false;
	}

	public MobileReturnModel getResult() {
		return result;
	}


	public void setResult(MobileReturnModel result) {
		this.result = result;
	}


	public Object getData() {
		return data;
	}


	public void setData(Object data) {
		this.data = data;
	}


	public static int getSuccess() {
		return success;
	}


	public static void setSuccess(int success) {
		MsgModel.success = success;
	}


	public static int getError() {
		return error;
	}


	public static void setError(int error) {
		MsgModel.error = error;
	}


	
	
}
