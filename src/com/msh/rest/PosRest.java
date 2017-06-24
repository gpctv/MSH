package com.msh.rest;

import java.util.ArrayList;

import org.apache.struts2.json.annotations.JSON;

import com.dao.Item;
import com.dao.Salesdiscount;
import com.dao.Salesitem;
import com.opensymphony.xwork2.ActionSupport;

public class PosRest extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private ArrayList<Salesitem> salesItemList;
    private ArrayList<Salesdiscount> salesDiscountList;
	
    
    
	  public ArrayList<Salesitem> getSalesItemList() {
		return salesItemList;
	}



	public void setSalesItemList(ArrayList<Salesitem> salesItemList) {
		this.salesItemList = salesItemList;
	}



	public ArrayList<Salesdiscount> getSalesDiscountList() {
		return salesDiscountList;
	}



	public void setSalesDiscountList(ArrayList<Salesdiscount> salesDiscountList) {
		this.salesDiscountList = salesDiscountList;
	}



	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		  
		return super.execute();
	}
}
