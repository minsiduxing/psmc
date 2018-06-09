package priv.guochun.psmc.authentication.user.model.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import priv.guochun.psmc.authentication.user.model.TabGroup;
import priv.guochun.psmc.authentication.user.model.TabGroupExample;

public interface TabGroupMapper {
    int countByExample(TabGroupExample example);

    int deleteByExample(TabGroupExample example);

    int deleteByPrimaryKey(String uuid);

    int insert(TabGroup record);

    int insertSelective(TabGroup record);

    List<TabGroup> selectByExample(TabGroupExample example);

    TabGroup selectByPrimaryKey(String uuid);

    int updateByExampleSelective(@Param("record") TabGroup record, @Param("example") TabGroupExample example);

    int updateByExample(@Param("record") TabGroup record, @Param("example") TabGroupExample example);

    int updateByPrimaryKeySelective(TabGroup record);

    int updateByPrimaryKey(TabGroup record);
}