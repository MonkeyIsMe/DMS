package com.dms.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.dms.dao.StrangerDAO;
import com.dms.impl.StrangerImpl;
import com.dms.model.Stranger;
import com.dms.util.HibernateUtil;

/**
 * Servlet implementation class AddStranger
 */
@WebServlet("/AddStranger")
public class AddStranger extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//添加访问者信息
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStranger() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String st_name = req.getParameter("st_name");
		String st_id = req.getParameter("st_id");
		String st_to_room = req.getParameter("st_to_room");
		String st_to_name = req.getParameter("st_to_name");
		String st_telephone = req.getParameter("st_telephone");
		String st_reason = req.getParameter("st_reason");
		String st_people_num = req.getParameter("st_people_num");
		String st_date= req.getParameter("st_date");
		
			Stranger st = new Stranger();
			
			st.setSt_name(st_name);
			st.setSt_id(st_id);
			st.setSt_to_room(st_to_room);
			st.setSt_to_name(st_to_name);
			st.setSt_telephone(st_telephone);
			st.setSt_reason(st_reason);
			st.setSt_people_num(st_people_num);
			st.setSt_date(st_date);
			
			StrangerDAO sd = new StrangerImpl();
			PrintWriter out = resp.getWriter();
			if(sd.add(st)){
				out.println("SUCCESS");
			}
			else out.println("FAIL");
			
			out.flush();
			out.close();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
//	public static void main(String [] args){
//		
//		//SessionFactory sf = HibernateUtil.getSessionFactory();
//		
//		//Session s = sf.openSession();
//		Stranger st = new Stranger();
//		
//		st.setSt_name("王硕");
//		st.setSt_id("456478779555");
//		st.setSt_to_room("J7-442");
//		st.setSt_to_name("刘青松");
//		st.setSt_telephone("123123123");
//		st.setSt_reason("爱上大四爱搜");
//		st.setSt_people_num("2");
//		st.setSt_date("2018年4月21日");
//		StrangerDAO sd = new StrangerImpl();
//		try {
//			if(sd.add(st)){
//				System.out.println("YES");
//			}
//			else System.out.println("NO");
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			System.out.println("NO");
//		}
//	}

}
