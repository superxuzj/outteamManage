package com.boliangshenghe.outteam.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.boliangshenghe.outteam.entity.Catalogcopy;
import com.boliangshenghe.outteam.service.CatalogcopyService;

@Controller
@RequestMapping("/leader")
public class LeaderController {
	
	@Autowired
	private CatalogcopyService catalogcopyService;
	@RequestMapping
	public String defaultIndex(){
		return "redirect:/leader/list";
	}
	
	@RequestMapping("list")
	public String index(HttpServletRequest request, 
  			HttpServletResponse response,Catalogcopy record,Model model,
  			@RequestParam(defaultValue = "1", value = "pageNo") Integer pageNo){
		
		List<Catalogcopy> list = catalogcopyService.selectCatalogcopyList(record);
		model.addAttribute("list", list);
		
//		model.addAttribute("title", "四川地震");
		return "leader/list";
	}
}
