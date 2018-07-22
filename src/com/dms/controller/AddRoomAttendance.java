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
 * Servlet implementation class AddRoomAttendance
 */
@WebServlet("/AddRoomAttendance")
public class AddRoomAttendance extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//添加考勤信息
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddRoomAttendance() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String room_id = request.getParameter("room_id");
		String room_attendance = request.getParameter("room_attendance");
		PrintWriter out = response.getWriter();
		
		try {
			RoomDAO rd = new RoomImpl();
			Room room = rd.query(room_id);
			room.setRoom_attendance(room_attendance);
			rd.update(room);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			out.println("FAIL");
		}
		out.print("SUCCESS");
		
		
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
