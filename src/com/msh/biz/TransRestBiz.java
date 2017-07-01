package com.msh.biz;

import java.util.HashMap;

import com.dao.Trans;
import com.dao.TransCustomDAO;
import com.dao.TransDAO;
import com.msh.api.TimeStamp;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;

public class TransRestBiz {
	private static Logger log; //紀錄
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
	 * 設定LOG
	 */
    public TransRestBiz(){
    	log=LoggerFactory.getLogger(PosRestBiz.class);
    }
	
    public HashMap<String,Trans> getTrans(String sDate,String eDate){
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
    
     private  HashMap<String,Trans>  getTodayTrans(){
    	String today= TimeStamp.getNowString();
    	 HashMap<String,Trans> t=transCuDAO.getTrans(today+"000000", today+"235959");
     log.info("[#0]", "trans get");
     return t;
     }
   
     private HashMap<String,Trans> getRangeTrans(String sDate,String eDate){
    	 HashMap<String,Trans> t=transCuDAO.getTrans(sDate+"000000", eDate+"235959");
         log.info("[#0]", "trans get");
         return t;
     }
   
}
