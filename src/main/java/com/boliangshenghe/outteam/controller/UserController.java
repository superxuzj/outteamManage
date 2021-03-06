package com.boliangshenghe.outteam.controller;

import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.Paragraph;
import org.apache.poi.hwpf.usermodel.Range;
import org.apache.poi.hwpf.usermodel.Table;
import org.apache.poi.hwpf.usermodel.TableCell;
import org.apache.poi.hwpf.usermodel.TableIterator;
import org.apache.poi.hwpf.usermodel.TableRow;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.boliangshenghe.outteam.common.PageBean;
import com.boliangshenghe.outteam.controller.base.BaseCommonController;
import com.boliangshenghe.outteam.entity.Company;
import com.boliangshenghe.outteam.entity.User;
import com.boliangshenghe.outteam.service.CompanyService;
import com.boliangshenghe.outteam.service.UserService;

/**
 *用户管理
 * @author xuzj
 *
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseCommonController{
	
	@Autowired
	private CompanyService companyService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping
	public String defaultIndex(){
		return "redirect:/user/list";
	}
	
	@RequestMapping("list")
	public String index(HttpServletRequest request, 
  			HttpServletResponse response,User user,Model model,
  			@RequestParam(defaultValue = "1", value = "pageNo") Integer pageNo){
		user.setState("1");//state为0 逻辑删除 
		if(this.getRoleId(request)!=1){//不是系统管理员 只能看到本单位的队员
			user.setCid(this.getUserCid(request));
		}
		PageBean<User> page =userService.getUserByPage(user, pageNo);
		model.addAttribute("page", page);
		return "user/list";
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
		
		userService.addDetail(user);
		
		return "redirect:/user/list";
	}
	
	@RequestMapping("info")
	public String info(HttpServletRequest request, 
  			HttpServletResponse response,Integer id,Model model){
		if(id!=null){
			User user = userService.selectByPrimaryKey(id);
			model.addAttribute("user", user);
		}
		return "user/info";
	}
	/**
	 * 跳转到新增页面
	 * @return
	 */
	@RequestMapping("goadd")
	public String goadd(HttpServletRequest request, 
  			HttpServletResponse response,Integer id,Model model){
		if(null!=id){
			User user = userService.selectByPrimaryKey(id);
			model.addAttribute("user", user);
		}
		
		List<Company> companyList = companyService.selectCompanyList(new Company());
		model.addAttribute("companyList", companyList);
		
		/*
		 * 系统里面添加的只是队员
		 * List<Role> roleList = roleService.selectRoleList(new Role());
		model.addAttribute("roleList", roleList);*/
		
		return "user/addOrEdit";
	}
	
	@RequestMapping("del")
	public String del(HttpServletRequest request, 
  			HttpServletResponse response,Integer id,Model model){
		if(id!=null){
			User user = userService.selectByPrimaryKey(id);
			user.setState("0");//逻辑删除
			userService.updateByPrimaryKeySelective(user);
		}
		return "redirect:/user/list";
	}
	
	/**
	 * 上传
	 * @param request
	 * @param response
	 * @param file
	 * @param model
	 * @return
	 */
	@RequestMapping("/uploadword")
	public String uploadword(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam("file") CommonsMultipartFile file,Model model) {
		String fileName = file.getOriginalFilename();
//		System.out.println(fileName);
		try {
			request.setCharacterEncoding("UTF-8");
			InputStream is = file.getInputStream();
			 POIFSFileSystem pfs = new POIFSFileSystem(is);     
	            HWPFDocument hwpf = new HWPFDocument(pfs);     
	            Range range = hwpf.getRange();//得到文档的读取范围  
	            TableIterator it = new TableIterator(range);  
	           //迭代文档中的表格  
	            while (it.hasNext()) {     
	                Table tb = (Table) it.next();     
	                //迭代行，默认从0开始  
	                for (int i = 0; i < tb.numRows(); i++) {     
	                    TableRow tr = tb.getRow(i);     
	                    //迭代列，默认从0开始  
	                    for (int j = 0; j < tr.numCells(); j++) {     
	                        TableCell td = tr.getCell(j);//取得单元格  
	                        //取得单元格的内容  
	                        for(int k=0;k<td.numParagraphs();k++){     
	                            Paragraph para =td.getParagraph(k);     
	                            String s = para.text();     
	                            System.out.println(s);  
	                        } //end for      
	                    }   //end for  
	                }   //end for  
	            } //end wh
			
		} catch (Exception c) {
			// TODO Auto-generated catch block
			c.printStackTrace();
		}
		model.addAttribute("message", "上传成功");
		return "redirect:/user/info";
	}
	
}
