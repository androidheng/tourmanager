package com.tourmanager.mapper;

import com.tourmanager.pojo.TbStrategy;
import com.tourmanager.pojo.TbStrategyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbStrategyMapper {
    int countByExample(TbStrategyExample example);

    int deleteByExample(TbStrategyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbStrategy record);

    int insertSelective(TbStrategy record);

    List<TbStrategy> selectByExampleWithBLOBs(TbStrategyExample example);

    List<TbStrategy> selectByExample(TbStrategyExample example);

    TbStrategy selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbStrategy record, @Param("example") TbStrategyExample example);

    int updateByExampleWithBLOBs(@Param("record") TbStrategy record, @Param("example") TbStrategyExample example);

    int updateByExample(@Param("record") TbStrategy record, @Param("example") TbStrategyExample example);

    int updateByPrimaryKeySelective(TbStrategy record);

    int updateByPrimaryKeyWithBLOBs(TbStrategy record);

    int updateByPrimaryKey(TbStrategy record);

	List<TbStrategy> findNoLoginAll();

	List<TbStrategy> findBanner();
}