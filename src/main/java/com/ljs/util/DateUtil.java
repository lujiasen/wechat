package com.ljs.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import org.apache.commons.lang.StringUtils;

/**
 * 
 * @Title: DateUtil.java
 * @Package com.somur.util
 * @Description: Date 工具类
 * @author jiang
 * @date 2016-4-11 下午03:35:04
 * @version V1.0
 */
public class DateUtil {
	/**
	 * yyyyMMddHHmmssSSS
	 */
	public static String yyyyMMddHHmmssSSS = "yyyyMMddHHmmssSSS";
	/**
	 * yyyy-MM-dd
	 */
	public static String yyyy_MM_dd_EN = "yyyy-MM-dd";

	/**
	 * yyyy-MM-dd HH:mm
	 */
	public static String yyyy_MM_dd_HH_mm_EN = "yyyy-MM-dd HH:mm";

	/**
	 * yyyy-MM-dd HH:mm:ss
	 */
	public static String yyyy_MM_dd_HH_mm_ss_EN = "yyyy-MM-dd HH:mm:ss";

	/**
	 * yyyyMMdd
	 */
	public static String yyyyMMdd = "yyyyMMdd";

	/**
	 * HH:mm
	 */
	public static String HH_mm = "HH:mm";

	/**
	 * MM.dd
	 */
	public static String MM_dd = "MM.dd";

	/**
	 * yyyy年MM月dd日
	 */
	public static String yyyy_MM_dd_CN = "yyyy年MM月dd日";
	public static String yyyy_MM_dd_CN_2 = "yyyy-MM-dd";

	/**
	 * yyyy年MM月dd日HH时mm分
	 */
	public static String yyyy_MM_dd_HH_mm_CN = "yyyy年MM月dd日HH时mm分";

	/**
	 * yyyy年MM月dd日HH时mm分ss秒
	 */
	public static String yyyy_MM_dd_HH_mm_ss_CN = "yyyy年MM月dd日HH时mm分ss秒";
	public static String yyyy_MMdd_HH_mm_ss = "yyyy-MM-dd HH:mm:ss";

	/**
	 * yyyyMMddHHmmss
	 */
	public static String yyyyMMddHHmmss = "yyyyMMddHHmmss";
	/**
	 * yyyy.MMdd.HHmmss
	 */
	public static String yyyy_MMdd_HHmmss = "yyyy.MMdd.HHmmss";

	/**
	 * 日期格式化函数
	 * 
	 * @param date
	 *            格式化对象
	 * @param strFormat
	 *            日期的格式化字符串
	 * @return 格式化后的日期字符串
	 */
	public static String format(Date date, String strFormat) {
		if (date == null) {
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(strFormat);
		return sdf.format(date);
	}

	/**
	 * 格式化当前日期为指定格式
	 * 
	 * @param pattern
	 *            日期格式
	 * @return 格式化后的日期字符串
	 */
	public static String formatTo(String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(new Date());
	}

	/**
	 * 取得制定格式的日期
	 * 
	 * @param dateStr
	 *            日期字符串
	 * @param strFormat
	 *            格式化字符串
	 * @return 返回的日期类型
	 * @throws ParseException
	 *             异常
	 */
	public static Date parse(String dateStr, String strFormat)
			throws ParseException {
		if (StringUtils.isNotBlank(dateStr)) {
			SimpleDateFormat sdf = new SimpleDateFormat(strFormat);
			return sdf.parse(dateStr);
		}
		return null;
	}

	/**
	 * 改变日期字符串格式
	 * 
	 * @param dateStr
	 *            日期字符串
	 * @param oldFormat
	 *            旧日期格式
	 * @param newFormat
	 *            新日期格式
	 * @return
	 * @throws ParseException
	 */
	public static String changeFormat(String dateStr, String oldFormat,
			String newFormat) throws ParseException {
		return format(parse(dateStr, oldFormat), newFormat);
	}

	/**
	 * 为指定的日期增减若干分钟
	 * 
	 * @param date
	 *            增减的日期对象
	 * @param minute
	 *            增减的分钟数
	 * @return 增减以后的日期
	 */
	public static Date addMinute(Date date, int minute) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MINUTE, minute);

		return cal.getTime();
	}

	/**
	 * 为指定的日期增减若干天
	 * 
	 * @param date
	 *            增减的日期对象
	 * @param day
	 *            增减的天数
	 * @return 增减以后的日期
	 */
	public static Date addDay(Date date, int day) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DAY_OF_MONTH, day);
		return cal.getTime();
	}
	
	/**
	 * 为指定的日期增减若干天
	 * 
	 * @param date
	 *            增减的日期对象
	 * @param day
	 *            增减的月
	 * @return 增减以后的日期
	 */
	public static Date addMonth(Date date, int month) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, month);
		return cal.getTime();
	}
	

	/**
	 * 获得某天是周几
	 * 
	 * @param date
	 *            日期
	 * @return 周几（数字）
	 */
	public static int getWeekDay(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.DAY_OF_WEEK) - 1;
	}

	/**
	 * 为指定的日期增减若干年
	 * 
	 * @param date
	 * @param year
	 * @return
	 */
	public static Date addYear(Date date, int year) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.YEAR, year);
		return cal.getTime();
	}

	/*
	 * long类型转化
	 */
	public static String getDateBylong(long times,String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		java.util.Date dt = new Date(times);
		String sDateTime = sdf.format(dt);
		return sDateTime;
	}
	
	/**
	 * 
	* @param times
	* @return  
	* @Description: 获取时间  yyyy_MM_dd_HH_mm_ss_EN
	* @author jiang     
	* @date 2016-4-12 上午10:02:41  
	* @version V1.0
	 */
	public static String getDateTimeByDate(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat(yyyy_MM_dd_HH_mm_ss_EN);
		String sDateTime = sdf.format(date);
		return sDateTime;
	}
	
	/**
	 * 
	* @param date
	* @return  
	* @Description: 获取当前时间  yyyy_MM_dd
	* @author jiangpeng    
	* @date 2016-4-25 下午03:40:35  
	* @version V1.0
	 */
	public static String getDateTimeYYYYMMDD(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat(yyyy_MM_dd_EN);
		String sDateTime = sdf.format(date);
		return sDateTime;
	}
	/**
	 * 
	* @param date
	* @return  
	* @Description: TODO  
	* @author lujiasen     
	* @date 2017年6月30日 下午1:04:30  
	* @version V1.0
	 */
	public static String getYYYYMMDD(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat(yyyyMMdd);
		String sDateTime = sdf.format(date);
		return sDateTime;
	}
    /**
     *   
    * @param s
    * @return  
    * @Description: 把日期转化为/年/月/日/yyyyMMddHHmmssSSS存储文件 
    * @author jiang     
    * @date 2016-3-9 下午05:41:42  
    * @version V1.0
     */
	public static String toSaveUrlString(String s,String saveType) {  
	    return s.substring(0,4)+"/"+saveType+"/"+s.substring(4, 6)+"/"+s.substring(4, 8)+"/";
	}  
	/**
	 * 将文件名中的汉字转为UTF8编码的串,以便下载时能正确显示另存的文件名.
	 */
	public static String toUtf8String(String s) {
		if (s == null || s.equals("")) {
			return "";
		}
		StringBuffer sb = new StringBuffer();
		try {
			char c;
			for (int i = 0; i < s.length(); i++) {
				c = s.charAt(i);
				if (c >= 0 && c <= 255) {
					sb.append(c);
				} else {
					byte[] b;
					b = Character.toString(c).getBytes("utf-8");
					for (int j = 0; j < b.length; j++) {
						int k = b[j];
						if (k < 0)
							k += 256;
						sb.append("%" + Integer.toHexString(k).toUpperCase());
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

	/**
	 * 
	 * @param args
	 * @Description: 获取当前时间-精确到秒
	 * @author jiang
	 * @date 2016-4-11 下午03:33:39
	 * @version V1.0
	 */

	public static int getNowTimes() {
		return (int)(System.currentTimeMillis()/1000);
	}

	public static void main(String[] args) {
		//System.out.println(getDateTimeByDate(addDay(new Date(),1)));
		System.out.println("2016-02-01 10:55:55".substring(0, 10));
		
		/*Calendar a =Calendar.getInstance();
		a.setTime(new Date());*/
		
		/*TimeZone time = TimeZone.getTimeZone("GMT+8"); //设置为东八区
		time = TimeZone.getDefault();// 这个是国际化所用的
		System.out.println(time);
		TimeZone.setDefault(time);// 设置时区
		Calendar calendar = Calendar.getInstance();// 获取实例
		//DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");//构造格式化模板
		Date date = calendar.getTime(); //获取Date对象
		System.out.println(date);
		String str = new String();
		str = format1.format(date);//对象进行格式化，获取字符串格式的输出
		System.out.println(str);*/
		
		Calendar cd = Calendar.getInstance();  
		SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM d yyyy HH:mm:ss 'GMT 0800 (CST)'");  
		sdf.setTimeZone(TimeZone.getTimeZone("GMT")); // 设置时区为GMT  
		String str = sdf.format(cd.getTime());  
		System.out.println(str); 
		      // Thu Jan 10 2017 00:00:00 GMT 0800 (CST)
		   
		      /* Calendar cd = Calendar.getInstance();  
				SimpleDateFormat sdf = new SimpleDateFormat("'Thu' MMM d yyyy HH:mm:ss 'GMT 0800(CST)'");  
				sdf.setTimeZone(TimeZone.getTimeZone("GMT")); // 设置时区为GMT  
				    String str = sdf.format(cd.getTime());  
				       System.out.println(str); */

		
		
		
}
}
