package com.msh.rest;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.json.annotations.JSON;

import com.dao.Item;
import com.dao.Salesdiscount;
import com.dao.Salesitem;
import com.msh.model.LessBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;

public class PosRest extends ActionSupport {

	/**
	 * 
	 */
	
	private static Logger log; //紀錄
	private String action; //判斷此ACTION 名稱 
	private String message; //錯誤時訊息
	
	private static final long serialVersionUID = 1L;
    private List <Salesitem> salesItemList;
    private List <Salesdiscount> discountList;
    private List <LessBean> lessList;
    
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
		action=ActionContext.getContext().getName(); 
		log.info("actionName:[#0]", action);
	}
    
	  public List<LessBean> getLessList() {
		return lessList;
	}
	public void setLessList(List<LessBean> lessList) {
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



	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		try{
			if(null!=salesItemList){
				for(int i=0;i<this.salesItemList.size();i++){
					log.info("[#0]", salesItemList.get(i).getItemSalesitem().trim());
				}
			}
			if(null!=discountList){
				log.info("[#0]",this.discountList.get(0).getNameSalesdiscount());
				 
			}
		
		getActionName();
		  
		return super.execute();
		}catch(Exception e){
			this.action="";
	    	 log.error("[#0],[#1]",e, e.getMessage() );
	    	 return "ERROR";
		}
	}
}
