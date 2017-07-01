package com.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
@Transactional
public class TransCustomDAO {
	private static final Logger log = LoggerFactory.getLogger(TransDAO.class);
	// property constants

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public HashMap<String,Trans> getTrans(String sDate,String eDate){
		HashMap<String,Trans> transList=new HashMap<String,Trans>();
		Query query =this.sessionFactory.getCurrentSession()
				.getNamedQuery("trans.query.range");
		query.setParameter("sDate", sDate);
		query.setParameter("eDate", eDate);
		Iterator iter=query.list().iterator();
		while(iter.hasNext()){
			Trans trans=(Trans)iter.next();
			transList.put(trans.getReceiptnoTrans(), trans);
		}
		return transList;
	}
}
