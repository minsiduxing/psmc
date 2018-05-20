package priv.guochun.psmc.website.backstage.InfoRelease.dao.impl;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;

import priv.guochun.psmc.system.framework.dao.IDaoTemplate;
import priv.guochun.psmc.system.framework.page.MyPage;
import priv.guochun.psmc.website.backstage.InfoRelease.dao.InfoReleaseDao;
import priv.guochun.psmc.website.backstage.InfoRelease.model.InfoRelease;

public class InfoReleaseDaoImpl implements InfoReleaseDao{

	public static final String getInfoReleaseList="getInfoReleaseList";
    public static final String getInfoReleaseByUuid="getInfoReleaseByUuid";
    public static final String getNewsTitlesListByTwoLevelClassify="getNewsTitlesListByTwoLevelClassify";
    public static final String insertInfoRelease="insertInfoRelease";
    public static final String updateInfoRelease="updateInfoRelease";
    public static final String deletesInfoReleaseByUuid="deletesInfoReleaseByUuid";
    
    private SqlSessionTemplate sqlSession;
    private IDaoTemplate iDaoTemplate;
    
	@Override
	public void saveOrUpdateInfoRelease(InfoRelease infoRelease) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteInfoReleaseByUuids(String uuids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Map<String, Object> getInfoReleaseByUuid(String uuid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MyPage getInfoReleaseList(MyPage myPage) {
		// TODO Auto-generated method stub
		return null;
	}

}
