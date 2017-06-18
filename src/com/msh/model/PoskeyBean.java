package com.msh.model;

import java.math.BigDecimal;

public class PoskeyBean {
	private String title;
	private String type;
	private BigDecimal sales;
	private BigDecimal discount;
	private String id;
	private Long selfId;
	private boolean isEnable;
	
	public Long getSelfId() {
		return selfId;
	}
	public void setSelfId(Long selfId) {
		this.selfId = selfId;
	}
	public boolean getIsEnable() {
	 
		return isEnable;
	}
	public void setEnable(boolean isEnable) {
		this.isEnable = isEnable;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public BigDecimal getSales() { 
		return sales;
	}
	public void setSales(BigDecimal sales) {
		this.sales = sales;
	}
	public BigDecimal getDiscount() {
		return discount;
	}
	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}
}
