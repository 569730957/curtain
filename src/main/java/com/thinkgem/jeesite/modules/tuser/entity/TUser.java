/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.tuser.entity;

import java.util.Date;
import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 用户管理Entity
 * @author cq
 * @version 2018-12-30
 */
public class TUser extends DataEntity<TUser> {
	
	private static final long serialVersionUID = 1L;
	private String userid;		// 用户表
	private String openid;		// openid
	private String nickname;		// 昵称
	private Date createtime;		// 创建时间
	
	private String portrait;
	private String province;
	private String city;
	
	
	
	public String getPortrait() {
		return portrait;
	}

	public void setPortrait(String portrait) {
		this.portrait = portrait;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public TUser() {
		super();
	}

	public TUser(String id){
		super(id);
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}
	
	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	
}