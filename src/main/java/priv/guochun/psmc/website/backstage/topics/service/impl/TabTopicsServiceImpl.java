package priv.guochun.psmc.website.backstage.topics.service.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import priv.guochun.psmc.system.exception.PsmcBuisnessException;
import priv.guochun.psmc.system.util.DateUtil;
import priv.guochun.psmc.system.util.UUIDGenerator;
import priv.guochun.psmc.website.backstage.common.BaseDao;
import priv.guochun.psmc.website.backstage.topics.model.TabTopics;

public class TabTopicsServiceImpl {
	
	@Autowired
	private BaseDao baseDao;
	
	public void saveOrUpdateToMobile(TabTopics tabTopics) {
		if(tabTopics == null) {
			throw new PsmcBuisnessException("主题信息数据为null!");
		}
		if(StringUtils.isBlank(tabTopics.getTopicUuid())) {
			//新增
			String reportUuid = UUIDGenerator.createUUID();
			tabTopics.setCreateDate(DateUtil.getCurrentTimstamp());
			tabTopics.setTopicStatus(1);
		}
	}
}
