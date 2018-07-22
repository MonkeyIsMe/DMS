package com.dms.impl;

import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.dms.dao.FixDAO;
import com.dms.model.Fix;
import com.dms.util.HibernateUtil;

public class FixImpl implements FixDAO{

	//申请一个维修的服务
	@Override
	public boolean add(Fix fix) {
		// TODO Auto-generated method stub
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		
		try {
			session.beginTransaction();
			session.save(fix);
			session.getTransaction().commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			session.getTransaction().rollback();
			return false;
		}
		
		return true;
	}
	
	
	//查询维修服务
	@Override
	public List<Fix> getFixInformation() {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		List<Fix> result = null;
		try {
			session.beginTransaction();
			String hql = "from Fix";
			Query query = session.createQuery(hql);
			result = query.list();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return result;
		}
		return result;
	}


	@Override
	public Fix query(String id) {
		// TODO Auto-generated method stub
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		
		Fix fix = null;
		
		try {
			session.beginTransaction();
			Long num = Long.parseLong(id);
			String hql = "from Fix where fix_id = :fix_id";
			Query query = session.createQuery(hql);
			query.setParameter("fix_id", num);
			fix = (Fix) query.uniqueResult();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return fix;
		}
		
		return fix;
	}


	@Override
	public boolean update(Fix fix) {
		// TODO Auto-generated method stub
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		
		try {
			session.beginTransaction();
			session.update(fix);
			session.getTransaction().commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			session.getTransaction().rollback();
			return false;
		}
		return true;
	}


	@Override
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		
		try {
			session.beginTransaction();
			Long num = Long.parseLong(id);
			Fix fix = session.get(Fix.class, num);
			session.delete(fix);
			session.getTransaction().commit();	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			session.getTransaction().rollback();
			return false;
		}
		
		return true;
	}

}
