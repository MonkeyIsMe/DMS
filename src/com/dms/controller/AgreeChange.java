package com.dms.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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
 * Servlet implementation class AgreeChange
 */
@WebServlet("/AgreeChange")
public class AgreeChange extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//批准交换宿舍
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgreeChange() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String stu_id = request.getParameter("account");
		String room_id = request.getParameter("room_id");
		
		PrintWriter out = response.getWriter();
		RoomDAO rd = new RoomImpl();
		if(rd.queryfull(room_id)){
			Room room = rd.query(room_id);
			Long num = room.getRoom_num();
			num--;
			room.setRoom_num(num);
			if(num == 0l) {
				room.setRoom_flag("0");
			}			
			rd.update(room);
			
			StudentDAO sd = new StudentImpl();
			Student stu = sd.query(stu_id);
			
			//先获得原来的寝室room_id
			String ex_room_id = stu.getStu_room_id();
			Room ex_room = rd.query(ex_room_id);
			Long ex_num = ex_room.getRoom_num();
			ex_num++;
			ex_room.setRoom_num(ex_num);
			if(ex_room.getRoom_flag().equals("0")) ex_room.setRoom_flag("1");
			//把原来寝室的信息里的外建删掉
			Set<Student> ex_set = ex_room.getStudents();
			ex_set.remove(stu);
			rd.update(ex_room);
			
			//添加新的外建
			Set<Student> set = room.getStudents();
			set.add(stu);
			
			stu.setStu_room_id(room_id);
			stu.setRoom(room);
			sd.update(stu);
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
//		String stu_id = "2014551621";
//		String room_id = "Q7-101";
//		RoomDAO rd = new RoomImpl();
//		
//		if(rd.queryfull(room_id)){
//			Room room = rd.query(room_id);
//			Long num = room.getRoom_num();
//			num--;
//			room.setRoom_num(num);
//			if(num == 0l) {
//				room.setRoom_flag("0");
//			}			
//			rd.update(room);
//			
//			StudentDAO sd = new StudentImpl();
//			Student stu = sd.query(stu_id);
//			
//			//先获得原来的寝室room_id
//			String ex_room_id = stu.getStu_room_id();
//			Room ex_room = rd.query(ex_room_id);
//			Long ex_num = ex_room.getRoom_num();
//			ex_num++;
//			ex_room.setRoom_num(ex_num);
//			if(ex_room.getRoom_flag().equals("0")) ex_room.setRoom_flag("1");
//			//把原来寝室的信息里的外建删掉
//			Set<Student> ex_set = ex_room.getStudents();
//			ex_set.remove(stu);
//			rd.update(ex_room);
//			
//			//添加新的外建
//			Set<Student> set = room.getStudents();
//			set.add(stu);
//			stu.setRoom(room);
//			stu.setStu_room_id(room_id);
//			sd.update(stu);
//			
//			System.out.println("SUCCESS");
//		}
//		else System.out.print("FAIL");
//	}
}
