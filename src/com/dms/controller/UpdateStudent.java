package com.dms.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dms.dao.StudentDAO;
import com.dms.impl.StudentImpl;
import com.dms.model.Student;
import com.dms.util.MD5;

/**
 * Servlet implementation class UpdateStudent
 */
@WebServlet("/UpdateStudent")
public class UpdateStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
     //更新学生信息
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		
		String stu_id = request.getParameter("account");
		String stu_yard = request.getParameter("stu_yard");
		String stu_password = request.getParameter("stu_password"); 
		String stu_marjor_in = request.getParameter("stu_marjor_in");
		String stu_class_id = request.getParameter("stu_class_id");
		String stu_tele_num = request.getParameter("stu_tele_num");
		
		try {
			StudentDAO student = new StudentImpl();
			
			Student stu = student.query(stu_id);
			stu_password = MD5.md5(stu_password);
			stu.setStu_password(stu_password);
			stu.setStu_yard(stu_yard);
			stu.setStu_marjor_in(stu_marjor_in);
			stu.setStu_class_id(stu_class_id);
			stu.setStu_tele_num(stu_tele_num);
			
			student.update(stu);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			out.println("FAIL");
		}
		out.println("SUCCESS");
		
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
//		
//		StudentDAO student = new StudentImpl();
//		Student stu = student.query("2014551635");
//		stu.setStu_yard("辣鸡院");
//		stu.setStu_marjor_in("傻逼");
//		stu.setStu_class_id("2");;
//		stu.setStu_tele_num("13617305586");
//		if(student.update(stu)){
//			System.out.println(1);
//		}
//		else System.out.println(2);
//	}

}
