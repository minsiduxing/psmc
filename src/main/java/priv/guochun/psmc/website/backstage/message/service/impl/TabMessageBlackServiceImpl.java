package priv.guochun.psmc.website.backstage.message.service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import priv.guochun.psmc.website.backstage.common.BaseDao;
import priv.guochun.psmc.website.backstage.message.model.TabMessageBlack;
import priv.guochun.psmc.website.backstage.message.service.TabMessageBlackService;

public class TabMessageBlackServiceImpl implements TabMessageBlackService {

	private static final String insertBlackSelective = "insertBlackSelective";
	
	@Autowired
	private BaseDao baseDao;
	
	@Override
	public int insertBlack(TabMessageBlack tabMessageBlack) {
		tabMessageBlack.setBlackUuid(UUID.randomUUID().toString().replace("-", ""));
		return baseDao.insert(insertBlackSelective, tabMessageBlack); 
	}

}
