package com.dms.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dms.dao.Information_noticeDAO;
import com.dms.impl.Information_noticeImpl;
import com.dms.model.Information_notice;

/**
 * Servlet implementation class AddInformation
 */
@WebServlet("/AddInformation")
public class AddInformation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//发布公告
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddInformation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String infor_name = request.getParameter("infor_name");
		String infor_description=request.getParameter("infor_description");
		String infor_flag=request.getParameter("infor_flag");
		
		Information_notice in = new Information_notice();
		in.setInfor_name(infor_name);
		in.setInfor_description(infor_description);
		in.setInfor_flag(infor_flag);
		Information_noticeDAO id = new Information_noticeImpl();

		PrintWriter out = response.getWriter();
		try {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String str = df.format(new Date());
			Date date=df.parse(str);
			in.setInfor_time(date);
			if(id.add(in)){
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

}
