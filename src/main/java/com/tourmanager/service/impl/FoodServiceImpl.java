package com.tourmanager.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.tourmanager.mapper.TbFoodMapper;
import com.tourmanager.pojo.TbFood;
import com.tourmanager.pojo.TbFoodExample;
import com.tourmanager.pojo.TbFoodExample.Criteria;
import com.tourmanager.service.FoodService;

import entity.PageResult;

/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
public class FoodServiceImpl implements FoodService {

	@Autowired
	private TbFoodMapper foodMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<TbFood> findAll() {
		return foodMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page<TbFood> page=   (Page<TbFood>) foodMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add(TbFood food) {
		foodMapper.insert(food);		
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update(TbFood food){
		foodMapper.updateByPrimaryKey(food);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public TbFood findOne(Integer id){
		return foodMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Integer id) {
		foodMapper.deleteByPrimaryKey(id);
	}
	
	
		@Override
	public PageResult findPage(TbFood food, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		TbFoodExample example=new TbFoodExample();
		Criteria criteria = example.createCriteria();
		
		if(food!=null){			
			if(!StringUtils.isEmpty(food.getTitle())) {
				criteria.andTitleLike("%"+food.getTitle()+"%");
			}	
		}
		
		Page<TbFood> page= (Page<TbFood>)foodMapper.selectByExample(example);		
		return new PageResult(0,"",page.getTotal(), page.getResult());
	}
	
}
