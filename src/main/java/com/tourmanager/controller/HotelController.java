package com.tourmanager.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tourmanager.pojo.TbHotel;
import com.tourmanager.service.HotelService;

import entity.PageResult;
import entity.Result;
/**
 * controller
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/hotel")
public class HotelController {

	@Autowired
	private HotelService hotelService;
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/findAll")
	public List<TbHotel> findAll(){			
		return hotelService.findAll();
	}
	
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/findPage")
	public PageResult  findPage(int page,int rows){			
		return hotelService.findPage(page, rows);
	}
	
	/**
	 * 增加
	 * @param hotel
	 * @return
	 */
	@RequestMapping("/addOrUpdate")
	public Result addOrUpdate(@RequestBody TbHotel hotel){
		if(StringUtils.isEmpty(hotel.getId())) {
			try {
				hotelService.add(hotel);
				return new Result(true, "增加成功");
			} catch (Exception e) {
				e.printStackTrace();
				return new Result(false, "增加失败");
			}
		}else {
			try {
				hotelService.update(hotel);
				return new Result(true, "修改成功");
			} catch (Exception e) {
				e.printStackTrace();
				return new Result(false, "修改失败");
			}
		}
		
	}
	
	/**
	 * 修改
	 * @param hotel
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/update")
	public Result update(@RequestBody TbHotel hotel){
		try {
			hotelService.update(hotel);
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
	@ResponseBody
	@RequestMapping("/findOne")
	public TbHotel findOne(Integer id){
		return hotelService.findOne(id);		
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/delete")
	public Result delete(@RequestBody TbHotel hotel){
		try {
			hotelService.delete(hotel.getId());
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
	public PageResult search(String key, int page, int rows  ){
		TbHotel hotel=new TbHotel();
		if(!StringUtils.isEmpty(key)) {
			hotel.setTitle(key);
		}
		return hotelService.findPage(hotel, page, rows);		
	}
	
}
