package com.dao;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Discount entity. @author MyEclipse Persistence Tools
 */

public class Discount implements java.io.Serializable {

	// Fields

	private Long idDiscount;
	private String typeDiscount;
	private Double amountDiscount;
	private String nameDiscount;
	private BigDecimal enableDiscount;
	private Timestamp createdateDiscount;

	// Constructors

	/** default constructor */
	public Discount() {
	}

	/** minimal constructor */
	public Discount(Long idDiscount) {
		this.idDiscount = idDiscount;
	}

	/** full constructor */
	public Discount(Long idDiscount, String typeDiscount,
			Double amountDiscount, String nameDiscount,
			BigDecimal enableDiscount, Timestamp createdateDiscount) {
		this.idDiscount = idDiscount;
		this.typeDiscount = typeDiscount;
		this.amountDiscount = amountDiscount;
		this.nameDiscount = nameDiscount;
		this.enableDiscount = enableDiscount;
		this.createdateDiscount = createdateDiscount;
	}

	// Property accessors

	public Long getIdDiscount() {
		return this.idDiscount;
	}

	public void setIdDiscount(Long idDiscount) {
		this.idDiscount = idDiscount;
	}

	public String getTypeDiscount() {
		return this.typeDiscount;
	}

	public void setTypeDiscount(String typeDiscount) {
		this.typeDiscount = typeDiscount;
	}

	public Double getAmountDiscount() {
		return this.amountDiscount;
	}

	public void setAmountDiscount(Double amountDiscount) {
		this.amountDiscount = amountDiscount;
	}

	public String getNameDiscount() {
		return this.nameDiscount;
	}

	public void setNameDiscount(String nameDiscount) {
		this.nameDiscount = nameDiscount;
	}

	public BigDecimal getEnableDiscount() {
		return this.enableDiscount;
	}

	public void setEnableDiscount(BigDecimal enableDiscount) {
		this.enableDiscount = enableDiscount;
	}

	public Timestamp getCreatedateDiscount() {
		return this.createdateDiscount;
	}

	public void setCreatedateDiscount(Timestamp createdateDiscount) {
		this.createdateDiscount = createdateDiscount;
	}

}