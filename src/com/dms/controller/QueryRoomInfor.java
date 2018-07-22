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

/**
 * Servlet implementation class QueryRoomInfor
 */
@WebServlet("/QueryRoomInfor")
public class QueryRoomInfor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryRoomInfor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String stu_id = request.getParameter("stu_id");
		StudentDAO std = new StudentImpl();
		Student stu = std.query(stu_id);
		String Room_id = stu.getStu_room_id();
		if(Room_id != null) {
			RoomDAO rd = new RoomImpl();
			Room room = rd.query(Room_id);
			String attendance = room.getRoom_attendance();
			out.println(attendance);
		}
		else {
			JSONObject jo = new JSONObject();
			jo.put("stu_room_id","没有寝室信息");
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
