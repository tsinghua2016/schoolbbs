package model;

import java.sql.Timestamp;
import java.util.List;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;

/**
 * A data access object (DAO) providing persistence and search support for
 * Uploadfiles entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see model.Uploadfiles
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class UploadfilesDAO {
	private static final Logger log = LoggerFactory
			.getLogger(UploadfilesDAO.class);
	// property constants
	public static final String FILENAME = "filename";

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

	public void save(Uploadfiles transientInstance) {
		log.debug("saving Uploadfiles instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Uploadfiles persistentInstance) {
		log.debug("deleting Uploadfiles instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Uploadfiles findById(java.lang.Integer id) {
		log.debug("getting Uploadfiles instance with id: " + id);
		try {
			Uploadfiles instance = (Uploadfiles) getCurrentSession().get(
					"model.Uploadfiles", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Uploadfiles> findByExample(Uploadfiles instance) {
		log.debug("finding Uploadfiles instance by example");
		try {
			List<Uploadfiles> results = (List<Uploadfiles>) getCurrentSession()
					.createCriteria("model.Uploadfiles").add(create(instance))
					.list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Uploadfiles instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Uploadfiles as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Uploadfiles> findByFilename(Object filename) {
		return findByProperty(FILENAME, filename);
	}

	public List findAll() {
		log.debug("finding all Uploadfiles instances");
		try {
			String queryString = "from Uploadfiles";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Uploadfiles merge(Uploadfiles detachedInstance) {
		log.debug("merging Uploadfiles instance");
		try {
			Uploadfiles result = (Uploadfiles) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Uploadfiles instance) {
		log.debug("attaching dirty Uploadfiles instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Uploadfiles instance) {
		log.debug("attaching clean Uploadfiles instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static UploadfilesDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (UploadfilesDAO) ctx.getBean("UploadfilesDAO");
	}
}