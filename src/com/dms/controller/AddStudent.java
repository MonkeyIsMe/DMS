package com.dms.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.dms.dao.StudentDAO;
import com.dms.impl.StudentImpl;
import com.dms.model.Student;
import com.dms.util.HibernateUtil;
import com.dms.util.MD5;

/**
 * Servlet implementation class AddStudent
 */
@WebServlet("/AddStudent")
public class AddStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//添加学生信息 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String stu_id = request.getParameter("account"); //
		String stu_password = request.getParameter("stu_password"); //
		String stu_name = request.getParameter("stu_name");
		String stu_yard = request.getParameter("stu_yard");
		String stu_marjor_in = request.getParameter("stu_marjor_in");
		String stu_class_id = request.getParameter("stu_class_id");
		String stu_in_time = request.getParameter("stu_in_time");
		String stu_tele_num = request.getParameter("stu_tele_num");
		PrintWriter out = response.getWriter();
		StudentDAO sd = new StudentImpl();
		Student stu = new Student();
		Student student = sd.query(stu_id);
		if(student != null) {
			
		}
		else {
			//System.out.println(stu_password);
			//MD5加密
			stu_password = MD5.md5(stu_password);
			
			stu.setStu_id(stu_id);
			stu.setStu_password(stu_password);
			stu.setStu_name(stu_name);
			stu.setStu_yard(stu_yard);
			stu.setStu_marjor_in(stu_marjor_in);
			stu.setStu_class_id(stu_class_id);
			stu.setStu_in_time(stu_in_time);
			stu.setStu_tele_num(stu_tele_num);
			
			//PrintWriter out = response.getWriter();
			if(sd.add(stu)){
				out.println("SUCCESS");
			}
			else out.print("FAIL");
		}
		out.flush();
		out.close();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
//	public static void main(String [] args){
//		String stu_id = "2015551629";
//		String stu_password = "123456";
//		String stu_name = "Jerry";
//		String stu_yard = "化学院";
//		String stu_marjor_in = "生物科学";
//		String stu_class_id = "2";
//		String stu_in_time = "2014-5-5";
//		String stu_tele_num = "123145678";
//		
//		
//		Student stu = new Student();
//		
//		stu.setStu_id(stu_id);
//		stu.setStu_password(stu_password);
//		stu.setStu_name(stu_name);
//		stu.setStu_yard(stu_yard);
//		stu.setStu_marjor_in(stu_marjor_in);
//		stu.setStu_class_id(stu_class_id);
//		stu.setStu_in_time(stu_in_time);
//		stu.setStu_tele_num(stu_tele_num);
//		
//		StudentDAO sd = new StudentImpl();
//		if(sd.add(stu)){
//			System.out.println("SUCCESS");
//		}
//		else System.out.print("FAIL");
//	}

}
