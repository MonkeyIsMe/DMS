package com.dms.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.dms.dao.TeacherDAO;
import com.dms.model.Teacher;
import com.dms.util.HibernateUtil;

public class TeacherImpl implements TeacherDAO{

	@Override
	public boolean add(Teacher teacher) {
		// TODO Auto-generated method stub
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		
		try {
			session.beginTransaction();
			session.save(teacher);
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
	public boolean update(Teacher teacher) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		try {
			session.beginTransaction();
			session.update(teacher);
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
	public Teacher query(String id) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Teacher result = null;
		try {
			session.beginTransaction();
			result = session.get(Teacher.class, id);
			session.getTransaction().commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return result;
		}
		return result;
	}

	@Override
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		try {
			session.beginTransaction();
			Teacher teacher = session.get(Teacher.class, id);
			session.delete(teacher);
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
