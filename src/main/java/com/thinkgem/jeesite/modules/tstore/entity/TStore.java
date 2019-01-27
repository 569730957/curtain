/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.tstore.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 店铺信息Entity
 * @author cq
 * @version 2019-01-10
 */
public class TStore extends DataEntity<TStore> {
	
	private static final long serialVersionUID = 1L;
	private String storeid;		// 店铺信息表
	private String storename;		// 店铺名称
	private String logo;		// 店铺logo
	
	public TStore() {
		super();
	}

	public TStore(String id){
		super(id);
	}

	public String getStoreid() {
		return storeid;
	}

	public void setStoreid(String storeid) {
		this.storeid = storeid;
	}
	
	public String getStorename() {
		return storename;
	}

	public void setStorename(String storename) {
		this.storename = storename;
	}
	
	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}
	
}