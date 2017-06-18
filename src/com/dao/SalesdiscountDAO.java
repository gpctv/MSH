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
 * Salesdiscount entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.dao.Salesdiscount
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class SalesdiscountDAO {
	private static final Logger log = LoggerFactory
			.getLogger(SalesdiscountDAO.class);
	// property constants
	public static final String NAME_SALESDISCOUNT = "nameSalesdiscount";
	public static final String AMOUNT_SALESDISCOUNT = "amountSalesdiscount";

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

	public void save(Salesdiscount transientInstance) {
		log.debug("saving Salesdiscount instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Salesdiscount persistentInstance) {
		log.debug("deleting Salesdiscount instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Salesdiscount findById(java.lang.String id) {
		log.debug("getting Salesdiscount instance with id: " + id);
		try {
			Salesdiscount instance = (Salesdiscount) getCurrentSession().get(
					"com.dao.Salesdiscount", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Salesdiscount instance) {
		log.debug("finding Salesdiscount instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("com.dao.Salesdiscount")
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
		log.debug("finding Salesdiscount instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Salesdiscount as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByNameSalesdiscount(Object nameSalesdiscount) {
		return findByProperty(NAME_SALESDISCOUNT, nameSalesdiscount);
	}

	public List findByAmountSalesdiscount(Object amountSalesdiscount) {
		return findByProperty(AMOUNT_SALESDISCOUNT, amountSalesdiscount);
	}

	public List findAll() {
		log.debug("finding all Salesdiscount instances");
		try {
			String queryString = "from Salesdiscount";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Salesdiscount merge(Salesdiscount detachedInstance) {
		log.debug("merging Salesdiscount instance");
		try {
			Salesdiscount result = (Salesdiscount) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Salesdiscount instance) {
		log.debug("attaching dirty Salesdiscount instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Salesdiscount instance) {
		log.debug("attaching clean Salesdiscount instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static SalesdiscountDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (SalesdiscountDAO) ctx.getBean("SalesdiscountDAO");
	}
}