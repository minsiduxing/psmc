package priv.guochun.psmc.website.backstage;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import priv.guochun.psmc.system.BaseTestClass;
import priv.guochun.psmc.website.backstage.navbar.dao.TabNavBarDao;
import priv.guochun.psmc.website.backstage.navbar.model.TabNavBar;
import priv.guochun.psmc.website.backstage.navbar.service.TabNavBarService;
//配置spring和junit整合，这样junit在启动时就会加载spring容器
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring的配置文件
@ContextConfiguration(locations= {"/spring/applicationContext_base_test.xml"})
public class TabNavBarTest {
	@Autowired
	private TabNavBarService tabNavBarService;
	@Autowired
	private TabNavBarDao tabNavBarDao;
	
	public TabNavBarService getTabNavBarService() {
		return tabNavBarService;
	}


	public void setTabNavBarService(TabNavBarService tabNavBarService) {
		this.tabNavBarService = tabNavBarService;
	}


	@Test
	public void testGetAllShowTabNavBar(){
		 List<TabNavBar> navbs = tabNavBarService.getAllShowTabNavBar();
		for (TabNavBar navb : navbs) {
				System.out.println(navb);
		}
	}
}
