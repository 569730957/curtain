package com.thinkgem.jeesite.modules.api.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class CTimeUtils {


	/**
	 * 比较时间
	 * @方法说明:
	 * @方法名称:coudata
	 * @param businesstime1
	 * @param businesstime2
	 * @return
	 * @作者:张威
	 * @返回值:int
	 */
	public static int coudata(String businesstime1,String businesstime2){
		if(businesstime1!=null&&businesstime2!=null){
			String[] businesstime1i = StringUtilsInter.interceptionData(businesstime1, ":");
			String[] businesstime2i = StringUtilsInter.interceptionData(businesstime2, ":");
			
			int datatodata1 = Ctime.datatodata(Integer.parseInt(businesstime1i[0]), Integer.parseInt(businesstime1i[1]), new Date());
			int[] minute = Ctime.getAddMinute(new Date(), 30);
			int datatodata2 = Ctime.datatodata(Integer.parseInt(businesstime2i[0]), Integer.parseInt(businesstime2i[1]), minute[0],minute[1]);

			System.out.println(businesstime1i[0]+":"+businesstime1i[1]+"======="+datatodata1);
			System.out.println(businesstime2i[0]+":"+businesstime2i[1]+"======="+datatodata2);
			
			if(datatodata1<=0 && datatodata2>0){
				return 1;
			}
		}
		return 0;
	}
	
	
	/**
	 * 获取时间段
	 * @方法说明:
	 * @方法名称:getDatas
	 * @param date
	 * @return
	 * @作者:张威
	 * @返回值:String[]
	 */
	@Deprecated
	public static String[] getDatasDate(Date date){
		String[] s = new String[5];
		int t = 30;
		for (int i = 0; i < 5; i++) {
			int[] minute = Ctime.getAddMinute(date, t);
			String b =  minute[0]+":"+minute[1];
			t+=30;
			s[i] = b;
		}
		
		
		return s;
	}
	
	/**
	 * 获取时间段
	 * @方法说明:
	 * @方法名称:getDatasDateList
	 * @param f 标志
	 * @return
	 * @作者:张威
	 * @返回值:String[]
	 */
	public static String[] getDatasDateList(int f){
		String[] s1 = new String[5];
		s1[0] = "尽快送达";
		s1[1] = "10:";
		s1[2] = "";
		s1[3] = "";
		s1[4] = "";
		s1[5] = "";
		String[] s2 = new String[5];
		s2[0] = "尽快送达";
		s2[1] = "";
		s2[2] = "";
		s2[3] = "";
		s2[4] = "";
		s2[5] = "";
		String[] s3 = new String[5];
		s3[0] = "尽快送达";
		s3[1] = "";
		s3[2] = "";
		s3[3] = "";
		s3[4] = "";
		s3[5] = "";
		String[] s4 = new String[1];
		s3[0] = "尽快送达";
		if(f==1){
			return s1;
		}else if(f==2){
			return s2;
		}else if(f==3){
			return s3;
		}else{
			return s4;
		}
	}
	
	public static String[] getDatasDateList(Date d){
		// 创建 Calendar 对象  
	    Calendar calendar = Calendar.getInstance();  
	    // 初始化 Calendar 对象，但并不必要，除非需要重置时间  
	    calendar.setTime(d);  
	    int MINUTE2 = calendar.get(Calendar.HOUR_OF_DAY); 
	    if(MINUTE2>8&&MINUTE2<12){
	    	 return getDatasDateList(1);
	    }else if(MINUTE2>12&&MINUTE2<18){
	    	return getDatasDateList(2);
	    }else if(MINUTE2>12&&MINUTE2<18){
	    	return getDatasDateList(3);
	    }else{
	    	return getDatasDateList(4);
	    }
	}
	
	/**
	 * 获取时间段
	 * @方法说明:
	 * @方法名称:coudatelist
	 * @param businesstime1  开始营业时间
	 * @param businesstime2  结束营业时间
	 * @param d
	 * @return
	 * @作者:张威
	 * @返回值:List<String> 时间段
	 */
	public static List<String> coudatelist(String businesstime1,String businesstime2,Date d){
//		 字符串转换日期格式  
		Date date = null;
	     DateFormat fmtDateTime = new SimpleDateFormat("HH:mm");  
	     List<String> l = new ArrayList<String>();
//	     得到日期格式对象  
	     try {
			date = fmtDateTime.parse("10:00");
			if(businesstime1!=null&&businesstime2!=null){
				String[] businesstime1i = StringUtilsInter.interceptionData(businesstime1, ":");
				String[] businesstime2i = StringUtilsInter.interceptionData(businesstime2, ":");
				
				int datatodata1 = Ctime.datatodata(Integer.parseInt(businesstime1i[0]), Integer.parseInt(businesstime1i[1]), date);
				int gg = 30;
				int[] minute ;
				int datatodata2;

				if(datatodata1<0){
					System.out.println("营业时间--小于-->10：30 -------在10：30之前营业");
					while (true) {
						minute = Ctime.getAddMinute(date, gg);
						datatodata2 = Ctime.datatodata(Integer.parseInt(businesstime2i[0]), Integer.parseInt(businesstime2i[1]), minute[0],minute[1]);
						gg+=30;
//						System.out.println(minute[0]+":"+minute[1]);
						if(datatodata2<0){
							return l;
						}else{
							l.add(minute[0]+":"+minute[1]);
						}
					}
				}else{
					System.out.println("营业时间<-大于--10：00 --在10：30以后才营业");
					
					String string = businesstime1i[1];
					int parseInt = Integer.parseInt(string);
					if(parseInt>30){
						int parseIntv = Integer.parseInt(businesstime1i[0]);
						parseIntv=parseIntv-1;
						date = fmtDateTime.parse(parseIntv+":30");
					}else{
						date = fmtDateTime.parse(businesstime1i[0]+":00");
					}
					while (true) {
						minute = Ctime.getAddMinute(date,gg);
						datatodata2 = Ctime.datatodata(Integer.parseInt(businesstime2i[0]), Integer.parseInt(businesstime2i[1]), minute[0],minute[1]);
						gg+=30;
//						System.out.println(minute[0]+":"+minute[1]);
						if(datatodata2<0){
							return l;
						}else{
							l.add(minute[0]+":"+minute[1]);
						}
							
					}
				}
			}else{
				return l;
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}  
		return l;
	}
	
	/**
	 * 格式時間 返回
	 * @方法说明:
	 * @方法名称:getDateOfer
	 * @param businesstime1
	 * @param businesstime2
	 * @param d
	 * @return
	 * @作者:张威
	 * @返回值:List<String>
	 */
	public static List<String> getDateOfer(String businesstime1,String businesstime2,Date d){
		List<String> l = new ArrayList<String>();
		if(businesstime1 != null && businesstime2 != null){
			List<String> list = coudatelists(businesstime1,businesstime2,d);
			l.add("尽快送达");
			for (int i = 1; i < list.size()-1; i++) {
				String string;
				String string1;
				if(list.get(i).length()<5){
					string = list.get(i);
					int of = string.indexOf(":");
					String h = string.substring(0, of);
					if(h.length()<2){
						string="0"+string;
					}else{
						string=string+"0";
					}
				}else{
					string = list.get(i);
				}
				if(list.get(i+1).length()<5){
					string1 = list.get(i+1);
					int of = string1.indexOf(":");
					String h = string1.substring(0, of);
					if(h.length()<2){
						string1="0"+string1;
					}else{
						string1=string1+"0";
					}
				}else{
					string1 = list.get(i+1);
				}
				String strings = string+"-"+string1;
				System.out.println(strings);
				l.add(strings);
			}
		}
		return l;
	}
	
	public static void main(String[] args) {
//		System.out.println(coudata("15:30","15:40"));
//		List<String> list = coudatelists("08:30","21:40",new Date());
		List<String> list = getDateOfer("08:30","18:00",new Date());
		for (int i = 0; i < list.size(); i++) {
			
			System.out.println(list.get(i));
		}
		
	}
	
	/**
	 * 从当前时间望后加半小时
	 * @方法说明:
	 * @方法名称:coudatelists
	 * @param businesstime1
	 * @param businesstime2
	 * @param d
	 * @return
	 * @作者:张威
	 * @返回值:List<String>
	 */
	public static List<String> coudatelists(String businesstime1, String businesstime2, Date d) {
		// 字符串转换日期格式
		Date date = null;
		Date date1 = null;
		DateFormat fmtDateTime = new SimpleDateFormat("HH:mm");
		List<String> l = new ArrayList<String>();
		// 得到日期格式对象
		try {
			if (businesstime1 != null && businesstime2 != null) {
//				String[] businesstime2i = StringUtilsInter.interceptionData(businesstime2, ":");
				//
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(d);
				int MINUTE = calendar.get(Calendar.MINUTE);
				int MINUTE2 = calendar.get(Calendar.HOUR_OF_DAY);
				int coudata = coudata(businesstime1, businesstime2);
				date1 = fmtDateTime.parse(businesstime2);
				if (coudata == 1) {
					int gg = 30;
					if (MINUTE > 30) {
						date = fmtDateTime.parse(MINUTE2 + ":30");
					} else {
						date = fmtDateTime.parse(MINUTE2 + ":00");
					}
					while (true) {
						int[] minute = Ctime.getAddMinute(date, gg);
						int[] minute2 = Ctime.getAddMinute(date1 ,-30);
						int datatodata2 = Ctime.datatodata(minute2[0], minute2[1], minute[0], minute[1]);
						gg += 30;
						if (datatodata2 < 0) {
							return l;
						} else {
							l.add(minute[0] + ":" + minute[1]);
						}

					}
				}
			} else {
				return l;
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return l;
	}

}
