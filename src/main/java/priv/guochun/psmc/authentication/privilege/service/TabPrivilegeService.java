package priv.guochun.psmc.authentication.privilege.service;

import java.util.List;

public interface TabPrivilegeService
{

    /**
     * 查询系统权限表作为下拉框数据
     * <p>Description:<p>
     * @return
     * @author wenxiaoming 2017年7月19日
     */
    @SuppressWarnings("rawtypes")
    public List queryTabPrivilegeForCombboox();
}
