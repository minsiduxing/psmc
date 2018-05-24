package priv.guochun.psmc.system.framework.model;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright ICSS(c) 2018</p>
 * @author <a href="mailTo:Guochun002@chinasofti.com">guochun</a>
 * @version 1.0
 * @history:
 * Created by guochun 2018-1-17
 */


public class MobileReturnModel implements java.io.Serializable {

	public int flag;
	public String msg;
	
	
	public MobileReturnModel(int flag,String msg){
		this.flag = flag;
		this.msg = msg;
	}


	public int getFlag() {
		return flag;
	}


	public void setFlag(int flag) {
		this.flag = flag;
	}


	public String getMsg() {
		return msg;
	}


	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
}
