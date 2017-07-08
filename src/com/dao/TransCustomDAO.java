package com.dao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import com.msh.model.TransDetailBean;
@Transactional
public class TransCustomDAO {
	private static final Logger log = LoggerFactory.getLogger(TransDAO.class);
	// property constants

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	/**
	 * 查詢期間銷售
	 * @param sDate
	 * @param eDate
	 * @return
	 */
	public  LinkedHashMap<String,Trans> getTrans(String sDate,String eDate){
		 LinkedHashMap<String,Trans> transList=new  LinkedHashMap<String,Trans>();
		Query query =this.sessionFactory.getCurrentSession()
				.getNamedQuery("trans.query.range");
		query.setParameter("sDate", sDate);
		query.setParameter("eDate", eDate);
		Iterator<?> iter=query.list().iterator();
		while(iter.hasNext()){
			Trans trans=(Trans)iter.next();
			transList.put(trans.getReceiptnoTrans(), trans);
		}
		log.info("回傳LinkedHashMap");
		return transList;
	}
	/**
	 * 回傳總額
	 * @param sDate
	 * @param eDate
	 * @return
	 */
	public BigDecimal getSum(String sDate,String eDate){
		 Query query =this.sessionFactory.getCurrentSession()
				.getNamedQuery("trans.query.sum");
		query.setParameter("sDate", sDate);
		query.setParameter("eDate", eDate);
		BigDecimal sum=(BigDecimal)query.uniqueResult();
		return sum;
	}
	/**
	 * 回傳品項細目
	 * @param receiptNo
	 * @return
	 */
	public LinkedHashMap<String,TransDetailBean> getDetail(String receiptNo){
		 LinkedHashMap<String,TransDetailBean> transList=new  LinkedHashMap<String,TransDetailBean>();
		Query query =this.sessionFactory.getCurrentSession()
				.getNamedQuery("trans.query.detail");
		query.setString("receiptNo", receiptNo);
		List<Object[]> t=query.list();
		for(Object o[] :t){
			TransDetailBean bean=new TransDetailBean();
		BigDecimal amount=new	BigDecimal(o[2].toString() );
			bean.setAmount(amount);
			bean.setName(o[1].toString());
			bean.setReceipt(o[0].toString() );
			 bean.setTranDate((Date)o[3]);
			 bean.setId((BigDecimal)o[4] );
			 transList.put(bean.getId().toString(), bean);
		}
		return transList;
	}
}
