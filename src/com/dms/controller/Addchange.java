package com.dms.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dms.dao.Change_RoomDAO;
import com.dms.impl.Change_roomImpl;
import com.dms.model.Change_room;

/**
 * Servlet implementation class Addchange
 */
@WebServlet("/Addchange")
public class Addchange extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//鐢宠浜ゆ崲瀹胯垗
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Addchange() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String apart_room_id = request.getParameter("apart_room_id");
		String apart_stu_id = request.getParameter("apart_stu_id");
		String apart_stu_name = request.getParameter("apart_stu_name");
		String apart_reason = request.getParameter("apart_reason");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		Change_room change = new Change_room();
		Change_RoomDAO crd = new Change_roomImpl();
		try {
			change.setApart_room_id(apart_room_id);
			change.setApart_stu_id(apart_stu_id);
			change.setApart_stu_name(apart_stu_name);
			change.setApart_reason(apart_reason);
			boolean flag = true;
			change.setFlag(flag);
			if(crd.add(change)){
				out.println("SUCCESS");
			}
			else out.print("FAIL");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			out.print("FAIL");
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
	
//	public static void main(String [] args){
//		Change_room change = new Change_room();
//		change.setApart_room_id("J8-112");
//		change.setApart_cnt("2");
//		change.setApart_stu_id("2016881251");
//		change.setApart_stu_name("James");
//		change.setApart_reason("no reason");
//		change.setFlag(true);
//		Change_RoomDAO crd = new Change_roomImpl();
//		if(crd.add(change)){
//			System.out.println("YES");
//		}
//		else System.out.println("NO");
//	}

}
