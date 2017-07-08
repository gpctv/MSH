package com.msh.biz;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.dao.BatchDAO;
import com.dao.IdDAO;
import com.dao.Salesdiscount;
import com.dao.SalesdiscountDAO;
import com.dao.Salesitem;
import com.dao.SalesitemDAO;
import com.dao.Salesless;
import com.dao.Trans;
import com.dao.TransDAO;
import com.msh.api.TimeStamp;

public class PosRestBiz {
	private IdDAO idDao; 
	private SalesdiscountDAO salesdiscountDAO;
	private SalesitemDAO salesitemDAO;
	private TransDAO transDAO;
	private BatchDAO batchDAO;
	
	public BatchDAO getBatchDAO() {
		return batchDAO;
	}
	public void setBatchDAO(BatchDAO batchDAO) {
		this.batchDAO = batchDAO;
	}
	public IdDAO getIdDao() {
		return idDao;
	}
	public void setIdDao(IdDAO idDao) {
		this.idDao = idDao;
	}
	public SalesdiscountDAO getSalesdiscountDAO() {
		return salesdiscountDAO;
	}
	public void setSalesdiscountDAO(SalesdiscountDAO salesdiscountDAO) {
		this.salesdiscountDAO = salesdiscountDAO;
	}
	public SalesitemDAO getSalesitemDAO() {
		return salesitemDAO;
	}
	public void setSalesitemDAO(SalesitemDAO salesitemDAO) {
		this.salesitemDAO = salesitemDAO;
	}
	public TransDAO getTransDAO() {
		return transDAO;
	}
	public void setTransDAO(TransDAO transDAO) {
		this.transDAO = transDAO;
	}
	
	/**
	 * 獲取交易序號
	 * @return
	 */
	private String getInvoiceNO(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssS");
	     return sdf.format(Calendar.getInstance().getTime());
	}
	/**
	 * 計算交易
	 * @param salesItemList
	 * @param discountList
	 * @param lessList
	 * @return
	 */
	private BigDecimal calResult(List <Salesitem> salesItemList,
			List <Salesdiscount> discountList,List <Salesless> lessList){
		BigDecimal sum=new BigDecimal("0");
		//ITEM 計算
		for(Salesitem s:salesItemList){
			
			sum=sum.add(s.getAmountSalesitem());
		}
		BigDecimal sumLess=new BigDecimal("0");
		//折讓計算
		for(Salesless l:lessList){
			sumLess=sumLess.add(BigDecimal.valueOf(l.getAmountSalesless()));
		}
		BigDecimal discount=new BigDecimal("0");
		//折扣
		for(Salesdiscount d:discountList){
			discount=discount.add(BigDecimal.valueOf(d.getAmountSalesdiscount() ) );
		}
		sum=sum.add(sumLess);
		return sum.multiply(discount);
	}
	/**
	 * 儲存
	 * @param salesItemList
	 * @param discountList
	 * @param lessList
	 */
	private void saveTran(List <Salesitem> salesItemList,
			List <Salesdiscount> discountList,
			List <Salesless> lessList,
			Trans trans){
		batchDAO.save(salesItemList, discountList, lessList,trans);
	}
	
	 public void trans(List <Salesitem> salesItemList,
			List <Salesdiscount> discountList,
			List <Salesless> lessList 
			 ){
		 List <Salesitem> s1=new ArrayList<Salesitem>();
		 List <Salesdiscount> d1=new ArrayList<Salesdiscount>();
		 List <Salesless> l1=new ArrayList<Salesless>(); 
			Trans trans=new Trans();
		 String invoice=getInvoiceNO();
		 for(Salesitem s:salesItemList){
			s.setReceiptnoSalesitem(invoice);
			 s1.add(s);
		 }
		 for(Salesdiscount d:discountList){
			 d.setReceiptnoSalesdiscount(invoice);
			 d1.add(d);
		 }
		 for(Salesless l:lessList){
			 l.setReceiptnoSalesless(invoice);
			 l1.add(l);
		 }
		 trans.setReceiptnoTrans(invoice);
		 trans.setAmountTrans(calResult(s1, d1, l1));
		 trans.setDateTrans(TimeStamp.getNowTimeStamp());
	     saveTran(s1, d1, l1, trans);
	 }
}
