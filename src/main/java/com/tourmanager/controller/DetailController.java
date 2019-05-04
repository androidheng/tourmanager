package com.tourmanager.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tourmanager.pojo.TbStrategy;
import com.tourmanager.service.StrategyService;

@Controller
public class DetailController {
	@Autowired
	private StrategyService strategyService;
	@RequestMapping("/detail")
	public String detail(HttpServletRequest request,Model model) {
		
		TbStrategy tbStrategy = strategyService.findOne(Integer.parseInt(request.getParameter("id")));
		model.addAttribute("strategy",tbStrategy);
		return "detail";
	}
}
