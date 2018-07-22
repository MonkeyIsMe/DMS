package com.dms.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dms.dao.RoomDAO;
import com.dms.dao.StudentDAO;
import com.dms.impl.RoomImpl;
import com.dms.impl.StudentImpl;
import com.dms.model.Room;
import com.dms.model.Student;

/**
 * Servlet implementation class UpdateRoom
 */
@WebServlet("/UpdateRoom")
public class UpdateRoom extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateRoom() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String id = request.getParameter("stu_id");
		StudentDAO std = new StudentImpl();
		//获取删除学生的全部信息
		List<Student> stu =std.getStudent(id);
		RoomDAO rd = new RoomImpl();
		for(Student stus : stu) {
			String room_id = stus.getStu_room_id();
			Room room =  rd.query(room_id);
			Long num = room.getRoom_num();
			num++;
			String flag = room.getRoom_flag();
			flag = "1";
			room.setRoom_num(num);
			room.setRoom_flag(flag);
			rd.update(room);
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
