package com.tourmanager.service;
import java.util.List;
import com.tourmanager.pojo.TbHotel;

import entity.PageResult;
/**
 * 服务层接口
 * @author Administrator
 *
 */
public interface HotelService {

	/**
	 * 返回全部列表
	 * @return
	 */
	public List<TbHotel> findAll();
	
	
	/**
	 * 返回分页列表
	 * @return
	 */
	public PageResult findPage(int pageNum,int pageSize);
	
	
	/**
	 * 增加
	*/
	public void add(TbHotel hotel);
	
	
	/**
	 * 修改
	 */
	public void update(TbHotel hotel);
	

	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	public TbHotel findOne(Integer id);
	
	
	/**
	 * 删除
	 * @param id
	 */
	public void delete(Integer  id);

	/**
	 * 分页
	 * @param pageNum 当前页 码
	 * @param pageSize 每页记录数
	 * @return
	 */
	public PageResult findPage(TbHotel hotel, int pageNum,int pageSize);
	
}
