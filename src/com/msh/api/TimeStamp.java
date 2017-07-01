package com.msh.api;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TimeStamp {

	public static Timestamp getNowTimeStamp(){
		Timestamp timestamp=new Timestamp(System.currentTimeMillis());
		return timestamp;
	}
	
	public static String getNowString(){
		SimpleDateFormat s=new  SimpleDateFormat("yyyyMMdd");
		return s.format(Calendar.getInstance().getTime());
	}
}
