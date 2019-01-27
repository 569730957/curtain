package com.thinkgem.jeesite.modules.api.utils;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;


/**
 * 微信授权
 * @author E480
 *
 */
public class WxUtil {

	// 小程序唯一标识 (在微信小程序管理后台获取)
	static String wxAppid = "wxa9e3081f22bb2fc0";
	// 小程序的 app secret (在微信小程序管理后台获取)
	static String wxSecret = "16bb953a2b83ff9262d63c4ed329dcd8";
	// 授权（必填）
	static String grant_type = "authorization_code";
	
	
    public static Map<String,Object> getOpenid(String code) {
    	
    	Map<String,Object> map=new HashMap<String, Object>();
        String params = "appid=" + wxAppid + "&secret=" + wxSecret + "&js_code=" + code + "&grant_type=" + grant_type;
        String sr = HttpRequest.sendGet("https://api.weixin.qq.com/sns/jscode2session", params);
        JSONObject json = JSONObject.parseObject(sr);
        String openid = json.get("openid").toString();
        String session_key=json.getString("session_key").toString();
        
        map.put("openid", openid);
        map.put("session_key", session_key);
        
        return map;
    }
	
	
}








