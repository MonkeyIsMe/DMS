package com.dms.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dms.dao.TeacherDAO;
import com.dms.impl.TeacherImpl;
import com.dms.model.Teacher;
import com.dms.util.MD5;

/**
 * Servlet implementation class AddTeacher
 */
@WebServlet("/AddTeacher")
public class AddTeacher extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTeacher() {
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
		response.setContentType("text/html;charset=utf-8");
		
		String tea_account = request.getParameter("tea_account"); //
		String tea_password = request.getParameter("tea_password"); //
		String tea_name = request.getParameter("tea_name");
		String tea_yard = request.getParameter("tea_yard");
		String tea_tele_num = request.getParameter("tea_tele_num");
		String tea_email = request.getParameter("tea_email");
		
		TeacherDAO td = new TeacherImpl();
		Teacher t = new Teacher();
		String password = MD5.md5(tea_password);
		t.setTea_account(tea_account);
		t.setTea_password(password);
		t.setTea_name(tea_name);
		t.setTea_yard(tea_yard);
		t.setTea_tele_num(tea_tele_num);
		t.setTea_email(tea_email);
		
		try {
			if(td.add(t)) {
				out.println("SUCCESS");
			}
			else {
				out.println("FAIL");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			out.println("FAIL");
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

}
