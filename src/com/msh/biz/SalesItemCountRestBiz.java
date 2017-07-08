package com.msh.biz;

import java.util.LinkedHashMap;

import com.dao.SalesItemCount;
import com.dao.SalesItemCountDAO;
import com.msh.api.TimeStamp;

public class SalesItemCountRestBiz {
	private SalesItemCountDAO salesItemCountDAO;
	public SalesItemCountDAO getSalesItemCountDAO() {
		return salesItemCountDAO;
	}
	public void setSalesItemCountDAO(SalesItemCountDAO salesItemCountDAO) {
		this.salesItemCountDAO = salesItemCountDAO;
	}
	/**
	 * 查詢ITEM 賣出去統計
	 * @param sDate
	 * @param eDate
	 * @return
	 */
	public LinkedHashMap<String,SalesItemCount>  getSalesItemCount(String sDate,String eDate){
		String today= TimeStamp.getNowString();
		if(sDate.isEmpty() && eDate.isEmpty()){
			return salesItemCountDAO.getCountList(today+"000000", today+"235959");
		}else if(sDate.isEmpty() || eDate.isEmpty()){
			if(sDate.isEmpty()){
				return	salesItemCountDAO.getCountList(eDate+"000000", eDate+"235959");
			}
			if(eDate.isEmpty()){
				return	salesItemCountDAO.getCountList(sDate+"000000", sDate+"235959");
			}
		}
		return 	salesItemCountDAO.getCountList(sDate+"000000", eDate+"235959");
	}
	
	
}
