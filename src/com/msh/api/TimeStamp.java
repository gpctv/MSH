package com.msh.api;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
/**
 * 取得現在時間API
 * @author Stan
 *
 */
public class TimeStamp {
   /**
    * 回傳現在時間
    * @return 時間
    */
	public static Timestamp getNowTimeStamp(){
		Timestamp timestamp=new Timestamp(System.currentTimeMillis());
		return timestamp;
	}
	/**
	 * 回傳現在時間
	 * @return STRING
	 */
	public static String getNowString(){
		SimpleDateFormat s=new  SimpleDateFormat("yyyyMMdd");
		return s.format(Calendar.getInstance().getTime());
	}
}
