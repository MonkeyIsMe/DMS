package com.dms.test;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;

import com.dms.dao.FixDAO;
import com.dms.dao.Information_noticeDAO;
import com.dms.dao.PaymentDAO;
import com.dms.dao.RoomDAO;
import com.dms.dao.StrangerDAO;
import com.dms.dao.StudentDAO;
import com.dms.dao.TeacherDAO;
import com.dms.impl.FixImpl;
import com.dms.impl.Information_noticeImpl;
import com.dms.impl.PaymentImpl;
import com.dms.impl.RoomImpl;
import com.dms.impl.StrangerImpl;
import com.dms.impl.StudentImpl;
import com.dms.impl.TeacherImpl;
import com.dms.model.Change_room;
import com.dms.model.Fix;
import com.dms.model.Information_notice;
import com.dms.model.Payment;
import com.dms.model.Room;
import com.dms.model.Stranger;
import com.dms.model.Student;
import com.dms.model.Teacher;
import com.dms.util.HibernateUtil;
import com.dms.util.MD5;



public class DemoTest {

	
	@Test
	public void TestInformation_notice() {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		
//		Information_notice in = new Information_notice();
//		in.setInfor_description("4");
//		in.setInfor_name("4");
//		in.setInfor_flag("2");
//		s.save(in);
		String hql = "from Information_notice";
		Query query = s.createQuery(hql);
		List<Information_notice> in = query.list();
		  for(Information_notice ins : in){   
	            System.out.println(ins.getInfor_id()+":"+ins.getInfor_flag()+":"+ins.getInfor_description());   
	        }   
		
		s.getTransaction().commit();
		
	}
	
	
	@Test
	public void TestStranger() {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		
		Stranger st = new Stranger();
		st.setSt_name("王硕");
		st.setSt_id("45645645645646");
		st.setSt_to_room("J7-442");
		st.setSt_to_name("刘青松");
		st.setSt_telephone("123123123");
		st.setSt_reason("爱上大四爱搜");
		st.setSt_people_num("2");
		st.setSt_date("2018年4月21日");
		
		s.save(st);
		s.getTransaction().commit();
		
		
	}
	
	@Test
	public void TestFix() {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		
//		Information_notice in = new Information_notice();
//		in.setInfor_description("4");
//		in.setInfor_name("4");
//		in.setInfor_flag("2");
//		s.save(in);
		String hql = "from Fix";
		Query query = s.createQuery(hql);
		List<Fix> fixs = query.list();
		  for(Fix fix : fixs){   
	            System.out.println(fix.getFix_stu_id()+"  ++  "+fix.getFix_reason());   
	        }   
		
		s.getTransaction().commit();
		
	}
	
	@Test
	public void TestChangeFind() {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		Long num = 3L;
		String hql = " from Change_room where apart_id = :apart_id";
		Query query = s.createQuery(hql);
		query.setParameter("apart_id", num);
		Change_room room = (Change_room) query.uniqueResult();
		System.out.println(room.toString());
		s.getTransaction().commit();
		
	}
	

	
	@Test
	public void TestQueryTask() {
		String stu_id = "2014551624";
		StudentDAO std = new StudentImpl();
		Student stu = std.query(stu_id);
		System.out.println(stu.toString());
		String Room_id = stu.getStu_room_id();
		RoomDAO rd = new RoomImpl();
		Room room = rd.query(Room_id);
		String task = room.getApart_task();
		
		System.out.println(task);
		
	}
	
	@Test
	public void deletefix() {
		String id = "1";
		FixDAO fd = new FixImpl();
		Fix fix = fd.query(id);
		if(fd.delete(id)){
			System.out.println(11);
		}
		
	}
	

	@Test
	public void Change() {
		String id = "1";
		FixDAO fd = new FixImpl();
		Fix fix = fd.query(id);
		if(fd.delete(id)){
			System.out.println(11);
		}
		
	}
	
	@Test
	public void Testadd() {
		String room_id = "J9-112";
		String description = "Q15-503";
		String money = "123";
		String body = "132";
			Long num =(long) ((Math.random()*9+1)*10000000);
			PaymentDAO pd = new PaymentImpl();
			Payment pay = new Payment();
			Payment payment = pd.query(room_id);
			System.out.println(pay);
			//System.out.println(pay.toJSON());
			if( payment == null) {
				pay.setPay_cnt(num);
				pay.setPay_description(description);
				pay.setPay_money(money);
				pay.setPay_room_id(room_id);
				pay.setPay_body(body);
				if(pd.add(pay)){
					System.out.println("SUCCESS");
				}
				else System.out.print("FAIL");
			}
			else {
				String cnt = pay.getPay_money(); //查找已有金额
				Long num1 = Long.parseLong(cnt);
				Long num2 = Long.parseLong(money);
				Long sum = num1 + num2;
				String new_money = sum.toString();
				pay.setPay_cnt(num);
				payment.setPay_description(description);
				payment.setPay_money(new_money);
				payment.setPay_room_id(room_id);
				payment.setPay_body(body);
				pd.update(pay);
				
			}
	}
	

	
	@Test
	public void Testdelete() {
		String room = "3";
		PaymentDAO pd = new PaymentImpl();
		Payment pay = new Payment();
		if(pd.delete(room))System.out.println(11);
	}
	
	@Test
	public void Testquery() {
		String room = "J7-442";
		PaymentDAO pd = new PaymentImpl();
		Payment pay = new Payment();
		pay = pd.query(room);
		System.out.println(pay);
	}
	
	@Test
	public void Testupdate() {
		String money = "123";
		String room_id = "J7-442";
		PaymentDAO pd = new PaymentImpl();
		Payment pay = new Payment();
		//先查出寝室
		pay = pd.query(room_id);
		String cnt = pay.getPay_money(); //查找已有金额
		
		//获取两次金额相加
		Long num1 = Long.parseLong(cnt);
		Long num2 = Long.parseLong(money);
		Long sum = num1 + num2;
		String new_money = sum.toString();
		pay.setPay_money(new_money);
		pd.update(pay);
	}
	
	@Test
	public void TestInfor() {
		String id = "1";

		Information_noticeDAO ind = new Information_noticeImpl();
		Information_notice in = new Information_notice();
		if(ind.delete(id)) System.out.println(11);
	}
	
	@Test
	public void QueryInfor() {
		String id = "1";

		Information_noticeDAO ind = new Information_noticeImpl();
		Information_notice in = new Information_notice();
		in = ind.query(id);
		System.out.println(in.toString());
	}
	
	@Test
	public void Querystu() {
		String id = "789";
		StudentDAO std = new StudentImpl();
		List<Student> stu =std.getStudent(id);
		System.out.println(stu.size());
		for(Student stus : stu) {
			System.out.println(stus.toJSON());
		}
	}
	
	@Test
	public void Deletestu() {
		String id = "12";
		StudentDAO std = new StudentImpl();
		List<Student> stu =std.getStudent(id);
		System.out.println(stu.size());
		for(Student stus : stu) {
			String stu_id = stus.getStu_id();
			std.delete(stu_id);
		}
	}
	
	@Test
	public void Queryst() {
		//System.out.println(111);
		StrangerDAO std = new StrangerImpl();
		
		List<Stranger> stu =std.querySt();
		for(Stranger stus : stu) {
			System.out.println(stus.toJSON());
		}
	}
	
	@Test
	public void QueryRoom() {
		//System.out.println(111);
		String room_id = "J6-442";
		RoomDAO rd = new RoomImpl();
		List<Room> room = rd.queryEmpty();
		boolean flag = false;
		for(Room rooms : room) {
			if(rooms.getRoom_id().equals(room_id)) flag = true;
		}
		System.out.println(flag);
	}
	
	@Test
	public void UpdateRoom() {
		//System.out.println(111);
		String id = "2014";
		StudentDAO std = new StudentImpl();
		//获取删除学生的全部信息
		List<Student> stu =std.getStudent(id);
		RoomDAO rd = new RoomImpl();
		for(Student stus : stu) {
			String room_id = stus.getStu_room_id();
			Room room =  rd.query(room_id);
			Long num = room.getRoom_num();
			num++;
			String flag = room.getRoom_flag();
			flag = "1";
			room.setRoom_num(num);
			room.setRoom_flag(flag);
			rd.update(room);
		}
	}
	
	@Test
	public void AddStudent() {
		String stu_id = "2199551878";
		String stu_password = "2019551878";
		String stu_name = "2019551878";
		String stu_yard = "2019551878";
		String stu_marjor_in = "2019551878";
		String stu_class_id = "2019551878";
		String stu_in_time = "2019551878";
		String stu_tele_num = "2019551878";
		String password = MD5.md5(stu_password);
		Student stu = new Student();
		stu.setStu_id(stu_id);
		stu.setStu_password(password);
		stu.setStu_name(stu_name);
		stu.setStu_yard(stu_yard);
		stu.setStu_marjor_in(stu_marjor_in);
		stu.setStu_class_id(stu_class_id);
		stu.setStu_in_time(stu_in_time);
		stu.setStu_tele_num(stu_tele_num);
		StudentDAO sd = new StudentImpl();
		sd.add(stu);
		}
	
	@Test
	public void TestLogin() {
		String stu_id = "2019551878";
		String stu_password ="2019551878";
		StudentDAO sd = new StudentImpl();
		String password = MD5.md5(stu_password);
		Student stu = new Student();
		stu = sd.query(stu_id);
		if(stu.getStu_password().equals(password))
		{
			System.out.println("11111");
		}
		}
	
	@Test
	public void TestPassword() {
		StudentDAO std = new StudentImpl();
		List<Student> stu = new ArrayList<>();
		stu = std.UpdatePwd();
		for(Student stus: stu) {
			//System.out.println(stus.toJSON());
			String password = stus.getStu_password();
			String stu_password = MD5.md5(password);
			stus.setStu_password(stu_password);
			std.update(stus);
		}
		}
	
	@Test
	public void AddTeacher() {
		String tea_account = "123123";
		String tea_password = "123123";
		String tea_name = "123123";
		String tea_yard = "123123";
		String tea_tele_num = "123123";
		String tea_email = "123123";
		
		TeacherDAO td = new TeacherImpl();
		Teacher t = new Teacher();
		String password = MD5.md5(tea_password);
		t.setTea_account(tea_account);
		t.setTea_password(password);
		t.setTea_name(tea_name);
		t.setTea_yard(tea_yard);
		t.setTea_tele_num(tea_tele_num);
		t.setTea_email(tea_email);
		
		if(td.add(t)) {
			System.out.println("SUCCESS");
		}
		else {
			System.out.println("FAIL");
		}
	
}
}
