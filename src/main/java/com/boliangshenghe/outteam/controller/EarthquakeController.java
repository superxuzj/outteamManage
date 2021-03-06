package com.boliangshenghe.outteam.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.boliangshenghe.outteam.common.PageBean;
import com.boliangshenghe.outteam.controller.base.BaseCommonController;
import com.boliangshenghe.outteam.entity.Catalogcopy;
import com.boliangshenghe.outteam.entity.Company;
import com.boliangshenghe.outteam.entity.Earthquake;
import com.boliangshenghe.outteam.entity.Hbplan;
import com.boliangshenghe.outteam.entity.HbplanDetail;
import com.boliangshenghe.outteam.entity.Link;
import com.boliangshenghe.outteam.entity.LinkDetail;
import com.boliangshenghe.outteam.entity.Onduty;
import com.boliangshenghe.outteam.entity.Outteam;
import com.boliangshenghe.outteam.entity.OutteamDetail;
import com.boliangshenghe.outteam.entity.Response;
import com.boliangshenghe.outteam.entity.ResponseCompany;
import com.boliangshenghe.outteam.service.CatalogcopyService;
import com.boliangshenghe.outteam.service.CompanyService;
import com.boliangshenghe.outteam.service.EarthquakeService;
import com.boliangshenghe.outteam.service.HbplanDetailService;
import com.boliangshenghe.outteam.service.HbplanService;
import com.boliangshenghe.outteam.service.LinkDetailService;
import com.boliangshenghe.outteam.service.LinkService;
import com.boliangshenghe.outteam.service.OndutyService;
import com.boliangshenghe.outteam.service.OutteamDetailService;
import com.boliangshenghe.outteam.service.OutteamService;
import com.boliangshenghe.outteam.service.PhoneService;
import com.boliangshenghe.outteam.service.ResponseCompanyService;
import com.boliangshenghe.outteam.service.ResponseService;
import com.boliangshenghe.outteam.util.CodeUtils;
import com.boliangshenghe.outteam.util.CommonUtils;
import com.boliangshenghe.outteam.util.SendMessageUtil;
import com.boliangshenghe.outteam.util.WordGenerator;
/**
 * 地震事件管理
 2017
 * @author xuzj
 *
 */
@Controller
@RequestMapping("/earthquake")
public class EarthquakeController extends BaseCommonController{
	
	@Autowired
	private EarthquakeService earthquakeService;
	
	@Autowired
	private ResponseService responseService;
	
	@Autowired
	private OutteamService outteamService;
	
	@Autowired
	private OutteamDetailService outteamDetailService;
	
	@Autowired
	private OndutyService ondutyService;
	
	@Autowired
	private CompanyService companyService;
	
	@Autowired
	private LinkService linkService;
	
	@Autowired
	private LinkDetailService linkDetailService;
	
	@Autowired
	private ResponseCompanyService responseCompanyService;
	
	@Autowired
	private HbplanService hbplanService;
	
	@Autowired
	private HbplanDetailService hbplanDetailService;
	
	@Autowired
	private PhoneService phoneService;
	
	@Autowired
	private CatalogcopyService catalogcopyService;
	@RequestMapping
	public String defaultIndex(){
		return "redirect:/earthquake/list";
	}
	
	@RequestMapping("list")
	public String index(HttpServletRequest request, 
  			HttpServletResponse response,Earthquake earthquake,Model model,
  			@RequestParam(defaultValue = "1", value = "pageNo") Integer pageNo){
		PageBean<Earthquake> page = earthquakeService.getEarthquakeByPage(earthquake, pageNo);
		model.addAttribute("page", page);
		model.addAttribute("earthquake", earthquake);
		
		return "earthquake/list";
	}
	
	@RequestMapping("info")
	public String info(HttpServletRequest request, 
  			HttpServletResponse response,Integer id,Model model){
		if(id!=null){
			Earthquake earthquake = earthquakeService.selectByPrimaryKey(id);
			model.addAttribute("earthquake", earthquake);
		}
		return "earthquake/info";
	}
	
	@RequestMapping("goadd")
	public String goadd(HttpServletRequest request, 
  			HttpServletResponse response,Integer id,Model model){
		if(id!=null){
			Earthquake earthquake = earthquakeService.selectByPrimaryKey(id);
			model.addAttribute("earthquake", earthquake);
		}
		
		/**
		 * 这段话是不是考虑放到base里面
		 */
		List<Response> responseList = responseService.selectResponseList(new Response());
		model.addAttribute("responseList", responseList);
		
		Company company = new Company();
		company.setType("1");
		List<Company> companyList = companyService.selectCompanyList(company);
		model.addAttribute("companyList", companyList);
		return "earthquake/addOrEdit";
	}
	/**
	 * 添加到数据库
	 * 不用了
	 * @param request
	 * @param response
	 * @param earthquake
	 * @param model
	 * @return
	 */
	@RequestMapping("save")
	public String save(HttpServletRequest request, 
  			HttpServletResponse response,Earthquake earthquake,Model model){
		
		if(earthquake.getId()!=null){
			earthquake.setCreatetime(new Date());
			earthquake.setCreator(this.getName(request));
			earthquakeService.updateByPrimaryKeySelective(earthquake);
		}else{
			earthquake.setState("1");//1演练 2 eqim触发
			earthquake.setStatus("1");//1 开启 2 结束
			earthquake.setCreatetime(new Date());
			earthquake.setCreator(this.getName(request));
			earthquakeService.insertSelective(earthquake);
			
			Catalogcopy catalogcopy = new Catalogcopy();
			catalogcopy.setArea(earthquake.getArea());
			catalogcopy.setCataId(earthquake.getId()+"");
			catalogcopy.setCid(earthquake.getCid());
			catalogcopy.setProvince(earthquake.getProvince());
			catalogcopy.setLocationCname(earthquake.getEqname());
			String mag = earthquake.getMagnitude();
			if(StringUtils.isNotBlank(mag)) {
				catalogcopy.setM(Double.parseDouble(mag));
			}else {
				catalogcopy.setM(0d);
			}
			
			catalogcopy.setOTime(earthquake.getCreatetime());
			catalogcopy.setEventId(earthquake.getEventid());
			catalogcopy.setCataId(earthquake.getEventid());
			catalogcopy.setIsouttem("1");
			catalogcopyService.insertSelective(catalogcopy);
		}
		
		return "redirect:/earthquake/list";
	}
	
	/**
	 * 添加到数据库
	 * 新增 
	 * @param request
	 * @param response
	 * @param earthquake
	 * @param model
	 * @return
	 */
	@RequestMapping("savenew")
	@ResponseBody
	public String savenew(HttpServletRequest request, 
  			HttpServletResponse response,Earthquake earthquake,Model model){
		if(earthquake.getId()==null){
			earthquake.setCreatetime(new Date());
			earthquake.setCreator("管理员");
			earthquake.setState("1");//1演练 2 eqim触发
			earthquake.setStatus("1");//1 开启 2 结束
			Company company = companyService.selectByPrimaryKey(earthquake.getCid());
			earthquake.setProvince(company.getProvince());
			earthquakeService.insertSelective(earthquake);
			
			Catalogcopy catalogcopy = new Catalogcopy();
			catalogcopy.setArea(earthquake.getArea());
			catalogcopy.setCataId(earthquake.getId()+"");
			catalogcopy.setCid(earthquake.getCid());
			catalogcopy.setLocationCname(earthquake.getEqname());
			String mag = earthquake.getMagnitude();
			if(StringUtils.isNotBlank(mag)) {
				catalogcopy.setM(Double.parseDouble(mag));
			}else {
				catalogcopy.setM(0d);
			}
			
			catalogcopy.setOTime(earthquake.getCreatetime());
			catalogcopy.setEventId(earthquake.getEventid());
			catalogcopy.setCataId(earthquake.getEventid());
			catalogcopy.setIsouttem("1");
			catalogcopyService.insertSelective(catalogcopy);
			
			if(null!=earthquake.getResponseid() && earthquake.getResponseid()>0){
    			//给所有单位发送响应等级短信
				Response r = responseService.selectByPrimaryKey(earthquake.getResponseid());
				String message = earthquake.getEqname()+"的响应等级为："+r.getName();
				SendMessageUtil.sendMessage(phoneService.getAllCompanyPhone(message), message);
	    	}
			
			String retu = earthquake.getId().toString();
			return retu;
		}else{
			earthquake.setCreatetime(new Date());
			earthquake.setCreator("管理员");
			Company company = companyService.selectByPrimaryKey(earthquake.getCid());
			earthquake.setProvince(company.getProvince());
			earthquakeService.updateByPrimaryKeySelective(earthquake);
			return earthquake.getId().toString();
		}
	}
	
	/**
	 * 判断该地震是否按照
	 * 震源省份 响应等级 轮值单位这三个判断依据
	 * 分配了出队单位
	 * @param request
	 * @param response
	 * @param earthquake
	 * @param model
	 * @return
	 */
	@RequestMapping("valCompany")
	@ResponseBody
	public String valCompany(HttpServletRequest request, 
  			HttpServletResponse response,Earthquake earthquake,Model model){
		
		earthquake.setCreatetime(new Date());
		earthquake.setCreator("管理员");
		earthquakeService.updateByPrimaryKeySelective(earthquake);
		
		//Earthquake earthquake = earthquakeService.selectByPrimaryKey(id);
		Outteam outteam = new Outteam();
		outteam.setEqid(earthquake.getId());
		int count= outteamService.selectOutteamCount(outteam);
//		System.out.println(count);
		//还没有安排出队
		if(count==0){
			return "success";
		}else{
			return "fail";
		}
	}
	
	/**
	 * 震源省份 响应等级 联动 轮值单位这三个判断规则应该出队的单位
	 * @param request
	 * @param response
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("ruleoutteam")
	public String ruleoutteam(HttpServletRequest request, 
  			HttpServletResponse response,Integer id,Integer rid,Model model){
		System.out.println(id);
		
		Earthquake earthquake = earthquakeService.selectByPrimaryKey(id);
		model.addAttribute("earthquake", earthquake);
		
		Response resinfo = responseService.selectByPrimaryKey(rid);//在页面上选取的响应等级
		Set<String> set = new HashSet<String>();
		
		/**
		 * 震源省份从单位表里面取 
		 * 1、判断震源省份是否有出队单位
		 * 2、数据保持一致
		 */
		Company company = new Company();
		company.setProvince(earthquake.getProvince());
		List<Company> comlist = companyService.selectCompanyList(company);
		if(comlist!=null && comlist.size()>0){
			model.addAttribute("earthsource", comlist.get(0).getProvince());
			set.add(comlist.get(0).getProvince());
		}
		
		if(earthquake.getArea().equals(CommonUtils.HUABEI)){//华北地区的出队判断
			//华北地区 通过t_hbplan 来判断
			Hbplan hbplan = new Hbplan();
			hbplan.setCompanys(earthquake.getProvince());//发震省份
			if(null!=earthquake.getMagnitude() && earthquake.getMagnitude().length()==1){
				earthquake.setMagnitude(earthquake.getMagnitude()+".0");
			}
			
			hbplan.setHigh(Double.parseDouble(earthquake.getMagnitude()));//地震级数
			Hbplan hbplantemp = hbplanService.selectHbplanByCompanys(hbplan);
			if(null!=hbplantemp.getId()){//有对应的华预案
				HbplanDetail hbplanDetail = new HbplanDetail();
				hbplanDetail.setHbplanid(hbplantemp.getId());
				List<HbplanDetail> hbplanDetailList = hbplanDetailService.selectHbplanDetailList(hbplanDetail);
				if(hbplanDetailList!=null && hbplanDetailList.size()>0){
					for (HbplanDetail detail : hbplanDetailList) {
						set.add(detail.getCompany());//添加到set里面
					}
				}
				model.addAttribute("hbplan", hbplantemp);
				model.addAttribute("hbplanDetailList", hbplanDetailList);
			}
		}else{
			ResponseCompany responseCompany = new ResponseCompany();
			responseCompany.setRid(resinfo.getId());//根据响应id查
			List<ResponseCompany> rcList = responseCompanyService.selectResponseCompanyList(responseCompany);
			//model.addAttribute("responseName", resinfo.getName());
			model.addAttribute("resinfo", resinfo);
			model.addAttribute("rcList", rcList);//响应等级出队单位
			
			if(rcList!=null && rcList.size()>0){
				for (ResponseCompany temp : rcList) {
					set.add(temp.getCompany());
				}
			}
			
			//联动方案
			Link link = new Link();
			link.setRid(resinfo.getId());
			link.setEqcompany(earthquake.getProvince());
			link.setState("1");
			List<Link> linkList = linkService.selectLinkList(link);
			if(null != linkList && linkList.size()>0){
				Link temp = linkList.get(0);
				LinkDetail linkDetail = new LinkDetail();
				linkDetail.setLinkid(temp.getId());
				List<LinkDetail> linkDetailList = linkDetailService.selectLinkDetailList(linkDetail);
				model.addAttribute("linkDetailList", linkDetailList);//联动方案出队单位
				model.addAttribute("link", temp);//联动方案出队单位
				if(linkDetailList!=null && linkDetailList.size()>0){
					for (LinkDetail detail : linkDetailList) {
						set.add(detail.getCompany());//添加到set里面
					}
				}
			}
			
		}
		
		
		Onduty onduty = new Onduty();
		onduty.setYearm(CodeUtils.getYearMonth());
		List<Onduty> dutyList = ondutyService.selectOndutyList(onduty);
		model.addAttribute("yearm", CodeUtils.getYearMonth());//轮值年月
		model.addAttribute("dutyList", dutyList);//轮值单位
		
		if(dutyList!=null && dutyList.size()>0){
			for (Onduty temp : dutyList) {
				set.add(temp.getCompany());
			}
		}
		
		//手动出队
		Outteam outteam = new Outteam();
		outteam.setEqid(id);
		outteam.setOuttype("6");
		List<Outteam> outtemlist = outteamService.selectOutteamList(outteam);
		if(null != outtemlist && outtemlist.size()>0){
			String cids = "";
			for (Outteam record : outtemlist) {
				set.add(record.getCompany());
				cids = cids+record.getCid()+",";
			}
			if(!cids.equals("")){
				cids = cids.substring(0, cids.length()-1);
				System.out.println(cids+" cidss");
				model.addAttribute("cids", cids);//
			}
			model.addAttribute("outtemlist", outtemlist);//手动单位
		}
		
		
		
		model.addAttribute("set", set);
		
		return "earthquake/ruleoutteam";
	}
	
	/**
	 * 震源省份 响应等级 轮值单位这三个判断规则应该出队的单位
	 * @param request
	 * @param response
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("addoutteam")
	public String addoutteam(HttpServletRequest request, 
  			HttpServletResponse response,Integer eqid,String cids,Integer rid,Model model){
		System.out.println(eqid);
		
		earthquakeService.addoutteam(eqid,cids,rid);
		
		return "redirect:/earthquake/list";
	}
	
	/**
	 * 震源省份 响应等级 轮值单位这三个判断规则应该出队的单位
	 * @param request
	 * @param response
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("del")
	public String del(HttpServletRequest request, 
  			HttpServletResponse response,Integer id,Model model){
		System.out.println(id);
		if(id!=null){
			Earthquake earthquake = earthquakeService.selectByPrimaryKey(id);
			earthquake.setStatus("2");
			earthquakeService.updateByPrimaryKeySelective(earthquake);
		}
		
		return "redirect:/earthquake/list";
	}
	
	/**
	 * 出队详情
	 * @param request
	 * @sadparam response
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("outteamdetail")
	public String outteandetail(HttpServletRequest request, 
  			HttpServletResponse response,Integer id,Model model){
		if(id!=null){
			List<OutteamDetail> details = outteamDetailService.selectOutteamDetailGroupByEqid(id);
			model.addAttribute("details", details);
			Earthquake earthquake = earthquakeService.selectByPrimaryKey(id);
			model.addAttribute("earthquake", earthquake);
		}
		return "earthquake/outteamdetail";
	}
	
	/**
	 * 导出
	 * @param request
	 * @sadparam response
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("export")
	@ResponseBody
	public void export(HttpServletRequest request, 
  			HttpServletResponse response,Integer id,Model model){
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException c1) {
			// TODO Auto-generated catch block
			c1.printStackTrace();
		}
		List<OutteamDetail> details = outteamDetailService.selectOutteamDetailGroupByEqid(id);
		Earthquake earthquake = earthquakeService.selectByPrimaryKey(id);
		if(earthquake==null) return;
		model.addAttribute("earthquake", earthquake);
		// 构造数据
		Map<String, Object> dataMap = new HashMap<String, Object>();

		dataMap.put("details", details);
		dataMap.put("eqname", earthquake.getEqname());
		// 提示：在调用工具类生成Word文档之前应当检查所有字段是否完整
		// 否则Freemarker的模板殷勤在处理时可能会因为找不到值而报错 这里暂时忽略这个步骤了
		File file = null;
		InputStream fin = null;
		ServletOutputStream out = null;
		try {
			// 调用工具类WordGenerator的createDoc方法生成Word文档
			file = WordGenerator.createDoc(dataMap, "report");
			fin = new FileInputStream(file);

			response.setCharacterEncoding("utf-8");
			response.setContentType("application/msword");
			// 设置浏览器以下载的方式处理该文件默认名为resume.doc
			response.addHeader("Content-Disposition",
					"attachment;filename=report.doc");

			out = response.getOutputStream();
			byte[] buffer = new byte[512]; // 缓冲区
			int bytesToRead = -1;
			// 通过循环将读入的Word文件的内容输出到浏览器中
			while ((bytesToRead = fin.read(buffer)) != -1) {
				out.write(buffer, 0, bytesToRead);
			}
		} catch (Exception c) {
			// TODO: handle exception
		} finally {
			try {
				if (fin != null)
					fin.close();
				if (out != null)
					out.close();
				if (file != null)
					file.delete(); // 删除临时文件
			} catch (Exception c) {
				// TODO: handle exception
			}
		}
	}
	
	
}
