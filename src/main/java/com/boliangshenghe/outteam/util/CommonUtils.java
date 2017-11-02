package com.boliangshenghe.outteam.util;

import javax.servlet.http.HttpServletResponse;

/**
 * 静态常量工具类
 * @author xuzj
 *
 */
public class CommonUtils {

	public static final Integer PAGESIZE = 10;//分页 每页条数
	
	public static final String REQUEST_KEY_REQUEST = "_request";// 当前请求
	
	public static final String USERID = "userid";
	public static final String USERNAME = "username";
	public static final String REALNAME = "realname";
	public static final String ROLEID = "roleid";
	public static final String CID = "cid";
	public static final String COMPANY = "company";
	public static final String ISLOGIN = "islogin";
	
	
	private static final String CACHE_CONTROL = "Cache-Control";
	private static final String PRAGMA = "Pragma";
	private static final String HTTP_NO_CACHE = "no-store,no-cache,must-revalidate";
	private static final String IE_HTTP_NO_CACHE = "post-check=0, pre-check=0";
	private static final String STANDARD_HTTP_NO_CACHE = "no-cache";
	 /**no-cache*/
    public static final void addNoCacheHeader(final HttpServletResponse response){
		response.setHeader(CACHE_CONTROL, HTTP_NO_CACHE); 
		response.addHeader(CACHE_CONTROL, IE_HTTP_NO_CACHE); 
		response.setHeader(PRAGMA, STANDARD_HTTP_NO_CACHE); 
    }
}
