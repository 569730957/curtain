package com.thinkgem.jeesite.modules.api.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.thinkgem.jeesite.common.utils.IdGen;
import com.thinkgem.jeesite.modules.api.entity.ApiCate;
import com.thinkgem.jeesite.modules.api.entity.ApiCollect;
import com.thinkgem.jeesite.modules.api.entity.ApiDic;
import com.thinkgem.jeesite.modules.api.entity.ApiGoods;
import com.thinkgem.jeesite.modules.api.entity.ApiStore;
import com.thinkgem.jeesite.modules.api.entity.ApiUser;
import com.thinkgem.jeesite.modules.api.entity.DicCateEntity;
import com.thinkgem.jeesite.modules.api.service.YijuService;
import com.thinkgem.jeesite.modules.api.utils.AesCbcUtil;
import com.thinkgem.jeesite.modules.api.utils.BaseDataController;
import com.thinkgem.jeesite.modules.api.utils.ResponseResultUtils;
import com.thinkgem.jeesite.modules.api.utils.TSuper;
import com.thinkgem.jeesite.modules.api.utils.WxUtil;

/**
 * 宜居小程序一期的接口
 * @author E480
 *
 */
@Controller
@RequestMapping(value = "${adminfath}/interface/yiju")
public class YijuController {
	
	@Autowired
	YijuService service;
	
	@RequestMapping(value = "api")
	@ResponseBody
	public Map<String, Object> client(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		BaseDataController base;// 变量的声明
		try {
			base = new BaseDataController(request, response);// 初始化
			if (ResponseResultUtils.check(base.getAppkey())) {
				JSONObject reqPayloadBody = base.getReqPayloadBody();
			
				String api=reqPayloadBody.getString("api");
				if(api.equals("login")){
					try {
						map = request_login(reqPayloadBody);
					} catch (Exception e) {
						map = ResponseResultUtils.responseErrorMessage(0, e);
					}
				}else if(api.equals("addCollect")){
					try {
						map = request_addCollect(reqPayloadBody);
					} catch (Exception e) {
						map = ResponseResultUtils.responseErrorMessage(0, e);
					}
				}else if(api.equals("delCollect")){
					try {
						map = request_delCollect(reqPayloadBody);
					} catch (Exception e) {
						map = ResponseResultUtils.responseErrorMessage(0, e);
					}
				}else if(api.equals("getMyCollect")){
					try {
						map = request_getMyCollect(reqPayloadBody);
					} catch (Exception e) {
						map = ResponseResultUtils.responseErrorMessage(0, e);
					}
				}else if(api.equals("getMyCates")){
					try {
						map = request_getCates(reqPayloadBody);
					} catch (Exception e) {
						map = ResponseResultUtils.responseErrorMessage(0, e);
					}
				}else if(api.equals("getGoods")){
					try {
						map = request_getGoods(reqPayloadBody);
					} catch (Exception e) {
						map = ResponseResultUtils.responseErrorMessage(0, e);
					}
				}else if(api.equals("getStore")){
					try {
						map = request_getStore(reqPayloadBody);
					} catch (Exception e) {
						map = ResponseResultUtils.responseErrorMessage(0, e);
					}
				}else if(api.equals("getGoodsById")){
					try {
						map = request_getGoodsById(reqPayloadBody);
					} catch (Exception e) {
						map = ResponseResultUtils.responseErrorMessage(0, e);
					}
				}
				
				
				
			} else {
				map = ResponseResultUtils.responseKeyFailMap();
			}

		} catch (Exception e) {
			e.printStackTrace();
			map = ResponseResultUtils.responseErrorMessage("", e);
		}
		return map;
	}
	
	//微信授权登陆
	private Map<String, Object> request_login(JSONObject reqPayloadBody) {
	    
		//获取encryptedData和iv
		String encryptedData = reqPayloadBody.getString("encryptedData");
		String iv = reqPayloadBody.getString("iv");
		
		//获取code，调用api获取openid
		String code = reqPayloadBody.getString("code");
		Map<String,Object> map = WxUtil.getOpenid(code);
		if(map!=null){
			
			try{
				String openid=(String) map.get("openid");
				String session_key=(String) map.get("session_key");
				String result=AesCbcUtil.decrypt(encryptedData, session_key, iv, "UTF-8");
				ApiUser u=null;
				if (null != result && result.length() > 0) {
					//登录数据解密完成
					u=new ApiUser();
					com.alibaba.fastjson.JSONObject ob=com.alibaba.fastjson.JSONObject.parseObject(result);
					
					u.setOpenid(openid);
					u.setNickname(ob.getString("nickName"));
					u.setPortrait(ob.getString("avatarUrl"));
					u.setGender(ob.getString("gender"));
					u.setProvince(ob.getString("province"));
					u.setCity(ob.getString("city"));
					//注册查询返回用户对象
					ApiUser uu=service.getByOpenid(u);
					return ResponseResultUtils.responseMap(uu);
				}else{
					return ResponseResultUtils.responseMap(null);
				}
			}catch(Exception e){
				return ResponseResultUtils.responseMap(null,"","个人数据解析失败");
			}
		}
		return ResponseResultUtils.responseMap(null);
	}
	
	//用户收藏
	private Map<String, Object> request_addCollect(JSONObject reqPayloadBody) {
		ApiCollect collect = new Gson().fromJson(reqPayloadBody.toString(), new TypeToken<ApiCollect>() {}.getType());
		collect.setCollectid(IdGen.uuid());
		int result=service.addCollect(collect);
		return ResponseResultUtils.responseStringOrInt(result);
	}
	//用户取消收藏
	private Map<String, Object> request_delCollect(JSONObject reqPayloadBody) {
		String collectid = reqPayloadBody.getString("collectid");
		int result=service.delCollect(collectid);
		return ResponseResultUtils.responseStringOrInt(result);
	}
	//查询我的收藏
	private Map<String, Object> request_getMyCollect(JSONObject reqPayloadBody) {
		
		ApiCollect c = new ApiCollect();
		String uid = reqPayloadBody.getString("userid");
		c.setUserid(uid);
		c.setPagePageSize(reqPayloadBody.getInt("page"), reqPayloadBody.getInt("pagesize"));
		List<ApiCollect> list=service.getMyCollect(c);
		return ResponseResultUtils.responseList(list);
	}
	
	//查询筛选条件列表和左边类目列表
	private  Map<String, Object> request_getCates(JSONObject reqPayloadBody) {
		
		//查询4个筛选条件列表
		List<ApiDic> listFabric = service.getDicByType("fabric");
		List<ApiDic> listStyle = service.getDicByType("style");
		List<ApiDic> listColor = service.getDicByType("color");
		List<ApiDic> listTechnology = service.getDicByType("technology");
		
		//查询左边类目列表
		List<ApiCate> listCate=service.getCate();
		
		DicCateEntity e=new DicCateEntity();
		e.setListFabric(listFabric);
		e.setListStyle(listStyle);
		e.setListColor(listColor);
		e.setListTechnology(listTechnology);
		e.setListCate(listCate);
		return ResponseResultUtils.responseMap(e);
	}
	
	//分页查询商品
	private  Map<String, Object> request_getGoods(JSONObject reqPayloadBody) {
		ApiGoods g = new Gson().fromJson(reqPayloadBody.toString(), new TypeToken<ApiGoods>() {}.getType());
		g.setPagePageSize(reqPayloadBody.getInt("page"), reqPayloadBody.getInt("pagesize"));
		List<ApiGoods> list=service.getGoods(g);
		return ResponseResultUtils.responseList(list);
	}
	
	//查询店铺信息
	private  Map<String, Object> request_getStore(JSONObject reqPayloadBody) {
		ApiStore s=service.getStore();
		s.setLogo(TSuper.setImageURL(s.getLogo()));
		return ResponseResultUtils.responseMap(s);
	}
	
	//根据商品id查询详情
	private  Map<String, Object> request_getGoodsById(JSONObject reqPayloadBody) {
		String goodsid = reqPayloadBody.getString("goodsid");
		ApiGoods g=service.getGoodsById(goodsid);
		return ResponseResultUtils.responseMap(g);
	}
	
	
	
	
	
	
	
}
