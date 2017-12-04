package com.boliangshenghe.outteam.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.boliangshenghe.outteam.controller.base.BaseCommonController;
import com.boliangshenghe.outteam.entity.Login;
import com.boliangshenghe.outteam.entity.User;
import com.boliangshenghe.outteam.service.LoginService;
import com.boliangshenghe.outteam.service.UserService;
import com.boliangshenghe.outteam.util.CommonUtils;

@Controller
public class LoginController extends BaseCommonController{
	
	@Autowired
	public UserService userService;
	
	@Autowired
	private LoginService loginService;
	
	@RequestMapping("/index")
	public String index1(){
		return "index";
	}
	
	/**
	 * 首页
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("")
    public String index(HttpServletRequest request, 
  			HttpServletResponse response) {
        return "redirect:/login";
    }
	
	/**
	 * 判断一下是否登录
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/login")
    public String login(HttpServletRequest request, 
  			HttpServletResponse response) {
		HttpSession session = request.getSession();
		if(session.getAttribute(CommonUtils.USERID)!=null){
			return "redirect:/dologin";
		}else{
			 return "login";
		}
       
    }

	@RequestMapping("/dologin")
	public String dologin(HttpServletRequest request, 
  			HttpServletResponse response,User user,Model model){
		
		User usermodel = userService.selectByPrimaryKey(this.getUserId(request));
		
		Login loginInfo = new Login();
		loginInfo.setLogindate(new Date());
		loginInfo.setLoginip(this.getRemortIP(request));
		loginInfo.setName(usermodel.getName());
		loginInfo.setUsername(usermodel.getPhone());
		loginInfo.setCid(usermodel.getCid());
		loginInfo.setCompany(usermodel.getCompany());
		loginService.insertSelective(loginInfo);
		/*if(usermodel.getPassword().equals("111111")){
			return "redirect:/changepwd?id="+usermodel.getId()+"&change=1";
		}*/
		/*if(usermodel.getType()!=null && usermodel.getType().equals("5")){
			return "redirect:/manage";
		}else if(usermodel.getType()!=null && usermodel.getType().equals("4")){
			return "redirect:/business";
		}else if(usermodel.getType()!=null && usermodel.getType().equals("3")){
			model.addAttribute("businesstype", "2");
			return "redirect:/business";
		}else if(usermodel.getType()!=null && usermodel.getType().equals("2")){
			model.addAttribute("businesstype", "1");
			return "redirect:/business";
		}else if(usermodel.getType()!=null && usermodel.getType().equals("1")){*/
		
		if(usermodel.getRoleid()!=null && usermodel.getRoleid().toString().equals("3")){
			return "redirect:/leader";
		}else{
			return "redirect:/earthquake/list";
		}
		
		
	}
	

	 //验证用户名和密码是否正确
 	@RequestMapping("/user/validate")
 	@ResponseBody
 	public String validateNameAndPassword(HttpServletRequest request, 
 			HttpServletResponse response, String username,String password,String code) {
 		System.out.println(username+" "+password);
 		Map<String,String> map = new HashMap<String,String> ();
 		 if (!(code.equalsIgnoreCase(request.getSession().getAttribute("code").toString()))) {  //忽略验证码大小写  
  			map.put("message", "验证码错误！");  
  			return responseWrite(request, response, map);
          }
// 		HttpSession sesion = request.getSession();
 		User user = new User();
 		user.setUsername(username);
 		user.setPassword(password);
 		List<User> loginList = userService.selectUserList(user);
 		
 		if(loginList!=null && loginList.size()>0){
 			HttpSession session = request.getSession();
 			User usermodel = loginList.get(0);
 			session.setAttribute(CommonUtils.USERID, usermodel.getId());
 			session.setAttribute(CommonUtils.USERNAME, usermodel.getUsername());
 			session.setAttribute(CommonUtils.REALNAME, usermodel.getName());
 			session.setAttribute(CommonUtils.ROLEID, usermodel.getRoleid());
 			session.setAttribute(CommonUtils.CID, usermodel.getCid());
 			session.setAttribute(CommonUtils.COMPANY, usermodel.getCompany());
 			session.setAttribute(CommonUtils.ISLOGIN, "OK");
 			map.put("message", "OK");
 		}else{
 			map.put("message", "用户名或密码错误！");
 		}
 		return responseWrite(request, response, map);
 	}
 	
 	
 	/**
 	 * 退出
 	 * @param request
 	 * @param response
 	 * @param user
 	 * @param model
 	 * @return
 	 */
 	@RequestMapping("/loginout")
	public String loginout(HttpServletRequest request, 
  			HttpServletResponse response,User user,Model model){
		HttpSession session = request.getSession();
		CommonUtils.addNoCacheHeader(response);
		
		session.setAttribute(CommonUtils.USERID,null);
		session.setAttribute(CommonUtils.USERNAME,null);
		
		session.setAttribute(CommonUtils.REALNAME,null);
		session.setAttribute(CommonUtils.ROLEID,null);
		session.setAttribute(CommonUtils.CID,null);
		session.setAttribute(CommonUtils.COMPANY,null);
		session.setAttribute(CommonUtils.ISLOGIN,null);
		return "redirect:/login";
	}
}
