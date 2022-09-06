package priv.guochun.psmc.website.backstage.report.service.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import priv.guochun.psmc.system.exception.PsmcBuisnessException;
import priv.guochun.psmc.system.util.DateUtil;
import priv.guochun.psmc.system.util.UUIDGenerator;
import priv.guochun.psmc.system.framework.dao.BaseDao;
import priv.guochun.psmc.website.backstage.report.model.TabReportReply;
import priv.guochun.psmc.website.backstage.report.service.ReplyService;

import java.util.HashMap;
import java.util.Map;

public class ReplyServiceImpl implements ReplyService{
    @Autowired
    BaseDao baseDao;
    public final static String insert ="insertReply";
    public final static String deleteByPrimaryKey ="deleteByReplyPrimaryKey";
    public final static String selectByPrimaryKey ="selectByReplyPrimaryKey";
    public final static String updateByPrimaryKey ="updateByReplyPrimaryKey";
    public final static String deleteByReportuuids ="deleteByReportuuids";


    @Override
    public void saveOrUpdateReply(TabReportReply tabReportReply) {
        if (null == tabReportReply) {
            throw new PsmcBuisnessException("insert data is null，add error");
        } else {
              Map tempMap = this.findByUuid(tabReportReply.getReplyUuid());
              if(null==tempMap || tempMap.size()<=0){
                if(StringUtils.isBlank(tabReportReply.getReplyUuid())){
                    tabReportReply.setReplyUuid(UUIDGenerator.createUUID());
                }
                //如果没有传则默认
                if(null==tabReportReply.getReplyTime()){
                    tabReportReply.setReplyTime(DateUtil.getCurrentTimstamp());
                }
                baseDao.insert(insert, tabReportReply);
            }else{
                tabReportReply.setLastModifyTime(DateUtil.getCurrentTimstamp());
                baseDao.update(updateByPrimaryKey,tabReportReply);
            }
        }
    }

    @Override
    public void deleteByuuids(String ids) {
        if(StringUtils.isBlank(ids)){throw new PsmcBuisnessException("delete key is null！");}
            Map<String, Object> condition = new HashMap<String, Object>();
            condition.put("ids", ids.split(","));
            baseDao.delete(deleteByPrimaryKey, condition);
        }

    @Override
    public void deleteByReportuuids(String ids) {
        if(StringUtils.isBlank(ids)){throw new PsmcBuisnessException("delete key is null！");}
        Map<String, Object> condition = new HashMap<String, Object>();
        condition.put("ids", ids.split(","));
        baseDao.delete(deleteByReportuuids, condition);
    }

    @Override
    public Map<String, Object> findByUuid(String uuid) {
        if(StringUtils.isBlank(uuid)){throw new PsmcBuisnessException("uuid  is null！");}
        Map<String, Object> condition = new HashMap<String, Object>();
        condition.put("replyUuid",uuid);
        return ( Map<String, Object>)baseDao.queryForObject(selectByPrimaryKey,condition);
    }
}
