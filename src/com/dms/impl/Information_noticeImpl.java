package com.dms.impl;

import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.dms.dao.Information_noticeDAO;
import com.dms.model.Information_notice;
import com.dms.util.HibernateUtil;

public class Information_noticeImpl implements Information_noticeDAO{

	@Override
	public boolean add(Information_notice information) {
		// TODO Auto-generated method stub
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		
		try {
			session.beginTransaction();
			session.save(information);
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
	public List<Information_notice> getInformationnotice() {
		// TODO Auto-generated method stub
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		List<Information_notice> result = null;
		
		try {
			session.beginTransaction();
			String hql = "from Information_notice";
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
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Information_notice in = null;
		try {
			Long num = Long.parseLong(id);
			session.beginTransaction();
			in = session.get(Information_notice.class, num);
			session.delete(in);
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
	public Information_notice query(String id) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Information_notice in = null;
		
		try {
			Long num = Long.parseLong(id);
			session.beginTransaction();
			in = session.get(Information_notice.class, num);
			session.getTransaction().commit();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			session.getTransaction().rollback();
			return in;
		}
		
		return in;
	}


}
