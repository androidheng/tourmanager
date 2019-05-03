package com.tourmanager.service;
import java.util.List;
import com.tourmanager.pojo.TbGrade;

import entity.PageResult;
/**
 * 服务层接口
 * @author Administrator
 *
 */
public interface GradeService {

	/**
	 * 返回全部列表
	 * @return
	 */
	public List<TbGrade> findAll();
	
	
	/**
	 * 返回分页列表
	 * @return
	 */
	public PageResult findPage(int pageNum,int pageSize);
	
	
	/**
	 * 增加
	*/
	public void add(TbGrade grade);
	
	
	/**
	 * 修改
	 */
	public void update(TbGrade grade);
	

	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	public TbGrade findOne(Integer id);
	
	
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
	public PageResult findPage(TbGrade grade, int pageNum,int pageSize);


	public List<TbGrade> findAllByName(String attrname);
	
}
