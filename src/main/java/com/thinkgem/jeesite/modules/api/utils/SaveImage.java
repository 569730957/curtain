package com.thinkgem.jeesite.modules.api.utils;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import com.thinkgem.jeesite.common.utils.IdGen;
import com.thinkgem.jeesite.modules.api.utils.Config.Data;
import com.thinkgem.jeesite.modules.api.utils.Config.Method;

/**
 * 保存图片
 * 
 * @类名:SaveImage
 * @类描述:
 * @作者:张威
 * @创建时间:2015年9月15日-上午11:18:08
 * @修改人:
 * @修改时间:
 * @修改备注:
 * @版本:
 * @Copyright (c)-2015
 */
public class SaveImage {

	 /**
	 * @方法说明:设置图片
	 * @方法名称:setPortrait
	 * @param request
	 * @param base64 base64格式的图片
	 * @param type 图片类型   0 头像 1 商品图片 2 其他
	 * @return
	 * @作者:李梦卿
	 * @返回值:String
	 */
	public static String setImage(HttpServletRequest request, String base64, int type) {
		String imageName = IdGen.uuid() + ".jpg";
		String path = "";
		switch (type) {
		case 0:
			path = Data.PATHAVATAR_PORTRAIT;
			break;
		case 1:
			path = Data.PATHAVATAR_GOODS;
			break;
		default:
			path = Data.PATHAVATAR_IMAGE;
			break;
		} 
		getFileFromBytes(Method.SaveAvatar(request,path), imageName, base64);
		return request.getContextPath() + path + imageName;
	}
	
	/**
	 * 把字节数组保存为一个文件
	 * 
	 * @param b
	 * @param outputFile
	 * @return File
	 */
	private static File getFileFromBytes(String outputFile, String imageName,
			String imageStr) {
		byte[] b = Base64.decode(imageStr);
		File ret = null;
		BufferedOutputStream stream = null;
		try {
			ret = new File(outputFile);
			if (!ret.exists()) {
				ret.mkdirs();
			}
			stream = new BufferedOutputStream(new FileOutputStream(ret + "/"
					+ imageName));
			if (b != null) {
				stream.write(b);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stream != null) {
				try {
					stream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return ret;
	}

}
