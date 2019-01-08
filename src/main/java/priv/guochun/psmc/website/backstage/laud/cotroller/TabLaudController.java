package priv.guochun.psmc.website.backstage.laud.cotroller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.View;

import priv.guochun.psmc.system.framework.controller.MyController;
import priv.guochun.psmc.system.framework.page.MyPage;
import priv.guochun.psmc.system.util.JsonUtil;
import priv.guochun.psmc.website.backstage.laud.service.TabLaudService;

@Controller
@RequestMapping("/website/backstage/tabLaudController")
public class TabLaudController extends MyController{
	
	@Autowired
	private TabLaudService tabLaudService;
	
	/**
	 * 查询点赞分页列表
	 * @param myPage
	 * @param uuid
	 * @throws IOException
	 */
	@RequestMapping(params="method=queryLaudPage")
	public void queryLaudPage(MyPage myPage, String uuid, String businessType) throws IOException{
		Map<String,Object> parameterMap = myPage.getQueryParams();
		if(parameterMap == null){
			parameterMap = new HashMap<String, Object>();
		}
		parameterMap.put("moduleUuid", uuid);
		myPage.setQueryParams(parameterMap);
		myPage = tabLaudService.queryLaudPage(myPage, businessType);
		super.responseJson(JsonUtil.convertToJSONObject(myPage), this.response());
	}
	
	/**
	 * 导出点赞信息
	 * @param moduleUuid
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(params="method=exportLaudList")
	public View exportLaudList( String moduleUuid, String businessType) throws IOException{
		//1、根据条件查询点赞信息列表
		List laudList = tabLaudService.queryLaudList(moduleUuid, businessType);
		//2、将得到的数据封装到excel里
		//2.1 设置属性列名
		this.setColumns(new String[]{"infoName","laud_person_name","laud_date"});
		//2.2 设置表格的显示名
		this.setTitles(new String[]{"信息名称","点赞人姓名","点赞时间"});
		//2.3设置文件名
		this.setFileName("点赞信息列表.xls");
		//2.4 初始化数据
		this.setExportList(laudList);
		//3、返回excel下载视图
		return this.responseExcelFile(this.response()) ;
	}	

}
