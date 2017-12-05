package com.boliangshenghe.outteam.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间工具类
 * 
 * @author xuzj
 * 
 */
public class DateUtils {

	public static String getStringDate(Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日HH时mm分");
		String dateString = formatter.format(date);
		return dateString;
	}
	
	public static String getAllStringDate(Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = formatter.format(date);
		return dateString;
	}
	
	public static String getYearMDayStringDate(Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = formatter.format(date);
		return dateString;
	}
}
