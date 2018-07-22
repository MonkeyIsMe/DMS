package com.dms.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dms.dao.RoomDAO;
import com.dms.impl.RoomImpl;
import com.dms.model.Room;

/**
 * Servlet implementation class QueryRoomExist
 */
@WebServlet("/QueryRoomExist")
public class QueryRoomExist extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryRoomExist() {
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
		String room_id = request.getParameter("room_id");
		RoomDAO rd = new RoomImpl();
		List<Room> room = rd.queryEmpty();
		boolean flag = false;
		for(Room rooms : room) {
			if(rooms.getRoom_id().equals(room_id)) flag = true;
		}
		if(flag == true)  out.println("SUCCESS");
		else out.println("FAIL");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
