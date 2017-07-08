package com.msh.rest;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.LinkedHashMap;

import org.apache.struts2.json.annotations.JSON;

import com.msh.biz.TransDetailRestBiz;
import com.msh.model.TransDetailBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;

public class TransDetailRest extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private static Logger log; //紀錄 
	private String message; //錯誤時訊息
	private HashMap<String,TransDetailBean>  records; //前端資料
	private BigDecimal sum;
	private TransDetailRestBiz transDetailRestBiz;
	private String result; //判定資料新增或查詢是否成功
	private String receiptNo;
	
	public String getReceiptNo() {
		return receiptNo;
	}
	public void setReceiptNo(String receiptNo) {
		this.receiptNo = receiptNo;
	}
	public TransDetailRestBiz getTransDetailRestBiz() {
		return transDetailRestBiz;
	}
	public void setTransDetailRestBiz(TransDetailRestBiz transDetailRestBiz) {
		this.transDetailRestBiz = transDetailRestBiz;
	}
	@JSON(name="Sum")
	public BigDecimal getSum() {
		return sum;
	}
	public void setSum(BigDecimal sum) {
		this.sum = sum;
	}
	@JSON(name="Message")
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@JSON(name="Records")
	public HashMap<String,TransDetailBean>  getRecords() {
		return records;
	}
	public void setRecords(HashMap<String,TransDetailBean>  records) {
		this.records = records;
	}
	 
	@JSON(name="Result")
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
	public TransDetailRest(){
		log=LoggerFactory.getLogger(TransRest.class); 
	}
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		log.info("create [#0]", "transDetail");
		try{
			getActionName();
		 LinkedHashMap<String, TransDetailBean> table=transDetailRestBiz.getDetail(receiptNo);
		this.setRecords(table );  
		this.setSum(transDetailRestBiz.detailSum(receiptNo));
		this.setResult("OK");
		}catch(Exception e){
			log.error("ERROR TransDetail[#0]", e,e.getMessage());
		}
		return super.execute();
	}
	 /**
		 * 呼叫action name
		 */
		private void getActionName(){
		String	action=ActionContext.getContext().getName(); 
			log.info("actionName:[#0]", action);
		}
}
