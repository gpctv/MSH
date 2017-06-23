package com.msh.action;

import java.util.ArrayList;

import com.dao.Discount;
import com.dao.Item;
import com.msh.biz.PosBiz;
import com.msh.rest.PoskeyRest;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;

public class PosAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private ArrayList<Item> itemKeys;
    private ArrayList<Discount> discountKeys;
    private PosBiz posBiz;
    private static Logger log; //紀錄

	public PosBiz getPosBiz() {
		return posBiz;
	}

   public PosAction(){
	   log=LoggerFactory.getLogger(PosAction.class); 
   }

	public void setPosBiz(PosBiz posBiz) {
		this.posBiz = posBiz;
	}



	public ArrayList<Item> getItemKeys() {
		return itemKeys;
	}



	public void setItemKeys(ArrayList<Item> itemKeys) {
		this.itemKeys = itemKeys;
	}



	public ArrayList<Discount> getDiscountKeys() {
		return discountKeys;
	}



	public void setDiscountKeys(ArrayList<Discount> discountKeys) {
		this.discountKeys = discountKeys;
	}



	@Override
	public String execute(){
		// TODO Auto-generated method stub
		try{
			getActionName();
		this.itemKeys=getItemList();
		return "SUCCESS";
		}catch(Exception e){
		log.error("ERROR:[#0],[#1]", e,e.getMessage());
		return "ERROR";
		}
		
	}
	private ArrayList<Item> getItemList(){
		return posBiz.getItemKey();
	}
	/**
	 * 呼叫action name
	 */
	private void getActionName(){
		String action=ActionContext.getContext().getName(); 
		log.info("actionName:[#0]", action);
	}
}
