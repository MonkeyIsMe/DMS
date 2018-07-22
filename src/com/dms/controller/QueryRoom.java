package com.dms.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import com.dms.dao.RoomDAO;
import com.dms.impl.RoomImpl;
import com.dms.model.Room;

/**
 * Servlet implementation class QueryRoom
 */
@WebServlet("/QueryRoom")
public class QueryRoom extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//查询可选宿舍 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryRoom() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		PrintWriter out = response.getWriter();
		RoomDAO rd = new RoomImpl();
		List<Room> rooms = rd.queryEmpty();
		
		request.setAttribute("list", rooms);
		RequestDispatcher   requestDispatcher=request.getRequestDispatcher("/QueryRoom.jsp");   
		requestDispatcher.forward(request,response);
		
//		JSONArray ja = new JSONArray();
//		for(Room room : rooms){
//			String flag = room.getRoom_flag();
//			if(flag.equals("1")){
//				ja.put(room.toString());
//			}
//		}
//		
//		response.setContentType("text/json");
//		out.println(ja.toString());
//		out.flush();
//		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

//	public static void main(String [] args){
//		RoomDAO rd = new RoomImpl();
//		List<Room> rooms = rd.queryEmpty();
//		
//		JSONArray ja = new JSONArray();
//		for(Room room : rooms){
//			String flag = room.getRoom_flag();
//			if(flag.equals("1")){
//				ja.put(room.toString());
//			}
//		}
//		
//		System.out.println(ja.toString());
//	}
}
