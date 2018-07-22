package com.dms.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.dms.dao.StrangerDAO;
import com.dms.model.Stranger;
import com.dms.util.HibernateUtil;

public class StrangerImpl implements StrangerDAO{

	@Override
	public Stranger query(String id) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Stranger st = null;
		try {
			session.beginTransaction();
			//st = session.get(Stranger.class, id);
			String hql = " from Stranger where st_id =:st_id";
			 Query query = session.createQuery(hql);
			 query.setParameter("st_id", id);
			 st = (Stranger) query.uniqueResult();
			session.getTransaction().commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return st;
	}

	@Override
	public boolean add(Stranger stranger) {
		// TODO Auto-generated method stub
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		
		try {
			session.beginTransaction();
			session.save(stranger);
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
	public List<Stranger> querySt() {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		
		List<Stranger> st = null;
		
		try {
			session.beginTransaction();
			String hql = "from Stranger";
			Query query = session.createQuery(hql);
			st = query.list();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return st;
		}
		
		return st;
	}

}
