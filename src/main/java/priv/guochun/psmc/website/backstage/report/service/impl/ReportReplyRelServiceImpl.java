package priv.guochun.psmc.website.backstage.report.service.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import priv.guochun.psmc.system.exception.PsmcBuisnessException;
import priv.guochun.psmc.system.util.UUIDGenerator;
import priv.guochun.psmc.system.framework.dao.BaseDao;
import priv.guochun.psmc.website.backstage.report.model.TabReportReplyRel;
import priv.guochun.psmc.website.backstage.report.service.ReportReplyRelService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReportReplyRelServiceImpl implements ReportReplyRelService {
    @Autowired
    BaseDao baseDao;
    public final static String insert ="insertReportRel";
    public final static String deleteByPReportUuid ="deleteByPReportUuid";
    public final static String selectByReportUuid ="selectByReportUuid";
    @Override
    public void saveReportReplyRel(TabReportReplyRel reportReplyRel) {
        if (null == reportReplyRel) {
            throw new PsmcBuisnessException("insert data is null，add error");
        } else {
            reportReplyRel.setRelUuid(UUIDGenerator.createUUID());
            baseDao.insert(insert, reportReplyRel);
        }
    }
    @Override
    public void deleteReportReplyRelByReportUids(String ids) {
        if(StringUtils.isBlank(ids)){throw new PsmcBuisnessException("delete key is null！");}
        Map<String, Object> condition = new HashMap<String,Object>();
        condition.put("ids", ids.split(","));
        baseDao.delete(deleteByPReportUuid, condition);
    }

    @Override
    public List<Map<String, Object>> findTabReportReplyRelByreportUuid(String reportUuid) {
        if(StringUtils.isBlank(reportUuid)){throw new PsmcBuisnessException("reportUuid  is null！");}
        Map<String, Object> condition = new HashMap<String,Object>();
        condition.put("reportUuid",reportUuid);
        return baseDao.queryForList(selectByReportUuid,condition);
    }
}
