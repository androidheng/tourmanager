package com.tourmanager.mapper;

import com.tourmanager.pojo.TbDiary;
import com.tourmanager.pojo.TbDiaryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbDiaryMapper {
    int countByExample(TbDiaryExample example);

    int deleteByExample(TbDiaryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbDiary record);

    int insertSelective(TbDiary record);

    List<TbDiary> selectByExample(TbDiaryExample example);
    
    List<TbDiary> findNoLoginAll();

    TbDiary selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbDiary record, @Param("example") TbDiaryExample example);

    int updateByExample(@Param("record") TbDiary record, @Param("example") TbDiaryExample example);

    int updateByPrimaryKeySelective(TbDiary record);

    int updateByPrimaryKey(TbDiary record);
}