package com.dms.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.dms.dao.RoomDAO;
import com.dms.dao.StudentDAO;
import com.dms.impl.RoomImpl;
import com.dms.impl.StudentImpl;
import com.dms.model.Room;
import com.dms.model.Student;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class QueryRoomTask
 */
@WebServlet("/QueryRoomTask")
public class QueryRoomTask extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryRoomTask() {
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
		String stu_id = request.getParameter("stu_id");
		StudentDAO std = new StudentImpl();
		Student stu = std.query(stu_id);
		String Room_id = stu.getStu_room_id();
		if(Room_id != null) {
			RoomDAO rd = new RoomImpl();
			Room room = rd.query(Room_id);
			String task = room.getApart_task();
			out.println(task);
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
//		String stu_id = "2014551624";
//		StudentDAO std = new StudentImpl();
//		Student stu = std.query(stu_id);
//		String Room_id = stu.getStu_room_id();
//		RoomDAO rd = new RoomImpl();
//		Room room = rd.query(Room_id);
//		String task = room.getApart_task();
//		
//		System.out.println(task);
//	}
}
