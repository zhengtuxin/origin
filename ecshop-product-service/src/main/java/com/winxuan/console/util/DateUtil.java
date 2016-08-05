package com.winxuan.console.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期工具
 * @author ztx
 */
public class DateUtil {
	
	/**
	 * 当前日期转换为指定的格式的字符串
	 * @param format "yyyy-MM-dd HH:mm:ss.SSS"
	 * @return
	 */
	public static String date2String(String format){
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(new Date());		
	}
	
	/**
	 * 指定日期日期转换为指定的格式的字符串
	 * @param date
	 * @param format "yyyy-MM-dd HH:mm:ss.SSS"
	 * @return
	 */
	public static String date2String(Date date, String format){
		if(null == date)
			return "";
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);		
	}

}