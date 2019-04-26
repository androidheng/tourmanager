package com.tourmanager.mapper;

import com.tourmanager.pojo.TbComments;
import com.tourmanager.pojo.TbCommentsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbCommentsMapper {
    int countByExample(TbCommentsExample example);

    int deleteByExample(TbCommentsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbComments record);

    int insertSelective(TbComments record);

    List<TbComments> selectByExample(TbCommentsExample example);

    TbComments selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbComments record, @Param("example") TbCommentsExample example);

    int updateByExample(@Param("record") TbComments record, @Param("example") TbCommentsExample example);

    int updateByPrimaryKeySelective(TbComments record);

    int updateByPrimaryKey(TbComments record);
}