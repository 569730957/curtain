package com.thinkgem.jeesite.modules.api.entity;

import com.thinkgem.jeesite.modules.api.utils.TSuper;

public class ApiCollect extends TSuper{

	private String collectid;
	private String userid;
	private String goodsid;
	private String createtime;
	
	private String goodsname;
	private String image;
	
	
	public String getGoodsname() {
		return goodsname;
	}
	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public String getCollectid() {
		return collectid;
	}
	public void setCollectid(String collectid) {
		this.collectid = collectid;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getGoodsid() {
		return goodsid;
	}
	public void setGoodsid(String goodsid) {
		this.goodsid = goodsid;
	}
	
	
}
