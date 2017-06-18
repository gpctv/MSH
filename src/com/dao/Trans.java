package com.dao;

/**
 * Trans entity. @author MyEclipse Persistence Tools
 */

public class Trans implements java.io.Serializable {

	// Fields

	private String receiptnoTrans;
	private Double amountTrans;

	// Constructors

	/** default constructor */
	public Trans() {
	}

	/** minimal constructor */
	public Trans(String receiptnoTrans) {
		this.receiptnoTrans = receiptnoTrans;
	}

	/** full constructor */
	public Trans(String receiptnoTrans, Double amountTrans) {
		this.receiptnoTrans = receiptnoTrans;
		this.amountTrans = amountTrans;
	}

	// Property accessors

	public String getReceiptnoTrans() {
		return this.receiptnoTrans;
	}

	public void setReceiptnoTrans(String receiptnoTrans) {
		this.receiptnoTrans = receiptnoTrans;
	}

	public Double getAmountTrans() {
		return this.amountTrans;
	}

	public void setAmountTrans(Double amountTrans) {
		this.amountTrans = amountTrans;
	}

}