package com.msh.api;

import java.sql.Timestamp;

public class TimeStamp {

	public static Timestamp getNowTimeStamp(){
		Timestamp timestamp=new Timestamp(System.currentTimeMillis());
		return timestamp;
	}
}
