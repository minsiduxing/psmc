package priv.guochun.psmc.system.excepthandler;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import priv.guochun.psmc.system.exception.PsmcBuisnessException;

import com.alibaba.fastjson.support.spring.FastJsonJsonView;

public class MyExceptionHandler implements HandlerExceptionResolver {
	 private static final Logger logger = Logger.getLogger(MyExceptionHandler.class); 
	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response,  Object handler, Exception ex) {
		 logger.error("系统异常!",ex); 
		 ModelAndView mv = new ModelAndView();  
         /*  使用FastJson提供的FastJsonJsonView视图返回，不需要捕获异常   */  
         FastJsonJsonView view = new FastJsonJsonView();  
         Map<String, Object> attributes = new HashMap<String, Object>();  
         if(ex instanceof PsmcBuisnessException){
        	 attributes.put("msg", ex.getMessage()); 
        	 attributes.put("error","false");
         }else{
        	 attributes.put("msg", "发生系统错误,请联系管理员!");  
        	 attributes.put("error", "true"); 
         }
         view.setAttributesMap(attributes);  
         mv.setView(view);   
         return mv;  
		 
	}

}
