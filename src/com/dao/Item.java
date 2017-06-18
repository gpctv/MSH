package com.dao;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Item entity. @author MyEclipse Persistence Tools
 */

public class Item implements java.io.Serializable {

	// Fields

	private Long idItem;
	private String nameItem;
	private BigDecimal enableItem;
	private Timestamp createdateItem;
	private Long amountItem;

	// Constructors

	/** default constructor */
	public Item() {
	}

	/** minimal constructor */
	public Item(Long idItem) {
		this.idItem = idItem;
	}

	/** full constructor */
	public Item(Long idItem, String nameItem, BigDecimal enableItem,
			Timestamp createdateItem, Long amountItem) {
		this.idItem = idItem;
		this.nameItem = nameItem;
		this.enableItem = enableItem;
		this.createdateItem = createdateItem;
		this.amountItem = amountItem;
	}

	// Property accessors

	public Long getIdItem() {
		return this.idItem;
	}

	public void setIdItem(Long idItem) {
		this.idItem = idItem;
	}

	public String getNameItem() {
		return this.nameItem;
	}

	public void setNameItem(String nameItem) {
		this.nameItem = nameItem;
	}

	public BigDecimal getEnableItem() {
		return this.enableItem;
	}

	public void setEnableItem(BigDecimal enableItem) {
		this.enableItem = enableItem;
	}

	public Timestamp getCreatedateItem() {
		return this.createdateItem;
	}

	public void setCreatedateItem(Timestamp createdateItem) {
		this.createdateItem = createdateItem;
	}

	public Long getAmountItem() {
		return this.amountItem;
	}

	public void setAmountItem(Long amountItem) {
		this.amountItem = amountItem;
	}

}