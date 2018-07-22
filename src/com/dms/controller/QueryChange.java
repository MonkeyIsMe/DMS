package com.dms.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import java.util.List;
import com.dms.dao.Change_RoomDAO;
import com.dms.impl.Change_roomImpl;
import com.dms.model.Change_room;

/**
 * Servlet implementation class QueryChange
 */
@WebServlet("/QueryChange")
public class QueryChange extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//查询交换宿舍的信息
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryChange() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//PrintWriter out = response.getWriter();
		Change_RoomDAO crd = new Change_roomImpl();
		List<Change_room> changes = crd.change();
		request.setAttribute("list", changes);
		RequestDispatcher   requestDispatcher=request.getRequestDispatcher("/QueryChange.jsp");   
		requestDispatcher.forward(request,response);
		
		
//		JSONArray ja = new JSONArray();
//		for(Change_room change : changes){
//			boolean flag = change.isFlag();
//			if(flag == true){
//				ja.put(change.toString());
//			}
//		}
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

}
