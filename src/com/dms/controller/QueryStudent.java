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

import org.json.JSONObject;

/**
 * Servlet implementation class QueryStudent
 */
@WebServlet("/QueryStudent")
public class QueryStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//查询一个学生信息 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html;charset=utf-8");
		String stu_id = request.getParameter("stu_id");
		PrintWriter out = response.getWriter();
		
		StudentDAO sd = new StudentImpl();
		Student stu = new Student(); 
		stu = sd.query(stu_id);
		if(stu == null) {
			out.println("FAIL");
		}
		else {
			JSONObject jo = stu.toJSON();
			response.setContentType("text/json");
			out.println(jo.toString());
			out.flush();
			out.close();
		}
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
//		StudentDAO sd = new StudentImpl();
//		Student stu = new Student();
//		stu = sd.query("2014551624");
//		JSONObject jo = stu.toJSON();
//		System.out.println(jo.toString());
//		
//	}
}
