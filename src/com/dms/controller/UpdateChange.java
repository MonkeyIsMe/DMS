package com.dms.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import com.dms.dao.Change_RoomDAO;
import com.dms.impl.Change_roomImpl;
import com.dms.model.Change_room;

/**
 * Servlet implementation class UpdateChange
 */
@WebServlet("/UpdateChange")
public class UpdateChange extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//更新交换宿舍信息  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateChange() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String apart_id = request.getParameter("apart_id");
		PrintWriter out = response.getWriter();
		response.setContentType("text/html;charset=utf-8");
		
		Change_RoomDAO crd = new Change_roomImpl();
		Change_room change = crd.query(apart_id);
		JSONObject jo = new JSONObject();
		//JSONArray ja = new JSONArray();
		//ja.put(change.toString());
		response.setContentType("text/json");
		//out.println(ja.toString());
		jo.put("room",change.getApart_room_id());
		jo.put("stu_id",change.getApart_stu_id());
		out.println(jo);
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
//		String apart_id = "3";
//		Change_RoomDAO crd = new Change_roomImpl();
//		Change_room room = crd.query(apart_id);
//		if(room.isFlag()== true) room.setFlag(false);
//		if(crd.Update(room)) System.out.println("Yes");
//		else System.out.println("No");
//	}

}
