package com.msh.biz;

import java.math.BigDecimal;
import java.util.LinkedHashMap;

import com.dao.Trans;
import com.dao.TransCustomDAO;
import com.dao.TransDAO;
import com.msh.model.TransDetailBean;

public class TransDetailRestBiz { 
	private TransDetailBean transDetailBean;
	private TransCustomDAO transCuDAO;
	private TransDAO transDAO;
	
	public TransDAO getTransDAO() {
		return transDAO;
	}
	public void setTransDAO(TransDAO transDAO) {
		this.transDAO = transDAO;
	}
	public TransDetailBean getTransDetailBean() {
		return transDetailBean;
	}
	public void setTransDetailBean(TransDetailBean transDetailBean) {
		this.transDetailBean = transDetailBean;
	}
	public TransCustomDAO getTransCuDAO() {
		return transCuDAO;
	}
	public void setTransCuDAO(TransCustomDAO transCuDAO) {
		this.transCuDAO = transCuDAO;
	}
	 
	/**
	 * 獲得DETAIL TABLE
	 * @param receiptNo
	 * @return
	 */
    public LinkedHashMap<String,TransDetailBean> getDetail(String receiptNo){
    	return transCuDAO.getDetail(receiptNo);
    }
    /**
     * 獲得DETAIL 總計
     * @param receiptNo
     * @return
     */
    public BigDecimal detailSum(String receiptNo){
    	 
    	Trans trans=transDAO.findById(receiptNo);
    	return trans.getAmountTrans();
    }
}
