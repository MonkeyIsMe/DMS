package com.dms.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dms.dao.FixDAO;
import com.dms.dao.StudentDAO;
import com.dms.impl.FixImpl;
import com.dms.impl.StudentImpl;
import com.dms.model.Fix;
import com.dms.model.Student;

/**
 * Servlet implementation class AddFix
 */
@WebServlet("/AddFix")
public class AddFix extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//申请维修 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddFix() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html;charset=utf-8");
		String fix_cnt = request.getParameter("fix_cnt");
		String fix_stu_id = request.getParameter("fix_stu_id");
		String fix_stu_name = request.getParameter("fix_stu_name");
		String fix_reason = request.getParameter("fix_reason");
		
		Fix fix = new Fix();
		
		fix.setFix_cnt(fix_cnt);
		fix.setFix_stu_id(fix_stu_id);
		fix.setFix_stu_name(fix_stu_name);
		fix.setFix_reason(fix_reason);
		PrintWriter out = response.getWriter();
		
		try {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String str = df.format(new Date());
			Date date=df.parse(str);
			FixDAO fd = new FixImpl();
			fix.setFix_time(date);
			if(fd.add(fix)){
				out.println("SUCCESS");
			}
			else out.print("FAIL");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			out.println("FAIL");
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
//		String fix_cnt = "J7-443";
//		String fix_stu_id ="2014551630";
//		String fix_stu_name = "2014551630";
//		String fix_room_id = "2014551630";
//		String fix_reason = "2014551630";
//		
//		Fix fix = new Fix();
//		StudentDAO std = new StudentImpl();
//		Student stu = std.query(fix_stu_id);
//		
//		fix.setFix_cnt(fix_cnt);
//		fix.setFix_stu_id(fix_stu_id);
//		fix.setFix_stu_name(fix_stu_name);
//		fix.setFix_room_id(fix_room_id);
//		fix.setFix_reason(fix_reason);
//		fix.setStudent(stu);
//		stu.getFixs().add(fix);
//		
//		try {
//			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//			String str = df.format(new Date());
//			Date date=df.parse(str);
//			FixDAO fd = new FixImpl();
//			fix.setFix_time(date);
//			if(fd.add(fix)){
//				System.out.println("SUCCESS");
//			}
//			else System.out.print("FAIL");
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			System.out.println("FAIL");
//		}
//	}
}
