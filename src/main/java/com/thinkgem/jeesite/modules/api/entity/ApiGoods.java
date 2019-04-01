package com.thinkgem.jeesite.modules.api.entity;

import com.thinkgem.jeesite.modules.api.utils.TSuper;

public class ApiGoods extends TSuper{

	
	private String goodsid;
	private String goodsname;
	private String image;
	private String fabric;
	private String style;
	private String color;
	private String technology;
	private String goodsdetail;
	private String createtime;
	private String cateid;
	private int iscollect;
	
	
	public int getIscollect() {
		return iscollect;
	}
	public void setIscollect(int iscollect) {
		this.iscollect = iscollect;
	}
	public String getGoodsid() {
		return goodsid;
	}
	public void setGoodsid(String goodsid) {
		this.goodsid = goodsid;
	}
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
		this.image = TSuper.setImageURL(image);
	}
	public String getFabric() {
		return fabric;
	}
	public void setFabric(String fabric) {
		this.fabric = fabric;
	}
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getTechnology() {
		return technology;
	}
	public void setTechnology(String technology) {
		this.technology = technology;
	}
	public String getGoodsdetail() {
		return goodsdetail;
	}
	public void setGoodsdetail(String goodsdetail) {
		this.goodsdetail = goodsdetail;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public String getCateid() {
		return cateid;
	}
	public void setCateid(String cateid) {
		this.cateid = cateid;
	}
	
	
	
}
