package model;

import java.util.Calendar;
import java.util.Date;
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

import constant.Constant;

/**
 * A data access object (DAO) providing persistence and search support for Chat
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see model.Chat
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class ChatDAO {
	private static final Logger log = LoggerFactory.getLogger(ChatDAO.class);
	// property constants
	public static final String UID = "uid";
	public static final String QID = "qid";
	public static final String TOUID = "touid";
	public static final String MSG = "msg";
	public static final String ISREAD = "isread";

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

	public void save(Chat transientInstance) {
		log.debug("saving Chat instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Chat persistentInstance) {
		log.debug("deleting Chat instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Chat findById(java.lang.Integer id) {
		log.debug("getting Chat instance with id: " + id);
		try {
			Chat instance = (Chat) getCurrentSession().get("model.Chat", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Chat> findByExample(Chat instance) {
		log.debug("finding Chat instance by example");
		try {
			List<Chat> results = (List<Chat>) getCurrentSession()
					.createCriteria("model.Chat").add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Chat instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Chat as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findNotRead(Integer uid) {
		try {
			String queryString = "from Chat as model where model.touid=? and model.isread=0 and model.uid!=? ";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, uid);
			queryObject.setParameter(1, uid);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List findAllmsg(Integer uid) {
		try {
			Calendar ca = Calendar.getInstance();
			ca.add(Calendar.DATE, Constant.timedelta);
			Date date = ca.getTime();
			String queryString = "from Chat as model where model.touid=? and model.uid!=? and (model.chattime> :stime or isread=0)";
			Query queryObject = getCurrentSession().createQuery(queryString).setDate("stime", date);
			queryObject.setParameter(0, uid);
			queryObject.setParameter(1, uid);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	
	public void setRead(Integer uid)
	{
		List<Chat> list=findNotRead(uid);
		for(Chat temp:list)
		{
			temp.setIsread(1);
			save(temp);
		}
	}
	
	
	public List<Chat> findByUid(Object uid) {
		return findByProperty(UID, uid);
	}

	public List<Chat> findByQid(Object qid) {
		return findByProperty(QID, qid);
	}

	public List<Chat> findByTouid(Object touid) {
		return findByProperty(TOUID, touid);
	}

	public List<Chat> findByMsg(Object msg) {
		return findByProperty(MSG, msg);
	}

	public List<Chat> findByIsread(Object isread) {
		return findByProperty(ISREAD, isread);
	}

	public List findAll() {
		log.debug("finding all Chat instances");
		try {
			String queryString = "from Chat";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Chat merge(Chat detachedInstance) {
		log.debug("merging Chat instance");
		try {
			Chat result = (Chat) getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Chat instance) {
		log.debug("attaching dirty Chat instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Chat instance) {
		log.debug("attaching clean Chat instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ChatDAO getFromApplicationContext(ApplicationContext ctx) {
		return (ChatDAO) ctx.getBean("ChatDAO");
	}
}