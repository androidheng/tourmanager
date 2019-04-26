package com.tourmanager.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.tourmanager.mapper.TbAdminMapper;
import com.tourmanager.pojo.TbAdmin;
import com.tourmanager.pojo.TbAdminExample;
import com.tourmanager.pojo.TbAdminExample.Criteria;
import com.tourmanager.service.AdminService;

import entity.PageResult;

/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private TbAdminMapper adminMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<TbAdmin> findAll() {
		return adminMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page<TbAdmin> page=   (Page<TbAdmin>) adminMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add(TbAdmin admin) {
		adminMapper.insert(admin);		
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update(TbAdmin admin){
		adminMapper.updateByPrimaryKeySelective(admin);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public TbAdmin findOne(Integer id){
		return adminMapper.selectByPrimaryKey(id);
	}

	/**
	 * 删除
	 */
	@Override
	public void delete(Integer id) {
		adminMapper.deleteByPrimaryKey(id);
	}
	
	
		@Override
	public PageResult findPage(TbAdmin admin, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		TbAdminExample example=new TbAdminExample();
		Criteria criteria = example.createCriteria();
		
		if(admin!=null){			
			if(!StringUtils.isEmpty(admin.getUsername())) {
				criteria.andUsernameLike("%"+admin.getUsername()+"%");
			}
			if(!StringUtils.isEmpty(admin.getUsertype())) {
				criteria.andUsertypeEqualTo(admin.getUsertype());
			}
		}
		
		Page<TbAdmin> page= (Page<TbAdmin>)adminMapper.selectByExample(example);		
		return new PageResult(0,"",page.getTotal(), page.getResult());
	}

		@Override
		public TbAdmin login(TbAdmin admin) {
			TbAdminExample example=new TbAdminExample();
			Criteria criteria = example.createCriteria();
			
			if(admin!=null){			
				if(!StringUtils.isEmpty(admin.getUsername())) {
					criteria.andUsernameEqualTo(admin.getUsername());
				}
				if(!StringUtils.isEmpty(admin.getPassword())) {
					criteria.andPasswordEqualTo(admin.getPassword());
				}
				if(!StringUtils.isEmpty(admin.getUsertype())) {
					criteria.andUsertypeEqualTo(admin.getUsertype());
				}
			}
			
			List<TbAdmin> list = adminMapper.selectByExample(example);
			if(list.size()>0)
				return list.get(0);
			return null;
		}
	
}
