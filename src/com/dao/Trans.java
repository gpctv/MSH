package com.dao;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Trans entity. @author MyEclipse Persistence Tools
 */

public class Trans implements java.io.Serializable {

	// Fields

	private String receiptnoTrans;
	private BigDecimal amountTrans;
	private Timestamp dateTrans;

	// Constructors

	/** default constructor */
	public Trans() {
	}

	/** minimal constructor */
	public Trans(String receiptnoTrans) {
		this.receiptnoTrans = receiptnoTrans;
	}

	/** full constructor */
	public Trans(String receiptnoTrans, BigDecimal amountTrans,
			Timestamp dateTrans) {
		this.receiptnoTrans = receiptnoTrans;
		this.amountTrans = amountTrans;
		this.dateTrans = dateTrans;
	}

	// Property accessors

	public String getReceiptnoTrans() {
		return this.receiptnoTrans;
	}

	public void setReceiptnoTrans(String receiptnoTrans) {
		this.receiptnoTrans = receiptnoTrans;
	}

	public BigDecimal getAmountTrans() {
		return this.amountTrans;
	}

	public void setAmountTrans(BigDecimal amountTrans) {
		this.amountTrans = amountTrans;
	}

	public Timestamp getDateTrans() {
		return this.dateTrans;
	}

	public void setDateTrans(Timestamp dateTrans) {
		this.dateTrans = dateTrans;
	}

}