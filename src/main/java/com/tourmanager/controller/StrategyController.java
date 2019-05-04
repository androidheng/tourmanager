package com.tourmanager.controller;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tourmanager.pojo.TbAdmin;
import com.tourmanager.pojo.TbCity;
import com.tourmanager.pojo.TbStrategy;
import com.tourmanager.pojo.TbUser;
import com.tourmanager.service.CityService;
import com.tourmanager.service.StrategyService;

import entity.PageResult;
import entity.Result;
/**
 * controller
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/strategy")
public class StrategyController {

	@Autowired
	private StrategyService strategyService;
	@Autowired
	private CityService cityService;
	/**
	 * 首页轮播图(点击次数最多的三个)
	 */
	@ResponseBody
	@RequestMapping("/findBanner")
	public Result findBanner(){			
		return new Result(true, strategyService.findBanner());
	}
	/**
	 * 返回全部没有登录的列表
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/findNoLoginAll")
	public Result findNoLoginAll(){			
		return new Result(true, strategyService.findNoLoginAll());
	}
	/**
	 * 根据年龄推荐的列表
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/findLoginAll")
	public Result findLoginAll(@RequestBody TbUser user){			
		return new Result(true, strategyService.findLoginAll(user));
	}
	/**
	 * 返回全部列表
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/findAll")
	public Result findAll(@RequestBody TbStrategy strategy){			
		return  new Result(true,strategyService.findAll(strategy));
	}
	@ResponseBody
	@RequestMapping("/findAllDis")
	public Result findAllDis(){			
		return  new Result(true,strategyService.findAllDis());
	}
	@ResponseBody
	@RequestMapping("/findAllDisWithLogo")
	public Result findAllDisWithLogo(){			
		return  new Result(true,strategyService.findAllDisWithLogo());
	}
	
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findPage")
	public PageResult  findPage(int page,int rows){			
		return strategyService.findPage(page, rows);
	}
	
	/**
	 * 增加
	 * @param strategy
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/addOrUpdate")
	public Result add(@RequestBody TbStrategy strategy,HttpSession session){
		TbAdmin loginAdmin=(TbAdmin) session.getAttribute("login");
		TbCity tbCity = cityService.findOne(strategy.getCid());
		if(loginAdmin!=null) {
			if(StringUtils.isEmpty(strategy.getId())) {
				try {
					strategy.setCity(tbCity.getCname());
					strategy.setStatus("1");
					strategy.setClicks(0);
					strategyService.add(strategy);
					return new Result(true, "增加成功");
				} catch (Exception e) {
					e.printStackTrace();
					return new Result(false, "增加失败");
				}
			}else {
				try {
					strategy.setCity(tbCity.getCname());
					strategyService.update(strategy);
					return new Result(true, "修改成功");
				} catch (Exception e) {
					e.printStackTrace();
					return new Result(false, "修改失败");
				}
			}
		}else {
			return new Result(false, "请先登录");
		}
	
		
	}
	
	/**
	 * 修改
	 * @param strategy
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/update")
	public Result update(@RequestBody TbStrategy strategy){
		try {
			strategyService.update(strategy);
			return new Result(true, "修改成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "修改失败");
		}
	}	
	/**
	 * 攻略被点击一次
	 * @param strategy
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/clicks")
	public Result clicks(@RequestBody TbStrategy strategy){
		try {
			TbStrategy newStrategy = strategyService.findOne(strategy.getId());
			newStrategy.setClicks(newStrategy.getClicks()+1);
			strategyService.update(newStrategy);
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
	public TbStrategy findOne(Integer id){
		return strategyService.findOne(id);		
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/delete")
	public Result delete(@RequestBody TbStrategy strategy){
		try {
			strategyService.delete(strategy.getId());
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
	public PageResult search(String citytype,String key,String status , int page, int limit  ){
		TbStrategy strategy=new TbStrategy();
		if(!StringUtils.isEmpty(citytype)) {
			strategy.setCitytype(citytype);
		}
		if(!StringUtils.isEmpty(key)) {
			strategy.setCity(key);
		}
		if(!StringUtils.isEmpty(status)) {
			strategy.setStatus(status);
		}
		return strategyService.findPage(strategy, page, limit);		
	}
	
}
