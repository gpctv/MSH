package com.msh.model;

import java.math.BigDecimal;
import java.util.Date;

public class TransDetailBean {
	private BigDecimal id;
private String receipt;
private String name;
private BigDecimal amount;
private Date tranDate;

public BigDecimal getId() {
	return id;
}
public void setId(BigDecimal id) {
	this.id = id;
}
public String getReceipt() {
	return receipt;
}
public void setReceipt(String receipt) {
	this.receipt = receipt;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public BigDecimal getAmount() {
	return amount;
}
public void setAmount(BigDecimal amount) {
	this.amount = amount;
}
public Date getTranDate() {
	return tranDate;
}
public void setTranDate(Date tranDate) {
	this.tranDate = tranDate;
}


}
