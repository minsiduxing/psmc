package priv.guochun.psmc.news;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import priv.guochun.psmc.system.util.DateUtil;
import priv.guochun.psmc.system.util.UUIDGenerator;
import priv.guochun.psmc.website.backstage.module.dao.TabModuleDao;
import priv.guochun.psmc.website.backstage.module.model.TabModule;
import priv.guochun.psmc.website.backstage.modulepublish.dao.TabModulePublishDao;
import priv.guochun.psmc.website.backstage.modulepublish.model.TabModulePublish;
import priv.guochun.psmc.website.backstage.news.dao.TabNewsDao;
import priv.guochun.psmc.website.backstage.news.model.TabNews;
//配置spring和junit整合，这样junit在启动时就会加载spring容器
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring的配置文件
@ContextConfiguration(locations= {"/spring/applicationContext_base_test.xml"})
public class NewsServiceTest {
	List<TabNews> tanews = new ArrayList<>();
	List<TabModule> tams = new ArrayList<>();
	List<TabModulePublish> tabps = new ArrayList<>();
	@Autowired
	private TabNewsDao tabNewsDao;
	@Autowired
	private TabModuleDao tabModuleDao;
	@Autowired
	private TabModulePublishDao tabModulePublishDao;
	@Before
	public void init(){
		initNews("1","热点新闻");
		//initNews("2","实时资讯");
		//initNews("3","行业动向");
		
	}
	private void initNews (String newsType,String pre){
		TabModule tam  = null;
		TabNews tnnew = null;
		TabModulePublish tabp = null;
		for(int i =0;i<11;i++){
			tnnew = new TabNews();
			String newUuid = UUIDGenerator.createUUID();
			tnnew.setNewsUuid(newUuid);
			tnnew.setNewsTitle(pre+"新闻标题新闻标题新闻标题新闻标题新闻标题新闻标题新闻标题新闻标题新闻标题新闻标题"+i);
			tnnew.setNewSubTitle(pre+"新闻副标题测试啊新闻副标题测试啊新闻副标题测试啊新闻副标题测试啊新闻副标题测试啊新闻副标题测试啊新闻副标题测试啊"+i);
			tnnew.setNewsContent(pre+"测试内容！测试内容测试内容测试内容测试内容测试内容测试内容测试"
					+ "内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内"
					+ "内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内"
					+ "内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内"
					+ "内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内"
					+ "内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内"
					+ "内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内"
					+ "内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内"
					+ "内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内"
					+ "内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内"
					+ "内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内"
					+ "内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内"
					+ "内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内"
					+ "内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内"
					+ "内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内"
					+ "容测试内容");
			tnnew.setNewsDate(DateUtil.getCurrentTimstamp());
			tnnew.setNewsAbstarct(pre+"新闻概要测试新闻概要测试新闻概要测试新闻概要测试新闻概要测试新闻概要测试新闻概要测试新闻概要测试新闻概要测试"+i);
			tnnew.setNewAutor(pre+"新闻作者用户"+i);
			tam = new TabModule();
		    String uid = "bd474935a3894530af485bea128501ec";
			tam.setModelUuid(newUuid);
			tam.setCreateAccUuid(uid);
			tam.setCreateDate(DateUtil.getCurrentTimstamp());
			tam.setAudit(1);
			tam.setAuditAccUuid(uid);
			tam.setAuditDate(DateUtil.getCurrentTimstamp());
			tam.setReleaseAccUuid(uid);
			tam.setReleaseDate(DateUtil.getCurrentTimstamp());
			tam.setOneLevelClassify("1");
			tam.setTowLevelClassify(newsType);
			tam.setReleaseStatus("1");
			tabp = new TabModulePublish();
			tabp.setModuleUuuid(newUuid);
			tabp.setPblishUuid(UUIDGenerator.createUUID());
			tabp.setPublishAccountUuid(uid);
			tabp.setPublishDate(DateUtil.getCurrentTimstamp());
			tabp.setPublishExpireDate(DateUtil.getTime("2017-11-09 00:00:00"));
			tanews.add(tnnew);
			tams.add(tam);
			tabps.add(tabp);
		}
	}
	@Test
	public void testAdd() {
		for(int i = 0;i<tanews.size();i++){
			tabNewsDao.saveOrUpdateTabNews(tanews.get(i));
			tabModuleDao.saveOrUpdateTabModule(tams.get(i));
			tabModulePublishDao.saveOrUpdateTabModulePublish(tabps.get(i));
		}
	}

}
