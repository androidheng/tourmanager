package com.tourmanager.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.tourmanager.mapper.TbAttractionsMapper;
import com.tourmanager.pojo.TbAttractions;
import com.tourmanager.pojo.TbAttractionsExample;
import com.tourmanager.pojo.TbAttractionsExample.Criteria;
import com.tourmanager.service.AttractionsService;

import entity.PageResult;

/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
public class AttractionsServiceImpl implements AttractionsService {

	@Autowired
	private TbAttractionsMapper attractionsMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<TbAttractions> findAll() {
		return attractionsMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page<TbAttractions> page=   (Page<TbAttractions>) attractionsMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add(TbAttractions attractions) {
		attractionsMapper.insert(attractions);		
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update(TbAttractions attractions){
		attractionsMapper.updateByPrimaryKey(attractions);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public TbAttractions findOne(Integer id){
		return attractionsMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Integer[] ids) {
		for(Integer id:ids){
			attractionsMapper.deleteByPrimaryKey(id);
		}		
	}
	
	
		@Override
	public PageResult findPage(TbAttractions attractions, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		TbAttractionsExample example=new TbAttractionsExample();
		Criteria criteria = example.createCriteria();
		
		if(attractions!=null){			
				
		}
		
		Page<TbAttractions> page= (Page<TbAttractions>)attractionsMapper.selectByExample(example);		
		return new PageResult(0,"",page.getTotal(), page.getResult());
	}
	
}