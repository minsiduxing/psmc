package priv.guochun.psmc.website.backstage.report.service;

import java.util.Map;

import priv.guochun.psmc.system.framework.page.MyPage;
import priv.guochun.psmc.website.backstage.report.model.TabReport;
import priv.guochun.psmc.website.backstage.report.model.TabReportReply;

/**
 * <p>Title:申请反馈service </p>
 * <p>Description: 1.申报内容新增或者修改；
 * 2.申报内容修改
 * 3.申报内容查询列表
 * 4.申报内容查询明细
 * 5.根据主键查询申报信息
 * 6.回复申报信息
 * 7.根据主键返回申报明细信息
 * </p>
 * @author <a href="mailTo:bingxuewulei@outlook.com">wanglei</a>
 * @version 1.0
 * @history:
 * Created by wanglei 2018年6月10日
 */
public interface ReportService {
	/**
	 * <p>Description: 1.新增或者编辑申报信息<p>
	 * @param report 申报信息
	 * @author wanglei 2018年6月10日
	 */
	 void saveOrUpdateReportBusinessMethod(TabReport report);
	/**
	 * <p>Description: 2.删除申报信息<p>
	 * @param ids 删除的主键
	 * @author wanglei 2018年6月10日
	 */
	 void deleteReportBusinessMethod(String ids);
	/**
	 * <p>Description:3.pc端查询列表<p>
	 * @param myPage 列表对象
	 * @return
	 * @author wanglei 2018年6月10日
	 */
	 MyPage findReportPageBusinessMethod(MyPage myPage);
	/**
	 * <p>Description:4.移动端查询列表<p>
	 * @param queryParameter 查询参数
	 * @param page 分页参数
	 * @return
	 * @author wanglei 2018年6月10日
	 */
	MyPage findReportPageToMobile( MyPage page,String queryParameter);
	/**
	 * <p>Description:5.根据主键查询申报信息<p>
	 * @param reportUuid 申报主键
	 * @return
	 * @author wanglei 2018年6月10日
	 */
	 Map<String,Object> findReportByUuidBusinessMethod(String reportUuid);
	/**
	 * <p>Description:6.回复申报信息<p>
	 * @param reportUuid
	 * @author wanglei 2018年6月10日
	 */
	 void executeReplyReportBusinessMethod(String reportUuid, TabReportReply reportReply);
	/**
	 * <p>Description:7.根据主键返回申报明细信息<p>
	 * @param reportUuid 申报信息主键
	 * @return
	 * @author wanglei 2018年6月10日
	 */
	Map<String,Object> getReportDetailToMobile(String reportUuid);

	 void saveOrUpdateReportToMobile(TabReport report);
}
