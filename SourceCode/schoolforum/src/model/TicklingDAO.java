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
 * Tickling entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see model.Tickling
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class TicklingDAO {
	private static final Logger log = LoggerFactory
			.getLogger(TicklingDAO.class);
	// property constants
	public static final String MSG = "msg";
	public static final String ISREAD = "isread";
	public static final String ID="id";

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

	public void save(Tickling transientInstance) {
		log.debug("saving Tickling instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Tickling persistentInstance) {
		log.debug("deleting Tickling instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Tickling findById(java.lang.Integer id) {
		log.debug("getting Tickling instance with id: " + id);
		try {
			Tickling instance = (Tickling) getCurrentSession().get(
					"model.Tickling", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Tickling> findByExample(Tickling instance) {
		log.debug("finding Tickling instance by example");
		try {
			List<Tickling> results = (List<Tickling>) getCurrentSession()
					.createCriteria("model.Tickling").add(create(instance))
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
		log.debug("finding Tickling instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Tickling as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Tickling> findByMsg(Object msg) {
		return findByProperty(MSG, msg);
	}

	public List<Tickling> findByIsread(Object isread) {
		return findByProperty(ISREAD, isread);
	}

	public List findAll() {
		log.debug("finding all Tickling instances");
		try {
			String queryString = "from Tickling";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Tickling merge(Tickling detachedInstance) {
		log.debug("merging Tickling instance");
		try {
			Tickling result = (Tickling) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Tickling instance) {
		log.debug("attaching dirty Tickling instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Tickling instance) {
		log.debug("attaching clean Tickling instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TicklingDAO getFromApplicationContext(ApplicationContext ctx) {
		return (TicklingDAO) ctx.getBean("TicklingDAO");
	}
	public List findNew(int start) {

		try {
				String queryString =null;
			
			if(start<=0)
			{
		
					queryString = "from Tickling as model where model."
							+ID+" > ?  and "+ISREAD+"=0 order by "+ID+" DESC ";
					start=0;
			}
			else
			{
				queryString = "from Tickling as model where model."
						+ID+" < ?  and "+ISREAD+"=0 order by "+ID+" DESC ";
			}
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, start);
			return queryObject.list();
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public void update(int end) {


		try {
				String queryString =null;
				
	   queryString = "update Tickling as model set "+ISREAD+"=1  where model."
							+ID+" <= ?  ";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, end);
			queryObject.executeUpdate();
			
		} catch (RuntimeException re) {
			throw re;
		}
	}

}