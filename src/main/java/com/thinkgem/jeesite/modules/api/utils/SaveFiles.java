package com.thinkgem.jeesite.modules.api.utils;

import java.io.File;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.thinkgem.jeesite.modules.api.utils.Config.Data;

/**
 * 保存文件
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
public class SaveFiles {

	public static File getFile(MultipartHttpServletRequest request, String name) {
		// 文件保存路径  
        String filePath = request.getSession().getServletContext().getRealPath("/") + Data.PATHAVATAR_FILE;  
        File ret = null;
        try {
        	ret = new File(filePath);
        	if (!ret.exists()) {
				ret.mkdir();
			}
        	ret = new File(filePath+ name);
		} catch (Exception e) {
			e.printStackTrace();
			ret = null;
		}
		return ret;
	}

}
