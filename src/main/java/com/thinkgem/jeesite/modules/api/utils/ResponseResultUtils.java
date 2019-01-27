package com.thinkgem.jeesite.modules.api.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import com.thinkgem.jeesite.modules.api.utils.Config.Data;


public class ResponseResultUtils {

	/**
	 * @方法说明:验证Appkey
	 * @方法名称:check
	 * @param appKey
	 * @return
	 * @作者:李梦卿
	 * @返回值:boolean
	 */
	public static boolean check(String appKey) {
		return appKey.equals(Data.APPKEY);
	}

	public static JSONObject readJSONString(HttpServletRequest request)
			throws JSONException, IOException {
		StringBuffer json = new StringBuffer();
		String line = null;
		BufferedReader reader = request.getReader();
		while ((line = reader.readLine()) != null) {
			json.append(line);
		}
		return new JSONObject(json.toString());
	}

	/**
	 * @方法说明:请求失败返回提示错误信息（代码错误信息）
	 * @方法名称:responseErrorMessage
	 * @param t
	 * @param e
	 * @return
	 * @作者:李梦卿
	 * @返回值:Map<String,Object>
	 */
	public static <T> Map<String, Object> responseErrorMessage(T t, Exception e) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("msg", e.getMessage());
		map.put("state", Data.STATE_ERROR);
		map.put("data", t);
		return map;
	}

	public static <T> Map<String, Object> responseOvertimeMessage(T t,
			Exception e) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("msg", e.getMessage());
		map.put("state", Data.STATE_OVERTIME);
		map.put("data", t);
		return map;
	}

	/**
	 * @方法说明:相应list类型数据返回结果
	 * @方法名称:responseList
	 * @param t
	 * @return
	 * @作者:李梦卿
	 * @返回值:Map<String,Object>
	 */
	public static <T> Map<String, Object> responseList(List<T> t) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (t != null) {
			if (t.size() > 0) {
				map.put("msg", Data.REQUEST_SUCCESS);
				map.put("state", Data.STATE_SUCCESS);
				map.put("data", t);
			} else {
				map.put("msg", Data.REQUEST_SUCCESS_DATA_NULL);
				map.put("state", Data.STATE_SUCCESS_DATA_NULL);
				map.put("data", t);
			}
		} else {
			map.put("msg", Data.REQUEST_FAIL);
			map.put("state", Data.STATE_FAIL);
			map.put("data", new ArrayList());
		}
		return map;
	}

	/**
	 * @方法说明:相应list类型数据返回结果
	 * @方法名称:responseList
	 * @param t
	 * @param request_success
	 *            成功提示信息
	 * @return
	 * @作者:李梦卿
	 * @返回值:Map<String,Object>
	 */
	public static <T> Map<String, Object> responseList(List<T> t,
			String request_success) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (t != null) {
			if (t.size() > 0) {
				map.put("msg", request_success);
				map.put("state", Data.STATE_SUCCESS);
				map.put("data", t);
			} else {
				map.put("msg", Data.REQUEST_SUCCESS_DATA_NULL);
				map.put("state", Data.STATE_SUCCESS_DATA_NULL);
				map.put("data", t);
			}
		} else {
			map.put("msg", Data.REQUEST_FAIL);
			map.put("state", Data.STATE_FAIL);
			map.put("data", new ArrayList());
		}
		return map;
	}

	/**
	 * @param <T>
	 * @方法说明:响应String或Int类型数据的返回结果
	 * @方法名称:responseMap
	 * @param t
	 * @return
	 * @作者:李梦卿
	 * @返回值:Map<String,Object>
	 */
	public static <T> Map<String, Object> responseStringOrInt(Object t) {
		Map<String, Object> map = new HashMap<String, Object>();
		if ((t instanceof String && !StringUtils.isEmpty(String.valueOf(t)))
				|| (t instanceof Integer && Integer.parseInt(String.valueOf(t)) != 0)) {
			map.put("msg", Data.REQUEST_SUCCESS);
			map.put("state", Data.STATE_SUCCESS);
			map.put("data", String.valueOf(t));
		} else {
			map.put("msg", Data.REQUEST_FAIL);
			map.put("state", Data.STATE_FAIL);
			map.put("data", "0");
		}
		return map;
	}

	/**
	 * @param <T>
	 * @方法说明:响应String或int类型数据的返回结果
	 * @方法名称:responseMap
	 * @param t
	 * @param request_success
	 *            成功提示信息
	 * @param request_fail
	 *            失败提示信息
	 * @return
	 * @作者:李梦卿
	 * @返回值:Map<String,Object>
	 */
	public static <T> Map<String, Object> responseStringOrInt(Object t,
			String request_success, String request_fail) {
		Map<String, Object> map = new HashMap<String, Object>();
		if ((t instanceof String && !StringUtils.isEmpty(String.valueOf(t)))
				|| (t instanceof Integer && Integer.parseInt(String.valueOf(t)) != 0)) {
			map.put("msg", request_success);
			map.put("state", Data.STATE_SUCCESS);
			map.put("data", String.valueOf(t));
		} else {
			map.put("msg", request_fail);
			map.put("state", Data.STATE_FAIL);
			map.put("data", "0");
		}
		return map;
	}

	/**
	 * @方法说明:响应map类型数据的返回结果
	 * @方法名称:responseMap
	 * @param t
	 * @return
	 * @作者:李梦卿
	 * @返回值:Map<String,Object>
	 */
	public static <T> Map<String, Object> responseMap(T t) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (t != null) {
			map.put("msg", Data.REQUEST_SUCCESS);
			map.put("state", Data.STATE_SUCCESS);
			map.put("data", t);
		} else {
			map.put("msg", Data.REQUEST_FAIL);
			map.put("state", Data.STATE_FAIL);
			map.put("data", new HashMap<String, Object>());
		}
		return map;
	}

	@Test
	public void test1() {
		System.out.println(responseMap(new HashMap(), "request_success",
				"request_fail"));
		;
	}

	/**
	 * @方法说明:响应map类型数据的返回结果
	 * @方法名称:responseMap
	 * @param t
	 * @param request_success
	 *            成功提示信息
	 * @param request_fail
	 *            失败提示信息
	 * @return
	 * @作者:李梦卿
	 * @返回值:Map<String,Object>
	 */
	public static <T> Map<String, Object> responseMap(T t,
			String request_success, String request_fail) {
		Map<String, Object> map = new HashMap<String, Object>();

		if (t != null) {
			map.put("msg", request_success);
			map.put("state", Data.STATE_SUCCESS);
			map.put("data", t);
		} else {
			map.put("msg", request_fail);
			map.put("state", Data.STATE_FAIL);
			map.put("data", new HashMap<String, Object>());
		}
		return map;
	}

	/**
	 * @方法说明:key值验证失败
	 * @方法名称:responseKeyFailMap
	 * @param t
	 * @param request_success
	 * @param request_fail
	 * @return
	 * @作者:李梦卿
	 * @返回值:Map<String,Object>
	 */
	public static <T> Map<String, Object> responseKeyFailMap() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("msg", Data.BASE_CHECK_ERROR);
		map.put("state", Data.STATE_APPKEY_FAIL);
		map.put("data", "");
		return map;
	}
	
	
	//新加
	public static <T> Map<String, Object> responseMapTOW(T t,
			String request_success, String request_fail) {
		Map<String, Object> map = new HashMap<String, Object>();

		if (t != null) {
			map.put("msg", request_success);
			map.put("state", Data.STATE_SUCCESS);
			map.put("data", t);
		} else {
			map.put("msg", request_fail);
			map.put("state", Data.STATE_APPKEY_FAIL);
			map.put("data", new HashMap<String, Object>());
		}
		return map;
	}
}
