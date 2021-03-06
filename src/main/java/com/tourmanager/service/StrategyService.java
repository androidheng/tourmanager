package com.tourmanager.service;
import java.util.List;
import com.tourmanager.pojo.TbStrategy;
import com.tourmanager.pojo.TbUser;

import entity.PageResult;
/**
 * 服务层接口
 * @author Administrator
 *
 */
public interface StrategyService {

	/**
	 * 返回全部列表
	 * @return
	 */
	public List<TbStrategy> findAll(TbStrategy strategy);
	
	
	/**
	 * 返回分页列表
	 * @return
	 */
	public PageResult findPage(int pageNum,int pageSize);
	
	
	/**
	 * 增加
	*/
	public void add(TbStrategy strategy);
	
	
	/**
	 * 修改
	 */
	public void update(TbStrategy strategy);
	

	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	public TbStrategy findOne(Integer id);
	
	
	/**
	 * 批量删除
	 * @param ids
	 */
	public void delete(Integer  id);

	/**
	 * 分页
	 * @param pageNum 当前页 码
	 * @param pageSize 每页记录数
	 * @return
	 */
	public PageResult findPage(TbStrategy strategy, int pageNum,int pageSize);


	public List<TbStrategy> findNoLoginAll();


	public List<TbStrategy> findBanner();


	public List<TbStrategy> findLoginAll(TbUser user);


	public List<TbStrategy> findAllDis();


	public List<TbStrategy> findAllDisWithLogo();
	
}
