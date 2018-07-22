package com.dms.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dms.dao.RoomDAO;
import com.dms.impl.RoomImpl;

/**
 * Servlet implementation class QueryFull
 */
@WebServlet("/QueryFull")
public class QueryFull extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//查询宿舍是不是为空
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryFull() {
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
		String room_id = request.getParameter("room_id");
		PrintWriter out = response.getWriter();
		
		try {
			RoomDAO rd= new RoomImpl();
			if(rd.queryfull(room_id)) out.println("SUCCESS");
			else out.println("FAIL");
			
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
