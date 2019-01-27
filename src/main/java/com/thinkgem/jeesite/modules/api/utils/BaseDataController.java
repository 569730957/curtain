package com.thinkgem.jeesite.modules.api.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONObject;
import org.apache.commons.lang3.StringUtils;
import com.thinkgem.jeesite.modules.api.utils.Config.Data;
import com.thinkgem.jeesite.modules.api.utils.Config.Method;


public class BaseDataController {
	protected String rel;
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	protected String appkey;
	protected String version;
	protected String from;

	public BaseDataController(HttpServletRequest request,
			HttpServletResponse response) throws IOException  {
		this.request = request;
		this.response = response;
		Data.IPPORT = Method.getPath(request);
		response.setHeader("Access-Control-Allow-Origin", "*");
		populateRequestData();
	}

	public String getAppkey() {
		return appkey;
	}

	public void setAppkey(String appkey) {
		this.appkey = appkey;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public BaseDataController() {
		super();
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	protected JSONObject reqPayloadBody = new JSONObject();

	public JSONObject getReqPayloadBody() {
		return reqPayloadBody;
	}

	public void setReqPayloadBody(JSONObject reqPayloadBody) {
		this.reqPayloadBody = reqPayloadBody;
	}

	protected JSONObject respObj = new JSONObject();

	protected void setResponse(HttpServletResponse response) {
		response.setContentType("application/json;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		// 设置浏览器不要缓存
		response.setHeader("Cache-Control", "no-store"); // HTTP1.1
		response.setHeader("Pragma", "no-cache"); // HTTP1.0
		response.setDateHeader("Expires", 0);
	}

	protected String urlEncoder(String url) {
		if (url == null) {
			return null;
		}
		try {
			return URLEncoder.encode(url, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return url;
	}

	/**
	 * 得到数据流转换
	 * 
	 * @方法说明:
	 * @方法名称:getPostPayload
	 * @return
	 * @throws IOException
	 * @作者:张威
	 * @返回值: JSONObject
	 */
	public JSONObject getPostPayload() throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader reader = null;
		reader = request.getReader();
		String line;
		while ((line = reader.readLine()) != null) {
			sb.append(line).append('\n');
		}
		return JSONObject.fromObject(sb.toString());
	}

	/**
	 * 得到前端网页数据
	 * 
	 * @方法说明:http://192.168.31.23:8080/jeesite/p/interface/frontContact/ 
	 *                                                                   saveFrontContact
	 *                                                                   ?
	 *                                                                   callback
	 *                                                                   =
	 *                                                                   jQuery1102014672404346996037_1450850167982
	 *                                                                   &{%22
	 *                                                                   username
	 *                                                                   %22:2}&
	 *                                                                   _=
	 *                                                                   1450850167983
	 * @方法名称:getPostPayload
	 * @return
	 * @throws IOException
	 * @作者:zw
	 * @返回值:JSONObject
	 */
	public JSONObject getPostPayloadbrooss(HttpServletRequest request)
			throws IOException {
		String requestURI = request.getQueryString();
		String[] split = requestURI.split("&");
		String decode = null;
		if (split != null && split.length > 0) {
			for (int i = 0; i < split.length; i++) {
				if (split[i].indexOf("{") != -1) {
					decode = java.net.URLDecoder.decode(split[i], "UTF-8");
				}
			}
			return JSONObject.fromObject(decode.toString());
		}
		return null;
	}

	
	 /**
	 * @方法说明:李梦卿
	 * @方法名称:populateRequestData
	 * @throws IOException
	 * @作者:李梦卿
	 * @返回值:void
	 */
	public void populateRequestData() throws IOException {
		String json = request.getParameter("str");
		JSONObject reqPayload = null;
		if(StringUtils.isEmpty(json)){
			reqPayload = getPostPayload();
		} else {
			reqPayload =JSONObject.fromObject(json);
		}
		if (null != reqPayload) {
			this.reqPayloadBody = reqPayload.getJSONObject("reqBody");
			this.appkey = reqPayload.optString("appkey");
			this.version = reqPayload.optString("version");
			this.from = reqPayload.optString("from");
		}
	}

}
