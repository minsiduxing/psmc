package priv.guochun.psmc.website.backstage.report.service;

import priv.guochun.psmc.website.backstage.report.model.TabReportReplyRel;

import java.util.List;
import java.util.Map;

/**
 * <p>Title:申报回复关联关系</p>
 * <p>Description:1、关联关系查询
 * 2、关联关系新增
 * 3、关联关系删除</p>
 * @author <a href="mailTo:bingxuewulei@outlook.com">wanglei</a>
 * @version 1.0
 * @history: Created by wanglei on  2018/6/11
 */
public interface ReportReplyRelService {
    /**
     * Description: 1、新增关联关系
     * @param: 关联关系对象
     * @return: void
     * @auther: wanglei
     * @date: 2018/6/11
     **/
    void saveReportReplyRel(TabReportReplyRel reportReplyRel);
    /**
     * Description: 根据申报id删除关联关系
     * @param: ids report主键集合
     * @return:
     * @auther: wanglei
     * @date: 2018/6/11
     **/
    void deleteReportReplyRelByReportUids(String ids);
    /**
     * Description: 根据申报主键查询关联关系
     * @param: reportUuid 申报主键
     * @return: 申报关联关系集合
     * @auther: wanglei
     * @date: 2018/6/11
     **/
    List<Map<String,Object>> findTabReportReplyRelByreportUuid(String reportUuid);
}
