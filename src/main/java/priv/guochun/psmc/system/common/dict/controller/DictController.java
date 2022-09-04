package priv.guochun.psmc.system.common.dict.controller;

import org.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import priv.guochun.psmc.system.common.dict.service.TabDataDictService;
import priv.guochun.psmc.system.framework.controller.MyController;
import priv.guochun.psmc.system.framework.page.MyPage;
import priv.guochun.psmc.system.util.JsonUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;



@Controller
@RequestMapping("/system/common/dictController")
public class DictController extends MyController {
	
	protected static final  Logger logger  = LoggerFactory.getLogger(DictController.class);
	
	 @Autowired
	 private TabDataDictService tabDataDictService;

	 //从缓存获取某一个字典
	 @RequestMapping(params="method=loadDict")  
	 @ResponseBody
	 public void loadDict(HttpServletRequest request,
				 HttpServletResponse response,String dictNo,String parentDictType) throws IOException{
			 List<Map<?,?>> list = tabDataDictService.getDictDataList(dictNo,parentDictType);
			 JSONArray ja = JsonUtil.convertToJSONArray(list);
			 super.responseJson(ja, response);
	 }

	@RequestMapping(params="method=selectAllDicts")
	@ResponseBody
	public void selectAllDicts(MyPage page) throws IOException{
		page = tabDataDictService.getDictDataList(page);
		super.responseJson(JsonUtil.convertToJSONObject(page), this.response());
	}
	 
}
