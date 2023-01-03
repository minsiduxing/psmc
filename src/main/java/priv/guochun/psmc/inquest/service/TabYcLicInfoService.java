package priv.guochun.psmc.inquest.service;

import priv.guochun.psmc.system.framework.page.MyPage;

/**
 * @description 许可证数据维护服务类
 * @author wangt
 * @create 2022/12/28 16:05
 */
public interface TabYcLicInfoService {

    /**
     * 查询许可证数据分页
     * @param page
     * @return
     */
    MyPage selectLicInfoPage(MyPage page);
}
