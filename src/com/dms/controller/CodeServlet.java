package com.dms.controller;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * Servlet implementation class CodeServlet
 */
@WebServlet("/CodeServlet")
public class CodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CodeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        String str = code();
        //System.out.println(str);
        session.setAttribute("checkCode", str);
        BufferedImage bi = new BufferedImage(100,33,BufferedImage.TYPE_INT_BGR);
        Graphics g = bi.getGraphics();
        g.setFont(new Font(null, Font.ITALIC, 22));
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 100, 33);
        g.setColor(Color.BLACK);
        g.drawString(str, 30, 25);
        response.setContentType("image/jpg");
        ImageIO.setUseCache(false);
        ImageIO.write(bi, "jpg", response.getOutputStream());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

    private String code(){
        StringBuffer stringBuffer = new StringBuffer();
        char [] arr= {'0','1','2','3','4','5','6','7','8','9',
                'q','w','e','r','t','y','u','i','o','p','a','s','d','f','g','h','j','k','l','z','x','c','v','b','n','m'};
        for(int i = 0; i < 4; i++){
            stringBuffer.append(arr[new Random().nextInt(arr.length)]);
        }
        return stringBuffer.toString();
    }
	
}
