package com.dao;

import java.util.List;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;

/**
 * A data access object (DAO) providing persistence and search support for
 * Salesless entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.dao.Salesless
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class SaleslessDAO {
	private static final Logger log = LoggerFactory
			.getLogger(SaleslessDAO.class);
	// property constants
	public static final String NAME_SALESLESS = "nameSalesless";
	public static final String AMOUNT_SALESLESS = "amountSalesless";

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	protected void initDao() {
		// do nothing
	}

	public void save(Salesless transientInstance) {
		log.debug("saving Salesless instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Salesless persistentInstance) {
		log.debug("deleting Salesless instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	 

	public List findByExample(Salesless instance) {
		log.debug("finding Salesless instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("com.dao.Salesless")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Salesless instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Salesless as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByNameSalesless(Object nameSalesless) {
		return findByProperty(NAME_SALESLESS, nameSalesless);
	}

	public List findByAmountSalesless(Object amountSalesless) {
		return findByProperty(AMOUNT_SALESLESS, amountSalesless);
	}

	public List findAll() {
		log.debug("finding all Salesless instances");
		try {
			String queryString = "from Salesless";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Salesless merge(Salesless detachedInstance) {
		log.debug("merging Salesless instance");
		try {
			Salesless result = (Salesless) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Salesless instance) {
		log.debug("attaching dirty Salesless instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Salesless instance) {
		log.debug("attaching clean Salesless instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static SaleslessDAO getFromApplicationContext(ApplicationContext ctx) {
		return (SaleslessDAO) ctx.getBean("SaleslessDAO");
	}
}