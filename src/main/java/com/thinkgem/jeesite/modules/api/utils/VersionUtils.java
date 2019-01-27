package com.thinkgem.jeesite.modules.api.utils;

/**
 * 比较版本号、
 * 参考资料 http://blog.csdn.net/sowhat_ah/article/details/43955337
  * @类名:VersionUtils
  * @类描述:
  * @作者:zw
  * @创建时间:2015年12月14日-上午10:13:36
  * @修改人:
  * @修改时间:
  * @修改备注:
  * @版本: 2.0
  * @Copyright (c)-2015
 */
public class VersionUtils {

	/** 
	 * 比较版本号的大小,前者大则返回一个正数,后者大返回一个负数,相等则返回0 
	 * @方法说明:
	 * @方法名称:compareVersion
	 * @param version1
	 * @param version2
	 * @return
	 * @throws Exception
	 * @作者:张威
	 * @返回值:int
	 */
	public static int compareVersion(String version1, String version2) throws Exception {  
	    if (version1 == null || version2 == null) {  
	        throw new Exception("compareVersion error:illegal params.");  
	    }  
	    String[] versionArray1 = version1.split("\\.");
	    String[] versionArray2 = version2.split("\\.");  
	    int idx = 0;  
	    int minLength = Math.min(versionArray1.length, versionArray2.length);//取最小长度值  
	    int diff = 0;  
	    while (idx < minLength  
	            && (diff = versionArray1[idx].length() - versionArray2[idx].length()) == 0//先比较长度  
	            && (diff = versionArray1[idx].compareTo(versionArray2[idx])) == 0) {//再比较字符  
	        ++idx;  
	    }  
	    diff = (diff != 0) ? diff : versionArray1.length - versionArray2.length;  
	    return diff;  
	}
	
	public static void main(String[] args) {
		try {
			int version = compareVersion("91.1.1","50.2.6");
			System.out.println(version);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
