package com.thinkgem.jeesite.modules.api.dao;

import java.util.List;

import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.api.entity.ApiCate;
import com.thinkgem.jeesite.modules.api.entity.ApiCollect;
import com.thinkgem.jeesite.modules.api.entity.ApiDic;
import com.thinkgem.jeesite.modules.api.entity.ApiGoods;
import com.thinkgem.jeesite.modules.api.entity.ApiStore;
import com.thinkgem.jeesite.modules.api.entity.ApiUser;


@MyBatisDao
public interface YijuDao {

	public int addCollect(ApiCollect c);
	public int delCollect(String collectid);
	public List<ApiCollect> getMyCollect(ApiCollect c);
	
	public List<ApiDic> getDicByType(String dictype);
	public List<ApiCate> getCate();
	
	public List<ApiGoods> getGoods(ApiGoods g);
	public ApiStore getStore();
	public ApiGoods getGoodsById(String goodsid);
	
	public int checkOpenid(String openid);
	public int insertUser(ApiUser u);
	public ApiUser getUserByOpenid(String openid);
	public int checkIsCollect(ApiCollect c);
}
