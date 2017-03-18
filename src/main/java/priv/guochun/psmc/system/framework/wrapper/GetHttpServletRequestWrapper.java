package priv.guochun.psmc.system.framework.wrapper;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * 解决get方式请求服务器时的URL中携带中文的乱码问题
 * @author Administrator
 *
 */

public class GetHttpServletRequestWrapper extends HttpServletRequestWrapper {

	
	private String charset = "UTF-8";  
	
	public GetHttpServletRequestWrapper(HttpServletRequest request) {
		super(request);
	}
	
	/** 
     * 获得被装饰对象的引用和采用的字符编码 
     * @param request 
     * @param charset 
     */  
    public GetHttpServletRequestWrapper(HttpServletRequest request,  
            String charset) {  
        super(request);  
        this.charset = charset;  
    }  
    
    /** 
     * 实际上就是调用被包装的请求对象的getParameter方法获得参数，然后再进行编码转换 
     */  
    public String getParameter(String name) {  
        String value = super.getParameter(name);  
        value = value == null ? null : convert(value);  
        return value;  
    }  
    
    public String convert(String target) {  
        try {  
            return new String(target.trim().getBytes("ISO-8859-1"), charset);  
        } catch (UnsupportedEncodingException e) {  
            return target;  
        }  
    }  
	

}
