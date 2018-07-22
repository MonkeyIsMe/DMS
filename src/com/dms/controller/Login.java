package com.dms.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.JSONObject;

import com.dms.dao.StudentDAO;
import com.dms.dao.TeacherDAO;
import com.dms.impl.StudentImpl;
import com.dms.impl.TeacherImpl;
import com.dms.model.Student;
import com.dms.util.MD5;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//登录
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String checkCode = (String) session.getAttribute("checkCode");
		
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		String information = request.getParameter("information");
		String inputcode = request.getParameter("code");
		//System.out.println(checkCode);
			password = MD5.md5(password);
		StudentDAO sd = new StudentImpl();
		TeacherDAO td = new TeacherImpl();
		Student stu = new Student();
		System.out.println(checkCode+" "+inputcode);
		if(account == null || password == null){
			JSONObject jo = new JSONObject();
			jo.put("identity","NULL");
			jo.put("flag", "FAIL");
			out.println(jo);
		}
		else {
			if(information.equals("teacher")){
				if(!inputcode.equals(checkCode)) {
					JSONObject jo = new JSONObject();
					jo.put("identity","NULL");
					jo.put("flag", "Wrong");
					out.println(jo);
				}
				else if(td.query(account) == null){
					JSONObject jo = new JSONObject();
					jo.put("identity","NULL");
					jo.put("flag", "NULL");
					out.println(jo);
				}
				else if(td.query(account).getTea_password().equals(password)){
					JSONObject jo = new JSONObject();
					jo.put("identity","teacher");
					jo.put("flag", "SUCCESS");
					out.println(jo);
				}
				else{
					JSONObject jo = new JSONObject();
					jo.put("identity","NULL");
					jo.put("flag", "FAIL");
					out.println(jo);
				}
			}
			else{
				if(inputcode.equals(checkCode) == false) {
					System.out.println(checkCode+" "+inputcode+"897780");
					JSONObject jo = new JSONObject();
					jo.put("identity","NULL");
					jo.put("flag", "Wrong");
					out.println(jo);
				}
				else if(sd.query(account) == null){
					JSONObject jo = new JSONObject();
					jo.put("identity","NULL");
					jo.put("flag", "NULL");
					out.println(jo);
				}				
				else if(sd.query(account).getStu_password().equals(password)){
					JSONObject jo = new JSONObject();
					jo.put("identity","student");
					jo.put("flag", "SUCCESS");
					//jo.put("msg", 0);
					out.println(jo);
				}
				else{
					JSONObject jo = new JSONObject();
					jo.put("identity","NULL");
					jo.put("flag", "FAIL");
					//jo.put("msg", 0);
					out.println(jo);
				
			}
		}
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
//	public static void main(String [] args){
//		String account = "2014551624";
//		String password = "ccaipeipei";
//		String information = "student";
//		StudentDAO sd = new StudentImpl();
//		TeacherDAO td = new TeacherImpl();
//		Student stu = new Student();
//		
//		if(account == null || password == null){
//			JSONObject jo = new JSONObject();
//			jo.put("identity","NULL");
//			jo.put("flag", "FAIL");
//			System.out.println(jo);
//		}
//		else {
//			if(information.equals("teacher")){
//				if(td.query(account) == null){
//					JSONObject jo = new JSONObject();
//					jo.put("identity","NULL");
//					jo.put("message", "Your account is not existed");
//					System.out.println(jo);
//				}
//				else if(td.query(account).getTea_password().equals(password)){
//					JSONObject jo = new JSONObject();
//					jo.put("identity","teacher");
//					jo.put("flag", "SUCCESS");
//					//jo.put("msg", 0);
//					System.out.println(jo);
//				}
//				else{
//					JSONObject jo = new JSONObject();
//					jo.put("identity","NULL");
//					jo.put("flag", "FAIL");
//					//jo.put("msg", 0);
//					System.out.println(jo);
//				}
//			}
//			else{
//				if(sd.query(account) == null){
//					JSONObject jo = new JSONObject();
//					jo.put("identity","NULL");
//					jo.put("message", "Your account is not existed");
//					System.out.println(jo);
//				}				
//				else if(sd.query(account).getStu_password().equals(password)){
//					JSONObject jo = new JSONObject();
//					jo.put("identity","student");
//					jo.put("flag", "SUCCESS");
//					//jo.put("msg", 0);
//					System.out.println(jo);
//				}
//				else{
//					JSONObject jo = new JSONObject();
//					jo.put("identity","NULL");
//					jo.put("flag", "FAIL");
//					//jo.put("msg", 0);
//					System.out.println(jo);
//				
//			}
//		}
//		}
//	}
}
