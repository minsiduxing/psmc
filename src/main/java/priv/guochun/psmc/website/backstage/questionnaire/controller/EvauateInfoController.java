package priv.guochun.psmc.website.backstage.questionnaire.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import priv.guochun.psmc.authentication.login.model.User;
import priv.guochun.psmc.system.framework.controller.MyController;
import priv.guochun.psmc.system.framework.excel.ExcelUtil;
import priv.guochun.psmc.system.framework.page.MyPage;
import priv.guochun.psmc.system.util.ContantsUtil;
import priv.guochun.psmc.system.util.JsonUtil;
import priv.guochun.psmc.system.util.SystemPropertiesUtil;
import priv.guochun.psmc.website.backstage.excellentInnovation.model.TabExcellentInnovation;
import priv.guochun.psmc.website.backstage.module.model.TabModule;
import priv.guochun.psmc.website.backstage.questionnaire.model.TabEvaluateInfo;
import priv.guochun.psmc.website.backstage.questionnaire.service.TabEvaluateInfoService;

@Controller
@RequestMapping("/website/backstage/EvauateInfoController")
public class EvauateInfoController extends MyController{
	
	@Autowired
	private TabEvaluateInfoService tabEvaluateInfoService;

	/**
	 * 提交客户消费信息
	 * @param evaluateInfo
	 */
	@RequestMapping(params="method=submit")
	public void submit(TabEvaluateInfo evaluateInfo) throws IOException{
		User user = this.getUserBySeesion(this.request());
		tabEvaluateInfoService.insertEvaluateInfoBusinessMethod(evaluateInfo, user);
		super.responseJson(true, "操作成功!", this.response());
	}
	
	/**
	 * 查询客户消费信息列表
	 * @param myPage
	 * @throws IOException 
	 */
	@RequestMapping(params="method=evaluateInfoList")
	@ResponseBody
	public void queryEvaluateInfoList(MyPage myPage) throws IOException{
		myPage = tabEvaluateInfoService.queryEvaluateInfoListBusinessMethod(myPage);
		super.responseJson(JsonUtil.convertToJSONObject(myPage), this.response());
	}
	
	/**
	 * 跳转到客户消费信息列表界面
	 * @return
	 */
	@RequestMapping(params="method=toEvaluateInfoList")
	public String toEvaluateInfoList(){
		return "backstage/questionnaire/evaluateInfoList";
	}
	
	/**
	 * 导入客户消费信息
	 * @param file
	 * @param excelExamInfoUuid
	 * @throws IOException 
	 */
	@RequestMapping(params="method=loadExcelEvaluateInfo")
	public void loadExcelEvaluateInfo(File file, Integer evaluateNoticeType, String questionnaireUuid) throws IOException {
		String filePath = file.getPath();
		if (!(filePath.endsWith("xls"))) {
			super.responseJson(false, "只支持xls后缀的Excel文件!", this.response());;
        }else{
        	//使用工具类读取excel数据
    		ExcelUtil excelUtil = new ExcelUtil(file);
    		List<String[]> excelList = excelUtil.readExcel();
            
            Map<String,String> resultMap=new HashMap<String, String>();
            if(excelList!=null && excelList.size()>0){
            	User user = this.getUserBySeesion(this.request());
            	tabEvaluateInfoService.saveExcelEvaluateBusinessMethod(excelList, evaluateNoticeType, questionnaireUuid, user);
            }else{
            	super.responseJson(false, "该文件没有需要导入的数据", this.response());
            }
            super.responseJson(true, "导入成功!", this.response());
        }
        
    }
}
