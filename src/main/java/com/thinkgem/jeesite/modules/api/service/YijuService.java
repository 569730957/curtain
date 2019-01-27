package com.thinkgem.jeesite.modules.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.utils.IdGen;
import com.thinkgem.jeesite.modules.api.dao.YijuDao;
import com.thinkgem.jeesite.modules.api.entity.ApiCate;
import com.thinkgem.jeesite.modules.api.entity.ApiCollect;
import com.thinkgem.jeesite.modules.api.entity.ApiDic;
import com.thinkgem.jeesite.modules.api.entity.ApiGoods;
import com.thinkgem.jeesite.modules.api.entity.ApiStore;
import com.thinkgem.jeesite.modules.api.entity.ApiUser;

@Service
@Transactional(readOnly = true)
public class YijuService {

	@Autowired
	private YijuDao dao;
	
	@Transactional(readOnly = false)
	public int addCollect(ApiCollect c){
		
		int isCollect = dao.checkIsCollect(c);
		if(isCollect<=0){
			return dao.addCollect(c);
		}
		return 0;
	}
	
	@Transactional(readOnly = false)
	public int delCollect(String collectid){
		return dao.delCollect(collectid);
	}
	
	public List<ApiCollect> getMyCollect(ApiCollect c){
		return dao.getMyCollect(c);
	}
	
	public List<ApiDic> getDicByType(String dictype){
		return dao.getDicByType(dictype);
	}
	public List<ApiCate> getCate(){
		return dao.getCate();
	}
	
	public List<ApiGoods> getGoods(ApiGoods g){
		return dao.getGoods(g);
	}
	public ApiStore getStore(){
		return dao.getStore();
	}
	
	public ApiGoods getGoodsById(String goodsid){
		return dao.getGoodsById(goodsid);
	}
	
	@Transactional(readOnly = false)
	public ApiUser getByOpenid(ApiUser u){
		
		int isexist=dao.checkOpenid(u.getOpenid());
		if(isexist<=0){
			//没有注册
			u.setUserid(IdGen.uuid());
			//注册
			dao.insertUser(u);
			return u;
		}
		//注册了就直接查询返回
		return dao.getUserByOpenid(u.getOpenid());
	}
	
}
