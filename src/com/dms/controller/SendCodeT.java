package com.dms.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dms.dao.StudentDAO;
import com.dms.dao.TeacherDAO;
import com.dms.impl.StudentImpl;
import com.dms.impl.TeacherImpl;
import com.dms.model.Student;
import com.dms.model.Teacher;
import com.dms.util.MD5;

/**
 * Servlet implementation class SendCodeT
 */
@WebServlet("/SendCodeT")
public class SendCodeT extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendCodeT() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String myEmailAccount = "real251024@163.com";
	    String myEmailPassword = "ccaipeipei001";
	    String id = request.getParameter("tea_id");
//	    StudentDAO std = new StudentImpl();
//	    Student stu= std.query(id);
//	    String email = stu.getStu_email();
	    TeacherDAO td = new TeacherImpl();
	    Teacher t = new Teacher();
	    t = td.query(id);
	    String email = t.getTea_email();
	    PrintWriter out = response.getWriter();
	    if(email == null) {
	    	out.println("FAIL");
	    }
	    else {
	    	 String myEmailSMTPHost = "smtp.163.com";

	 	    // 收件人邮箱（替换为自己知道的有效邮箱）
	 	    String receiveMailAccount = email;
	 	    Properties props = new Properties();                    // 参数配置
	         props.setProperty("mail.transport.protocol", "smtp");   // 使用的协议（JavaMail规范要求）
	         props.setProperty("mail.smtp.host", myEmailSMTPHost);   // 发件人的邮箱的 SMTP 服务器地址
	         props.setProperty("mail.smtp.auth", "true"); 
	         Session session = Session.getInstance(props);
	         session.setDebug(true); 
	         // 3. 创建一封邮件
	         MimeMessage message = new MimeMessage(session);
	         try {
	 			message.setFrom(new InternetAddress(myEmailAccount, "宿舍管理系统验证码", "UTF-8"));
	 			message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receiveMailAccount, "管理者", "UTF-8"));
	 			message.setSubject("宿舍管理系统验证码", "UTF-8");
	 			Long num =(long) ((Math.random()*9+1)*100000);
	 	        String password = num.toString();
	 	        password = MD5.md5(password);
	 	        t.setTea_password(password);
	 	        td.update(t);
	 	        message.setContent("管理者你好, 验证码为"+num, "text/html;charset=UTF-8");

	 	        // 6. 设置发件时间
	 	        message.setSentDate(new Date());

	 	        // 7. 保存设置
	 	        message.saveChanges();
	 		} catch (MessagingException e1) {
	 			// TODO Auto-generated catch block
	 			e1.printStackTrace();
	 		}

	         // 4. 根据 Session 获取邮件传输对象
	         Transport transport = null;
	 		try {
	 			transport = session.getTransport();
	 		} catch (NoSuchProviderException e) {
	 			// TODO Auto-generated catch block
	 			e.printStackTrace();
	 		}
	         try {
	 			transport.connect(myEmailAccount, myEmailPassword);
	 		} catch (MessagingException e) {
	 			// TODO Auto-generated catch block
	 			e.printStackTrace();
	 		}

	         // 6. 发送邮件, 发到所有的收件地址, message.getAllRecipients() 获取到的是在创建邮件对象时添加的所有收件人, 抄送人, 密送人
	         try {
	 			transport.sendMessage(message, message.getAllRecipients());
	 		} catch (MessagingException e) {
	 			// TODO Auto-generated catch block
	 			e.printStackTrace();
	 		}

	         // 7. 关闭连接
	         try {
	 			transport.close();
	 		} catch (MessagingException e) {
	 			// TODO Auto-generated catch block
	 			e.printStackTrace();
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

}
