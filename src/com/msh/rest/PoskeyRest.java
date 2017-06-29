package com.msh.rest;

import java.math.BigDecimal;
import java.util.HashMap;

import org.apache.struts2.json.annotations.JSON;

import com.msh.biz.PoskeyBizRest;
import com.msh.model.PoskeyBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;
 
/**
 * 獲取及新增 POSKEY 資料 
 * @author Stan
 *
 */
public class PoskeyRest extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private String id; //id
	private String selfId;//自身ID
	private HashMap<String,PoskeyBean>  records; //前端資料
	private PoskeyBean record; //單筆資料
	private String result; //判定資料新增或查詢是否成功
	private String title; //POSKEY 名稱
	private String type; //種類 
	private String sales; //銷售金額
	private String discount; //折扣
	private String enable; //功能是否啟用
	private static Logger log; //紀錄
	private String action; //判斷此ACTION 名稱 
	private String message; //錯誤時訊息
	private PoskeyBizRest poskeyBizRest; //呼叫BIZ
	
	public String getSelfId() {
		return selfId;
	}
	public void setSelfId(String selfId) {
		this.selfId = selfId;
	}
	public void setPoskeyBizRest(PoskeyBizRest poskeyBizRest){
		this.poskeyBizRest=poskeyBizRest;
	}
	public PoskeyRest(){
		log=LoggerFactory.getLogger(PoskeyRest.class); 
	}
	@JSON(name="Message")
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@JSON(name="Records")
	public HashMap<String, PoskeyBean> getRecords() {
		return records;
	}
	public void setRecords(HashMap<String, PoskeyBean> records) {
		this.records = records;
	}
	@JSON(name="Record")
	public PoskeyBean getRecord() {
		return record;
	}
	public void setRecord(PoskeyBean record) {
		this.record = record;
	}
	
	@JSON(name="Result")
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSales() {
		return sales;
	}
	public void setSales(String sales) {
		this.sales = sales;
	}
	public String getDiscount() {
		return discount;
	}
	public void setDiscount(String discount) {
		this.discount = discount;
	}
	public String getEnable() {
		return enable;
	}
	public void setEnable(String enable) {
		this.enable = enable;
	}
	/**
	 * 呼叫action name
	 */
	private void getActionName(){
		action=ActionContext.getContext().getName(); 
		log.info("actionName:[#0]", action);
	}
	@Override
	public String execute()   {
		// TODO Auto-generated method stub 
		getActionName();
		 HashMap<String,PoskeyBean> poskeyList =new HashMap<String, PoskeyBean>();
	     try{
	    	 switch(this.action){
	    	 case "poskeyQueryRest": 
	    		 poskeyList=poskeyBizRest.getPoskeyList();
				 this.setRecords(poskeyList);
				 this.setResult("OK");
				 this.action="";
				 break;
	    	 case "poskeyInsertRest":
	    		this.record= setPoskeyBean();
	    		PoskeyBean poskeybean=this.poskeyBizRest.setPoskey(this.record);//insertDB
	 			poskeyList=poskeyBizRest.getPoskeyList();
	 			this.record=poskeybean;
	 			this.setRecords(poskeyList);
	 			this.setResult("OK");
	 			this.action="";
	 			 break;
	    	 case "poskeyDeleteRest":
	    		 poskeyList=poskeyBizRest.getPoskeyList();
	    		 this.setRecords(poskeyList);
	    		 PoskeyBean deletePoskey=this.records.get(this.id);
	    		 poskeyBizRest.deletePoskey(deletePoskey);//deleteDB
	    		 this.setResult("OK");
	    		 this.action="";
	    		 break;
	    	 case "poskeyUpdateRest":
	    		 this.record=setPoskeyBean();
	    		 poskeyList=poskeyBizRest.getPoskeyList();
	    		 this.record.setSelfId(poskeyList.get(this.id).getSelfId()) ;
	    		 
	    		 this.poskeyBizRest.updatePoskey(this.record);
	    		 this.setResult("OK");
	    		 break;
	    	 } 
		 return super.execute();
	     }catch(Exception e){
	    	 this.action="";
	    	 log.error("[#0],[#1]",e, e.getMessage() );
	    	 return "ERROR";
	     }
		
	}

	 /**
	  * 設定poskeyBean
	  * 
	  * @return
	  */
	 private PoskeyBean setPoskeyBean(){
		 PoskeyBean poskeyBean=new PoskeyBean();
		 if(this.discount!=null){
			 poskeyBean.setDiscount(new BigDecimal(this.discount));
		 }else{
			 poskeyBean.setDiscount(new BigDecimal("0"));
		 }

		 poskeyBean.setEnable("true".equals(this.enable)?true:false);
		 poskeyBean.setId(this.id);
		 if(this.sales!=null){
			 poskeyBean.setSales(new BigDecimal(this.sales)); 
		 }else{
			 poskeyBean.setSales(new BigDecimal("0"));
		 }
		 
		 if(this.title!=null){
			 poskeyBean.setTitle(this.title);
		 }else{
			 this.message="title null";
		 }
		 
		 poskeyBean.setType(this.type);
		 return poskeyBean;
	 }
	 
}
