package com.msh.rest;

import java.util.HashMap;

import org.apache.struts2.json.annotations.JSON;

import com.dao.SalesItemCount;
import com.msh.biz.SalesItemCountRestBiz;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;

public class SalesItemRest extends ActionSupport {

	/**
	 * 
	 */ 
	private static final long serialVersionUID = 1L;
	private static Logger log; //紀錄 
	private String message; //錯誤時訊息
	private  HashMap<String,SalesItemCount> records;
	private String result; //判定資料新增或查詢是否成功
	private SalesItemCountRestBiz salesItemCountRestBiz;
	private String sDate;
	private String eDate;
	
	public String getSDate() {
		return sDate;
	}

	public void setSDate(String sDate) {
		this.sDate = sDate;
	}

	public String getEDate() {
		return eDate;
	}

	public void setEDate(String eDate) {
		this.eDate = eDate;
	}

	public SalesItemCountRestBiz getSalesItemCountRestBiz() {
		return salesItemCountRestBiz;
	}

	public void setSalesItemCountRestBiz(SalesItemCountRestBiz salesItemCountRestBiz) {
		this.salesItemCountRestBiz = salesItemCountRestBiz;
	}

	@JSON(name="Message")
public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	@JSON(name="Records")
	public HashMap<String, SalesItemCount> getRecords() {
		return records;
	}

	public void setRecords(HashMap<String, SalesItemCount> records) {
		this.records = records;
	}
	@JSON(name="Result")
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	
	public SalesItemRest(){
		log=LoggerFactory.getLogger(SalesItemRest.class); 
	}

@Override
public String execute() throws Exception {
	// TODO Auto-generated method stub
	try{
		getActionName();
		this.records=salesItemCountRestBiz.getSalesItemCount(sDate, eDate);
	this.result="OK";
	
	}catch(Exception e){
		this.result="ERROR";
		log.error("ERROR SalesItemRest[#0]", e,e.getMessage());
	}
	return super.execute();
}

/**
 * 呼叫action name
 */
private void getActionName(){
	String action=ActionContext.getContext().getName(); 
	log.info("actionName:[#0]", action);
}
}
