package priv.guochun.psmc.system.common.dict.controller;

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

import priv.guochun.psmc.system.common.dict.service.TabDataDictService;
import priv.guochun.psmc.system.framework.controller.MyController;
import priv.guochun.psmc.system.util.JsonUtil;



@Controller
@RequestMapping("/system/common/dicyController")
public class DictController extends MyController {
	
	protected static final  Logger logger  = LoggerFactory.getLogger(DictController.class);
	
	 @Autowired
	 private TabDataDictService tabDataDictService;
	 
	 @RequestMapping(params="method=loadDict")  
	    @ResponseBody
	    public void loadDict(HttpServletRequest request,
	            HttpServletResponse response,String dictNo) throws IOException{
		 	List list = tabDataDictService.getDictDataList(dictNo);
	        JSONArray ja = JsonUtil.convertToJSONArray(list);
	        super.responseJson(ja, response);
	    } 
	 
}
