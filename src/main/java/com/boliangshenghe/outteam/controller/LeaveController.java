package com.boliangshenghe.outteam.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.boliangshenghe.outteam.common.PageBean;
import com.boliangshenghe.outteam.controller.base.BaseCommonController;
import com.boliangshenghe.outteam.entity.Flight;
import com.boliangshenghe.outteam.entity.Leave;
import com.boliangshenghe.outteam.entity.Outteam;
import com.boliangshenghe.outteam.service.FlightService;
import com.boliangshenghe.outteam.service.LeaveService;
import com.boliangshenghe.outteam.service.OutteamService;
import com.boliangshenghe.outteam.service.UserService;

/**
 * 撤退管理
 * @author xuzj
 *
 */
@Controller
@RequestMapping("/leave")
public class LeaveController extends BaseCommonController{
	@Autowired
	private OutteamService outteamService;
	@Autowired
	private LeaveService leaveService;
	
	@Autowired
	private FlightService flightService;
	
	@RequestMapping
	public String defaultIndex(){
		return "redirect:/leave/list";
	}
	
	@RequestMapping("list")
	public String index(HttpServletRequest request, 
  			HttpServletResponse response,Outteam outteam,Model model,
  			@RequestParam(defaultValue = "1", value = "pageNo") Integer pageNo){
		
		Outteam eqoutteam = new Outteam();
		eqoutteam.setCid(this.getUserCid(request));
		List<Outteam> eqlist = outteamService.selectDistinctEqIDByCid(eqoutteam);
		Integer[] eqids = new Integer[10];
		if( null!=eqlist && eqlist.size()>0){
			for(int i=0;i<eqlist.size();i++){
				eqids[i] = eqlist.get(i).getEqid();
			}
			outteam.setEqids(eqids);
			outteam.setCid(this.getUserCid(request));
			PageBean<Outteam> page = outteamService.getOutteamByPageForLeave(outteam, pageNo);
			model.addAttribute("page", page);
			
		}else{
			
			if(this.getRoleId(request)!=1){//不是系统管理员 只能看到本单位的出队
				outteam.setCid(this.getUserCid(request));
			}
			PageBean<Outteam> page = outteamService.getOutteamByPage(outteam, pageNo);
			model.addAttribute("page", page);
		}
		
		model.addAttribute("outteam", outteam);
		return "leave/list";
	}
	
	/**
	 * 审批看到详情
	 * @param request
	 * @param response
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("info")
	public String info(HttpServletRequest request, 
  			HttpServletResponse response,Integer id,Model model){
		Leave leave = leaveService.selectByPrimaryKey(id);
		model.addAttribute("leave", leave);
		return "leave/info";
	}
	
	@RequestMapping("save")
	public String save(HttpServletRequest request, 
  			HttpServletResponse response,Leave leave,Model model){
		Flight flight = new Flight();
    	flight.setArractual(leave.getArractual());
    	flight.setArrcity(leave.getArrcity());
    	flight.setArrport(leave.getArrport());
    	flight.setArrscheduled(leave.getArrscheduled());
    	flight.setArrterminal(leave.getArrterminal());
    	flight.setDepactual(leave.getDepactual());
    	flight.setDepcity(leave.getDepcity());
    	flight.setDepdate(leave.getDepdate());
    	flight.setDepport(leave.getDepport());
    	flight.setDepscheduled(leave.getDepscheduled());
    	flight.setDepterminal(leave.getDepterminal());
    	flight.setFlight(leave.getFlight());
    	flight.setFlightstate(leave.getFlightstate());
    	flight.setDepdate(leave.getDepdate());
    	if(!leave.getFlight().equals("")){//要是不要坐飞机，没有航班信息
    		List<Flight> flightlist = flightService.selectFlightByRecord(flight);
        	if(flightlist!=null && flightlist.size()>0){
        		flight.setId(flightlist.get(0).getId());
        		flightService.updateByPrimaryKeySelective(flight);
        	}else{
        		flightService.insertSelective(flight);
        	}
        	leave.setFid(flight.getId());
    	}
		
		if(leave.getId()!=null){
			leaveService.updateByPrimaryKeySelective(leave);
		}else{
			leave.setCreatetime(new Date());
			leave.setState("1");//1 撤离申请  2撤离
			leaveService.insertSelective(leave);
			
			Outteam outteam = outteamService.selectByPrimaryKey(leave.getOtid());
			outteam.setState("3");
			outteam.setLid(leave.getId());
			outteamService.updateByPrimaryKeySelective(outteam);
		}
		
//		model.addAttribute("page", page);
		return "redirect:/leave/list";
	}
	
	/**
	 * 受灾省份审批确认
	 * @param request
	 * @param response
	 * @param leave
	 * @param model
	 * @return
	 */
	@RequestMapping("approval")
	public String approval(HttpServletRequest request, 
  			HttpServletResponse response,Leave leave,Model model){
		if(leave.getId()!=null){
			leave = leaveService.selectByPrimaryKey(leave.getId());
			leave.setState("2");
			leaveService.updateByPrimaryKeySelective(leave);
			
			Outteam outteam = outteamService.selectByPrimaryKey(leave.getOtid());
			outteam.setState("4");
			outteamService.updateByPrimaryKeySelective(outteam);
			
		}
		
//		model.addAttribute("page", page);
		return "redirect:/leave/list";
	}
	
	/**
	 * 申请页面
	 * @return
	 */
	@RequestMapping("ask")
	public String ask(HttpServletRequest request, 
  			HttpServletResponse response,Integer id,Model model){
		if(id!=null){
			Outteam outteam = outteamService.selectByPrimaryKey(id);
			model.addAttribute("outteam", outteam);
			if(outteam.getLid()!=null){
				Leave leave = leaveService.selectByPrimaryKey(outteam.getLid());
				model.addAttribute("leave", leave);
				
				if(null!=leave.getFid()){
					Flight flight = flightService.selectByPrimaryKey(leave.getFid());
					model.addAttribute("flight", flight);
					
				}
			}
		}
		return "leave/ask";
	}
}
