package priv.guochun.psmc.authentication.user.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import priv.guochun.psmc.authentication.user.dao.TabGroupDao;
import priv.guochun.psmc.authentication.user.model.TabGroup;
import priv.guochun.psmc.authentication.user.model.TabGroupExample;
import priv.guochun.psmc.authentication.user.model.TabGroupExample.Criteria;
import priv.guochun.psmc.authentication.user.model.TreeNode;
import priv.guochun.psmc.authentication.user.model.mapper.TabGroupMapper;

public class TabGroupDaoImplMybatis implements TabGroupDao 
{
	protected static final Logger logger = LoggerFactory.getLogger(TabGroupDaoImplMybatis.class);

	public static final String getAllTabGroups="getAllTabGroups";
	
	private SqlSessionTemplate sqlSession;
	
	
	
	public int getTabGroupCount(){
		TabGroupMapper mapper = sqlSession.getMapper(TabGroupMapper.class);
		return mapper.countByExample(null);
	}
	
    /**
     * 新增/修改 用户组
     * @param tabGroup
     */
    public int saveOrUpdateTabGroup(TabGroup tabGroup){
    	TabGroupMapper mapper = sqlSession.getMapper(TabGroupMapper.class);
    	TabGroup dbGroup = mapper.selectByPrimaryKey(tabGroup.getUuid());
    	if(dbGroup == null)
    		return mapper.insert(tabGroup);
    	else{
    		return mapper.updateByPrimaryKey(tabGroup);
    	}
    }
    
    public int deleteTabGroup(String uuid){
    	TabGroupMapper mapper = sqlSession.getMapper(TabGroupMapper.class);
    	return mapper.deleteByPrimaryKey(uuid);
    }

	@Override
	public List<Map<?, ?>> getAllTabGroups() {
        List<Map<?,?>> list =sqlSession.selectList(getAllTabGroups,null);
        return list;
	}
	
	@Override
	public TabGroup getTabGroupsBygroupCode(String groupCode){
		TabGroupMapper mapper = sqlSession.getMapper(TabGroupMapper.class);
		TabGroupExample example = new TabGroupExample();
		Criteria cc = example.createCriteria();
		cc.andGroupCodeEqualTo(groupCode);
		List<TabGroup> list = mapper.selectByExample(example);
		if(list != null && list.size()>0){
			return list.get(0);
		}else
			return null;
	}
	
	@Override
	public List<TabGroup> getSubTabGroupsByGroupCode(String groupCode){
		TabGroupMapper mapper = sqlSession.getMapper(TabGroupMapper.class);
		TabGroupExample example = new TabGroupExample();
		Criteria cc = example.createCriteria();
		cc.andParentGroupCodeEqualTo(groupCode);
		example.setOrderByClause(" ordernum ASC ");
		return mapper.selectByExample(example);
	}

	@Override
	public List<TreeNode> getGroupTree(String groupCode){
		Map<String, String> paramMap = new HashMap<>();
		paramMap.put("groupCode", groupCode);
		return sqlSession.selectList("getGroupTree", paramMap);
	}

	public SqlSessionTemplate getSqlSession() {
		return sqlSession;
	}

	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}

	

}
