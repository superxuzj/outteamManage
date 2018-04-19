package com.boliangshenghe.outteam.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.boliangshenghe.outteam.service.CompanyService;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

@Controller
public class IndexController {

	@Autowired
	private CompanyService companyService;
	/*
	 * @Autowired public UserService userService;
	 * 
	 * @RequestMapping("/") public String all(){ return "redirect:/index"; }
	 */

	public static void main(String[] args) {
		File file = new File("D:/mingdan.xls");
        List excelList = readExcel(file);
        System.out.println("list中的数据打印出来");
        for (int i = 0; i < excelList.size(); i++) {
            List list = (List) excelList.get(i);
            for (int j = 0; j < list.size(); j++) {
                //System.out.print(list.get(j));
            }
            
            //System.out.println();
        }
	}
	 // 去读Excel的方法readExcel，该方法的入口参数为一个File对象
    public static List readExcel(File file) {
        try {
            // 创建输入流，读取Excel
            InputStream is = new FileInputStream(file.getAbsolutePath());
            // jxl提供的Workbook类
            Workbook wb = Workbook.getWorkbook(is);
            // Excel的页签数量
            int sheet_size = wb.getNumberOfSheets();
            for (int index = 0; index < sheet_size; index++) {
                List<List> outerList=new ArrayList<List>();
                // 每个页签创建一个Sheet对象
                Sheet sheet = wb.getSheet(index);
                // sheet.getRows()返回该页的总行数
                for (int i = 0; i < sheet.getRows(); i++) {
                    List innerList=new ArrayList();
                    // sheet.getColumns()返回该页的总列数
                    /*INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES 
                    (4,'xuzh','1','32','32','1111','23',21,'32','3',1,'2017-11-28 14:45:52');*/
                    String sql = "INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES" + 
                    		" ( 4 ";
                    for (int j = 0; j < sheet.getColumns(); j++) {
                        String cellinfo = sheet.getCell(j, i).getContents();
                        
                        innerList.add(cellinfo);
                        if(cellinfo.trim().equals("男")) {
                        	cellinfo = "1";
                        }else if(cellinfo.trim().equals("女")){
                        	cellinfo="2";
                        }
                        if(cellinfo.trim().equals("地质研究所")) {
                        	sql  = sql+" , 33";
                        }
                        if(cellinfo.trim().equals("中国地震应急搜救中心")) {
                        	sql  = sql+" , 40";
                        }
                        if(cellinfo.trim().equals("地球物理研究所")) {
                        	sql  = sql+" , 32";
                        }
                        if(cellinfo.trim().equals("中国地震灾害防御中心")) {
                        	sql  = sql+" , 38";
                        }
                        if(cellinfo.trim().equals("新疆省地震局")) {
                        	sql  = sql+" , 29";
                        }
                        if(cellinfo.trim().equals("陕西省地震局")) {
                        	sql  = sql+" , 25";
                        }
                        if(cellinfo.trim().equals("青海省地震局")) {
                        	sql  = sql+" , 27";
                        }
                        if(cellinfo.trim().equals("宁夏省地震局")) {
                        	sql  = sql+" , 28";
                        }
                        if(cellinfo.trim().equals("甘肃省地震局")) {
                        	sql  = sql+" , 27";
                        }
                        if(cellinfo.trim().equals("工程力学研究所")) {
                        	sql  = sql+" , 36";
                        }
                        if(cellinfo.trim().equals("河南省地震局")) {
                        	sql  = sql+" , 14";
                        }
                        if(cellinfo.trim().equals("防灾科技学院")) {
                        	sql  = sql+" , 45";
                        }
                        if(cellinfo.trim().equals("重庆市地震局")) {
                        	sql  = sql+" , 20";
                        }
                        if(cellinfo.trim().equals("云南省地震局")) {
                        	sql  = sql+" , 23";
                        }
                        if(cellinfo.trim().equals("四川省地震局")) {
                        	sql  = sql+" , 21";
                        }
                        if(cellinfo.trim().equals("西藏省地震局")) {
                        	sql  = sql+" , 24";
                        }
                        if(cellinfo.trim().equals("贵州省地震局")) {
                        	sql  = sql+" , 22";
                        }
                        if(cellinfo.trim().equals("山东省地震局")) {
                        	sql  = sql+" , 13";
                        }
                        
                        sql  = sql+" , '"+cellinfo+"' ";
                        if(j==2) {
                        	sql  = sql+" , '"+cellinfo+"' ";
                        	sql  = sql+" , '111111' ";;
                        }
                        if(j==5) {
                        	sql  = sql+" , 1 ";;
                        }
                       
//                        System.out.print(cellinfo);
                    }
                    sql  = sql+",'2018-04-19 14:45:52');";
                    outerList.add(i, innerList);
                    System.out.println(sql);
                }
                return outerList;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
	/*
	 * @RequestMapping("/page") public String hello(User user,Model
	 * model,@RequestParam(defaultValue = "1", value = "pageNo") Integer pageNo){
	 * user.setType("1"); PageBean<User> page =
	 * userService.getUserByPage(user,pageNo,10);
	 * System.out.println(page.getTotal()); model.addAttribute("page", page);
	 * model.addAttribute("hello", "sdfds"); System.out.println("1"); return
	 * "hello"; }
	 */
    /**
     INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '马玺'  , '1'  , '15811039129'  , '15811039129'  , '111111'  , '513701198901090810'  , 33 , '地质研究所'  , '地球物理'  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '范熙伟'  , '1'  , '13718300200'  , '13718300200'  , '111111'  , '142627198603310000'  , 33 , '地质研究所'  , '地震地质'  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '董绍鹏'  , '1'  , '18001203631'  , '18001203631'  , '111111'  , '42112219830826001X'  , 33 , '地质研究所'  , '构造地质学'  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '庞建章'  , '1'  , '15210619298'  , '15210619298'  , '111111'  , '130633198512025515'  , 33 , '地质研究所'  , '地球化学'  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '许冲'  , '1'  , '13522561327'  , '13522561327'  , '111111'  , '412701198210013037'  , 33 , '地质研究所'  , '水文地质与工程地质'  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '魏占玉'  , '1'  , '13811420178'  , '13811420178'  , '111111'  , '150403198105240538'  , 33 , '地质研究所'  , '构造地质学'  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '王恒'  , '1'  , '15811584529'  , '15811584529'  , '111111'  , '140106198510240000'  , 33 , '地质研究所'  , '构造地质'  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '石峰'  , '1'  , '13910849765'  , '13910849765'  , '111111'  , '410502198408131518'  , 33 , '地质研究所'  , '构造地质学'  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '安基文'  , '1'  , '15811251901'  , '15811251901'  , '111111'  , '222405198107150619'  , 33 , '地质研究所'  , '地图学与地理信息系统'  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '李康'  , '1'  , '15210675822'  , '15210675822'  , '111111'  , '341222198512301814'  , 33 , '地质研究所'  , '构造地质学'  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '魏本勇'  , '1'  , '13439515762'  , '13439515762'  , '111111'  , '370284198212043650'  , 33 , '地质研究所'  , '自然地理学'  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '李彦宝'  , '1'  , '13810348442'  , '13810348442'  , '111111'  , '131128198112104516'  , 33 , '地质研究所'  , '构造地质学'  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '赵波'  , '1'  , '13691343483'  , '13691343483'  , '111111'  , '320723198303220013'  , 33 , '地质研究所'  , '火山地质'  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '谭锡斌'  , '1'  , '18910601840'  , '18910601840'  , '111111'  , '320924198512069000'  , 33 , '地质研究所'  , '构造地质学'  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '李晓丽'  , '2'  , '13466693376'  , '13466693376'  , '111111'  , '412701198210013000'  , 33 , '地质研究所'  , '构造地质学'  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '陈桂华'  , '1'  , '13522920007'  , '13522920007'  , '111111'  , '371325198202173000'  , 33 , '地质研究所'  , '构造地质学'  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '袁仁茂'  , '1'  , '18911812072'  , '18911812072'  , '111111'  , '362501197211032459'  , 33 , '地质研究所'  , '地质灾害'  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '陈立春'  , '1'  , '13683525847'  , '13683525847'  , '111111'  , '420111197001085574'  , 33 , '地质研究所'  , '构造地质学'  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '安艳芬'  , '2'  , '13581611254'  , '13581611254'  , '111111'  , '142321198010140048'  , 33 , '地质研究所'  , '构造地质学'  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '王志秋'  , '1'  , '13701338749'  , '13701338749'  , '111111'  , '110108199011061814'  , 40 , '中国地震应急搜救中心'  , '地震应急救援'  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '李亦纲'  , '1'  , '13910839689'  , '13910839689'  , '111111'  , '110108199011061814'  , 40 , '中国地震应急搜救中心'  , '地球物理'  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '许建华'  , '2'  , '13718531750'  , '13718531750'  , '111111'  , '110108199011061814'  , 40 , '中国地震应急搜救中心'  , '地球物理'  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '乔成斌'  , '1'  , '18910785091'  , '18910785091'  , '111111'  , '110108199011061814'  , 40 , '中国地震应急搜救中心'  , '地球物理'  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '倪景玉'  , '1'  , '13811869603'  , '13811869603'  , '111111'  , '110108199011061814'  , 40 , '中国地震应急搜救中心'  , '装备保障'  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '张天罡'  , '1'  , '13811663765'  , '13811663765'  , '111111'  , '110108199011061814'  , 40 , '中国地震应急搜救中心'  , '通讯工程'  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '张云昌'  , '1'  , '13717752103'  , '13717752103'  , '111111'  , '110108199011061814'  , 40 , '中国地震应急搜救中心'  , '通讯工程'  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '李岩峰'  , '1'  , '13671148851'  , '13671148851'  , '111111'  , '110108199011061814'  , 40 , '中国地震应急搜救中心'  , '地震地质'  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '张雪华'  , '1'  , '17888817149'  , '17888817149'  , '111111'  , '110108199011061814'  , 40 , '中国地震应急搜救中心'  , '遥感'  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '李红光'  , '1'  , '13121213128'  , '13121213128'  , '111111'  , '110108199011061814'  , 40 , '中国地震应急搜救中心'  , '地球物理'  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '刘  亢'  , '1'  , '13811260814'  , '13811260814'  , '111111'  , '110108199011061814'  , 40 , '中国地震应急搜救中心'  , '地质'  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '玄  月'  , '1'  , '13911588139'  , '13911588139'  , '111111'  , '110108199011061814'  , 40 , '中国地震应急搜救中心'  , '构造地质'  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '彭立国'  , '1'  , '13041266543'  , '13041266543'  , '111111'  , '110108199011061814'  , 40 , '中国地震应急搜救中心'  , '地球物理'  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '冯  军'  , '1'  , '13520144735'  , '13520144735'  , '111111'  , '110108199011061814'  , 40 , '中国地震应急搜救中心'  , '地震地质'  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '李伟华'  , '2'  , '13466693399'  , '13466693399'  , '111111'  , '110108199011061814'  , 40 , '中国地震应急搜救中心'  , '地球物理'  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '贺  专'  , '1'  , '18511896895'  , '18511896895'  , '111111'  , '110108199011061814'  , 40 , '中国地震应急搜救中心'  , '通讯工程'  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '陈  建'  , '1'  , '13621078874'  , '13621078874'  , '111111'  , '110108199011061814'  , 40 , '中国地震应急搜救中心'  , '地震应急救援'  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '李  立'  , '1'  , '13552761785'  , '13552761785'  , '111111'  , '110108199011061814'  , 40 , '中国地震应急搜救中心'  , '装备保障'  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '王  珂'  , '1'  , '18101167463'  , '18101167463'  , '111111'  , '110108199011061814'  , 40 , '中国地震应急搜救中心'  , '遥感'  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '杨建思'  , '2'  , '13801213040'  , '13801213040'  , '111111'  , '110108199011061814'  , 32 , '地球物理研究所'  , '地震观测'  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '姜旭东'  , '1'  , '13521681929'  , '13521681929'  , '111111'  , '110108199011061814'  , 32 , '地球物理研究所'  , '地震观测'  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '徐志强'  , '1'  , '13601229597'  , '13601229597'  , '111111'  , '110108199011061814'  , 32 , '地球物理研究所'  , '地震观测'  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '郑  钰'  , '1'  , '13611312331'  , '13611312331'  , '111111'  , '110108199011061814'  , 32 , '地球物理研究所'  , '地震观测'  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '彭朝勇'  , '1'  , '13161678848'  , '13161678848'  , '111111'  , '110108199011061814'  , 32 , '地球物理研究所'  , '地震观测'  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '温增平'  , '1'  , '13683065696'  , '13683065696'  , '111111'  , '110108199011061814'  , 32 , '地球物理研究所'  , '震害调查与灾评'  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '刘爱文'  , '1'  , '13683605459'  , '13683605459'  , '111111'  , '110108199011061814'  , 32 , '地球物理研究所'  , '震害调查与灾评'  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '吴  健'  , '1'  , '13661317105'  , '13661317105'  , '111111'  , '110108199011061814'  , 32 , '地球物理研究所'  , '震害调查与灾评'  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '陈学良'  , '1'  , '13811396447'  , '13811396447'  , '111111'  , '110108199011061814'  , 32 , '地球物理研究所'  , '震害调查与灾评'  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '吕红山'  , '1'  , '13911092704'  , '13911092704'  , '111111'  , '110108199011061814'  , 32 , '地球物理研究所'  , '震害调查与灾评'  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '王玉石'  , '1'  , '13366291320'  , '13366291320'  , '111111'  , '110108199011061814'  , 32 , '地球物理研究所'  , '震害调查与灾评'  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '迟明杰'  , '1'  , '18201685592'  , '18201685592'  , '111111'  , '110108199011061814'  , 32 , '地球物理研究所'  , '震害调查与灾评'  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '梅泽洪'  , '1'  , '18610785250'  , '18610785250'  , '111111'  , '110108199011061814'  , 32 , '地球物理研究所'  , '震害调查与灾评'  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '徐  超'  , '1'  , '13811123295'  , '13811123295'  , '111111'  , '110108199011061814'  , 32 , '地球物理研究所'  , '震害调查与灾评'  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '宋毅盛'  , '1'  , '13521112337'  , '13521112337'  , '111111'  , '110108199011061814'  , 32 , '地球物理研究所'  , '地震地质'  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '唐方头'  , '1'  , '13691458994'  , '13691458994'  , '111111'  , '110108199011061814'  , 32 , '地球物理研究所'  , '震害调查与灾评'  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '韩  炜'  , '1'  , '13801039799'  , '13801039799'  , '111111'  , '110108199011061814'  , 32 , '地球物理研究所'  , '应急通讯'  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '陈  波'  , '1'  , '13426237901'  , '13426237901'  , '111111'  , '110108199011061814'  , 32 , '地球物理研究所'  , '震害调查与灾评'  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '陈  苏'  , '1'  , '13718062518'  , '13718062518'  , '111111'  , '110108199011061814'  , 32 , '地球物理研究所'  , '震害调查与灾评'  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '王晓辉'  , '1'  , '13810357099'  , '13810357099'  , '111111'  , '110108199011061814'  , 32 , '地球物理研究所'  , '震害调查与灾评'  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '申文庄'  , '1'  , '15010231928'  , '15010231928'  , '111111'  , '650104196007060719'  , 38 , '中国地震灾害防御中心'  , '地震工程'  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '张郁山'  , '1'  , '13681162796'  , '13681162796'  , '111111'  , '130229197408044811'  , 38 , '中国地震灾害防御中心'  , '地震工程'  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '高战武'  , '1'  , '13911738470'  , '13911738470'  , '111111'  , '210902197007080035'  , 38 , '中国地震灾害防御中心'  , '地震地质'  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '王东明'  , '1'  , '13810197500'  , '13810197500'  , '111111'  , '210213197705073917'  , 38 , '中国地震灾害防御中心'  , '地震工程'  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '李方杰'  , '1'  , '13466510993'  , '13466510993'  , '111111'  , '13040219791120211X'  , 38 , '中国地震灾害防御中心'  , '土木工程'  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '张效亮'  , '1'  , '13581626571'  , '13581626571'  , '111111'  , '370829198412033519'  , 38 , '中国地震灾害防御中心'  , '固体地球物理'  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '高  杰'  , '1'  , '15001185673'  , '15001185673'  , '111111'  , '370202198101073537'  , 38 , '中国地震灾害防御中心'  , '结构工程'  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '程  理'  , '1'  , '18301163299'  , '18301163299'  , '111111'  , '37028419820304271X'  , 38 , '中国地震灾害防御中心'  , '构造地质学'  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '黄宝忠'  , '1'  , '13581908860'  , '13581908860'  , '111111'  , '110105196902037735'  , 38 , '中国地震灾害防御中心'  , '声像制作'  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '郭  冰'  , '1'  , '13522785031'  , '13522785031'  , '111111'  , '340111198101307554'  , 38 , '中国地震灾害防御中心'  , '摄影摄像'  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '孙甲宁'  , '1'  , '13718062518'  , '13718062518'  , '111111'  , '110108199011061814'  , 29 , '新疆省地震局'  , '震害调查与灾评'  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '李雪冬'  , '1'  , '13810357099'  , '13810357099'  , '111111'  , '110108199011061814'  , 29 , '新疆省地震局'  , '震害调查与灾评'  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '唐丽华'  , '1'  , '15010231928'  , '15010231928'  , '111111'  , '650104196007060719'  , 29 , '新疆省地震局'  , '震害调查与灾评'  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '郑黎明'  , '1'  , '13681162796'  , '13681162796'  , '111111'  , '130229197408044811'  , 29 , '新疆省地震局'  , '震害调查与灾评'  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '刘月成'  , '1'  , '13911738470'  , '13911738470'  , '111111'  , '210902197007080035'  , 29 , '新疆省地震局'  , '震害调查与灾评'  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '石广岭'  , '1'  , '13810197500'  , '13810197500'  , '111111'  , '210213197705073917'  , 29 , '新疆省地震局'  , '地震地质'  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '梁志远'  , '1'  , '13466510993'  , '13466510993'  , '111111'  , '13040219791120211X'  , 29 , '新疆省地震局'  , '震害调查与灾评'  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '胡伟华'  , '1'  , '13581626571'  , '13581626571'  , '111111'  , '370829198412033519'  , 29 , '新疆省地震局'  , '应急通讯'  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '宋立军'  , '1'  , '15001185673'  , '15001185673'  , '111111'  , '370202198101073537'  , 29 , '新疆省地震局'  , '震害调查与灾评'  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '姚远'  , '1'  , '18301163299'  , '18301163299'  , '111111'  , '37028419820304271X'  , 29 , '新疆省地震局'  , '震害调查与灾评'  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '王伟'  , '1'  , '13581908860'  , '13581908860'  , '111111'  , '110105196902037735'  , 29 , '新疆省地震局'  , '震害调查与灾评'  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '王兵'  , '1'  , '13522785031'  , '13522785031'  , '111111'  , '340111198101307554'  , 29 , '新疆省地震局'  , '震害调查与灾评'  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '阿力木江·亚里昆'  , '1'  , '13911738470'  , '13911738470'  , '111111'  , '210902197007080035'  , 29 , '新疆省地震局'  , '震害调查与灾评'  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '常想德'  , '1'  , '13810197500'  , '13810197500'  , '111111'  , '210213197705073917'  , 29 , '新疆省地震局'  , '地震地质'  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '陈建波'  , '1'  , '13466510993'  , '13466510993'  , '111111'  , '13040219791120211X'  , 29 , '新疆省地震局'  , '震害调查与灾评'  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '吴国栋'  , '1'  , '13581626571'  , '13581626571'  , '111111'  , '370829198412033519'  , 29 , '新疆省地震局'  , '应急通讯'  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '局罗炬'  , '1'  , '15001185673'  , '15001185673'  , '111111'  , '370202198101073537'  , 29 , '新疆省地震局'  , '震害调查与灾评'  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '袁志祥'  , '1'  , '18511821877'  , '18511821877'  , '111111'  , '110108199011061814'  , 25 , '陕西省地震局'  , '震害调查与灾评'  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '林卓'  , '1'  , '13581611254'  , '13581611254'  , '111111'  , '142321198010140048'  , 25 , '陕西省地震局'  , '震害调查与灾评'  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '李宝来'  , '1'  , '13701338749'  , '13701338749'  , '111111'  , '110108199011061814'  , 25 , '陕西省地震局'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '李春峰'  , '1'  , '13910839689'  , '13910839689'  , '111111'  , '110108199011061814'  , 25 , '陕西省地震局'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '张炜超'  , '1'  , '15010906897'  , '15010906897'  , '111111'  , '110108199011061814'  , 25 , '陕西省地震局'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '杨晨艺'  , '1'  , '13718531750'  , '13718531750'  , '111111'  , '110108199011061814'  , 25 , '陕西省地震局'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '张恩会'  , '1'  , '18910785091'  , '18910785091'  , '111111'  , '110108199011061814'  , 25 , '陕西省地震局'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '任浩'  , '1'  , '13811869603'  , '13811869603'  , '111111'  , '110108199011061814'  , 25 , '陕西省地震局'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '姚生海'  , '1'  , '13717752103'  , '13717752103'  , '111111'  , '110108199011061814'  , 27 , '青海省地震局'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '刘炜'  , '1'  , '13671148851'  , '13671148851'  , '111111'  , '110108199011061814'  , 27 , '青海省地震局'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '李国佑'  , '1'  , '17888817149'  , '17888817149'  , '111111'  , '110108199011061814'  , 27 , '青海省地震局'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '刘兴盛'  , '1'  , '13121213128'  , '13121213128'  , '111111'  , '110108199011061814'  , 27 , '青海省地震局'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '马震'  , '1'  , '13811260814'  , '13811260814'  , '111111'  , '110108199011061814'  , 27 , '青海省地震局'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '殷翔'  , '1'  , '13911588139'  , '13911588139'  , '111111'  , '110108199011061814'  , 27 , '青海省地震局'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '王海功'  , '1'  , '13041266543'  , '13041266543'  , '111111'  , '110108199011061814'  , 27 , '青海省地震局'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '李世忠'  , '1'  , '13520144735'  , '13520144735'  , '111111'  , '110108199011061814'  , 28 , '宁夏省地震局'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '金涛'  , '1'  , '13466693399'  , '13466693399'  , '111111'  , '110108199011061814'  , 28 , '宁夏省地震局'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '李泽山'  , '1'  , '18511896895'  , '18511896895'  , '111111'  , '110108199011061814'  , 28 , '宁夏省地震局'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '兰宁'  , '1'  , '13041266543'  , '13041266543'  , '111111'  , '110108199011061814'  , 28 , '宁夏省地震局'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '蒋天纵'  , '1'  , '13041266543'  , '13041266543'  , '111111'  , '110108199011061814'  , 28 , '宁夏省地震局'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '尚建本'  , '1'  , '13041266543'  , '13041266543'  , '111111'  , '110108199011061814'  , 28 , '宁夏省地震局'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '毛成业'  , '1'  , '13041266543'  , '13041266543'  , '111111'  , '110108199011061814'  , 28 , '宁夏省地震局'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '魏东星'  , '1'  , '13041266543'  , '13041266543'  , '111111'  , '110108199011061814'  , 27 , '甘肃省地震局'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '张成军'  , '1'  , '13041266543'  , '13041266543'  , '111111'  , '110108199011061814'  , 27 , '甘肃省地震局'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '杨超'  , '1'  , '13041266543'  , '13041266543'  , '111111'  , '110108199011061814'  , 27 , '甘肃省地震局'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '曹喜'  , '1'  , '13041266543'  , '13041266543'  , '111111'  , '110108199011061814'  , 27 , '甘肃省地震局'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '刘琨'  , '1'  , '13041266543'  , '13041266543'  , '111111'  , '110108199011061814'  , 27 , '甘肃省地震局'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '陈永明'  , '1'  , '13041266543'  , '13041266543'  , '111111'  , '110108199011061814'  , 27 , '甘肃省地震局'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '高晓明'  , '1'  , '13041266543'  , '13041266543'  , '111111'  , '110108199011061814'  , 27 , '甘肃省地震局'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '梁永强'  , '1'  , '13041266543'  , '13041266543'  , '111111'  , '110108199011061814'  , 27 , '甘肃省地震局'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '胡永钧'  , '1'  , '13041266543'  , '13041266543'  , '111111'  , '110108199011061814'  , 27 , '甘肃省地震局'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '冯博'  , '1'  , '13041266543'  , '13041266543'  , '111111'  , '110108199011061814'  , 27 , '甘肃省地震局'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '马忠宏'  , '1'  , '13041266543'  , '13041266543'  , '111111'  , '110108199011061814'  , 27 , '甘肃省地震局'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '林均岐'  , '1'  , '13041266543'  , '13041266543'  , '111111'  , '110108199011061814'  , 36 , '工程力学研究所'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '陈相兆'  , '1'  , '13041266543'  , '13041266543'  , '111111'  , '110108199011061814'  , 36 , '工程力学研究所'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '杨振宇'  , '1'  , '13041266543'  , '13041266543'  , '111111'  , '110108199011061814'  , 36 , '工程力学研究所'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '闫培雷'  , '1'  , '13041266543'  , '13041266543'  , '111111'  , '110108199011061814'  , 36 , '工程力学研究所'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '孙得璋'  , '1'  , '13041266543'  , '13041266543'  , '111111'  , '110108199011061814'  , 36 , '工程力学研究所'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '黄勇'  , '1'  , '13041266543'  , '13041266543'  , '111111'  , '110108199011061814'  , 36 , '工程力学研究所'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '余世舟'  , '1'  , '13041266543'  , '13041266543'  , '111111'  , '110108199011061814'  , 36 , '工程力学研究所'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '钟江荣'  , '1'  , '13041266543'  , '13041266543'  , '111111'  , '110108199011061814'  , 36 , '工程力学研究所'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '徐俊杰'  , '1'  , '13041266543'  , '13041266543'  , '111111'  , '110108199011061814'  , 36 , '工程力学研究所'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '曾德厚'  , '1'  , '13041266543'  , '13041266543'  , '111111'  , '110108199011061814'  , 36 , '工程力学研究所'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '蓬正真'  , '1'  , '13041266543'  , '13041266543'  , '111111'  , '110108199011061814'  , 36 , '工程力学研究所'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '仰向明'  , '1'  , '13041266543'  , '13041266543'  , '111111'  , '110108199011061814'  , 36 , '工程力学研究所'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '尚鸿飞'  , '1'  , '13041266543'  , '13041266543'  , '111111'  , '110108199011061814'  , 36 , '工程力学研究所'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '谢同济'  , '1'  , '13041266543'  , '13041266543'  , '111111'  , '110108199011061814'  , 36 , '工程力学研究所'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '莘和雅'  , '1'  , '13041266543'  , '13041266543'  , '111111'  , '110108199011061814'  , 36 , '工程力学研究所'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '冉波鸿'  , '1'  , '13041266543'  , '13041266543'  , '111111'  , '110108199011061814'  , 36 , '工程力学研究所'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '桂志学'  , '1'  , '13041266543'  , '13041266543'  , '111111'  , '110108199011061814'  , 36 , '工程力学研究所'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '李文利'  , '1'  , '18543826722'  , '18543826722'  , '111111'  , '110108199011061814'  , 14 , '河南省地震局'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '余军生'  , '1'  , '18539566026'  , '18539566026'  , '111111'  , '110108199011061814'  , 14 , '河南省地震局'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '王志铄'  , '1'  , '13700846975'  , '13700846975'  , '111111'  , '110108199011061814'  , 14 , '河南省地震局'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '蔡颖哲'  , '1'  , '13598095986'  , '13598095986'  , '111111'  , '110108199011061814'  , 14 , '河南省地震局'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '任锦团'  , '1'  , '15838367197'  , '15838367197'  , '111111'  , '110108199011061814'  , 14 , '河南省地震局'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '孙  杰'  , '1'  , '13598401426'  , '13598401426'  , '111111'  , '110108199011061814'  , 14 , '河南省地震局'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '李  涛'  , '1'  , '18137679150'  , '18137679150'  , '111111'  , '110108199011061814'  , 14 , '河南省地震局'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '赵显刚'  , '1'  , '15290897272'  , '15290897272'  , '111111'  , '110108199011061814'  , 14 , '河南省地震局'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '马兴全'  , '1'  , '15901235126'  , '15901235126'  , '111111'  , '110108199011061814'  , 14 , '河南省地震局'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '张  扬'  , '1'  , '18339918272'  , '18339918272'  , '111111'  , '110108199011061814'  , 14 , '河南省地震局'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '王  磊'  , '1'  , '18638586799'  , '18638586799'  , '111111'  , '110108199011061814'  , 14 , '河南省地震局'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '郭志刚'  , '1'  , '15903935123'  , '15903935123'  , '111111'  , '110108199011061814'  , 14 , '河南省地震局'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '曹云涛'  , '1'  , '15139380922'  , '15139380922'  , '111111'  , '110108199011061814'  , 14 , '河南省地震局'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '谢恒义'  , '1'  , '18625566533'  , '18625566533'  , '111111'  , '110108199011061814'  , 14 , '河南省地震局'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '元晓春'  , '1'  , '13939065252'  , '13939065252'  , '111111'  , '110108199011061814'  , 14 , '河南省地震局'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '郭  慧'  , '1'  , '17698096226'  , '17698096226'  , '111111'  , '110108199011061814'  , 14 , '河南省地震局'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '郭海涛'  , '1'  , '18539566016'  , '18539566016'  , '111111'  , '110108199011061814'  , 14 , '河南省地震局'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '王荣涛'  , '1'  , '18039222286'  , '18039222286'  , '111111'  , '110108199011061814'  , 14 , '河南省地震局'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '王  石'  , '1'  , '18937137778'  , '18937137778'  , '111111'  , '110108199011061814'  , 14 , '河南省地震局'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '高  旗'  , '1'  , '13503829912'  , '13503829912'  , '111111'  , '110108199011061814'  , 14 , '河南省地震局'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '张予来'  , '1'  , '13783577668'  , '13783577668'  , '111111'  , '110108199011061814'  , 14 , '河南省地震局'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '沈军'  , '1'  , '13899940655'  , '13899940655'  , '111111'  , '110108199011061814'  , 45 , '防灾科技学院'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '孙有为'  , '1'  , '13363617195'  , '13363617195'  , '111111'  , '110108199011061814'  , 45 , '防灾科技学院'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '唐彦东'  , '1'  , '13722601368'  , '13722601368'  , '111111'  , '110108199011061814'  , 45 , '防灾科技学院'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '李孝波'  , '1'  , '18831611694'  , '18831611694'  , '111111'  , '110108199011061814'  , 45 , '防灾科技学院'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '周洋'  , '1'  , '18931647833'  , '18931647833'  , '111111'  , '110108199011061814'  , 45 , '防灾科技学院'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '郭迅'  , '1'  , '13354051339'  , '13354051339'  , '111111'  , '110108199011061814'  , 45 , '防灾科技学院'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '于晓辉'  , '1'  , '13910163548'  , '13910163548'  , '111111'  , '110108199011061814'  , 45 , '防灾科技学院'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '卢滔'  , '1'  , '15831694835'  , '15831694835'  , '111111'  , '110108199011061814'  , 45 , '防灾科技学院'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '袁四化'  , '1'  , '15133628052'  , '15133628052'  , '111111'  , '110108199011061814'  , 45 , '防灾科技学院'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '张建毅'  , '1'  , '15097625359'  , '15097625359'  , '111111'  , '110108199011061814'  , 45 , '防灾科技学院'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '蔡晓光'  , '1'  , '15003166920'  , '15003166920'  , '111111'  , '110108199011061814'  , 45 , '防灾科技学院'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '黄鑫'  , '1'  , '18101051192'  , '18101051192'  , '111111'  , '110108199011061814'  , 45 , '防灾科技学院'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '秦娟'  , '2'  , '18101051192'  , '18101051192'  , '111111'  , '110108199011061814'  , 20 , '重庆市地震局'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '王宏超'  , '1'  , '18101051192'  , '18101051192'  , '111111'  , '110108199011061814'  , 20 , '重庆市地震局'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '龚丽文'  , '1'  , '18101051192'  , '18101051192'  , '111111'  , '110108199011061814'  , 20 , '重庆市地震局'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '唐茂云'  , '1'  , '18101051192'  , '18101051192'  , '111111'  , '110108199011061814'  , 20 , '重庆市地震局'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '王赞军'  , '1'  , '18101051192'  , '18101051192'  , '111111'  , '110108199011061814'  , 20 , '重庆市地震局'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '李晓丽'  , '2'  , '18101051192'  , '18101051192'  , '111111'  , '110108199011061814'  , 20 , '重庆市地震局'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '庾德寿'  , '1'  , '13041266543'  , '13041266543'  , '111111'  , '110108199011061814'  , 20 , '重庆市地震局'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '贡兴昌'  , '1'  , '13041266543'  , '13041266543'  , '111111'  , '110108199011061814'  , 20 , '重庆市地震局'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '富康盛'  , '1'  , '13041266543'  , '13041266543'  , '111111'  , '110108199011061814'  , 20 , '重庆市地震局'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '薛永元'  , '1'  , '13041266543'  , '13041266543'  , '111111'  , '110108199011061814'  , 20 , '重庆市地震局'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '伊阳伯'  , '1'  , '13041266543'  , '13041266543'  , '111111'  , '110108199011061814'  , 20 , '重庆市地震局'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '晏经艺'  , '1'  , '13041266543'  , '13041266543'  , '111111'  , '110108199011061814'  , 20 , '重庆市地震局'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '金凯乐'  , '1'  , '13041266543'  , '13041266543'  , '111111'  , '110108199011061814'  , 20 , '重庆市地震局'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '谢英情'  , '1'  , '18101051192'  , '18101051192'  , '111111'  , '110108199011061814'  , 23 , '云南省地震局'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '王云'  , '1'  , '18101051192'  , '18101051192'  , '111111'  , '110108199011061814'  , 23 , '云南省地震局'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '赵昆'  , '1'  , '18101051192'  , '18101051192'  , '111111'  , '110108199011061814'  , 23 , '云南省地震局'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '李正光'  , '1'  , '18101051192'  , '18101051192'  , '111111'  , '110108199011061814'  , 23 , '云南省地震局'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '陈坤华'  , '1'  , '18101051192'  , '18101051192'  , '111111'  , '110108199011061814'  , 23 , '云南省地震局'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '林辉'  , '1'  , '18101051192'  , '18101051192'  , '111111'  , '110108199011061814'  , 23 , '云南省地震局'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '周艺颖'  , '1'  , '18101051192'  , '18101051192'  , '111111'  , '110108199011061814'  , 23 , '云南省地震局'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '陈俊磊'  , '1'  , '18101051192'  , '18101051192'  , '111111'  , '110108199011061814'  , 23 , '云南省地震局'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '郑定昌'  , '1'  , '18101051192'  , '18101051192'  , '111111'  , '110108199011061814'  , 23 , '云南省地震局'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '庞卫东'  , '1'  , '18101051192'  , '18101051192'  , '111111'  , '110108199011061814'  , 23 , '云南省地震局'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '非明伦'  , '1'  , '18101051192'  , '18101051192'  , '111111'  , '110108199011061814'  , 23 , '云南省地震局'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '卢永坤'  , '1'  , '18101051192'  , '18101051192'  , '111111'  , '110108199011061814'  , 23 , '云南省地震局'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '张彦琪'  , '1'  , '18101051192'  , '18101051192'  , '111111'  , '110108199011061814'  , 23 , '云南省地震局'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '钟玉盛'  , '1'  , '18101051192'  , '18101051192'  , '111111'  , '110108199011061814'  , 23 , '云南省地震局'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '于江'  , '1'  , '18101051192'  , '18101051192'  , '111111'  , '110108199011061814'  , 23 , '云南省地震局'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '周洋'  , '1'  , '18101051192'  , '18101051192'  , '111111'  , '110108199011061814'  , 23 , '云南省地震局'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '明小娜'  , '1'  , '18101051192'  , '18101051192'  , '111111'  , '110108199011061814'  , 23 , '云南省地震局'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '赵峰'  , '1'  , '18101051192'  , '18101051192'  , '111111'  , '110108199011061814'  , 21 , '四川省地震局'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '张威'  , '1'  , '18101051192'  , '18101051192'  , '111111'  , '110108199011061814'  , 21 , '四川省地震局'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '史丙新'  , '1'  , '18101051192'  , '18101051192'  , '111111'  , '110108199011061814'  , 21 , '四川省地震局'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '胡志峰'  , '1'  , '18101051192'  , '18101051192'  , '111111'  , '110108199011061814'  , 21 , '四川省地震局'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '鲁长江'  , '1'  , '18101051192'  , '18101051192'  , '111111'  , '110108199011061814'  , 21 , '四川省地震局'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '梁厚朗'  , '1'  , '18101051192'  , '18101051192'  , '111111'  , '110108199011061814'  , 21 , '四川省地震局'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '李虎'  , '1'  , '18101051192'  , '18101051192'  , '111111'  , '110108199011061814'  , 21 , '四川省地震局'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '刘杨'  , '1'  , '18101051192'  , '18101051192'  , '111111'  , '110108199011061814'  , 21 , '四川省地震局'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '杨阳'  , '1'  , '18101051192'  , '18101051192'  , '111111'  , '110108199011061814'  , 21 , '四川省地震局'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '格桑扎西'  , '1'  , '18101051192'  , '18101051192'  , '111111'  , '110108199011061814'  , 21 , '四川省地震局'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '罗安元'  , '1'  , '18101051192'  , '18101051192'  , '111111'  , '110108199011061814'  , 21 , '四川省地震局'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '毛利'  , '1'  , '18101051192'  , '18101051192'  , '111111'  , '110108199011061814'  , 21 , '四川省地震局'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '章明圆'  , '1'  , '18101051192'  , '18101051192'  , '111111'  , '110108199011061814'  , 21 , '四川省地震局'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '吴今生'  , '1'  , '18101051192'  , '18101051192'  , '111111'  , '110108199011061814'  , 21 , '四川省地震局'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '唐志京'  , '1'  , '18101051192'  , '18101051192'  , '111111'  , '110108199011061814'  , 21 , '四川省地震局'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '王兴国'  , '1'  , '18101051192'  , '18101051192'  , '111111'  , '110108199011061814'  , 21 , '四川省地震局'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '肖本夫'  , '1'  , '18101051192'  , '18101051192'  , '111111'  , '110108199011061814'  , 21 , '四川省地震局'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '周志华'  , '1'  , '18101051192'  , '18101051192'  , '111111'  , '110108199011061814'  , 21 , '四川省地震局'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '亢川'  , '1'  , '18101051192'  , '18101051192'  , '111111'  , '110108199011061814'  , 21 , '四川省地震局'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '刘玉发'  , '1'  , '18101051192'  , '18101051192'  , '111111'  , '110108199011061814'  , 21 , '四川省地震局'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '丁成周'  , '1'  , '13041266543'  , '13041266543'  , '111111'  , '110108199011061814'  , 24 , '西藏省地震局'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '连文斌'  , '1'  , '13041266543'  , '13041266543'  , '111111'  , '110108199011061814'  , 24 , '西藏省地震局'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '饶泰和'  , '1'  , '13041266543'  , '13041266543'  , '111111'  , '110108199011061814'  , 24 , '西藏省地震局'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '易炫明'  , '1'  , '13041266543'  , '13041266543'  , '111111'  , '110108199011061814'  , 24 , '西藏省地震局'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '曹正阳'  , '1'  , '13041266543'  , '13041266543'  , '111111'  , '110108199011061814'  , 24 , '西藏省地震局'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '通俊智'  , '1'  , '13041266543'  , '13041266543'  , '111111'  , '110108199011061814'  , 24 , '西藏省地震局'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '濮泰河'  , '1'  , '13041266543'  , '13041266543'  , '111111'  , '110108199011061814'  , 24 , '西藏省地震局'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '邴昊然'  , '1'  , '13041266543'  , '13041266543'  , '111111'  , '110108199011061814'  , 24 , '西藏省地震局'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '糜才捷'  , '1'  , '13041266543'  , '13041266543'  , '111111'  , '110108199011061814'  , 24 , '西藏省地震局'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '程懿轩'  , '1'  , '13041266543'  , '13041266543'  , '111111'  , '110108199011061814'  , 24 , '西藏省地震局'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '储波光'  , '1'  , '13041266543'  , '13041266543'  , '111111'  , '110108199011061814'  , 22 , '贵州省地震局'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '莫宏嵘'  , '1'  , '13041266543'  , '13041266543'  , '111111'  , '110108199011061814'  , 22 , '贵州省地震局'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '陈本金'  , '1'  , '13041266543'  , '13041266543'  , '111111'  , '110108199011061814'  , 22 , '贵州省地震局'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '梁开伦'  , '1'  , '13041266543'  , '13041266543'  , '111111'  , '110108199011061814'  , 22 , '贵州省地震局'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '徐祥'  , '1'  , '13041266543'  , '13041266543'  , '111111'  , '110108199011061814'  , 22 , '贵州省地震局'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '菱宏盛'  , '1'  , '13041266543'  , '13041266543'  , '111111'  , '110108199011061814'  , 22 , '贵州省地震局'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '蔚越彬'  , '1'  , '13041266543'  , '13041266543'  , '111111'  , '110108199011061814'  , 22 , '贵州省地震局'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '蓬和怡'  , '1'  , '13041266543'  , '13041266543'  , '111111'  , '110108199011061814'  , 22 , '贵州省地震局'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '弘凯乐'  , '1'  , '13041266543'  , '13041266543'  , '111111'  , '110108199011061814'  , 22 , '贵州省地震局'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '茹波涛'  , '1'  , '13041266543'  , '13041266543'  , '111111'  , '110108199011061814'  , 22 , '贵州省地震局'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '姜久坤'  , '1'  , '13953191521'  , '13953191521'  , '111111'  , '110108199011061814'  , 13 , '山东省地震局'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '冯志泽'  , '1'  , '13153107587'  , '13153107587'  , '111111'  , '110108199011061814'  , 13 , '山东省地震局'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '胡以云'  , '1'  , '18553123106'  , '18553123106'  , '111111'  , '110108199011061814'  , 13 , '山东省地震局'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '许  丹'  , '1'  , '13605403410'  , '13605403410'  , '111111'  , '110108199011061814'  , 13 , '山东省地震局'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '越丝琦'  , '1'  , '18553123110'  , '18553123110'  , '111111'  , '110108199011061814'  , 13 , '山东省地震局'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '许洪泰'  , '1'  , '13515310256'  , '13515310256'  , '111111'  , '110108199011061814'  , 13 , '山东省地震局'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '白新颖'  , '1'  , '18553123102'  , '18553123102'  , '111111'  , '110108199011061814'  , 13 , '山东省地震局'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '鹿子林'  , '1'  , '18866856857'  , '18866856857'  , '111111'  , '110108199011061814'  , 13 , '山东省地震局'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '姜悠婉'  , '1'  , '18553123109'  , '18553123109'  , '111111'  , '110108199011061814'  , 13 , '山东省地震局'  , ''  , 1 ,'2018-04-19 14:45:52');
INSERT INTO t_user (roleid,name,sex,username,phone,password,idcard,cid,company,profession,state,createtime) VALUES ( 4  , '倪永进'  , '1'  , '13256660103'  , '13256660103'  , '111111'  , '110108199011061814'  , 13 , '山东省地震局'  , ''  , 1 ,'2018-04-19 14:45:52');
     
     */
}
