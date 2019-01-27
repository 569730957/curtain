package com.thinkgem.jeesite.modules.api.utils;


import org.apache.commons.lang.StringUtils;

import com.thinkgem.jeesite.modules.api.utils.Config.Data;
import com.thinkgem.jeesite.modules.api.utils.MyUtils;



public class TSuper {

	private String id;// 主键id(用户ID)
	private int page;// 页
	private int pagesize;// 条
	
	public void setPagePageSize(int page, int pagesize){
		setPage(((page-1)*pagesize));
		setPagesize(pagesize);  
	}
	
	/**
	 * @方法说明:页
	 * @方法名称:getPage
	 * @return
	 * @作者:李梦卿
	 * @返回值:int
	 */
	protected int getPage() {
		return page;
	}

	/**
	 * @方法说明:页
	 * @方法名称:getPage
	 * @return
	 * @作者:李梦卿
	 * @返回值:int
	 */
	protected void setPage(int page) {
		this.page = page;
	}

	/**
	 * @方法说明:条
	 * @方法名称:getPagesize
	 * @return
	 * @作者:李梦卿
	 * @返回值:int
	 */
	protected int getPagesize() {
		return pagesize;
	}

	/**
	 * @方法说明:条
	 * @方法名称:getPagesize
	 * @return
	 * @作者:李梦卿
	 * @返回值:int
	 */
	protected void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}

	/**
	 * @方法说明:设置价格显示
	 * @方法名称:setScale
	 * @param f
	 * @return
	 * @作者:李梦卿
	 * @返回值:double
	 */
	protected String setScale(double price) {
		return String.format("%.2f", price);
	}
//	protected String setScale(String price) {
//		return String.format("%.2f", price);
//	}
	/**
	 * @方法说明:设置主键
	 * @方法名称:setId
	 * @param id
	 * @作者:李梦卿
	 * @返回值:void
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @方法说明:获取主键
	 * @方法名称:getId
	 * @return
	 * @作者:李梦卿
	 * @返回值:String
	 */
	public String getId() {
		return id;
	}

	/**
	 * @方法说明:更加，|,拆分数据
	 * @方法名称:setString
	 * @param str
	 * @return
	 * @作者:李梦卿
	 * @返回值:String[]
	 */
	protected String[] setString(String str) {
		return MyUtils.setSeparator(str, ",|，");
	}

	/**
	 * @方法说明:id转换
	 * @方法名称:setTId
	 * @param tid
	 * @return
	 * @作者:李梦卿
	 * @返回值:String
	 */
	protected String setTId(String tid) {
		return StringUtils.isEmpty(tid) ? getId() : tid;
	}
   
	
	 /**
	 * @方法说明:文件下载路径
	 * @方法名称:setDownurlURL
	 * @param downurl
	 * @return
	 * @作者:邓师
	 * @返回值:String
	 */
	protected String setDownurlURL(String downurl) {
	    if(downurl == null || downurl.equals("")){
	    	return "";
	    }else if(downurl.contains("http://") || downurl.contains("https://")){
	    	return downurl;
	    } else{
	    	return Data.IPPORT + downurl;
	    }
	}
	/**
	 * @方法说明:单个图片路径输出
	 * @方法名称:setImageURL
	 * @param image
	 * @return
	 * @作者:李梦卿
	 * @返回值:String
	 */
	public static String setImageURL(String image) {
	    if(image == null || image.equals("")){
	    	return "";
	    }else if(image.contains("http://") || image.contains("https://")){
	    	return image;
	    } else{
	    	return Data.IPPORT + image;
	    }
	}

	/**
	 * @方法说明:多个图片路径输出
	 * @方法名称:setImageURLs
	 * @param images
	 * @return
	 * @作者:李梦卿
	 * @返回值:String[]
	 */
	protected String[] setImageURLs(String images) {
		return MyUtils.setSeparatorImage(images, ",|，", Data.IPPORT);
	}

	
	/**
	 * 插入之前执行方法，子类实现
	 */
	public void preInsert() {
	}
	
	/**
	 * 更新之前执行方法，子类实现
	 */
	public void preUpdate() {
	}

	


}
