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
 * Notice entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see model.Notice
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class NoticeDAO {
	private static final Logger log = LoggerFactory.getLogger(NoticeDAO.class);
	// property constants
	public static final String TITLE = "title";
	public static final String CONTENT = "content";
	public static final String ID = "id";

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

	public void save(Notice transientInstance) {
		log.debug("saving Notice instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Notice persistentInstance) {
		log.debug("deleting Notice instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Notice findById(java.lang.Integer id) {
		log.debug("getting Notice instance with id: " + id);
		try {
			Notice instance = (Notice) getCurrentSession().get("model.Notice",
					id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Notice> findByExample(Notice instance) {
		log.debug("finding Notice instance by example");
		try {
			List<Notice> results = (List<Notice>) getCurrentSession()
					.createCriteria("model.Notice").add(create(instance))
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
		log.debug("finding Notice instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Notice as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List findNew(int start, int top) {

		try {
				String queryString =null;
			
			if(start<=0)
			{
		
					queryString = "from Notice as model where model."
							+ID+" > ? "+ "order by "+ID+" DESC ";
					start=0;
			}
			else
			{
				queryString = "from Notice as model where model."
						+ID+" < ? "+ "order by "+ID+" DESC ";
			}
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, start);
			
			queryObject.setMaxResults(top);
			return queryObject.list();
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	

	public List<Notice> findByTitle(Object title) {
		return findByProperty(TITLE, title);
	}

	public List<Notice> findByContent(Object content) {
		return findByProperty(CONTENT, content);
	}



	public List findAll() {
		log.debug("finding all Notice instances");
		try {
			String queryString = "from Notice";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Notice merge(Notice detachedInstance) {
		log.debug("merging Notice instance");
		try {
			Notice result = (Notice) getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Notice instance) {
		log.debug("attaching dirty Notice instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Notice instance) {
		log.debug("attaching clean Notice instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static NoticeDAO getFromApplicationContext(ApplicationContext ctx) {
		return (NoticeDAO) ctx.getBean("NoticeDAO");
	}
}