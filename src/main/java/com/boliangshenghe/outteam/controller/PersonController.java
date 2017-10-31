package com.boliangshenghe.outteam.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.boliangshenghe.outteam.entity.Phone;
import com.boliangshenghe.outteam.entity.User;
import com.boliangshenghe.outteam.service.PhoneService;
import com.boliangshenghe.outteam.service.UserService;

/**
 * 个人信息
 * @author xuzj
 *
 */
@Controller
@RequestMapping("/person")
public class PersonController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private PhoneService phoneService;
	
	@RequestMapping
	public String defaultIndex(){
		return "redirect:/person/info";
	}
	
	/**
	 * 添加 插入
	 * @param request
	 * @param response
	 * @param outteam
	 * @param model
	 * @return
	 */
	@RequestMapping("save")
	public String save(HttpServletRequest request, 
  			HttpServletResponse response,User user,Model model){
		
		phoneService.addDetail(user);
		
		return "redirect:/person/info";
	}
	
	@RequestMapping("info")
	public String info(HttpServletRequest request, 
  			HttpServletResponse response,Integer id,Model model){
		/**
		 * if roleid=4
		 * 跳转到队员信息
		 * 
		 * if roleid=2
		 * 跳转到单位管理员补充手机号
		 * 
		 */
		id=4;
		if(id!=null){
			User user = userService.selectByPrimaryKey(id);
			Phone record = new Phone();
			record.setUserid(id);
			List<Phone> phonelist = phoneService.selectListByPhone(record);
			if(null!=phonelist && phonelist.size()>0){
				Phone phone = phonelist.get(0);
				user.setPhoneone(phone.getPhoneone());
				user.setPhonetwo(phone.getPhonetwo());
			}
			model.addAttribute("user", user);
		}
		return "person/companyinfo";
	}
}
