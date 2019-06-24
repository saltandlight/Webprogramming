package com.sds;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.regex.Matcher;
import java.util.regex.Pattern;



/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet({ "/RegisterServlet", "/register" })
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		String result="1";
		if(id.equals("aaa") ) {
			result="0";
		}
		PrintWriter out = response.getWriter();
		out.print(result);
		out.close();		
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Pattern p = Pattern.compile("^(?=.*[a-zA-Z])((?=.*\\d)|(?=.*\\W)).{6,20}$");
		String id=request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name=request.getParameter("name");
		String job = request.getParameter("job");
		Matcher matcher = p.matcher(pwd);
		//DB에 입력하면 됨
		System.out.println(id+" "+pwd+" "+name+" "+job);
		if(id.equals("aaa") || matcher.find()==false) {
			response.sendRedirect("registerfail.html");
		}else {
			response.sendRedirect("login.html");
		}
	}

}
