package com.tourmanager.controller;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import com.tourmanager.pojo.TbAttractions;
import com.tourmanager.service.AttractionsService;

import entity.PageResult;
import entity.Result;
/**
 * controller
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/attractions")
public class AttractionsController {

	@Autowired
	private AttractionsService attractionsService;
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findAll")
	public List<TbAttractions> findAll(){			
		return attractionsService.findAll();
	}
	
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findPage")
	public PageResult  findPage(int page,int rows){			
		return attractionsService.findPage(page, rows);
	}
	
	/**
	 * 增加
	 * @param attractions
	 * @return
	 */
	@RequestMapping("/add")
	public Result add(@RequestBody TbAttractions attractions){
		try {
			attractionsService.add(attractions);
			return new Result(true, "增加成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "增加失败");
		}
	}
	
	/**
	 * 修改
	 * @param attractions
	 * @return
	 */
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
	@RequestMapping("/delete")
	public Result delete(Integer [] ids){
		try {
			attractionsService.delete(ids);
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
	@RequestMapping("/search")
	public PageResult search(@RequestBody TbAttractions attractions, int page, int rows  ){
		return attractionsService.findPage(attractions, page, rows);		
	}
	
}
