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
import org.springframework.web.bind.annotation.ResponseBody;

import com.boliangshenghe.outteam.entity.Catalogcopy;
import com.boliangshenghe.outteam.entity.Company;
import com.boliangshenghe.outteam.entity.Earthquake;
import com.boliangshenghe.outteam.entity.Outteam;
import com.boliangshenghe.outteam.entity.OutteamDetail;
import com.boliangshenghe.outteam.service.CatalogcopyService;
import com.boliangshenghe.outteam.service.CompanyService;
import com.boliangshenghe.outteam.service.EarthquakeService;
import com.boliangshenghe.outteam.service.OutteamDetailService;
import com.boliangshenghe.outteam.service.OutteamService;
import com.boliangshenghe.outteam.util.DateUtils;

@Controller
@RequestMapping("/leader")
public class LeaderController {
	
	@Autowired
	private CatalogcopyService catalogcopyService;
	
	@Autowired
	private EarthquakeService earthquakeService;
	
	@Autowired
	private OutteamService outteamService;
	
	@Autowired
	private OutteamDetailService outteamDetailService;
	
	@Autowired
	private CompanyService companyService;
	
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
		String flights = "[[{ name: '北京', value: 100 }, { name: '北京' }]]";
		model.addAttribute("flights", flights);
		model.addAttribute("text", "无");
		model.addAttribute("subtext", "现场工作队由0家单位组成，共计0人");
		return "leader/list";
	}
	
	/**
	 * 点出队
	 * @param request
	 * @param response
	 * @param cataId
	 * @param model
	 * @return
	 */
	@RequestMapping("outteam")
	public String outteam(HttpServletRequest request, 
  			HttpServletResponse response,String cataId,Model model){
		
		Catalogcopy catalogcopy = catalogcopyService.selectByPrimaryKey(cataId);
		Earthquake earthquake = new Earthquake();
		
		earthquake.setEqname(catalogcopy.getLocationCname()+catalogcopy.getM()+"级地震");
		earthquake.setArea(catalogcopy.getArea());
		earthquake.setProvince(catalogcopy.getProvince());
		earthquake.setCid(catalogcopy.getCid());
		earthquake.setCreatetime(new Date());
		earthquake.setCreator("领导");
		earthquake.setDepth(catalogcopy.getDepth().toString());
		earthquake.setEqdate(DateUtils.getYearMDayStringDate(catalogcopy.getOTime()));
		earthquake.setEqtime(DateUtils.getAllStringDate(catalogcopy.getOTime()));
		earthquake.setEventid(catalogcopy.getCataId());
		earthquake.setLatitude(catalogcopy.getLat().toString());
		earthquake.setLocation(catalogcopy.getLocationCname());
		earthquake.setLongitude(catalogcopy.getLon().toString());
		earthquake.setMagnitude(catalogcopy.getM().toString());
		earthquake.setResponseid(1);
		earthquake.setState("2");//地震事件为eqim触发
		
		earthquakeService.insertSelective(earthquake);
		
		catalogcopy.setIsouttem("1");
		catalogcopyService.updateByPrimaryKeySelective(catalogcopy);
		
		List<Catalogcopy> list = catalogcopyService.selectCatalogcopyList(new Catalogcopy());
		model.addAttribute("list", list);
		
		String flights = "[[{ name: '"+catalogcopy.getProvince()+"', value: 100 }, { name: '"+catalogcopy.getProvince()+"' }]]";
		model.addAttribute("flights", flights);
		model.addAttribute("text", "无");
		model.addAttribute("subtext", "现场工作队由0家单位组成，共计0人");
		return "leader/list";
	}
	/**
	 * 点不出队
	 * @param request
	 * @param response
	 * @param cataId
	 * @param model
	 * @return
	 */
	@RequestMapping("unoutteam")
	public String unoutteam(HttpServletRequest request, 
  			HttpServletResponse response,String cataId,Model model){
		
		Catalogcopy catalogcopy = catalogcopyService.selectByPrimaryKey(cataId);
		
		
		catalogcopy.setIsouttem("3");//领导说不要出队
		catalogcopyService.updateByPrimaryKeySelective(catalogcopy);
		
		List<Catalogcopy> list = catalogcopyService.selectCatalogcopyList(new Catalogcopy());
		model.addAttribute("list", list);
		
		String flights = "[[{ name: '北京', value: 100 }, { name: '北京' }]]";
		model.addAttribute("flights", flights);
		model.addAttribute("text", "无");
		model.addAttribute("subtext", "现场工作队由0家单位组成，共计0人");
//		model.addAttribute("title", "四川地震");
		return "leader/list";
	}
	
	/**
	 * 一个地震事件的出队单位 
	 * 单位的航班信息
	 * @param request
	 * @param response
	 * @param cataId
	 * @param model
	 * @return
	 */
	@RequestMapping("info")
	public String info(HttpServletRequest request, 
  			HttpServletResponse response,String cataId,Model model){
		
		Earthquake record = new Earthquake();
		record.setEventid(cataId);
		record.setState("2");
		List<Earthquake> earthquakeList =  earthquakeService.selectEarthquakeList(record);
		if(null !=earthquakeList && earthquakeList.size()>0){
			Earthquake earthquake = earthquakeList.get(0);
			
			Outteam ot = new Outteam();
			ot.setEqid(earthquake.getId());
			List<Outteam> outteamlist = outteamService.selectOutteamList(ot);
			model.addAttribute("outteamlist", outteamlist);
			int companycount = 0;
			String flights = "[[{ name: '"+earthquake.getProvince()+"', value: 100 }, { name: '"+earthquake.getProvince()+"' }]";
			if(null!=outteamlist && outteamlist.size()>0){
				companycount = outteamlist.size();
				flights = flights+",";
				for (Outteam outteam : outteamlist) {
					Company company = companyService.selectByPrimaryKey(outteam.getCid());
					flights = flights + "[{ name: '"+company.getLocation()+"', value: 30 }, { name: '"+earthquake.getProvince()+"' }],";
				}
				flights = flights.substring(0, flights.length()-1);
			}
			flights = flights +"]";
			model.addAttribute("flights", flights);
			
			model.addAttribute("text", earthquake.getEqname());
			model.addAttribute("subtext", "现场工作队由"+companycount+"家单位组成，共计100人");
			
			
		}else{
			String flights = "[[{ name: '北京', value: 100 }, { name: '北京' }]]";
			model.addAttribute("flights", flights);
			
			model.addAttribute("text", "无");
			model.addAttribute("subtext", "现场工作队由0家单位组成，共计0人");
		}
		
		List<Catalogcopy> list = catalogcopyService.selectCatalogcopyList(new Catalogcopy());
		model.addAttribute("list", list);
		
		
		
		/*[
         [{ name: '上海', value: 30 }, { name: '北京' }],
         [{ name: '广东', value: 30 }, { name: '北京' }],
         [{ name: '广西', value: 30 }, { name: '北京' }],
         [{ name: '江西', value: 30 }, { name: '北京' }],
         [{ name: '西藏', value:  30}, { name: '北京' }],
         [{ name: '吉林', value: 30 }, { name: '北京' }],
         [{ name: '内蒙古', value: 30 }, { name: '北京' }],
         [{ name: '四川', value: 30 }, { name: '北京' }],
         [{ name: '北京', value: 100 }, { name: '北京' }]
     ]*/
    	
		
		return "leader/list";
	}
	
	/**
	 * 一个地震事件的出队单位的人员
	 * @param request
	 * @param response
	 * @param cataId
	 * @param model
	 * @return
	 */
	@RequestMapping(value="getPersonnel", produces="text/html;charset=UTF-8")
	@ResponseBody
	public String getPersonnel(HttpServletRequest request, 
  			HttpServletResponse response,Integer otid,Model model){
        response.setHeader("Cache-Control", "no-cache");
        response.setCharacterEncoding("UTF-8");
		OutteamDetail record = new OutteamDetail();
		record.setOtid(otid);
		List<OutteamDetail> outteamDetailList = outteamDetailService.selectOutteamDetailList(record);
		
		String retu="<dd><span>无</span></dd>";
		if(null!=outteamDetailList && outteamDetailList.size()>0){
			retu = "";
			for(int i=0 ; i<outteamDetailList.size() ;i++){
				OutteamDetail outteamDetail = outteamDetailList.get(i);
				if((i+1)%3==1){
					retu = retu +"<dd><span>"+outteamDetail.getName()+"</span>";
				}else if((i+1)%3==2){
					retu = retu +"<span>"+outteamDetail.getName()+"</span>";
				}else if((i+1)%3==0){
					retu = retu +"<span>"+outteamDetail.getName()+"</span></dd>";
				}
			}
			System.out.println(retu);
		}
		return retu;
	}
}
