package com.dao;

import java.sql.Timestamp;

/**
 * Id entity. @author MyEclipse Persistence Tools
 */

public class Id implements java.io.Serializable {

	// Fields

	private String receiptnoId;
	private Long idId;
	private Timestamp createdateId;
	private Timestamp createtimeId;

	// Constructors

	/** default constructor */
	public Id() {
	}

	/** minimal constructor */
	public Id(String receiptnoId) {
		this.receiptnoId = receiptnoId;
	}

	/** full constructor */
	public Id(String receiptnoId, Long idId, Timestamp createdateId,
			Timestamp createtimeId) {
		this.receiptnoId = receiptnoId;
		this.idId = idId;
		this.createdateId = createdateId;
		this.createtimeId = createtimeId;
	}

	// Property accessors

	public String getReceiptnoId() {
		return this.receiptnoId;
	}

	public void setReceiptnoId(String receiptnoId) {
		this.receiptnoId = receiptnoId;
	}

	public Long getIdId() {
		return this.idId;
	}

	public void setIdId(Long idId) {
		this.idId = idId;
	}

	public Timestamp getCreatedateId() {
		return this.createdateId;
	}

	public void setCreatedateId(Timestamp createdateId) {
		this.createdateId = createdateId;
	}

	public Timestamp getCreatetimeId() {
		return this.createtimeId;
	}

	public void setCreatetimeId(Timestamp createtimeId) {
		this.createtimeId = createtimeId;
	}

}