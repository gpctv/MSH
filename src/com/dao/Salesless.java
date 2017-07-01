package com.dao;

import java.math.BigDecimal;

/**
 * Salesless entity. @author MyEclipse Persistence Tools
 */

public class Salesless implements java.io.Serializable {

	// Fields
 
	private String nameSalesless;
	private Double amountSalesless;

	// Constructors

	/** default constructor */
	public Salesless() {
	}

	 
	/** full constructor */
	public Salesless(  String nameSalesless,
			Double amountSalesless) {
		 
		this.nameSalesless = nameSalesless;
		this.amountSalesless = amountSalesless;
	}
	// Fields

		private String receiptnoSalesless;
		private BigDecimal idSalesless;

		 

		// Property accessors

		public String getReceiptnoSalesless() {
			return this.receiptnoSalesless;
		}

		public void setReceiptnoSalesless(String receiptnoSalesless) {
			this.receiptnoSalesless = receiptnoSalesless;
		}

		public BigDecimal getIdSalesless() {
			return this.idSalesless;
		}

		public void setIdSalesless(BigDecimal idSalesless) {
			this.idSalesless = idSalesless;
		}

		public boolean equals(Object other) {
			if ((this == other))
				return true;
			if ((other == null))
				return false;
			if (!(other instanceof Salesless))
				return false;
			Salesless castOther = (Salesless) other;

			return ((this.getReceiptnoSalesless() == castOther
					.getReceiptnoSalesless()) || (this.getReceiptnoSalesless() != null
					&& castOther.getReceiptnoSalesless() != null && this
					.getReceiptnoSalesless().equals(
							castOther.getReceiptnoSalesless())))
					&& ((this.getIdSalesless() == castOther.getIdSalesless()) || (this
							.getIdSalesless() != null
							&& castOther.getIdSalesless() != null && this
							.getIdSalesless().equals(castOther.getIdSalesless())));
		}

		public int hashCode() {
			int result = 17;

			result = 37
					* result
					+ (getReceiptnoSalesless() == null ? 0 : this
							.getReceiptnoSalesless().hashCode());
			result = 37
					* result
					+ (getIdSalesless() == null ? 0 : this.getIdSalesless()
							.hashCode());
			return result;
		}
	// Property accessors

 

	 
	public String getNameSalesless() {
		return this.nameSalesless;
	}

	public void setNameSalesless(String nameSalesless) {
		this.nameSalesless = nameSalesless;
	}

	public Double getAmountSalesless() {
		return this.amountSalesless;
	}

	public void setAmountSalesless(Double amountSalesless) {
		this.amountSalesless = amountSalesless;
	}

}