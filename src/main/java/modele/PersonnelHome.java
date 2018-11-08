package modele;

// Generated 4 mai 2018 12:40:53 by Hibernate Tools 3.4.0.CR1

import static org.hibernate.criterion.Example.create;

import java.util.List;

import javax.naming.InitialContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import entities.Personnel;
//deuxieme modification effectuer par ousseynou

/**
 * Home object for domain model class Personnel.
 * @see entities.Personnel
 * @author Hibernate Tools
 */
public class PersonnelHome {

	private static final Log log = LogFactory.getLog(PersonnelHome.class);

	private static  final SessionFactory sessionFactory = getSessionFactory();

	protected static  SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext()
					.lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException(
					"Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Personnel transientInstance) {
		log.debug("persisting Personnel instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Personnel instance) {
		log.debug("attaching dirty Personnel instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Personnel instance) {
		log.debug("attaching clean Personnel instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Personnel persistentInstance) {
		log.debug("deleting Personnel instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Personnel merge(Personnel detachedInstance) {
		log.debug("merging Personnel instance");
		try {
			Personnel result = (Personnel) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Personnel findById(java.lang.String id) {
		log.debug("getting Personnel instance with id: " + id);
		try {
			Personnel instance = (Personnel) sessionFactory.getCurrentSession()
					.get("entities.Personnel", id);
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Personnel> findByExample(Personnel instance) {
		log.debug("finding Personnel instance by example");
		try {
			@SuppressWarnings({ "deprecation", "unchecked" })
			List<Personnel> results = (List<Personnel>) sessionFactory
					.getCurrentSession().createCriteria("entities.Personnel")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	public static Personnel connexion(String username, String password)
	{
		Session ss=sessionFactory.openSession();
		Criteria cr=ss.createCriteria(Personnel.class);
		cr.add(Restrictions.eq("login", username));
		cr.add(Restrictions.eq("password", password));
		Personnel pers=(Personnel)cr.uniqueResult();
		
		ss.close();
		
		return pers;
	}
}
