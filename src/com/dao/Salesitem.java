package com.dao;

import java.math.BigDecimal;

/**
 * Salesitem entity. @author MyEclipse Persistence Tools
 */

public class Salesitem implements java.io.Serializable {

	// Fields

 
	private String itemSalesitem;
	private Long countSalesitem;
	private BigDecimal amountSalesitem;

	// Constructors

	/** default constructor */
	public Salesitem() {
	}

	 
	// Fields

		private String receiptnoSalesitem;
		private Long idSalesitem;

		 
	 

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

		public boolean equals(Object other) {
			if ((this == other))
				return true;
			if ((other == null))
				return false;
			if (!(other instanceof Salesitem))
				return false;
			Salesitem castOther = (Salesitem) other;

			return ((this.getReceiptnoSalesitem() == castOther
					.getReceiptnoSalesitem()) || (this.getReceiptnoSalesitem() != null
					&& castOther.getReceiptnoSalesitem() != null && this
					.getReceiptnoSalesitem().equals(
							castOther.getReceiptnoSalesitem())))
					&& ((this.getIdSalesitem() == castOther.getIdSalesitem()) || (this
							.getIdSalesitem() != null
							&& castOther.getIdSalesitem() != null && this
							.getIdSalesitem().equals(castOther.getIdSalesitem())));
		}

		public int hashCode() {
			int result = 17;

			result = 37
					* result
					+ (getReceiptnoSalesitem() == null ? 0 : this
							.getReceiptnoSalesitem().hashCode());
			result = 37
					* result
					+ (getIdSalesitem() == null ? 0 : this.getIdSalesitem()
							.hashCode());
			return result;
		}
	 

	// Property accessors

	 
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