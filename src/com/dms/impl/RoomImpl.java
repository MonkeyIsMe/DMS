package com.dms.impl;

import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.dms.dao.RoomDAO;
import com.dms.model.Change_room;
import com.dms.model.Room;
import com.dms.model.Student;
import com.dms.util.HibernateUtil;

public class RoomImpl implements RoomDAO{




	//选宿舍
	@Override
	public boolean add(Room room) {
		// TODO Auto-generated method stub
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		
		try {
			session.beginTransaction();
			session.save(room);
			session.getTransaction().commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			session.getTransaction().rollback();
			return false;
		}
		return true;
	}

	//查询宿舍是不是满了
	@Override
	public boolean queryfull(String id) {
		// TODO Auto-generated method stub
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		String flag;
		Room room = null;
		try {
			session.beginTransaction();
			room = session.get(Room.class, id);
			flag = room.getRoom_flag();
			session.getTransaction().commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			session.getTransaction().rollback();
			return false;
		}
		if(flag.equals("0")==true) return false;
		else return true;
	}


	//更新一个房间信息
	@Override
	public boolean update(Room room) {
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

	//查询一个宿舍的情况
	@Override
	public Room query(String id) {
		// TODO Auto-generated method stub
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		
		Room result = null;
		
		try {
			session.beginTransaction();
			result = session.get(Room.class, id);
			session.getTransaction().commit();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return result;
		}
		
		 return result;
	}

	@Override
	public Set<Student> getRooms(String id) {
		// TODO Auto-generated method stub
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		
		Set<Student> stu = null;
		
		try {
			session.beginTransaction();
			Room room = session.get(Room.class, id);
			stu = room.getStudents();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return stu;
		}
		
		return stu;
	}

	@Override
	public List<Room> queryEmpty() {
		// TODO Auto-generated method stub
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		
		List<Room> result = null;
		
		try {
			session.beginTransaction();
			String hql = "from Room";
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
		return false;
	}

	@Override
	public boolean addroom(Room room) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		try {
			session.beginTransaction();
			session.save(room);
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
