package com.dao;

import java.util.LinkedHashMap;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
/**
 * 商品銷售量查詢DAO
 * @author Stan
 *
 */
@Transactional
public class SalesItemCountDAO {
	private static final Logger log = LoggerFactory.getLogger(TransDAO.class);
	// property constants

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	/**
	 * 查詢各商品銷售量
	 * @param sDate
	 * @param eDate
	 * @return
	 */
	public LinkedHashMap<String,SalesItemCount> getCountList(String sDate,String eDate){
		LinkedHashMap<String,SalesItemCount> salesItemCountList=new LinkedHashMap<String,SalesItemCount>();
		Query query =this.sessionFactory.getCurrentSession()
				.getNamedQuery("salesitem.query.salesitemCount");
		query.setParameter("sDate", sDate);
		query.setParameter("eDate", eDate);
		List<Object[]> t=query.list();
		for(Object o[] :t){
			SalesItemCount x=new SalesItemCount();
			x.setIdSales(o[0].toString());
			x.setNameItem(o[2].toString());
			x.setNum(o[1].toString());
			x.setRow(o[4].toString());
			salesItemCountList.put(x.getIdSales(), x);
		}
		log.info("salesItemCount 查詢完畢");
		return salesItemCountList;
	}
}
