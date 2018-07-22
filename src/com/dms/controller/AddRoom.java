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
import com.dms.model.Room;

/**
 * Servlet implementation class AddRoom
 */
@WebServlet("/AddRoom")
public class AddRoom extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddRoom() {
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
		String room_id = request.getParameter("room_id");
		Long num = (long) 4;
		RoomDAO rd = new RoomImpl();
		Room room = new Room();
		room.setRoom_id(room_id);
		String room_flag = "1";
		room.setRoom_flag(room_flag);
		room.setRoom_num(num);
		try {
			if(rd.addroom(room)) {
				out.println("SUCCESS");
			}
			else out.println("FAIL");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			 out.println("FAIL");
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
