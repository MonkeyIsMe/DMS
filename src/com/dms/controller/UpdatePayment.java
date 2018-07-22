package com.dms.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dms.dao.PaymentDAO;
import com.dms.impl.PaymentImpl;
import com.dms.model.Payment;

/**
 * Servlet implementation class UpdatePayment
 */
@WebServlet("/UpdatePayment")
public class UpdatePayment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePayment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String money = request.getParameter("money");
		String room_id = request.getParameter("room_id");
		PrintWriter out = response.getWriter();
		
		try {
			PaymentDAO pd = new PaymentImpl();
			Payment pay = new Payment();
			//先查出寝室
			pay = pd.query(room_id);
			String cnt = pay.getPay_money(); //查找已有金额
			//获取两次金额相加
			Long num1 = Long.parseLong(cnt);
			Long num2 = Long.parseLong(money);
			Long sum = num1 + num2;
			String new_money = sum.toString();
			pay.setPay_money(new_money);
			if(pd.update(pay)){
				out.println("SUCCESS");
			}
			else out.println("FAIL");
		} catch (Exception e) {
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

}
