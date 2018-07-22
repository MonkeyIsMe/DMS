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

import com.dms.dao.FixDAO;
import com.dms.impl.FixImpl;
import com.dms.model.Fix;



/**
 * Servlet implementation class QueryFix
 */
@WebServlet("/QueryFix")
public class QueryFix extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//查询维修信息  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryFix() {
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
		response.setContentType("text/html;charset=utf-8");
		FixDAO fd = new FixImpl();
		List<Fix> fixs = fd.getFixInformation();
		request.setAttribute("list", fixs);
		RequestDispatcher   requestDispatcher=request.getRequestDispatcher("/QueryFix.jsp");   
		requestDispatcher.forward(request,response);
		
//		JSONArray ja = new JSONArray();
//		
//		for(Fix fix : fixs){
//			boolean flag = fix.isFix_flag();
//			if(flag==true){
//				ja.put(fix.toString());
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
//	public static void main(String [] args){
//		FixDAO fd = new FixImpl();
//		List<Fix> fixs = fd.getFixInformation();
//		JSONArray ja = new JSONArray();
//		
//		for(Fix fix : fixs){
//			boolean flag = fix.isFix_flag();
//			if(flag==true){
//				ja.put(fix.toString());
//			}
//		}
//		System.out.println(ja.toString());
// 
//	}

}
