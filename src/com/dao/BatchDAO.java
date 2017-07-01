package com.dao;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import com.msh.model.LessBean;

public class BatchDAO {
	private static final Logger log = LoggerFactory
			.getLogger(BatchDAO.class);
	private SessionFactory sessionFactory;
	private Session session;
	private Transaction tx;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		
	} 
	private void turnSession(){
		this.session=sessionFactory.openSession();
		 tx = session.beginTransaction();
	}
	@Transactional
	public void save(List <Salesitem> salesItemList,
			List <Salesdiscount> discountList,
			List <Salesless> lessList,Trans trans){
		turnSession();
		try{
			if(!salesItemList.isEmpty()){
				for(Salesitem i:salesItemList){
					session.save(i);
				}
				session.flush();
		        session.clear();
			}
			if(!discountList.isEmpty()){
				for(Salesdiscount d:discountList){
		        	session.save(d);
		        }
		        session.flush();
		        session.clear();
			}
	        if(!lessList.isEmpty()){
	        	BigDecimal count=new BigDecimal("0");
	        	for(Salesless l:lessList){
	        		count=count.add(new BigDecimal("1"));
	        	l.setIdSalesless(count);
	            	 session.save(l);
	        	}
	            session.flush();
	            session.clear();
	        }
	        session.save(trans);
	        session.flush();
	        session.clear();
		}catch(Exception e){
			log.error("batchDAO",e.getMessage(),e);
		}finally{
			
	        tx.commit();
	        session.close();
		}
		
        
	}
}
