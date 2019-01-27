/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.tgoodscate.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 类目管理Entity
 * @author cq
 * @version 2018-12-30
 */
public class TGoodsCate extends DataEntity<TGoodsCate> {
	
	private static final long serialVersionUID = 1L;
	private String categoodsid;		// 商品-类目关联表
	private String cateid;		// 类目id
	private String goodsid;		// 商品id
	
	public TGoodsCate() {
		super();
	}

	public TGoodsCate(String id){
		super(id);
	}

	public String getCategoodsid() {
		return categoodsid;
	}

	public void setCategoodsid(String categoodsid) {
		this.categoodsid = categoodsid;
	}
	
	public String getCateid() {
		return cateid;
	}

	public void setCateid(String cateid) {
		this.cateid = cateid;
	}
	
	public String getGoodsid() {
		return goodsid;
	}

	public void setGoodsid(String goodsid) {
		this.goodsid = goodsid;
	}
	
}