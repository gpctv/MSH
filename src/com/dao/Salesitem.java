package com.dao;

import java.math.BigDecimal;

/**
 * Salesitem entity. @author MyEclipse Persistence Tools
 */

public class Salesitem implements java.io.Serializable {

	// Fields

	private String receiptnoSalesitem;
	private Long idSalesitem;
	private String itemSalesitem;
	private Long countSalesitem;
	private BigDecimal amountSalesitem;

	// Constructors

	/** default constructor */
	public Salesitem() {
	}

	/** minimal constructor */
	public Salesitem(String receiptnoSalesitem) {
		this.receiptnoSalesitem = receiptnoSalesitem;
	}

	/** full constructor */
	public Salesitem(String receiptnoSalesitem, Long idSalesitem,
			String itemSalesitem, Long countSalesitem,
			BigDecimal amountSalesitem) {
		this.receiptnoSalesitem = receiptnoSalesitem;
		this.idSalesitem = idSalesitem;
		this.itemSalesitem = itemSalesitem;
		this.countSalesitem = countSalesitem;
		this.amountSalesitem = amountSalesitem;
	}

	// Property accessors

	public String getReceiptnoSalesitem() {
		return this.receiptnoSalesitem;
	}

	public void setReceiptnoSalesitem(String receiptnoSalesitem) {
		this.receiptnoSalesitem = receiptnoSalesitem;
	}

	public Long getIdSalesitem() {
		return this.idSalesitem;
	}

	public void setIdSalesitem(Long idSalesitem) {
		this.idSalesitem = idSalesitem;
	}

	public String getItemSalesitem() {
		return this.itemSalesitem;
	}

	public void setItemSalesitem(String itemSalesitem) {
		this.itemSalesitem = itemSalesitem;
	}

	public Long getCountSalesitem() {
		return this.countSalesitem;
	}

	public void setCountSalesitem(Long countSalesitem) {
		this.countSalesitem = countSalesitem;
	}

	public BigDecimal getAmountSalesitem() {
		return this.amountSalesitem;
	}

	public void setAmountSalesitem(BigDecimal amountSalesitem) {
		this.amountSalesitem = amountSalesitem;
	}

}