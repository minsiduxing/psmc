package priv.guochun.psmc.website.backstage.report.service;

import priv.guochun.psmc.website.backstage.report.model.TabReportReply;

import java.util.Map;

/**
 * <p>Title:申报内容回复service</p>
 * <p>Description:1、申报内容查询
 * 2、申报内容新增，修改
 * 3、申报内容查询</p>
 * @author <a href="mailTo:bingxuewulei@outlook.com">wanglei</a>
 * @version 1.0
 * @history: Created by wanglei on  2018/6/11
 */
public interface ReplyService {
    /**
     * <p>Description: 1、删除或者更新回复对象</p>
     * @param:  tabReportReply 回复对象
     * @return:  void
     * @auther: wanglei 2018/6/11
     **/
    void  saveOrUpdateReply(TabReportReply tabReportReply);
    /**
     * <p>Description:2、删除回复信息</p>
     * @param: 删除id
     * @return:
     * @auther: wanglei 2018/6/11
     **/
    void  deleteByuuids(String ids);
    /**
     * <p>Description:根据申报UUid删除回复信息</p>
     * @param:  申报Uuid
     * @return:
     * @auther: wanglei 2018/6/11
     **/
    void  deleteByReportuuids(String ids);
    /**
     * <p>Description:根据主键查询回复信息</p>
     * @param: uuid 主键
     * @return:
     * @auther: wanglei 2018/6/11
     **/
    Map<String,Object> findByUuid(String uuid);
}
