package com.dms.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dms.dao.FixDAO;
import com.dms.impl.FixImpl;
import com.dms.model.Fix;

/**
 * Servlet implementation class UpdateFix
 */
@WebServlet("/UpdateFix")
public class UpdateFix extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//更新维修信息
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateFix() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		
		String fix_id = request.getParameter("fix_id");
		
		try {
			FixDAO fd = new FixImpl();
			Fix fix = fd.query(fix_id);
			if(fix.isFix_flag()==true) fix.setFix_flag(false);
			if(fd.update(fix)) out.println("SUCCESS");
			else out.println("FAIL");
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
//		String fix_id = "3";
//		FixDAO fd = new FixImpl();
//		Fix fix = fd.query(fix_id);
//		if(fix.isFix_flag()==true) fix.setFix_flag(false);
//		if(fd.update(fix)) System.out.println("SUCCESS");
//		else System.out.println("FAIL");
//	}
}
