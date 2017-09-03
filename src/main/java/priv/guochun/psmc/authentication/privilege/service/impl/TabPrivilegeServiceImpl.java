package priv.guochun.psmc.authentication.privilege.service.impl;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import priv.guochun.psmc.authentication.privilege.dao.TabPrivilegeDao;
import priv.guochun.psmc.authentication.privilege.service.TabPrivilegeService;

public class TabPrivilegeServiceImpl implements TabPrivilegeService
{
    protected static final  Logger logger  = LoggerFactory.getLogger(TabPrivilegeServiceImpl.class);

    private TabPrivilegeDao tabPrivilegeDao;
    
    @Override
    @SuppressWarnings("rawtypes")
    public List  queryTabPrivilegeForCombboox()
    {
        return tabPrivilegeDao.queryTabPrivilegeForCombboox();
    }

    public void setTabPrivilegeDao(TabPrivilegeDao tabPrivilegeDao)
    {
        this.tabPrivilegeDao = tabPrivilegeDao;
    }
}
