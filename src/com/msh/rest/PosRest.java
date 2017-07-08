package com.msh.rest;

import java.util.List;

import org.apache.struts2.json.annotations.JSON;

import com.dao.Salesdiscount;
import com.dao.Salesitem;
import com.dao.Salesless;
import com.msh.biz.PosRestBiz;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;

public class PosRest extends ActionSupport {

	/**
	 * 
	 */
	
	private static Logger log; //紀錄 
	private String message; //錯誤時訊息
	
	private static final long serialVersionUID = 1L;
    private List <Salesitem> salesItemList;
    private List <Salesdiscount> discountList;
    private List <Salesless> lessList;
    private PosRestBiz posRestBiz; 
    @JSON(name="Message")
	public String getMessage() {
		return message;
	}
	/**
	 * 設定LOG
	 */
    public PosRest(){
    	log=LoggerFactory.getLogger(PosRest.class);
    }
    /**
	 * 呼叫action name
	 */
	private void getActionName(){
	String	action=ActionContext.getContext().getName(); 
		log.info("actionName:[#0]", action);
	}
    
	  public List<Salesless> getLessList() {
		return lessList;
	}
	public void setLessList(List<Salesless> lessList) {
		this.lessList = lessList;
	}
	public List <Salesitem> getSalesItemList() {
		return salesItemList;
	}



	public void setSalesItemList(List <Salesitem> salesItemList) {
		this.salesItemList = salesItemList;
	}



	public List <Salesdiscount> getDiscountList() {
		return discountList;
	}



	public void setDiscountList(List <Salesdiscount> discountList) {
		this.discountList = discountList;
	}

    

	public PosRestBiz getPosRestBiz() {
		return posRestBiz;
	}
	public void setPosRestBiz(PosRestBiz posRestBiz) {
		this.posRestBiz = posRestBiz;
	}
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		getActionName();
		try{
	    posRestBiz.trans(salesItemList, discountList, lessList);
		this.message="success";
		
		clear();
		return super.execute();
		}catch(Exception e){
			clear(); 
	    	 log.error("[#0],[#1]",e, e.getMessage() );
	    	 this.message="error";
	    	 return "ERROR";
		}
	}
	
	private void clear(){
		salesItemList.clear();
		discountList.clear();
		lessList.clear();
	}
}
