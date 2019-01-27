/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.tdic.entity;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 字典管理Entity
 * @author cq
 * @version 2018-12-30
 */
public class TDic extends DataEntity<TDic> {
	
	private static final long serialVersionUID = 1L;
	private String dicid;		// 商品属性表
	private String dictype;		// 属性类型
	private String dicname;		// 类型名称
	private String dicvalue;		// 属性值
	private String sort;		// 排序
	private String remark;
	
	
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public TDic() {
		super();
	}

	public TDic(String id){
		super(id);
	}

	public String getDicid() {
		return dicid;
	}

	public void setDicid(String dicid) {
		this.dicid = dicid;
	}
	
	public String getDictype() {
		return dictype;
	}

	public void setDictype(String dictype) {
		this.dictype = dictype;
	}
	
	public String getDicname() {
		return dicname;
	}

	public void setDicname(String dicname) {
		this.dicname = dicname;
	}
	
	public String getDicvalue() {
		return dicvalue;
	}

	public void setDicvalue(String dicvalue) {
		this.dicvalue = dicvalue;
	}
	
	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}
	
}