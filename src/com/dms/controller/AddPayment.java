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
 * Servlet implementation class AddPayment
 */
@WebServlet("/AddPayment")
public class AddPayment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPayment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String room_id = request.getParameter("room_id");
		String description = request.getParameter("description");
		String money = request.getParameter("money");
		String body = request.getParameter("body");
		PrintWriter out = response.getWriter();
		try {
			PaymentDAO pd = new PaymentImpl();
			Payment pay = new Payment();
			Payment payment = pd.query(room_id);
			if(payment == null) {
				pay.setPay_description(description);
				pay.setPay_money(money);
				pay.setPay_room_id(room_id);
				pay.setPay_body(body);
				if(pd.add(pay)){
					System.out.println("SUCCESS");
				}
				else System.out.print("FAIL");
			}
			else {
				String cnt = pay.getPay_money(); //查找已有金额
				Long num1 = Long.parseLong(cnt);
				Long num2 = Long.parseLong(money);
				Long sum = num1 + num2;
				String new_money = sum.toString();
				payment.setPay_description(description);
				payment.setPay_money(new_money);
				payment.setPay_room_id(room_id);
				payment.setPay_body(body);
				pd.update(pay);
			}
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
