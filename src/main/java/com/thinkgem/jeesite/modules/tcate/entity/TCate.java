/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.tcate.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 类目Entity
 * @author cq
 * @version 2018-12-31
 */
public class TCate extends DataEntity<TCate> {
	
	private static final long serialVersionUID = 1L;
	private String cateid;		// 类目表
	private String catename;		// 类目名称
	private String sort;		// 排序（越小越靠前）
	private String state;
	
	
	
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public TCate() {
		super();
	}

	public TCate(String id){
		super(id);
	}

	public String getCateid() {
		return cateid;
	}

	public void setCateid(String cateid) {
		this.cateid = cateid;
	}
	
	public String getCatename() {
		return catename;
	}

	public void setCatename(String catename) {
		this.catename = catename;
	}
	
	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}
	
}