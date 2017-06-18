package com.dao;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.msh.model.PoskeyBean;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;

@Transactional
public class PoskeyDAO {
	private static final Logger log = LoggerFactory.getLogger(PoskeyDAO.class);
	private SessionFactory sessionFactory;
	private final String poskey="poskey";
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	/**
	 * get all db item union discount
	 * @return
	 */
	public HashMap<String,PoskeyBean> getAll(){
		Query query =sessionFactory.getCurrentSession()
				.getNamedQuery("item.query.itemUnionDiscount");
		List<Object[]> poskeyBeanList=query.list();
		HashMap<String,PoskeyBean> poskeyList=new HashMap<String,PoskeyBean>();
		for(Object o[] :poskeyBeanList){
			PoskeyBean poskeyBean=new PoskeyBean();
			poskeyBean.setDiscount(new BigDecimal(o[2].toString()));
			if("1".equals(o[4].toString())){
				poskeyBean.setEnable(true);
			}else{
				poskeyBean.setEnable(false);
			}
			poskeyBean.setSelfId(Long.valueOf(o[5].toString()));
			poskeyBean.setId(o[6].toString());
			poskeyBean.setSales(new BigDecimal(o[3].toString())); 
			poskeyBean.setTitle(o[0].toString());
			poskeyBean.setType(o[1].toString());
			poskeyList.put (poskeyBean.getId(),poskeyBean);
		}
		return poskeyList;
		
	}
	/**
	 * 獲取POSKEY ID 最大值
	 * @param poskey
	 * @return
	 */
	public Long getMax(PoskeyBean poskey){
		if(this.poskey.equals(poskey.getType())){
			Query query =sessionFactory.getCurrentSession()
					.getNamedQuery("item.query.max");
			String max=query.uniqueResult().toString();
			Long foodMaxId=Long.valueOf(max);
			return foodMaxId;
		}else{
			Query query =sessionFactory.getCurrentSession()
					.getNamedQuery("discount.query.max");
			String max=query.uniqueResult().toString();
			Long DiscountMaxId=Long.valueOf(max);
			return DiscountMaxId;
		}
	}
	
	 
}
