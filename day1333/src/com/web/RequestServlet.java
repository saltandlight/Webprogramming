package com.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestServlet
 */
@WebServlet({ "/RequestServlet", "/req" })
public class RequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String type = request.getParameter("type");
		if(type == null || type.equals("")) {
			type="index.jsp";
		}
		
		RequestDispatcher rd=request.getRequestDispatcher(type);
		rd.forward(request, response);
		
		//sendRedirect 사용하면 request 안의 정보가 사라짐
		
		
//		if(type.equals("user")) {
//			
//		}else if(type.equals("product")) {
//			
//		}
	}

	
}
