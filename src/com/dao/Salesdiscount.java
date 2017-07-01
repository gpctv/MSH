package com.dao;

import java.math.BigDecimal;


/**
 * Salesdiscount entity. @author MyEclipse Persistence Tools
 */

public class Salesdiscount  implements java.io.Serializable {


    // Fields    
 
     private String nameSalesdiscount;
     private Double amountSalesdiscount;


    // Constructors

    /** default constructor */
    public Salesdiscount() {
    }

	 
    /** full constructor */
    public Salesdiscount(  String nameSalesdiscount, Double amountSalesdiscount) {
        
        this.nameSalesdiscount = nameSalesdiscount;
        this.amountSalesdiscount = amountSalesdiscount;
    }
 // Fields    

    private String receiptnoSalesdiscount;
    private BigDecimal idSalesdiscount;


   
  
   // Property accessors

   public String getReceiptnoSalesdiscount() {
       return this.receiptnoSalesdiscount;
   }
   
   public void setReceiptnoSalesdiscount(String receiptnoSalesdiscount) {
       this.receiptnoSalesdiscount = receiptnoSalesdiscount;
   }

   public BigDecimal getIdSalesdiscount() {
       return this.idSalesdiscount;
   }
   
   public void setIdSalesdiscount(BigDecimal idSalesdiscount) {
       this.idSalesdiscount = idSalesdiscount;
   }
  



  public boolean equals(Object other) {
        if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof Salesdiscount) ) return false;
		 Salesdiscount castOther = ( Salesdiscount ) other; 
        
		 return ( (this.getReceiptnoSalesdiscount()==castOther.getReceiptnoSalesdiscount()) || ( this.getReceiptnoSalesdiscount()!=null && castOther.getReceiptnoSalesdiscount()!=null && this.getReceiptnoSalesdiscount().equals(castOther.getReceiptnoSalesdiscount()) ) )
&& ( (this.getIdSalesdiscount()==castOther.getIdSalesdiscount()) || ( this.getIdSalesdiscount()!=null && castOther.getIdSalesdiscount()!=null && this.getIdSalesdiscount().equals(castOther.getIdSalesdiscount()) ) );
  }
  
  public int hashCode() {
        int result = 17;
        
        result = 37 * result + ( getReceiptnoSalesdiscount() == null ? 0 : this.getReceiptnoSalesdiscount().hashCode() );
        result = 37 * result + ( getIdSalesdiscount() == null ? 0 : this.getIdSalesdiscount().hashCode() );
        return result;
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
   








}