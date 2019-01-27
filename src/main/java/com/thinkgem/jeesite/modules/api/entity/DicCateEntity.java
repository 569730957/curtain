package com.thinkgem.jeesite.modules.api.entity;

import java.util.List;

public class DicCateEntity {

	List<ApiDic> listFabric; 
	List<ApiDic> listStyle; 
	List<ApiDic> listColor; 
	List<ApiDic> listTechnology;
	List<ApiCate> listCate;
	public List<ApiDic> getListFabric() {
		return listFabric;
	}
	public void setListFabric(List<ApiDic> listFabric) {
		this.listFabric = listFabric;
	}
	public List<ApiDic> getListStyle() {
		return listStyle;
	}
	public void setListStyle(List<ApiDic> listStyle) {
		this.listStyle = listStyle;
	}
	public List<ApiDic> getListColor() {
		return listColor;
	}
	public void setListColor(List<ApiDic> listColor) {
		this.listColor = listColor;
	}
	public List<ApiDic> getListTechnology() {
		return listTechnology;
	}
	public void setListTechnology(List<ApiDic> listTechnology) {
		this.listTechnology = listTechnology;
	}
	public List<ApiCate> getListCate() {
		return listCate;
	}
	public void setListCate(List<ApiCate> listCate) {
		this.listCate = listCate;
	}
	
	
	
}
