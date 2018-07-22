package com.dms.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dms.dao.StrangerDAO;
import com.dms.impl.StrangerImpl;
import com.dms.model.Stranger;

import org.json.JSONObject;

/**
 * Servlet implementation class QueryStranger
 */
@WebServlet("/QueryStranger")
public class QueryStranger extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//查询一个访问者信息 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryStranger() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String st_id = request.getParameter("st_id");
		PrintWriter out = response.getWriter();
	
		StrangerDAO sd = new StrangerImpl();
		Stranger st = new Stranger();
		st = sd.query(st_id);
		JSONObject jo = st.toJSON();
		response.setContentType("text/json");
		out.println(jo.toString());
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
//		String st_id = "123123";
//		StrangerDAO sd = new StrangerImpl();
//		Stranger st = new Stranger();
//		st = sd.query(st_id);
//		JSONObject jo = st.toJSON();
//		System.out.println(jo);
//	}
}
