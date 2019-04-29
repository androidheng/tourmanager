package com.tourmanager.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tourmanager.pojo.TbUser;
import com.tourmanager.service.UserService;
import com.tourmanager.utils.DateUtils;

import entity.PageResult;
import entity.Result;
/**
 * controller
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/findAll")
	public List<TbUser> findAll(){			
		return userService.findAll();
	}
	
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findPage")
	public PageResult  findPage(int page,int rows){			
		return userService.findPage(page, rows);
	}
	/**
	 * 增加
	 * @param 登录
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/login")
	public Result login(@RequestBody TbUser user){
		try {
			TbUser loginUser=userService.login(user);
			if(loginUser!=null) {
				return new Result(true, "登录成功",loginUser);
			}else {
				return new Result(false, "登录失败");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "登录失败");
		}
	}
	
	/**
	 * 增加
	 * @param user
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/register")
	public Result register(@RequestBody TbUser user){
		try {
			user.setRegisgertime(DateUtils.getCurrent());
			userService.add(user);
			return new Result(true, "注册成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "注册失败");
		}
	}
	
	/**
	 * 修改
	 * @param user
	 * @return
	 */
	@RequestMapping("/update")
	public Result update(@RequestBody TbUser user){
		try {
			userService.update(user);
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
	public TbUser findOne(Integer id){
		return userService.findOne(id);		
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/delete")
	public Result delete(Integer [] ids){
		try {
			userService.delete(ids);
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
	@RequestMapping("/search")
	public PageResult search(String key , int page, int limit  ){
		TbUser user=new TbUser();
		if(!StringUtils.isEmpty(key)) {
			user.setUsername(key);
		}
		return userService.findPage(user, page, limit);		
	}
	
}
