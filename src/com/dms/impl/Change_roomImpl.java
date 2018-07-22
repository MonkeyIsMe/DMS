package com.dms.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.dms.dao.Change_RoomDAO;
import com.dms.model.Change_room;
import com.dms.model.Fix;
import com.dms.util.HibernateUtil;

public class Change_roomImpl implements Change_RoomDAO{

	@Override
	public List<Change_room> change() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		List<Change_room> result = null;
		try {
			session.beginTransaction();
			String hql = "from Change_room";
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
	public boolean add(Change_room change) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		try {
			session.beginTransaction();
			session.save(change);
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
	public Change_room query(String id) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		
		Change_room room = null;
		
		try {
			session.beginTransaction();
			Long num = Long.parseLong(id);
			String hql = " from Change_room where apart_id = :apart_id";
			Query query = session.createQuery(hql);
			query.setParameter("apart_id", num);
			room = (Change_room) query.uniqueResult();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return room;
		}
		
		return room;
	}

	@Override
	public boolean Update(Change_room room) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		
		
		try {
			session.beginTransaction();
			session.update(room);
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
			Change_room change = session.get(Change_room.class, num);
			session.delete(change);
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
