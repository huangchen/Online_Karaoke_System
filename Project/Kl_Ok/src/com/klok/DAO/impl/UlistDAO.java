package com.klok.DAO.impl;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.klok.DAO.IUlistDAO;
import com.klok.entity.Ulist;

/**
 * A data access object (DAO) providing persistence and search support for Ulist
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.klok.entity.Ulist
 * @author MyEclipse Persistence Tools
 */

public class UlistDAO extends HibernateDaoSupport implements IUlistDAO {
	private static final Logger log = LoggerFactory.getLogger(UlistDAO.class);

	// property constants

	protected void initDao() {
		// do nothing
	}

	/* (non-Javadoc)
	 * @see com.klok.DAO.impl.IUlistDAO#save(com.klok.entity.Ulist)
	 */
	@Override
	public void save(Ulist transientInstance) {
		log.debug("saving Ulist instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.klok.DAO.impl.IUlistDAO#delete(com.klok.entity.Ulist)
	 */
	@Override
	public void delete(Ulist persistentInstance) {
		log.debug("deleting Ulist instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.klok.DAO.impl.IUlistDAO#findById(java.lang.Integer)
	 */
	@Override
	public Ulist findById(java.lang.Integer id) {
		log.debug("getting Ulist instance with id: " + id);
		try {
			Ulist instance = (Ulist) getHibernateTemplate().get(
					"com.klok.entity.Ulist", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.klok.DAO.impl.IUlistDAO#findByExample(com.klok.entity.Ulist)
	 */
	@Override
	public List findByExample(Ulist instance) {
		log.debug("finding Ulist instance by example");
		try {
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.klok.DAO.impl.IUlistDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
	@Override
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Ulist instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Ulist as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.klok.DAO.impl.IUlistDAO#findAll()
	 */
	@Override
	public List findAll() {
		log.debug("finding all Ulist instances");
		try {
			String queryString = "from Ulist";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.klok.DAO.impl.IUlistDAO#merge(com.klok.entity.Ulist)
	 */
	@Override
	public Ulist merge(Ulist detachedInstance) {
		log.debug("merging Ulist instance");
		try {
			Ulist result = (Ulist) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.klok.DAO.impl.IUlistDAO#attachDirty(com.klok.entity.Ulist)
	 */
	@Override
	public void attachDirty(Ulist instance) {
		log.debug("attaching dirty Ulist instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.klok.DAO.impl.IUlistDAO#attachClean(com.klok.entity.Ulist)
	 */
	@Override
	public void attachClean(Ulist instance) {
		log.debug("attaching clean Ulist instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static IUlistDAO getFromApplicationContext(ApplicationContext ctx) {
		return (IUlistDAO) ctx.getBean("UlistDAO");
	}
}