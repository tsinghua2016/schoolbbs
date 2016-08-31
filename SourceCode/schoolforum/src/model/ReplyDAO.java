package model;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import static org.hibernate.criterion.Example.create;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import constant.Constant;

/**
 * A data access object (DAO) providing persistence and search support for Reply
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see model.Reply
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class ReplyDAO {
	private static final Logger log = LoggerFactory.getLogger(ReplyDAO.class);
	// property constants
	public static final String UID = "uid";
	public static final String QID = "qid";
	public static final String REPLYMSG = "replymsg";
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

	public void save(Reply transientInstance) {
		log.debug("saving Reply instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Reply persistentInstance) {
		log.debug("deleting Reply instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Reply findById(java.lang.Integer id) {
		log.debug("getting Reply instance with id: " + id);
		try {
			Reply instance = (Reply) getCurrentSession().get("model.Reply", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Reply> findByExample(Reply instance) {
		log.debug("finding Reply instance by example");
		try {
			List<Reply> results = (List<Reply>) getCurrentSession()
					.createCriteria("model.Reply").add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findDetail(int start, int top,int qid) {

		try {
				String queryString =null;
			
			if(start<=0)
			{
		
					queryString = "from Reply as model where model."
							+ID+" > ? and model."+QID+ "= ? order by "+ID+" DESC ";
					start=0;
			}
			else
			{
				queryString = "from Reply as model where model."
						+ID+" < ? and model."+QID+ "= ? order by "+ID+" DESC ";
			}
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, start);
			queryObject.setParameter(1, qid);
			queryObject.setMaxResults(top);
			return queryObject.list();
		} catch (RuntimeException re) {
			throw re;
		}
	}
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Reply instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Reply as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Reply> findByUid(Object uid) {
		return findByProperty(UID, uid);
	}

	public List<Reply> findByQid(Object qid) {
		return findByProperty(QID, qid);
	}

	public List<Reply> findByReplymsg(Object replymsg) {
		return findByProperty(REPLYMSG, replymsg);
	}

	public List findAll() {
		log.debug("finding all Reply instances");
		try {
			String queryString = "from Reply";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Reply merge(Reply detachedInstance) {
		log.debug("merging Reply instance");
		try {
			Reply result = (Reply) getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Reply instance) {
		log.debug("attaching dirty Reply instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Reply instance) {
		log.debug("attaching clean Reply instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ReplyDAO getFromApplicationContext(ApplicationContext ctx) {
		return (ReplyDAO) ctx.getBean("ReplyDAO");
	}
	public int findNotRead(Integer uid) {
		List list= Listfind(uid,false);
		if (list!=null) return list.size();
		return 0;
	}
	
	public List Listfind(Integer uid,boolean all)
	{
		try {
			String sql="select id  from Topic   where uid="+uid;
			SQLQuery query = getCurrentSession().createSQLQuery(sql);  
			List<Integer> idlist=query.list();
			String temp="";
			for(int i=0;i<(idlist.size()-1);i++)
				temp=temp+idlist.get(i)+",";
			if(idlist.size()>1)
			{
				temp=temp+idlist.get(idlist.size()-1);
				temp='('+temp+')'+"and r.uid!="+uid;
				String  queryString ="from Reply as r  where r.qid in "+temp;
				Query queryObject=null;
				if(!all) { 
					queryString= queryString+"and isread=0";
					queryObject = getCurrentSession().createQuery(queryString);
				}
				else
				{
					Calendar ca = Calendar.getInstance();
					ca.add(Calendar.DATE,Constant.timedelta);
					Date date = ca.getTime();
					queryString=queryString+"and (r.date> :stime or isread=0)";
					queryObject = getCurrentSession().createQuery(queryString).setDate("stime", date);
				}
				return queryObject.list();
			}
			return null;
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List findAllMsg(Integer uid) {
		return Listfind(uid,true);
	}
	public void setRead(Integer uid)
	{
		List<Reply> list=Listfind(uid,false);
		if(list!=null)
		{
			for(Reply temp:list)
			{
				temp.setIsread(1);
				save(temp);
			}
		}
	}
}