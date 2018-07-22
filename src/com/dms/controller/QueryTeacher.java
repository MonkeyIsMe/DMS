package com.dms.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.dms.dao.TeacherDAO;
import com.dms.impl.TeacherImpl;
import com.dms.model.Teacher;

/**
 * Servlet implementation class QueryTeacher
 */
@WebServlet("/QueryTeacher")
public class QueryTeacher extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryTeacher() {
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
		PrintWriter out = response.getWriter();
		
		String tea_id = request.getParameter("tea_id");
		TeacherDAO td = new TeacherImpl();
		Teacher t = new Teacher();
		t = td.query(tea_id);
		if(t == null) {
			JSONObject jo = new JSONObject();
			out.println("FAIL");
		}
		else {
			JSONObject jo = t.toJSON();
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

}
