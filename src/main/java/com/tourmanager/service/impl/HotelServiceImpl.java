package com.tourmanager.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.tourmanager.mapper.TbHotelMapper;
import com.tourmanager.pojo.TbHotel;
import com.tourmanager.pojo.TbHotelExample;
import com.tourmanager.pojo.TbHotelExample.Criteria;
import com.tourmanager.service.HotelService;

import entity.PageResult;

/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
public class HotelServiceImpl implements HotelService {

	@Autowired
	private TbHotelMapper hotelMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<TbHotel> findAll() {
		return hotelMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page<TbHotel> page=   (Page<TbHotel>) hotelMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add(TbHotel hotel) {
		hotelMapper.insert(hotel);		
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update(TbHotel hotel){
		hotelMapper.updateByPrimaryKey(hotel);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public TbHotel findOne(Integer id){
		return hotelMapper.selectByPrimaryKey(id);
	}

	/**
	 * 删除
	 */
	@Override
	public void delete(Integer id) {
		hotelMapper.deleteByPrimaryKey(id);
	}
	
	
		@Override
	public PageResult findPage(TbHotel hotel, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		TbHotelExample example=new TbHotelExample();
		Criteria criteria = example.createCriteria();
		
		if(hotel!=null){			
			if(!StringUtils.isEmpty(hotel.getTitle())) {
				criteria.andTitleLike("%"+hotel.getTitle()+"%");
			}	
		}
		
		Page<TbHotel> page= (Page<TbHotel>)hotelMapper.selectByExample(example);		
		return new PageResult(0,"",page.getTotal(), page.getResult());
	}

		@Override
		public List<TbHotel> findAll(String cname) {
			TbHotelExample example=new TbHotelExample();
			Criteria criteria = example.createCriteria();
			criteria.andCnameEqualTo(cname);
			return hotelMapper.selectByExample(example);		
		}
	
}
