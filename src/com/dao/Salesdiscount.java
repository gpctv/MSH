package com.dao;

import java.math.BigDecimal;

/**
 * Salesdiscount entity. @author MyEclipse Persistence Tools
 */

public class Salesdiscount implements java.io.Serializable {

	// Fields

	private String receiptnoSalesdiscount;
	private String nameSalesdiscount;
	private Double amountSalesdiscount;
	private BigDecimal idSalesdiscount;

	// Constructors

	/** default constructor */
	public Salesdiscount() {
	}

	/** minimal constructor */
	public Salesdiscount(String receiptnoSalesdiscount) {
		this.receiptnoSalesdiscount = receiptnoSalesdiscount;
	}

	/** full constructor */
	public Salesdiscount(String receiptnoSalesdiscount,
			String nameSalesdiscount, Double amountSalesdiscount,
			BigDecimal idSalesdiscount) {
		this.receiptnoSalesdiscount = receiptnoSalesdiscount;
		this.nameSalesdiscount = nameSalesdiscount;
		this.amountSalesdiscount = amountSalesdiscount;
		this.idSalesdiscount = idSalesdiscount;
	}

	// Property accessors

	public String getReceiptnoSalesdiscount() {
		return this.receiptnoSalesdiscount;
	}

	public void setReceiptnoSalesdiscount(String receiptnoSalesdiscount) {
		this.receiptnoSalesdiscount = receiptnoSalesdiscount;
	}

	public String getNameSalesdiscount() {
		return this.nameSalesdiscount;
	}

	public void setNameSalesdiscount(String nameSalesdiscount) {
		this.nameSalesdiscount = nameSalesdiscount;
	}

	public Double getAmountSalesdiscount() {
		return this.amountSalesdiscount;
	}

	public void setAmountSalesdiscount(Double amountSalesdiscount) {
		this.amountSalesdiscount = amountSalesdiscount;
	}

	public BigDecimal getIdSalesdiscount() {
		return this.idSalesdiscount;
	}

	public void setIdSalesdiscount(BigDecimal idSalesdiscount) {
		this.idSalesdiscount = idSalesdiscount;
	}

}