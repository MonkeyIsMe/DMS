package com.dms.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.dms.dao.StudentDAO;
import com.dms.model.Room;
import com.dms.model.Student;
import com.dms.util.HibernateUtil;

public class StudentImpl implements StudentDAO{

	//添加一个学生信息
	@Override
	public boolean add(Student student) {
		// TODO Auto-generated method stub
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		
		try {
			session.beginTransaction();
			session.save(student);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			session.getTransaction().rollback();
			return false;
		}finally {
			sessionFactory.close();
		}
		
		return true;
	}

	//查询一个学生信息
	@Override
	public Student query(String id) {
		// TODO Auto-generated method stub
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Student result = null;
		try {
			session.beginTransaction();
			result = session.get(Student.class, id);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return result;
		}
		
		return result;
	}

	//更新一个学生信息
	@Override
	public boolean update(Student student) {
		// TODO Auto-generated method stub
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		
		try {
			session.beginTransaction();
			session.update(student);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			session.getTransaction().rollback();
			return false;
		}
		
		return true;
	}

	@Override
	public boolean delete(String id) {
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		
		try {
			session.beginTransaction();
			Student stu = session.get(Student.class, id);
			session.delete(stu);
			session.getTransaction().commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			session.getTransaction().rollback();
			return false;
		}
		
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean update1(String id,String room_id,Room room) {
		// TODO Auto-generated method stub
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		
		try {
			session.beginTransaction();
			Student stu = session.get(Student.class, id);
			stu.setStu_room_id(room_id);
			stu.setRoom(room);
			session.update(stu);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			session.getTransaction().rollback();
			return false;
		}
		
		return true;
	}

	@Override
	public List<Student> getStudent(String id) {
		// TODO Auto-generated method stub
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		
		List<Student> stu = null;
		
		try {
			session.beginTransaction();
			String hql = "from Student where stu_in_time = :stu_in_time";
			Query query = session.createQuery(hql);
			query.setParameter("stu_in_time", id);
			stu = query.list();
			session.getTransaction().commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stu;
	}

	@Override
	public List<Student> UpdatePwd() {
		// TODO Auto-generated method stub
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		
		List<Student> stu = null;
		
		try {
			session.beginTransaction();
			String hql = "from Student";
			Query query = session.createQuery(hql);
			stu = query.list();
			session.getTransaction().commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return stu;
	}
	
}
