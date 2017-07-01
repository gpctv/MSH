package com.msh.rest;

import java.util.HashMap;

import org.apache.struts2.json.annotations.JSON;

import com.dao.Trans;
import com.msh.biz.TransRestBiz; 
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;

public class TransRest extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private static Logger log; //紀錄
	private String action; //判斷此ACTION 名稱 
	private String message; //錯誤時訊息
	private HashMap<String,Trans>  records; //前端資料
	private Trans record; //單筆資料
	private String result; //判定資料新增或查詢是否成功
	private TransRestBiz transRestBiz;
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
	public TransRestBiz getTransRestBiz() {
		return transRestBiz;
	}
	public void setTransRestBiz(TransRestBiz transRestBiz) {
		this.transRestBiz = transRestBiz;
	}
	@JSON(name="Message")
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@JSON(name="Records")
	public HashMap<String, Trans> getRecords() {
		return records;
	}
	public void setRecords(HashMap<String, Trans> records) {
		this.records = records;
	}
	@JSON(name="Record")
	public Trans getRecord() {
		return record;
	}
	public void setRecord(Trans record) {
		this.record = record;
	}
	@JSON(name="Result")
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
	public TransRest(){
		log=LoggerFactory.getLogger(TransRest.class); 
	}
	/**
	 * 呼叫action name
	 */
	private void getActionName(){
		action=ActionContext.getContext().getName(); 
		log.info("actionName:[#0]", action);
	}
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		getActionName();
		HashMap<String,Trans>  table=transRestBiz.getTrans(sDate,eDate);
		this.setRecords(table);
		this.setResult("OK");
		return super.execute();
	}
	
}
