package priv.guochun.psmc.website.backstage.report.controller;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import priv.guochun.psmc.system.framework.controller.MyController;
import priv.guochun.psmc.system.framework.page.MyPage;
import priv.guochun.psmc.system.util.JsonUtil;
import priv.guochun.psmc.website.backstage.report.model.TabReportReply;
import priv.guochun.psmc.website.backstage.report.service.ReportService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>Title:申报controller</p>
 * <p>Description:1、申报列表查询
 * 2、申报明细查询
 * 3、申报回复</p>
 * @author <a href="mailTo:bingxuewulei@outlook.com">wanglei</a>
 * @version 1.0
 * @history: Created by wanglei on  2018/6/11
 */
@Scope("prototype")
@Controller
@RequestMapping("/website/backstage/reportController")
public class ReportController extends MyController {
    @Autowired
    ReportService reportService;
    @RequestMapping(params="method=index",method = RequestMethod.GET)
    public String index(String type,Model model){
        model.addAttribute("type", type);
        return "backstage/report/reportList";
    }
    @RequestMapping(params="method=to_report")
    public String toReport(String reportUuid, Model model){
        Map<String,Object> report = reportService.findReportByUuidBusinessMethod(reportUuid);
        model.addAttribute("report",report);
        return "backstage/report/reportReply";
    }
    @RequestMapping(params="method=to_report_detail")
    public String toReportDetail(String reportUuid,Model model){
        Map<String,Object> report = reportService.findReportByUuidBusinessMethod(reportUuid);
        model.addAttribute("report",report);
        return "backstage/report/reportReply";
    }
    @RequestMapping(params="method=delete",method = RequestMethod.DELETE)
    @ResponseBody
    public void reportDelete(String ids,HttpServletResponse response) throws IOException {
        reportService.deleteReportBusinessMethod(ids);
        this.responseJson(true,"删除信息成功!",response);
    }
    @RequestMapping(params="method=get_report_page")
    @ResponseBody
    public void getReportPage(HttpServletResponse response, MyPage mypage ,String reportType) throws IOException {
        Map<String,Object> qureyParams = mypage.getQueryParams();
        if(null == qureyParams || qureyParams.isEmpty()){
            qureyParams = new HashMap<>();
            qureyParams.put("reportType",reportType);
            mypage.setQueryParams(qureyParams);
        }
        mypage = reportService.findReportPageBusinessMethod(mypage);
        this.responseJson(JsonUtil.convertToJSONObject(mypage), response);
    }

    @RequestMapping(params="method=replyReport",method = RequestMethod.POST)
    @ResponseBody
    public void replyReport(HttpServletResponse response, String reportUuid, TabReportReply reportReply) throws IOException {
       if(StringUtils.isBlank(reportUuid)){
           this.responseJson(false,"回复失败",response);
           return ;
       }
       if(null == reportReply){
           this.responseJson(false,"回复失败!",response);
           return ;
       }
        reportService.executeReplyReportBusinessMethod(reportUuid,reportReply);
        this.responseJson(true,"回复成功！",response);
    }
}
