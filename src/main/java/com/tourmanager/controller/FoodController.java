package com.tourmanager.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tourmanager.pojo.TbFood;
import com.tourmanager.pojo.TbHotel;
import com.tourmanager.pojo.TbStrategy;
import com.tourmanager.service.FoodService;
import com.tourmanager.service.StrategyService;

import entity.PageResult;
import entity.Result;
/**
 * controller
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/food")
public class FoodController {

	@Autowired
	private FoodService foodService;
	@Autowired
	private StrategyService strategyService;
	
	/**
	 * 返回全部列表
	 * @return
	 */
	
	@ResponseBody
	@RequestMapping("/findAll")
	public Result findAll(@RequestBody TbFood food){			
		return new Result(true, foodService.findAll(food.getCname())) ;
	}
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findPage")
	public PageResult  findPage(int page,int rows){			
		return foodService.findPage(page, rows);
	}
	
	/**
	 * 增加
	 * @param food
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/addOrUpdate")
	public Result addOrUpdate(@RequestBody TbFood food){
		TbStrategy tbStrategy = strategyService.findOne(food.getCid());
		food.setCname(tbStrategy.getCity());
		if(StringUtils.isEmpty(food.getId())) {
			try {
				
				foodService.add(food);
				return new Result(true, "增加成功");
			} catch (Exception e) {
				e.printStackTrace();
				return new Result(false, "增加失败");
			}
		}else {
			try {
				foodService.update(food);
				return new Result(true, "修改成功");
			} catch (Exception e) {
				e.printStackTrace();
				return new Result(false, "修改失败");
			}
		}
	
	}
	
	/**
	 * 修改
	 * @param food
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/update")
	public Result update(@RequestBody TbFood food){
		try {
			foodService.update(food);
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
	public TbFood findOne(Integer id){
		return foodService.findOne(id);		
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/delete")
	public Result delete(@RequestBody TbFood food){
		try {
			foodService.delete(food.getId());
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
	 * @param rows
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/search")
	public PageResult search(String key,  int page, int limit  ){
		TbFood food=new TbFood();
		if(!StringUtils.isEmpty(key)) {
			food.setTitle(key);
		}
		return foodService.findPage(food, page, limit);		
	}
	
}
