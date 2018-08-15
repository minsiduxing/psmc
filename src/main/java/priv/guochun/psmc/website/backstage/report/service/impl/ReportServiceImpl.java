package priv.guochun.psmc.website.backstage.report.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import priv.guochun.psmc.authentication.user.service.TabPersonService;
import priv.guochun.psmc.system.exception.PsmcBuisnessException;
import priv.guochun.psmc.system.framework.page.MyPage;
import priv.guochun.psmc.system.util.DateUtil;
import priv.guochun.psmc.system.util.SystemPropertiesUtil;
import priv.guochun.psmc.system.util.UUIDGenerator;
import priv.guochun.psmc.website.backstage.common.BaseDao;
import priv.guochun.psmc.website.backstage.report.enums.ReportEnum;
import priv.guochun.psmc.website.backstage.report.model.TabReport;
import priv.guochun.psmc.website.backstage.report.model.TabReportReply;
import priv.guochun.psmc.website.backstage.report.model.TabReportReplyRel;
import priv.guochun.psmc.website.backstage.report.service.ReplyService;
import priv.guochun.psmc.website.backstage.report.service.ReportReplyRelService;
import priv.guochun.psmc.website.backstage.report.service.ReportService;
import priv.guochun.psmc.website.backstage.webuser.model.TabWebUser;
import priv.guochun.psmc.website.backstage.webuser.service.TabWebUserService;


public class ReportServiceImpl implements ReportService{
	public final static String deleteByPrimaryKeys="deleteByReportPrimaryKeys";
	public final static String insert="insertReport";
	public final static String updateByPrimaryKey="updateByReportPrimaryKey";
	public final static String selectByPrimaryKey="selectByReportPrimaryKey";
	public final static String selectAll="selectReportAll";
	public final static String dealReport="dealReport";

	
	@Autowired
	private BaseDao baseDao;
	@Autowired
	ReportReplyRelService reportReplyRelService;
	@Autowired
	ReplyService replyService;
	@Autowired
	TabPersonService tabPersonService;
	@Override
	public void saveOrUpdateReportBusinessMethod(TabReport report) {
		addRport(report);
	}
	@Override
	public void saveOrUpdateReportToMobile(TabReport report) {
		addRport(report);
	}
	@Override
	public void deleteReportBusinessMethod(String ids) {
		if(StringUtils.isBlank(ids)){throw new PsmcBuisnessException("delete key is null！");}
		//删除回复数据
		replyService.deleteByReportuuids(ids);
		//删除回复关联关系
	 	reportReplyRelService.deleteReportReplyRelByReportUids(ids);
		//删除申报数据
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("ids", ids.split(","));
		baseDao.delete(deleteByPrimaryKeys, condition);
	}

	@Override
	public MyPage findReportPageBusinessMethod(MyPage myPage) {
		Map<String,Object> condition = new HashMap<String,Object>();
	    if(myPage.getQueryParams()!=null && myPage.getQueryParams().size()>0){
	      	condition.putAll(myPage.getQueryParams());
	    }
		return baseDao.getMyPage(myPage, selectAll, condition);
	}

	@Override
	public MyPage findReportPageToMobile( MyPage page,String queryParameter,String reportType,String reportUserUuid) {
		Map<String,Object> condition = new HashMap<String,Object>();
			condition.put("queryParameter",queryParameter);
		condition.put("reportType",reportType);
		condition.put("reportUserUuid", reportUserUuid);
		return baseDao.getMyPage(page, selectAll, condition);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> findReportByUuidBusinessMethod(String reportUuid) {
		Map<String,Object> condition = new HashMap<String,Object>();
		condition.put("reportUuid", reportUuid);
		return (Map<String, Object>)baseDao.queryForObject(selectByPrimaryKey,condition);
	}

	@Override
	public void executeReplyReportBusinessMethod(String reportUuid, TabReportReply reportReply) {
		//判断是否存在对应数据
		if(StringUtils.isBlank(reportUuid)){
			throw new PsmcBuisnessException("申报标识不能为空!");
		}
		if(null == this.findReportByUuidBusinessMethod(reportUuid)){
			throw new PsmcBuisnessException("申报内容不存在不能回复!");
		}
		//判断是否已经回复过了,如果后期需要多次回复可以注释掉
		List tempList = reportReplyRelService.findTabReportReplyRelByreportUuid(reportUuid);
		if(null != tempList && tempList.size()>0){
			   throw new PsmcBuisnessException("该申请已经回复!");
		}
		//检查回复数据是否为空
		if(null == reportReply){
			   throw new PsmcBuisnessException("回复内容不能为空 !");
		}
		//新增回复数据
		 String replyUuid =  UUIDGenerator.createUUID();
		reportReply.setReplyUuid(replyUuid);
		replyService.saveOrUpdateReply(reportReply);
		//新增回复-申报关联关系
		TabReportReplyRel reportReplyRel = new TabReportReplyRel();
		reportReplyRel.setRelUuid(UUIDGenerator.createUUID());
		reportReplyRel.setReplyUuid(replyUuid);
		reportReplyRel.setReportUuid(reportUuid);
		reportReplyRelService.saveReportReplyRel(reportReplyRel);
		//更新repor的状态
		Map<String,Object> reportMap =  this.findReportByUuidBusinessMethod(reportUuid);
		TabReport report = new TabReport();
		report.setReportUuid(reportUuid);
		report.setReportUserUuid(reportMap.get("reportUserUuid").toString());
		report.setReportStaus(ReportEnum.REPORT_STAUS_REPLY.getValue());
		this.saveOrUpdateReportBusinessMethod(report);
	}

	@Override
	public Map<String, Object> getReportDetailToMobile(String reportUuid) {
		return this.findReportByUuidBusinessMethod(reportUuid);
	}
	private void addRport( TabReport report){
		if(null == report){ throw new PsmcBuisnessException("operte data is null！");}
		//根据主键是否为空判断是判断还是新增
		String reportUuid = report.getReportUuid();
		String addUserID = report.getReportUserUuid();
		if(StringUtils.isBlank(addUserID)){ throw new PsmcBuisnessException("申报人不存在！");}
		Map tempWebUser = tabPersonService.getTabPersonById(addUserID);
		if(null == tempWebUser || tempWebUser.isEmpty()){
			throw new PsmcBuisnessException("申报人不存在！");
		}
		if(StringUtils.isBlank(reportUuid)){
			//新增
			reportUuid = UUIDGenerator.createUUID();
			report.setReportUuid(reportUuid);
			report.setReportStaus(ReportEnum.REPORT_STAUS_WAIT_REPLY.getValue());
			//如果没有传则默认
			if(null!=report.getReportTime()){
				report.setReportTime(DateUtil.getCurrentTimstamp());
			}
			if("report".equals(report.getReportType())){
				report.setImagePath(SystemPropertiesUtil.getfilePrefixPath() + SystemPropertiesUtil.getHelpDeclareImagePath());
			}else{
				report.setImagePath(SystemPropertiesUtil.getfilePrefixPath() + SystemPropertiesUtil.getLawHelpImagePath());
			}
			baseDao.insert(insert, report);
		}else{
			//修改
			report.setLastModifyTime(DateUtil.getCurrentTimstamp());
			baseDao.update(updateByPrimaryKey,report);
		}
	}
	@Override
	public void  dealReportBusinessMethod(String reportUuids,String reportStatus){
		Map<String,Object> condition = new HashMap<String,Object>();
		if(StringUtils.isBlank(reportUuids)){
			throw new PsmcBuisnessException("id为空处理失败!");
		}
		condition.put("reportStaus",reportStatus);
		condition.put("ids",reportUuids.split(","));
		baseDao.update(dealReport, condition);
	}
}