package priv.guochun.psmc.system.common.city.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import priv.guochun.psmc.system.common.city.service.CityService;
import priv.guochun.psmc.system.framework.controller.MyController;
import priv.guochun.psmc.system.util.JsonUtil;


@Controller
@RequestMapping("/system/common/cityController")
public class CityController extends MyController  {
	
	protected static final  Logger logger  = LoggerFactory.getLogger(CityController.class);
	
	 @Autowired
	 private CityService cityService;

	 
	 @RequestMapping(params="method=initRegion")  
	    @ResponseBody
	    public void initRegion(HttpServletRequest request,
	            HttpServletResponse response,String cityId) throws IOException{	
	        List list = cityService.getAllRegion(new String[]{cityId}, true, false);
	        JSONArray ja = JsonUtil.convertToJSONArray(list);
	        super.responseJson(ja, response);
	    } 
	 
	@RequestMapping(params="method=getRegionJson")  
	@ResponseBody
	public void getRegionJson(HttpServletRequest request,
		 	HttpServletResponse response,String cityId) throws IOException{
		List list = cityService.getAllRegion(new String[]{cityId}, false, true);
		JSONArray ja = JsonUtil.convertToJSONArray(list);
		super.responseJson(ja, response);
	}
}
