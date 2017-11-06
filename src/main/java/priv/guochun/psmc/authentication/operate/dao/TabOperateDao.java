package priv.guochun.psmc.authentication.operate.dao;

import java.util.List;
import java.util.Map;

import priv.guochun.psmc.authentication.operate.model.TabOperate;

public interface TabOperateDao {

    public List<Map<?,?>> getTabOperates(String roleUuid,String resourceUuid);
    
	public List<Map<?,?>> getPermitOperatesByRoleUuid(String roleUuid);
	
	public void deleteTabOperatesByResourceUuid(String resourceUuid);
	
	   /**
     * 获取某个资源的业务操作排序号
     * <p>Description:<p>
     * @return
     * @author wenxiaoming 2017年7月19日
     */
    public Integer getTabOperateOrderNum();
    
    /**
     * 根据资源查询对应的业务操作列表
     * <p>Description:<p>
     * @param resource_uuid
     * @return
     * @author wenxiaoming 2017年8月7日
     */
    public List getTabOperatesByResourceUuid(String resourceuuid);
    
    /**
     * 保存资源的操作配置
     * <p>Description:<p>
     * @param tabResourceOperate
     * @author wenxiaoming 2017年9月2日
     */
    public void saveResOperateConfig(TabOperate tabResourceOperate);
    
    /**
     * 更新资源的操作配置
     * <p>Description:<p>
     * @param tabResourceOperate
     * @author wenxiaoming 2017年9月2日
     */
    public void updateResOperateConfig(TabOperate tabResourceOperate);
    
    /**
     * 删除操作业务配置
     * <p>Description:<p>
     * @param operateUuid
     * @return
     * @author wenxiaoming 2017年9月3日
     */
    public int deleteOperate(String operateUuid);
    
    /**
     * 根据操作编号查询操作配置的个数
     * <p>Description:<p>
     * @param operateUuid
     * @param operateNo
     * @return
     * @author wenxiaoming 2017年10月3日
     */
    public int selectOperateCountByNo(String operateUuid, String operateNo);
    
	/**
	 * 根据主键查询操作配置
	 * @param operateUuid
	 * @return
	 */
	public TabOperate selectOpertateById(TabOperate tabResourceOperate);
}