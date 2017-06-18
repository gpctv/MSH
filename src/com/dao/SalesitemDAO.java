package com.dao;

import java.math.BigDecimal;
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
 * Salesitem entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.dao.Salesitem
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class SalesitemDAO {
	private static final Logger log = LoggerFactory
			.getLogger(SalesitemDAO.class);
	// property constants
	public static final String ID_SALESITEM = "idSalesitem";
	public static final String ITEM_SALESITEM = "itemSalesitem";
	public static final String COUNT_SALESITEM = "countSalesitem";

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

	public void save(Salesitem transientInstance) {
		log.debug("saving Salesitem instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Salesitem persistentInstance) {
		log.debug("deleting Salesitem instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Salesitem findById(java.lang.String id) {
		log.debug("getting Salesitem instance with id: " + id);
		try {
			Salesitem instance = (Salesitem) getCurrentSession().get(
					"com.dao.Salesitem", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Salesitem instance) {
		log.debug("finding Salesitem instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("com.dao.Salesitem")
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
		log.debug("finding Salesitem instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Salesitem as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByIdSalesitem(Object idSalesitem) {
		return findByProperty(ID_SALESITEM, idSalesitem);
	}

	public List findByItemSalesitem(Object itemSalesitem) {
		return findByProperty(ITEM_SALESITEM, itemSalesitem);
	}

	public List findByCountSalesitem(Object countSalesitem) {
		return findByProperty(COUNT_SALESITEM, countSalesitem);
	}

	public List findAll() {
		log.debug("finding all Salesitem instances");
		try {
			String queryString = "from Salesitem";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Salesitem merge(Salesitem detachedInstance) {
		log.debug("merging Salesitem instance");
		try {
			Salesitem result = (Salesitem) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Salesitem instance) {
		log.debug("attaching dirty Salesitem instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Salesitem instance) {
		log.debug("attaching clean Salesitem instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static SalesitemDAO getFromApplicationContext(ApplicationContext ctx) {
		return (SalesitemDAO) ctx.getBean("SalesitemDAO");
	}
}