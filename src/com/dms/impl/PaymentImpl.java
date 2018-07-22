package com.dms.impl;

import org.hibernate.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.dms.dao.PaymentDAO;
import com.dms.model.Payment;
import com.dms.model.Student;
import com.dms.util.HibernateUtil;

public class PaymentImpl implements PaymentDAO{

	@Override
	public boolean add(Payment payment) {
		// TODO Auto-generated method stub
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		
		try {
			session.beginTransaction();
			session.save(payment);
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
	public Payment query(String id) {
		// TODO Auto-generated method stub
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Payment result = null;
		
		try {
			session.beginTransaction();
			String hql = "from Payment where pay_room_id = :pay_room_id";
			Query query = session.createQuery(hql);
			query.setParameter("pay_room_id", id);
			result = (Payment) query.uniqueResult();
			//session.beginTransaction();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return result;
		}
		
		return result;
	}

	@Override
	public boolean update(Payment payment) {
		// TODO Auto-generated method stub
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		
		try {
			session.beginTransaction();
			session.update(payment);
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
		Payment result = null;
		
		try {
			Long num = Long.parseLong(id);
			session.beginTransaction();
			result = session.get(Payment.class, num);
			session.delete(result);
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
