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
 * A data access object (DAO) providing persistence and search support for Topic
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see model.Topic
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class TopicDAO {
	private static final Logger log = LoggerFactory.getLogger(TopicDAO.class);
	// property constants
	public static final String UID = "uid";
	public static final String TITLE = "title";
	public static final String DETAIL = "detail";
	public static final String REPLY = "reply";
	public static final String ID="id";
	public static final String DATE="date";
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

	public void save(Topic transientInstance) {
		log.debug("saving Topic instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Topic persistentInstance) {
		log.debug("deleting Topic instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Topic findById(java.lang.Integer id) {
		log.debug("getting Topic instance with id: " + id);
		try {
			Topic instance = (Topic) getCurrentSession().get("model.Topic", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Topic> findByExample(Topic instance) {
		log.debug("finding Topic instance by example");
		try {
			List<Topic> results = (List<Topic>) getCurrentSession()
					.createCriteria("model.Topic").add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Topic instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Topic as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Topic> findByUid(Object uid) {
		return findByProperty(UID, uid);
	}

	public List<Topic> findByTiltle(Object tiltle) {
		return findByProperty(TITLE, tiltle);
	}

	public List<Topic> findByDetail(Object detail) {
		return findByProperty(DETAIL, detail);
	}

	public List<Topic> findByReply(Object reply) {
		return findByProperty(REPLY, reply);
	}

	public List findAll() {
		log.debug("finding all Topic instances");
		try {
			String queryString = "from Topic";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Topic merge(Topic detachedInstance) {
		log.debug("merging Topic instance");
		try {
			Topic result = (Topic) getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Topic instance) {
		log.debug("attaching dirty Topic instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Topic instance) {
		log.debug("attaching clean Topic instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TopicDAO getFromApplicationContext(ApplicationContext ctx) {
		return (TopicDAO) ctx.getBean("TopicDAO");
	}

	public List findNew(int start, int top) {

		try {
				String queryString =null;
			
			if(start<=0)
			{
		
					queryString = "from Topic as model where model."
							+ID+" > ? order by "+DATE+" DESC ";
					start=0;
			}
			else
			{
				queryString = "from Topic as model where model."
						+ID+" < ? order by "+DATE+" DESC ";
			}
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, start);
			
			queryObject.setMaxResults(top);
			return queryObject.list();
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public List<Topic> search(int start, int top, String msg) {
		// TODO Auto-generated method stub
		//msg="\'"+msg+"\'";
		try {
		
			String queryString =null;
			if(start<=0)
			{
		
					queryString = "from Topic as model where model."
							+ID+" > ? and model."+TITLE+" like ? order by "+DATE+" DESC ";
					start=0;
			}
			else
			{
				queryString = "from Topic as model where model."
						+ID+" < ? and model."+TITLE+" like ? order by "+DATE+" DESC ";
			}
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, start);
			queryObject.setParameter(1, msg);
			queryObject.setMaxResults(top);
			return queryObject.list();
		} catch (RuntimeException re) {
			throw re;
		}
	}
	

	
}