package com.dms.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

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
 * Servlet implementation class ChooseRoom
 */
@WebServlet("/ChooseRoom")
public class ChooseRoom extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//选宿舍 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChooseRoom() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		
		String stu_id = request.getParameter("account");
		String room_id = request.getParameter("room_id");
		
		RoomDAO rd = new RoomImpl();
		StudentDAO std = new StudentImpl();
		
		Student stu = std.query(stu_id);
		if(rd.queryfull(room_id)){
			Room room = rd.query(room_id);
			Long num = room.getRoom_num();
			num--;
			room.setRoom_num(num);
			if(num == 0l) {
				room.setRoom_flag("0");
			}			
			
			stu.setStu_id(room_id);
			Set<Student> set = room.getStudents();
			set.add(stu);
			stu.setRoom(room);
			
			rd.update(room);
			std.update1(stu_id, room_id, room);
			
			out.println("SUCCESS");
		}
		else out.print("FAIL");
		
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
//		String stu_id = "2014551627";
//		String room_id = "Q15-503";
//		
//		RoomDAO rd = new RoomImpl();
//		StudentDAO std = new StudentImpl();
//		
//		Student stu = std.query(stu_id);
//		//System.out.println(stu.toJSON());
//		if(rd.queryfull(room_id)){
//			Room room = rd.query(room_id);
//			Long num = room.getRoom_num();
//			num--;
//			room.setRoom_num(num);
//			if(num == 0l) {
//				room.setRoom_flag("0");
//			}			
//			
//			Set<Student> set = room.getStudents();
//			set.add(stu);
//			
//			stu.setRoom(room);
//			stu.setStu_id(room_id);
//			
//			rd.update(room);
//			std.update1(stu_id, room_id,room);
//			
//			System.out.println("SUCCESS");
//		}
//		else System.out.print("FAIL");
//	}
}
