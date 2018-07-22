package com.dms.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.dms.dao.StudentDAO;
import com.dms.impl.StudentImpl;
import com.dms.model.Student;
import com.dms.util.MD5;

/**
 * Servlet implementation class Updateinfor
 */
@WebServlet("/Updateinfor")
public class Updateinfor extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//更新信息
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Updateinfor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String stu_id = request.getParameter("account");
		String email = request.getParameter("email");
		String pwd = request.getParameter("new_password");
		String tele = request.getParameter("stu_tele_num");
		StudentDAO std = new StudentImpl();
		Student stu = std.query(stu_id);
		pwd = MD5.md5(pwd);
		PrintWriter out = response.getWriter();
		
		if(email == null && pwd == null && tele == null){
			JSONObject jo = new JSONObject();
			jo.put("msg", "NOTHING");
		}
		else if( email != null && pwd == null && tele ==null){
			stu.setStu_email(email);
			try {
				if(std.update(stu)){
					JSONObject jo = new JSONObject();
					jo.put("msg", "SUCCESS");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				JSONObject jo = new JSONObject();
				jo.put("msg", "FAIL");
			}
		}
		else if(email != null && pwd != null && tele ==null){
			stu.setStu_email(email);
			stu.setStu_password(pwd);
			try {
				if(std.update(stu)){
					JSONObject jo = new JSONObject();
					jo.put("msg", "SUCCESS");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				JSONObject jo = new JSONObject();
				jo.put("msg", "FAIL");
			}
		}
		else if(email != null && pwd == null && tele != null){
			stu.setStu_email(email);
			stu.setStu_tele_num(tele);
			try {
				if(std.update(stu)){
					JSONObject jo = new JSONObject();
					jo.put("msg", "SUCCESS");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				JSONObject jo = new JSONObject();
				jo.put("msg", "FAIL");
			}
		}
		else if(email == null && pwd !=null && tele != null){
			stu.setStu_password(pwd);
			stu.setStu_tele_num(tele);
			try {
				if(std.update(stu)){
					JSONObject jo = new JSONObject();
					jo.put("msg", "SUCCESS");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				JSONObject jo = new JSONObject();
				jo.put("msg", "FAIL");
			}
		}
		else if(email == null && pwd != null && tele ==null){
			stu.setStu_password(pwd);
			try {
				if(std.update(stu)){
					JSONObject jo = new JSONObject();
					jo.put("msg", "SUCCESS");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				JSONObject jo = new JSONObject();
				jo.put("msg", "FAIL");
			}
		}
		else if(email == null && pwd == null && tele != null){
			stu.setStu_tele_num(tele);
			try {
				if(std.update(stu)){
					JSONObject jo = new JSONObject();
					jo.put("msg", "SUCCESS");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				JSONObject jo = new JSONObject();
				jo.put("msg", "FAIL");
			}
		}
		else if(email !=null && pwd != null && tele !=null){
			stu.setStu_email(email);
			stu.setStu_password(pwd);
			stu.setStu_tele_num(tele);
			try {
				if(std.update(stu)){
					JSONObject jo = new JSONObject();
					jo.put("msg", "SUCCESS");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				JSONObject jo = new JSONObject();
				jo.put("msg", "FAIL");
			}
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
//		String stu_id = "2014551624";
//		String email = "real251024@163.com";
//		String pwd = "ccaipeipei";
//		StudentDAO std = new StudentImpl();
//		Student stu = std.query(stu_id);
//		if(email == null && pwd == null){
//			JSONObject jo = new JSONObject();
//			jo.put("message", "nothing");
//		}
//		else if(email == null && pwd != null){
//			stu.setStu_email(pwd);
//			try {
//				if(std.update(stu)){
//					JSONObject jo = new JSONObject();
//					jo.put("message", "SUCCESS");
//				}
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//				JSONObject jo = new JSONObject();
//				jo.put("message", "FAIL");
//			}
//		}
//		else if(email != null && pwd == null){
//			stu.setStu_email(email);
//			try {
//				if(std.update(stu)){
//					JSONObject jo = new JSONObject();
//					jo.put("message", "SUCCESS");
//				}
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//				JSONObject jo = new JSONObject();
//				jo.put("message", "FAIL");
//			}
//		}
//		else{
//			stu.setStu_email(email);
//			stu.setStu_password(pwd);
//			try {
//				if(std.update(stu)){
//					JSONObject jo = new JSONObject();
//					jo.put("message", "SUCCESS");
//				}
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//				JSONObject jo = new JSONObject();
//				jo.put("message", "FAIL");
//			}
//			
//		}
//	}
}
