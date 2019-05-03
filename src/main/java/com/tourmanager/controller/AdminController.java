package com.tourmanager.controller;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tourmanager.pojo.TbAdmin;
import com.tourmanager.service.AdminService;
import com.tourmanager.utils.DateUtils;
import com.tourmanager.vo.AdminVo;

import entity.PageResult;
import entity.Result;
/**
 * controller
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;
	/**
	 * 登录
	 * @param admin
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/login")
	public Result login(@RequestBody TbAdmin admin,HttpSession session){
		try {
			TbAdmin loginAdmin=adminService.login(admin);
			if(loginAdmin!=null) {
				session.setAttribute("login", loginAdmin);
				return new Result(true, "登录成功");
			}
			return new Result(false, "登录失败");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "登录失败");
		}
	}
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findAll")
	public List<TbAdmin> findAll(){			
		return adminService.findAll();
	}
	
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findPage")
	public PageResult  findPage(int page,int rows){			
		return adminService.findPage(page, rows);
	}
	
	/**
	 * 增加
	 * @param admin
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/addOrUpdate")
	public Result addOrUpdate(@RequestBody TbAdmin admin){
		if(StringUtils.isEmpty(admin.getId())) {
			try {
				admin.setCreatetime(DateUtils.getCurrent());
				adminService.add(admin);
				return new Result(true, "增加成功");
			} catch (Exception e) {
				e.printStackTrace();
				return new Result(false, "增加失败");
			}
		}else {
			try {
				adminService.update(admin);
				return new Result(true, "修改成功");
			} catch (Exception e) {
				e.printStackTrace();
				return new Result(false, "修改失败");
			}
		}
		
	}
	
	/**
	 * 修改
	 * @param admin
	 * @return
	 */
	@RequestMapping("/update")
	public Result update(@RequestBody TbAdmin admin){
		try {
			adminService.update(admin);
			return new Result(true, "修改成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "修改失败");
		}
	}	
	
	/**
	 * 获取实体
	 * @param id
	 * @return
	 */
	@RequestMapping("/findOne")
	public TbAdmin findOne(Integer id){
		return adminService.findOne(id);		
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/delete")
	public Result delete(@RequestBody TbAdmin admin){
		try {
			adminService.delete(admin.getId());
			return new Result(true, "删除成功"); 
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "删除失败");
		}
	}
	
		/**
	 * 查询+分页
	 * @param brand
	 * @param page
	 * @param rows
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/search",produces = "application/json;charset=UTF-8")
	public PageResult search(String usertype,String key , int page, int limit  ){
		TbAdmin admin=new TbAdmin();
		if(!StringUtils.isEmpty(usertype)) {
			admin.setUsertype(usertype);
		}
		if(!StringUtils.isEmpty(key)) {
			admin.setUsername(key);
		}
		PageResult result = adminService.findPage(admin, page, limit);
		List<TbAdmin> data = result.getData();
		List<AdminVo> list=new ArrayList<>();
		for (TbAdmin ad : data) {
			AdminVo vo=new AdminVo();
			BeanUtils.copyProperties(ad, vo);
			if(ad.getUsertype().equals("1")) {
				vo.setShowstatus("用户管理者");
			}else if(ad.getUsertype().equals("2")) {
				vo.setShowstatus("发布信息者");
			}else if(ad.getUsertype().equals("3")) {
				vo.setShowstatus("审核信息者");
			}
			list.add(vo);
		}
		result.setData(list);
		return result;		
	}
	
}
