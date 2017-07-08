package com.msh.biz;

import java.math.BigDecimal;
import java.util.LinkedHashMap;

import com.dao.Trans;
import com.dao.TransCustomDAO;
import com.dao.TransDAO;
import com.msh.api.TimeStamp;

public class TransRestBiz {
	private Trans trans;//設定交易BEAN
	private TransDAO transDAO;
	private TransCustomDAO transCuDAO;
	
	
	public TransCustomDAO getTransCuDAO() {
		return transCuDAO;
	}
	public void setTransCuDAO(TransCustomDAO transCuDAO) {
		this.transCuDAO = transCuDAO;
	}
	public Trans getTrans() {
		return trans;
	}
	public void setTrans(Trans trans) {
		this.trans = trans;
	}
	public TransDAO getTransDAO() {
		return transDAO;
	}
	public void setTransDAO(TransDAO transDAO) {
		this.transDAO = transDAO;
	}
	
	/**
	 * 查詢期間銷售 沒日期時搜尋今日
	 * @param sDate
	 * @param eDate
	 * @return
	 */
    public  LinkedHashMap<String,Trans> getTrans(String sDate,String eDate){
    	if(sDate.isEmpty() && eDate.isEmpty()){
    	return 	getTodayTrans();
    	}else if(sDate.isEmpty() || eDate.isEmpty()){
    		if(sDate.isEmpty()){
    			return	getRangeTrans(eDate,eDate);
    		}
    		if(eDate.isEmpty()){
    			return getRangeTrans(sDate,sDate);
    		}
    	}
    	return getRangeTrans(sDate,eDate);
    }
    /**
     * 今日銷售
     * @return
     */
     private   LinkedHashMap<String,Trans>  getTodayTrans(){
    	String today= TimeStamp.getNowString();
    	 LinkedHashMap<String,Trans> t=transCuDAO.getTrans(today+"000000", today+"235959");
    
     return t;
     }
   /**
    * 期間銷售
    * @param sDate
    * @param eDate
    * @return
    */
     private  LinkedHashMap<String,Trans> getRangeTrans(String sDate,String eDate){
    	 LinkedHashMap<String,Trans> t=transCuDAO.getTrans(sDate+"000000", eDate+"235959");
         
         return t;
     }
     /**
      * 總額
      * @param sDate
      * @param eDate
      * @return
      */
     public BigDecimal getSum(String sDate,String eDate){
    	 if(sDate.isEmpty() && eDate.isEmpty()){
    	    	return 	getTodaySum();
    	    	}else if(sDate.isEmpty() || eDate.isEmpty()){
    	    		if(sDate.isEmpty()){
    	    			return	getRangeSum(eDate,eDate);
    	    		}
    	    		if(eDate.isEmpty()){
    	    			return getRangeSum(sDate,sDate);
    	    		}
    	    	}
    	    	return getRangeSum(sDate,eDate);
     }
     /**
      * 回傳總額(當日)
      * @return
      */
     private  BigDecimal getTodaySum(){
     	String today= TimeStamp.getNowString();
     	 BigDecimal t=transCuDAO.getSum(today+"000000", today+"235959");
     
      return t;
      }
     /**
      * 回傳總額區間
      * @param sDate
      * @param eDate
      * @return
      */
     private BigDecimal getRangeSum(String sDate,String eDate){
     
     	 BigDecimal t=transCuDAO.getSum(sDate+"000000", eDate+"235959");
      
      return t;
     }
   
}
