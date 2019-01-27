package com.thinkgem.jeesite.modules.api.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.junit.Test;

public class MyUtils {
	/**
	 * @param content
	 *            内容
	 * @param separator
	 *            按照什么来划分 ","或",|，|；|;"
	 */
	public static String[] setSeparator(String content, String separator) {
		if (content == null || content.equals("")) {
			return new String[0];
		} else {
			String[] arr = content.split(separator);// 根据“ ”和“,”区分
			return arr;
		}

	}

	// @Test
	// public void test(){
	// setSeparator("", ",");
	// }
	// @Test
	// public void test1(){
	// setSeparator(null, ",");
	// }
	//
	public static String[] setSeparatorImage(String content, String separator,
			String ipport) {
		if (content != null && !content.equals("")) {
			String[] arr = content.split(separator);// 根据“ ”和“,”区分
			for (int i = 0; i < arr.length; i++) {
				arr[i] = ipport + arr[i];
			}
			return arr;
		} else {
			return new String[0];
		}

	}

	public static List<String> setArraySeparator(String content,
			String separator) {
		List<String> strings = new ArrayList<String>();
		String[] arr = content.split(separator);// 根据“ ”和“,”区分
		for (String s : arr) {
			strings.add(s);
		}
		return strings;
	}

	public static String getPrintSize(long size) {
		// 如果字节数少于1024，则直接以B为单位，否则先除于1024，后3位因太少无意义
		if (size < 1024) {
			return String.valueOf(size) + "B";
		} else {
			size = size / 1024;
		}
		// 如果原字节数除于1024之后，少于1024，则可以直接以KB作为单位
		// 因为还没有到达要使用另一个单位的时候
		// 接下去以此类推
		if (size < 1024) {
			return String.valueOf(size) + "KB";
		} else {
			size = size / 1024;
		}
		if (size < 1024) {
			// 因为如果以MB为单位的话，要保留最后1位小数，
			// 因此，把此数乘以100之后再取余
			size = size * 100;
			return String.valueOf((size / 100)) + "."
					+ String.valueOf((size % 100)) + "MB";
		} else {
			// 否则如果要以GB为单位的，先除于1024再作同样的处理
			size = size * 100 / 1024;
			return String.valueOf((size / 100)) + "."
					+ String.valueOf((size % 100)) + "GB";
		}
	}
	/**获取随机的32个字符*/
	public static String getRandomString(int length){  
        String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";  
        Random random = new Random();  
        StringBuffer sb = new StringBuffer();  
          
        for(int i = 0 ; i < length; ++i){  
            int number = random.nextInt(62);//[0,62)  
              
            sb.append(str.charAt(number));  
        }  
        return sb.toString();  
	}
	
}
