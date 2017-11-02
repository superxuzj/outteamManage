package com.boliangshenghe.outteam.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.boliangshenghe.outteam.common.PageBean;
import com.boliangshenghe.outteam.controller.base.BaseCommonController;
import com.boliangshenghe.outteam.entity.Flight;
import com.boliangshenghe.outteam.entity.Outteam;
import com.boliangshenghe.outteam.entity.OutteamDetail;
import com.boliangshenghe.outteam.entity.User;
import com.boliangshenghe.outteam.json.JsonFlight;
import com.boliangshenghe.outteam.json.Result;
import com.boliangshenghe.outteam.service.FlightService;
import com.boliangshenghe.outteam.service.OutteamDetailService;
import com.boliangshenghe.outteam.service.OutteamService;
import com.boliangshenghe.outteam.service.UserService;
import com.boliangshenghe.outteam.util.FlightUtils;

/**
 * 出队管理
 * @author xuzj
 *
 */
@Controller
@RequestMapping("/outteam")
public class OutTeamController extends BaseCommonController{
	
	@Autowired
	private OutteamService outteamService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private OutteamDetailService outteamDetailService;
	
	@Autowired
	private FlightService flightService;
	
	@RequestMapping
	public String defaultIndex(){
		return "redirect:/outteam/list";
	}
	
	@RequestMapping("list")
	public String index(HttpServletRequest request, 
  			HttpServletResponse response,Outteam outteam,Model model,
  			@RequestParam(defaultValue = "1", value = "pageNo") Integer pageNo){
		
		if(this.getRoleId(request)!=1){//不是系统管理员 只能看到本单位的出队
			outteam.setCid(this.getUserCid(request));
		}
		PageBean<Outteam> page = outteamService.getOutteamByPage(outteam, pageNo);
		model.addAttribute("page", page);
		return "outteam/list";
	}
	
	@RequestMapping("info")
	public String info(HttpServletRequest request, 
  			HttpServletResponse response,Integer id,Model model){
		if(id!=null){
			Outteam outteam = outteamService.selectByPrimaryKey(id);
			model.addAttribute("outteam", outteam);
			if(outteam.getFid()!=null){
				Flight flight = flightService.selectByPrimaryKey(outteam.getFid());
				model.addAttribute("flight", flight);
			}
			OutteamDetail outteamDetail = new OutteamDetail();
			outteamDetail.setCid(outteam.getCid());
			outteamDetail.setEqid(outteam.getEqid());
			List<OutteamDetail> otdetailList = outteamDetailService.selectOutteamDetailList(outteamDetail);
			if(otdetailList!=null && otdetailList.size()>0){
				model.addAttribute("otdetailList", otdetailList);
			}
		}
		return "outteam/info";
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
  			HttpServletResponse response,Outteam outteam,Model model){
		
		outteamService.addDetail(outteam);
		
		System.out.println(outteam.getChooses()+" save");
		return "redirect:/outteam/list";
	}
	/**flight
	 * @param request
	 * @param response
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("goadd")
	public String goadd(HttpServletRequest request, 
  			HttpServletResponse response,Integer id,Model model){
		if(id!=null){
			Outteam outteam = outteamService.selectByPrimaryKey(id);
			model.addAttribute("outteam", outteam);
			if(outteam.getFid()!=null){
				Flight flight = flightService.selectByPrimaryKey(outteam.getFid());
				model.addAttribute("flight", flight);
			}
			OutteamDetail outteamDetail = new OutteamDetail();
			outteamDetail.setCid(outteam.getCid());
			outteamDetail.setEqid(outteam.getEqid());
			List<OutteamDetail> otdetailList = outteamDetailService.selectOutteamDetailList(outteamDetail);
			if(otdetailList!=null && otdetailList.size()>0){
				model.addAttribute("otdetailList", otdetailList);
			}
		}
		return "outteam/addOrEdit";
	}
	/**
	 * 选择出队员工弹出框
	 * @param request
	 * @param response
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("personlist")
	public String personlist(HttpServletRequest request, 
  			HttpServletResponse response,Integer id,Model model){
		Outteam outteam = outteamService.selectByPrimaryKey(id);
		User user = new User();
		user.setCid(outteam.getCid());
		//user.setCid(1);
		List<User> userlist = userService.selectUserList(user);//查询单位员工
		OutteamDetail outteamDetail = new OutteamDetail();
		outteamDetail.setCid(outteam.getCid());
		outteamDetail.setEqid(outteam.getEqid());
		List<OutteamDetail> otdetailList = outteamDetailService.selectOutteamDetailList(outteamDetail);
		if(otdetailList!=null && otdetailList.size()>0){
			for (OutteamDetail detail : otdetailList) {
				for (User u : userlist) {
					if(detail.getUserid()==u.getId()){
						u.setIschoose("1");
					}
					if(detail.getIslead()!=null && detail.getIslead().equals("1") && detail.getUserid()==u.getId()){
						u.setIslead("1");
					}
					if(detail.getIscontact()!=null && detail.getIscontact().equals("1") && detail.getUserid()==u.getId()){
						u.setIscontact("1");
					}
					if(detail.getIsmeet()!=null && detail.getIsmeet().equals("1") && detail.getUserid()==u.getId()){
						u.setIsmeet("1");
					}
				}
			}
		}
		
		model.addAttribute("otdetailList", otdetailList);
		model.addAttribute("userlist", userlist);
		return "outteam/personlist";
	}
	
	/**
	 * 获取航班信息
	 * @param request
	 * @param response
	 * @param outteam
	 * @param model
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value="/flight",produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String flight(HttpServletRequest request, 
  			HttpServletResponse response,String depdate,String flight,Model model) throws Exception{
		response.setContentType("text/json;charset=utf-8"); 
		System.out.println(depdate);
		String content = FlightUtils.makeRequest(flight, depdate);
		if(content.indexOf("output")==-1){//查询失败，返回失败信息
			return content;
		}
		
		JSONObject jsonObj = JSONObject.parseObject(content);
//		System.out.println(jsonObj.toString());
		JsonFlight jsonFlight = JSON.toJavaObject(jsonObj, JsonFlight.class);
		List<Result> resultList = jsonFlight.getOutput().getResult();
		
		
		JSONObject retudate = new JSONObject();
		if(resultList!=null && resultList.size()>1){
			retudate.put("size",resultList.size());
		}
		if(resultList!=null && resultList.size()>0){
			Result result = resultList.get(0);
			retudate.put("depcity",result.getDepCity());
			retudate.put("arrcity",result.getArrCity());
			retudate.put("depterminal",result.getDepTerminal());
			retudate.put("arrterminal",result.getArrTerminal());
			retudate.put("depscheduled",result.getDepScheduled());
			retudate.put("arrscheduled",result.getArrScheduled());
			retudate.put("depactual",result.getDepActual());
			retudate.put("arractual",result.getArrActual());
			retudate.put("depport",result.getDepPort());
			retudate.put("arrport",result.getArrPort());
			
			if(result.getDepActual().equals("0001-01-01T00:00:00Z")&&result.getArrActual().equals("0001-01-01T00:00:00Z")){
				retudate.put("flightstate","计划");
			}else if(!result.getDepActual().equals("0001-01-01T00:00:00Z")&& result.getArrActual().equals("0001-01-01T00:00:00Z")){
				retudate.put("flightstate","起飞");
			}else{
				retudate.put("flightstate","到达");
			}
			
			
			
		}
		String json = retudate.toString();
		return json;
		
		/*JSONObject retudate = new JSONObject();
		retudate.put("depcity","123");
		retudate.put("arrcity","234");
		String json = retudate.toString();
		return json;*/
	}
	
	
	/**
	 * 获取航班信息 
	 * 肯定是多个
	 * @param request
	 * @param response
	 * @param outteam
	 * @param model
	 * @return
	 * 到达 计划 起飞
	 * 
	 * 0001-01-01T00:00:00Z
	 * @throws Exception 
	 */
	@RequestMapping("flightlist")
	public String flightlist(HttpServletRequest request, 
  			HttpServletResponse response,String depdate,String flight,Model model) throws Exception{
		String content = FlightUtils.makeRequest(flight, depdate);
		JSONObject jsonObj = JSONObject.parseObject(content);
//		System.out.println(jsonObj.toString());
		JsonFlight jsonFlight = JSON.toJavaObject(jsonObj, JsonFlight.class);
		List<Result> resultList = jsonFlight.getOutput().getResult();
		List<Result> list = new ArrayList<Result>();
		for(int i=0;i<resultList.size();i++){
			Result temp = resultList.get(i);
			
			if(temp.getDepActual().equals("0001-01-01T00:00:00Z")&&temp.getArrActual().equals("0001-01-01T00:00:00Z")){
				temp.setFlightState("计划");
			}else if(!temp.getDepActual().equals("0001-01-01T00:00:00Z")&& temp.getArrActual().equals("0001-01-01T00:00:00Z")){
				temp.setFlightState("起飞");
			}else{
				temp.setFlightState("到达");
			}
			
			temp.setIndex(i);
			list.add(temp);
		}
		model.addAttribute("resultList", list);
		return "outteam/flightlist";
		
		
	}
}
