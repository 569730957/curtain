package com.thinkgem.jeesite.modules.api.utils;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import com.thinkgem.jeesite.common.utils.IdGen;

/**
 * @类名:Config
 * @类描述:公共参数及方法
 * @作者:李梦卿
 * @创建时间:2016年5月18日-上午11:13:06
 * @修改人:
 * @修改时间:
 * @修改备注:
 * @版本:
 * @Copyright (c)-2016湖南省新鲜在线有限科技公司
 */

public final class Config {

	public static class Data {
		public static String IPPORT = "http://localhost:8081/"; 
		/** 头像路径 */
		public static final String PATHAVATAR_PORTRAIT = "/userfiles/portrait/";
		public static final String PATHAVATAR_IMAGE = "/userfiles/images/";
		public static final String PATHAVATAR_GOODS = "/userfiles/goods/";
		public static final String PATHAVATAR_FILE = "userfiles/file/";
		/** appKey */
		public static final String APPKEY = "xfQE6dGsc64gtIAtbp8CCtThbFgGHd35jQWDse4lSgch35d9Fd3dscxgh85dOM0355dOM035";
		/** appKey验证失败! */
		public static final String BASE_CHECK_ERROR = "appKey验证失败!";
		/** 请求成功数据不为空 10001 */
		public static final int STATE_SUCCESS = 10001;
		/** 请求成功数据为空 10002 */
		public static final int STATE_SUCCESS_DATA_NULL = 10002;
		/** 请求失败 20001 */
		public static final int STATE_FAIL = 20001;
		public static final int STATE_ABNORMAL = 20002;
		/** 请求失败 appKey验证失败30001 */
		public static final int STATE_APPKEY_FAIL = 30001;
		/** 请求错误 40001 */
		public static final int STATE_ERROR = 40001;
		/** 请求超时 50001 */
		public static final int STATE_OVERTIME = 50001;
		/** 请求数据成功 */
		public static final String REQUEST_SUCCESS = "请求成功";
		/** 数据为空 */
		public static final String REQUEST_SUCCESS_DATA_NULL = "暂无更多数据";
		/** 请求数据失败 */
		public static final String REQUEST_FAIL = "请求失败";
		/** 接口异常 */
		public static final String REQUEST_ERROR = "接口异常";
		/** 已注册 */
		public static final String R_REGISTER_WAS_FAIL_ALREADY_REGISTERED = "该手机已注册!";
		/** 注册成功 */
		public static final String R_REGISTER_WAS_SUCCESSFUL = "注册成功!";
		/** 注册失败 */
		public static final String R_REGISTER_WAS_FAIL = "注册失败!";
		/** 登录成功 */
		public static final String R_LOGIN_WAS_SUCCESSFUL = "登录成功!";
		/** 登录失败 */
		public static final String R_LOGIN_WAS_FAIL = "登录失败,用户名或密码错误!";
		/** 修改密码成功 */
		public static final String R_MODIFY_PASSWORD_SUCCESSFUL = "修改密码成功!";
		/** 修改密码失败 */
		public static final String R_MODIFY_PASSWORD_FAIL = "修改密码失败!";
		/** 修改成功 */
		public static final String R_MODIFY_SUCCESSFUL = "修改成功!";
		/** 修改失败 */
		public static final String R_MODIFY_FAIL = "修改失败!";
		/** 开启成功 */
		public static final String R_OPEN_SUCCESSFUL = "开启成功!";
		/** 开启失败 */
		public static final String R_OPEN_FAIL = "开启失败!";
		/** 添加成功 */
		public static final String R_ADD_SUCCESSFUL = "添加成功!";
		/** 关闭失败 */
		public static final String R_CLOSE_FAIL = "关闭失败!";
		/** 关闭成功 */
		public static final String R_CLOSE_SUCCESSFUL = "关闭成功!";
		/** 添加失败 */
		public static final String R_ADD_FAIL = "添加失败!";
		/** 反馈成功 */
		public static final String R_FEEDBACK_SUCCESSFUL = "反馈成功!";
		/** 反馈失败 */
		public static final String R_FEEDBACK_FAIL = "反馈失败!";
		/** 删除成功 */
		public static final String R_MODIFY_DELETE_SUCCESSFUL = "删除成功!";
		/** 删除失败 */
		public static final String R_MODIFY_DELETE_FAIL = "删除失败!";
		/** 解绑成功 */
		public static final String R_MODIFY_BINDING_SUCCESSFUL = "解绑成功!";
		/** 解绑失败 */
		public static final String R_MODIFY_BINDING_FAIL = "解绑失败!";
		/** 添加成功 */
		public static final String R_MODIFY_ADD_SUCCESSFUL = "添加成功!";
		/** 添加失败 */
		public static final String R_MODIFY_SET_FAIL = "设置失败!";
		/** 设置成功 */
		public static final String R_MODIFY_SET_SUCCESSFUL = "设置成功!";
		/** 设置失败 */
		public static final String R_MODIFY_ADD_FAIL = "添加失败!";
		/** 操作成功 */
		public static final String R_MODIFY_OPERATION_SUCCESSFUL = "操作成功!";
		/** 操作失败 */
		public static final String R_MODIFY_OPERATION_FAIL = "操作失败!";
		/** 添加失败，该用户已添加！ */
		public static final String R_MODIFY_ADD_HAVE_FAIL = "添加失败，该用户已添加！";
		/** 添加失败，该用户未注册！ */
		public static final String R_MODIFY_ADD_HAVE_NO_USER_FAIL = "添加失败，该用户未注册！";

	}

	/**
	 * @类名:method
	 * @类描述:公共方法
	 * @作者:李梦卿
	 * @创建时间:2016年5月18日-上午11:14:26
	 * @修改人:
	 * @修改时间:
	 * @修改备注:
	 * @版本:
	 * @Copyright (c)-2016湖南省新鲜在线有限科技公司
	 */

	public static class Method {

		/**
		 * @方法说明:
		 * @方法名称:getPath
		 * @param request
		 * @return
		 * @作者:李梦卿
		 * @返回值:String
		 */
		public static String getPath(HttpServletRequest request) {
			String path = request.getScheme() + "://" + request.getServerName()
					+ ":" + request.getServerPort();
			return path;
		}

		/**
		 * 图片保存地址
		 * 
		 * @方法说明:
		 * @方法名称:getTupianSave
		 * @param request
		 * @return
		 * @作者:张威
		 * @返回值: String
		 */
		public static String SaveAvatar(HttpServletRequest request, String imagepath) {
			@SuppressWarnings("deprecation")
			String path = request.getRealPath("/") + imagepath;
			File folder = new File(path);
			// 如果文件夹不存在则创建
			if (!(folder.exists() && folder.isDirectory())) {
				folder.mkdirs();
			}
			return path;
		}

		/**
		 * @方法说明:生成随机的用户名
		 * @方法名称:getUserNameString
		 * @return
		 * @作者:李梦卿
		 * @返回值:String
		 */
		public static String getUserNameString() {
			return IdGen.uuid().substring(0, 10);
		}
	}
}
