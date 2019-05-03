package com.tourmanager.controller;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ResponseBody;
import com.tourmanager.pojo.TbCity;
import com.tourmanager.service.CityService;

import entity.PageResult;
import entity.Result;
/**
 * controller
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/city")
public class CityController {

	@Autowired
	private CityService cityService;
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/findAll",produces = "application/json;charset=UTF-8")
	public List<TbCity> findAll(){			
		return cityService.findAll();
	}
	
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/findPage")
	public PageResult  findPage(int page,int rows){			
		return cityService.findPage(page, rows);
	}
	
	/**
	 * 添加或者修改
	 * @param city
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/addOrUpdate",produces = "application/json;charset=UTF-8")
	public Result addOrUpdate(@RequestBody TbCity city){
		if(StringUtils.isEmpty(city.getId())) {
		try {
			TbCity newcity=cityService.findCity(city);
			if(newcity!=null)
				return new Result(true, city.getCname()+"已经存在!");
			cityService.add(city);
			return new Result(true, "增加成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "增加失败");
		}
		}else{
			try {
			cityService.update(city);
			return new Result(true, "修改成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "修改失败");
		}
		}
		
	}
	

	
	/**
	 * 获取实体
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/findOne")
	public TbCity findOne(Integer id){
		return cityService.findOne(id);		
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/delete",produces = "application/json;charset=UTF-8")
	public Result delete(@RequestBody TbCity city){
		try {
			cityService.delete(city.getId());
			return new Result(true, "删除成功"); 
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "删除失败");
		}
	}
	
		/**
	 * 查询+分页
	 * @param key
	 * @param page
	 * @param limit
	 * @return
	 */
	 @ResponseBody
	@RequestMapping(value="/search",produces = "application/json;charset=UTF-8")
	public PageResult search(String key, int page, int limit  ){
		TbCity city=new TbCity();
		if(!StringUtils.isEmpty(key)) {
			
		}
		return cityService.findPage(city, page, limit);		
	}
	
}
