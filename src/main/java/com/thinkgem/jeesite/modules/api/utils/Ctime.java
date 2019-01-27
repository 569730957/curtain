
package com.thinkgem.jeesite.modules.api.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;



/**
 * 
  * @类名:Ctime
  * @类描述:
  * @作者:张威
  * @创建时间:2015年11月20日-上午10:15:24
  * @修改人:
  * @修改时间:
  * @修改备注:
  * @版本: 2.0
  * @Copyright (c)-2015
 */
public class Ctime {

    /**
     * @方法说明:将时间戳转为代表"距现在多久之前"的字符串
     * @方法名称:getStandardDate
     * @param timeStr 时间戳
     * @return
     * @作者:李梦卿
     * @返回值:String
     */
    public static String getStandardDate(String timeStr) {

        StringBuffer sb = new StringBuffer();

        long t = Long.parseLong(timeStr);
        long time = System.currentTimeMillis() - (t * 1000);
        long mill = (long) Math.ceil(time / 1000);// 秒前

        long minute = (long) Math.ceil(time / 60 / 1000.0f);// 分钟前

        long hour = (long) Math.ceil(time / 60 / 60 / 1000.0f);// 小时

        long day = (long) Math.ceil(time / 24 / 60 / 60 / 1000.0f);// 天前

        if (day - 1 > 0) {
            sb.append(day + "天");
        } else if (hour - 1 > 0) {
            if (hour >= 24) {
                sb.append("1天");
            } else {
                sb.append(hour + "小时");
            }
        } else if (minute - 1 > 0) {
            if (minute == 60) {
                sb.append("1小时");
            } else {
                sb.append(minute + "分钟");
            }
        } else if (mill - 1 > 0) {
            if (mill == 60) {
                sb.append("1分钟");
            } else {
                sb.append(mill + "秒");
            }
        } else {
            sb.append("刚刚");
        }
        if (!sb.toString().equals("刚刚")) {
            sb.append("前");
        }
        return sb.toString();
    }

    /**
     * @方法说明:将时间戳转为代表"距现在多久之前"的字符串
     * @方法名称:getStandardDate
     * @param timeStr 时间戳
     * @return
     * @作者:李梦卿
     * @返回值:String
     */
    public static String getDate(String timeStr) {
        StringBuffer sb = new StringBuffer();
        long t = Long.parseLong(timeStr);
        long time = System.currentTimeMillis() - (t * 1000);
        long day = (long) Math.ceil(time / 24 / 60 / 60 / 1000.0f);// 天前

        if (day - 1 == 0) {
            sb.append("今天");
        } else if (day - 2 == 0) {
            sb.append("昨天");
        } else if (day - 3 == 0) {
            sb.append("前天");
        } else {
            sb.append(day + "天");
        }

        if (!sb.toString().equals("今天") && !sb.toString().equals("昨天")
                && !sb.toString().equals("前天")) {
            sb.append("前");
        }
        return sb.toString();
    }

    /**
     * @方法说明:转换格式"yyyy-MM-dd"
     * @方法名称:getStrTimeNYR
     * @param cc_time 时间戳
     * @return
     * @作者:李梦卿
     * @返回值:String
     */
    public static String getStrTimeNYR(String cc_time) {
        String re_StrTime = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        long lcc_time = Long.valueOf(cc_time);
        re_StrTime = sdf.format(new Date(lcc_time * 1000L));
        return re_StrTime;
    }
    
    /**
     * 时间戳转string
     * @方法说明:
     * @方法名称:getDatTimeNYR
     * @param cc_time
     * @return
     * @作者:张威
     * @返回值:String
     */
    public static String getDatTimeNYR(long cc_time) {
        String re_StrTime = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        long lcc_time = Long.valueOf(cc_time);
        re_StrTime = sdf.format(new Date(cc_time));
        return re_StrTime;
    }
    
    /**
     * 格式转换
     * @方法说明:
     * @方法名称:getDatTimeNYRS
     * @param d
     * @return
     * @作者:zw
     * @返回值:String
     */
    public static String getDatTimeNYRS(Date d) {
        String re_StrTime = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        long lcc_time = Long.valueOf(cc_time);
        re_StrTime = sdf.format(d);
        return re_StrTime;
    }
    
    /**
     * 返回时间戳
     * @方法说明:
     * @方法名称:getTimeNYD
     * @param d
     * @return
     * @作者:zw
     * @返回值:String
     */
    public static String getTimeNYD(Date d) {
        String re_time = null;
        try {
            long l = d.getTime();
            String str = String.valueOf(l);
            re_time = str.substring(0, 10);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return re_time;
    }
    

    /**
     * @方法说明:转换格式"HH-mm"
     * @方法名称:getStrTimeHM
     * @param cc_time 时间戳
     * @return
     * @作者:李梦卿
     * @返回值:String
     */
    public static String getStrTimeHMS(String cc_time) {
        String re_StrTime = null;
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        long lcc_time = Long.valueOf(cc_time);
        re_StrTime = sdf.format(new Date(lcc_time * 1000L));
        return re_StrTime;
    }

    /**
     * @方法说明:将字符串转为时间戳
     * @方法名称:getTime
     * @param user_time
     * @return
     * @作者:李梦卿
     * @返回值:String
     */
    public static String getTime(String user_time) {
        String re_time = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d;
        try {

            d = sdf.parse(user_time);
            long l = d.getTime();
            String str = String.valueOf(l);
            re_time = str.substring(0, 10);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return re_time;
    }

    /**
     * @方法说明:将时间戳转为字符串
     * @方法名称:getStrTime
     * @param cc_time
     * @return
     * @作者:李梦卿
     * @返回值:String
     */
    public static String getStrTime(String cc_time) {
        String re_StrTime = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long lcc_time = Long.valueOf(cc_time);
        re_StrTime = sdf.format(new Date(lcc_time * 1000L));
//        re_StrTime = sdf.format(new Date(lcc_time * 1000L));
        return re_StrTime;
    }

    public static String cal(int second) {
        int h = 0;
        int d = 0;
        int s = 0;
        int temp = second % 3600;
        if (second > 3600) {
            h = second / 3600;
            if (temp != 0) {
                if (temp > 60) {
                    d = temp / 60;
                    if (temp % 60 != 0) {
                        s = temp % 60;
                    }
                } else {
                    s = temp;
                }
            }
        } else {
            d = second / 60;
            if (second % 60 != 0) {
                s = second % 60;
            }
        }

        return h + ":" + d + ":" + s + ":";
    }

    /**
     * @方法说明:毫秒转化
     * @方法名称:formatTime
     * @param ms
     * @return
     * @作者:李梦卿
     * @返回值:String
     */
    public static String formatTime(long ms) {

        int ss = 1000;
        int mi = ss * 60;
        int hh = mi * 60;
        int dd = hh * 24;

        long day = ms / dd;
        long hour = (ms - day * dd) / hh;
        long minute = (ms - day * dd - hour * hh) / mi;
        long second = (ms - day * dd - hour * hh - minute * mi) / ss;
        long milliSecond = ms - day * dd - hour * hh - minute * mi - second
                * ss;

        String strDay = day < 10 ? "0" + day : "" + day; // 天
        String strHour = hour < 10 ? "0" + hour : "" + hour;// 小时
        String strMinute = minute < 10 ? "0" + minute : "" + minute;// 分钟
        String strSecond = second < 10 ? "0" + second : "" + second;// 秒
        String strMilliSecond = milliSecond < 10 ? "0" + milliSecond : ""
                + milliSecond;// 毫秒
        strMilliSecond = milliSecond < 100 ? "0" + strMilliSecond : ""
                + strMilliSecond;

        return strDay + ":" + strHour + ":" + strMinute + ":" + strSecond;
    }
    
	/**
	 * 
	 * @方法说明:返回倒计时
	 * @方法名称:StringToLong
	 * @param times 获取时间
	 * @return
	 * @作者:张威
	 * @返回值:String
	 */
	public static String StringToLong(String times){
		String timeslong;
		long a = 0;
		long ab = 0;
		long b = System.currentTimeMillis()/1000;//当前时间
		if(times!=null && !"".equals(times)){
			timeslong = Ctime.getTime(times);
			a = Long.parseLong(timeslong);
		}
		if(a > b){
			ab = a-b;
		}
		timeslong = String.valueOf(ab);
		return timeslong;
	}
	
	
	/**
	 * 返回时间戳
	 * @方法说明:
	 * @方法名称:DataToLong
	 * @param times
	 * @return
	 * @作者:张威
	 * @返回值:String
	 */
	public static String DataToLong(Date times) {
		String timeslong;
		long a = 0;
		long ab = 0;
		long b = System.currentTimeMillis() / 1000;// 当前时间
		if (times != null && !"".equals(times)) {
			long l = times.getTime();
			String str = String.valueOf(l);
			String re_time = str.substring(0, 10);
			a = Long.parseLong(re_time);
		}
		if (a > b) {
			ab = a - b;
		}
		timeslong = String.valueOf(ab);
		return timeslong;
	}
	
	/**
	 * 比较时间
	 * @方法说明:
	 * @方法名称:datatodata
	 * @param huor
	 * @param minute
	 * @param d
	 * @return 大于0 huor>d
	 * @作者:张威
	 * @返回值:int
	 */
	public static int datatodata(int huor,int minute,Date d){
		// 创建 Calendar 对象  
	    Calendar calendar = Calendar.getInstance();  
	    // 初始化 Calendar 对象，但并不必要，除非需要重置时间  
	    calendar.setTime(d);  
	    int MINUTE = calendar.get(Calendar.MINUTE); 
	    int MINUTE2 = calendar.get(Calendar.HOUR_OF_DAY); 
		 java.sql.Time d1 = new java.sql.Time(huor, minute, 0);
		 java.sql.Time d2 = new java.sql.Time(MINUTE2, MINUTE, 0);
		 int i = d1.compareTo(d2);
		 return i;
	}
	
	/**
	 * 
	 * @方法说明:
	 * @方法名称:datatodata
	 * @param huor
	 * @param minute
	 * @param huor1
	 * @param minute1
	 * @return
	 * @作者:张威
	 * @返回值:int
	 */
	public static int datatodata(int huor,int minute,int huor1,int minute1){
		 java.sql.Time d1 = new java.sql.Time(huor, minute, 0);
		 java.sql.Time d2 = new java.sql.Time(huor1, minute1, 0);
		 int i = d1.compareTo(d2);
		 return i;
	}
	

	/**
	 * 时间加多少分钟
	 * @方法说明:
	 * @方法名称:getAddMinute
	 * @param d
	 * @param minute
	 * @return
	 * @作者:张威
	 * @返回值:int[]
	 */
	public static int[] getAddMinute(Date d,int minute){
		// 创建 Calendar 对象  
	    Calendar calendar = Calendar.getInstance();  
	    // 初始化 Calendar 对象，但并不必要，除非需要重置时间  
	    calendar.setTime(d);  
		// 15 分钟以后  
	    calendar.add(Calendar.MINUTE, minute);  
	    int MINUTE = calendar.get(Calendar.MINUTE); 
	    int MINUTE2 = calendar.get(Calendar.HOUR_OF_DAY); 
	    int[] a = new int[2];
	    a[0] = MINUTE2;
	    a[1] = MINUTE;
	    return a;
	}
	
	public static void main(String[] args) {//		int[] minute = getAddMinute(new Date(),180);
//		System.out.println(minute[0]+":"+minute[1]);
		
		System.out.println(getDatTimeNYRS(new Date()));
		System.out.println(getTimeNYD(new Date()));
//		int i = datatodata(minute[0],minute[1],new Date());
//		System.out.println(i);
	}
	
//	 public static void main(String args[]) {
//	       int i= compare_date("1995-11-12 15:21", "1999-12-11 09:59");
//	       System.out.println("i=="+i);
//	    }
//
//	    public static int compare_date(String DATE1, String DATE2) {
//	       
//	       
//	        DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm");
//	        try {
//	            Date dt1 = df.parse(DATE1);
//	            Date dt2 = df.parse(DATE2);
//	            if (dt1.getTime() > dt2.getTime()) {
//	                System.out.println("dt1 在dt2前");
//	                return 1;
//	            } else if (dt1.getTime() < dt2.getTime()) {
//	                System.out.println("dt1在dt2后");
//	                return -1;
//	            } else {
//	                return 0;
//	            }
//	        } catch (Exception exception) {
//	            exception.printStackTrace();
//	        }
//	        return 0;
//	    }
	
	
	public void getcou(){
		// 字符串转换日期格式  
	    // DateFormat fmtDateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
	    // 得到日期格式对象  
	    // Date date = fmtDateTime.parse(strDateMake);  
	  
	    // 完整显示日期时间  
	    String str = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS")).format(new Date());  
	    System.out.println(str);  
	  
	    // 创建 Calendar 对象  
	    Calendar calendar = Calendar.getInstance();  
	    // 初始化 Calendar 对象，但并不必要，除非需要重置时间  
	    calendar.setTime(new Date());  
	  
	    // setTime 类似上面一行  
	    // Date date = new Date();  
	    // calendar.setTime(date);  
	  
	    // 显示年份  
	    int year = calendar.get(Calendar.YEAR);  
	    System.out.println("YEAR is = " + String.valueOf(year));  
	  
	    // 显示月份 (从0开始, 实际显示要加一)  
	    int MONTH = calendar.get(Calendar.MONTH);  
	    System.out.println("MONTH is = " + (MONTH + 1));  
	  
	    // 今年的第 N 天  
	    int DAY_OF_YEAR = calendar.get(Calendar.DAY_OF_YEAR);  
	    System.out.println("DAY_OF_YEAR is = " + DAY_OF_YEAR);  
	  
	    // 本月第 N 天  
	    int DAY_OF_MONTH = calendar.get(Calendar.DAY_OF_MONTH);  
	    System.out.println("DAY_OF_MONTH = " + String.valueOf(DAY_OF_MONTH));  
	  
	    // 3小时以后  
	    calendar.add(Calendar.HOUR_OF_DAY, 3);  
	    int HOUR_OF_DAY = calendar.get(Calendar.HOUR_OF_DAY);  
	    System.out.println("HOUR_OF_DAY + 3 = " + HOUR_OF_DAY);  
	  
	    // 当前分钟数  
	    int MINUTE = calendar.get(Calendar.MINUTE);  
	    System.out.println("MINUTE = " + MINUTE);  
	  
	    // 15 分钟以后  
	    calendar.add(Calendar.MINUTE, 15);  
	    MINUTE = calendar.get(Calendar.MINUTE);  
	    System.out.println("MINUTE + 15 = " + MINUTE);  
	  
	    // 30分钟前  
	    calendar.add(Calendar.MINUTE, -30);  
	    MINUTE = calendar.get(Calendar.MINUTE);  
	    System.out.println("MINUTE - 30 = " + MINUTE);  
	  
	    // 格式化显示  
	    str = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SS")).format(calendar.getTime());  
	    System.out.println(str);  
	  
	    // 重置 Calendar 显示当前时间  
	    calendar.setTime(new Date());  
	    str = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SS")).format(calendar.getTime());  
	    System.out.println(str);  
	  
	    // 创建一个 Calendar 用于比较时间  
	    Calendar calendarNew = Calendar.getInstance();  
	  
	    // 设定为 5 小时以前，后者大，显示 -1  
	    calendarNew.add(Calendar.HOUR, -5);  
	    System.out.println("时间比较：" + calendarNew.compareTo(calendar));  
	  
	    // 设定7小时以后，前者大，显示 1  
	    calendarNew.add(Calendar.HOUR, +7);  
	    System.out.println("时间比较：" + calendarNew.compareTo(calendar));  
	  
	    // 退回 2 小时，时间相同，显示 0  
	    calendarNew.add(Calendar.HOUR, -2);  
	    System.out.println("时间比较：" + calendarNew.compareTo(calendar)); 
	}
	
}
