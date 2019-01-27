package com.thinkgem.jeesite.modules.api.utils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
  * @类名:StringUtils
  * @类描述: 传入字符使用英文 , 隔开
  * @作者:张威
  * @创建时间:2015年8月13日-下午2:34:23
  * @修改人:
  * @修改时间:
  * @修改备注:
  * @版本:
  * @Copyright (c)-2015
 */
public class StringUtilsInter {

	//截图字段
	public static String[] interceptionString(String city){
		if (city.equals("")) {
			return null;
		}
		String[] split;
		try {
			split = city.split(",");
		} catch (Exception e) {
			split=null;
			e.printStackTrace();
		}
		return split;
	}
	
	/**
	 * 截取字符串 存入到list
	 * @方法说明:
	 * @方法名称:addStringlist
	 * @param data
	 * @return
	 * @作者:张威
	 * @返回值:List<String>
	 */
	public static List<String> addStringlist(String data){
		List<String> list = null;
		if(data!= null && !"".equals(data)){
			list = new ArrayList<String>();
			String[] string = interceptionString(data);
			for (int i = 0; i < string.length; i++) {
				list.add(string[i]);
			}
		}
		return list;
	}
	
	/**
	 * 截图字段
	 * @方法说明:
	 * @方法名称:interceptionString2
	 * @param image
	 * @return
	 * @作者:张威
	 * @返回值:String[]
	 */
	public static String[] interceptionString2(String image){
		if (image==null||image.equals("")) {
			return null;
		}
		String[] split;
		try {
			String eng;
			//如果第一个是特殊字符
			if("|".equals(image.substring(0,1))){
				eng = image.substring(1, image.length());
			}else{
				eng = image.substring(0, image.length());
			}
			//转义字符
			split = eng.split("\\|");
		} catch (Exception e) {
			split=null;
			e.printStackTrace();
		}
		return split;
	}
	
	/**
	 * 截取数据
	 * @方法说明:
	 * @方法名称:interceptionDate
	 * @param data
	 * @return
	 * @作者:张威
	 * @返回值:String[]
	 */
	public static String[] interceptionData(String data,String f) {
		if (data.equals("")) {
			return null;
		}
		String[] split;
		try {
			split = data.split(f);
		} catch (Exception e) {
			split = null;
			e.printStackTrace();
		}
		return split;
	}
	
	/**
	 * 四舍五入1位小数
	 * @方法说明:
	 * @方法名称:doubleValueOne
	 * @param d
	 * @return
	 * @作者:张威
	 * @返回值:Double
	 */
	public static Double doubleValueOne(Double d) {
		BigDecimal bd = new BigDecimal(d);
		//参数1为保留几位
		bd = bd.setScale(1, BigDecimal.ROUND_HALF_UP);
		//BigDecimal.ROUND_HALF_UP 是4舍5入，BigDecimal.ROUND_DOWN是舍去，BigDecimal.ROUND_FLOOR是向上取整
		return bd.doubleValue();
	}
	
	public static void main(String[] args) {
//		doubleValueOne(null);
//		int[] intArray = getIntArray("1000元-2000元",true,1);
//		
//				System.out.println(intArray[0]);
				String[] string2 = interceptionString2("|/jeesite/userfiles/1/images/cms/article/2015/11/666.jpg|/jeesite/userfiles/1/images/cms/article/2015/08/52133b9178754(1).png");
				System.out.println(string2[0]);
				
//				String[] interceptionInt = interceptionInt("18:21");
//				System.out.println(interceptionInt[0]+interceptionInt[1]);
	}
	
	/**
	 * 	截取中文特殊字符
	 * @方法说明:
	 * @方法名称:getIntArray
	 * @param data 需要截取的数据
	 * @param flag 是否截取特殊字符
	 * @param i 截取的个数
	 * @return
	 * @作者:张威
	 * @返回值:int[]
	 */
	public static int[] getIntArray(String data, boolean flag, int i) {
		int[] d = new int[i];
		String[] split;
		String a = "";
		if (flag) {
			try {
				split = data.split("-");
				Pattern p = Pattern.compile("[0-9]");
				for (int j = 0; j < i; j++) {
					Matcher m = p.matcher(split[j]);
					while (m.find()) {
						a = a + m.group();
					}
					d[j] = Integer.parseInt(a);
					a="";
				}
			} catch (Exception e) {
				d = null;
				e.printStackTrace();
			}
			return d;
		} else {
			Pattern p = Pattern.compile("[0-9]");
			Matcher m = p.matcher(data);
			while (m.find()) {
				a = a + m.group();
			}
			d[0] = Integer.parseInt(a);
			return d;
		}
	}
}
