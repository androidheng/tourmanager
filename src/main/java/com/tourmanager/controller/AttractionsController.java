package com.tourmanager.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tourmanager.pojo.TbAttractions;
import com.tourmanager.pojo.TbStrategy;
import com.tourmanager.service.AttractionsService;
import com.tourmanager.service.StrategyService;

import entity.PageResult;
import entity.Result;
/**
 * controller
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/attractions")
public class AttractionsController {

	@Autowired
	private AttractionsService attractionsService;
	@Autowired
	private StrategyService strategyService;
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/findAll")
	public List<TbAttractions> findAll(){			
		return attractionsService.findAll();
	}
	@ResponseBody
	@RequestMapping("/findAllApi")
	public Result findAllApi(@RequestBody TbAttractions attractions){			
		return new Result(true,attractionsService.findAllApi(attractions.getCname()));
	}
	
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/findPage")
	public PageResult  findPage(int page,int rows){			
		return attractionsService.findPage(page, rows);
	}
	
	/**
	 * 增加
	 * @param attractions
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/addOrUpdate")
	public Result add(@RequestBody TbAttractions attractions){
		if(StringUtils.isEmpty(attractions.getId())) {
			try {
				TbStrategy tbStrategy = strategyService.findOne(attractions.getCityid());
				attractions.setCname(tbStrategy.getCity());
				attractionsService.add(attractions);
				return new Result(true, "增加成功");
			} catch (Exception e) {
				e.printStackTrace();
				return new Result(false, "增加失败");
			}
		}else {
			try {
				attractionsService.update(attractions);
				return new Result(true, "修改成功");
			} catch (Exception e) {
				e.printStackTrace();
				return new Result(false, "修改失败");
			}
		}
		
	}
	
	/**
	 * 修改
	 * @param attractions
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/update")
	public Result update(@RequestBody TbAttractions attractions){
		try {
			attractionsService.update(attractions);
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
	public TbAttractions findOne(Integer id){
		return attractionsService.findOne(id);		
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/delete")
	public Result delete(@RequestBody TbAttractions attractions){
		try {
			attractionsService.delete(attractions.getId());
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
	 * @param limit
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/search")
	public PageResult search(String key , int page, int limit  ){
		TbAttractions attractions=new TbAttractions();
		if(!StringUtils.isEmpty(key)) {
			attractions.setAttrname(key);
		}
		return attractionsService.findPage(attractions, page, limit);		
	}
	
}
