package com.sds;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet({ "/HelloServlet", "/hello" })
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	//들어오는 건 request, 나가는 건 response가 담당함
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet Start...");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		System.out.println(id+" "+pwd);
		
		
		//HTML5
		//현재 들어온 Servlet에서 다른 쪽으로 이동하는 것임.
		//ok.jsp도 서버 프로그램임(모양은 좀 다르다)
//		response.sendRedirect("ok.jsp?id="+id); //이렇게 보내기도 한다.
		//보내고자 하는 값을 담음
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(5);
		list.add(3);
		list.add(8);
		
		ArrayList<Item> list2 = new ArrayList<Item>();
		list2.add(new Item("k1", 1000));
		list2.add(new Item("k2", 2000));
		list2.add(new Item("k3", 3000));
		list2.add(new Item("k4", 4000));
		list2.add(new Item("k5", 5000));
		request.setAttribute("list2",list2);
		
		request.setAttribute("list1",list);
		request.setAttribute("id",id);
		request.setAttribute("cnt", 7);
//		request.setAttribute("pwd", pwd);
		RequestDispatcher rd = request.getRequestDispatcher("ok2.jsp");
		rd.forward(request, response);
		
//		id, pwd 날아가기 전에 보통 암호화를 해서 날림.
		
//		response.setContentType("text/html;charset=UTF-8");
//		response.setCharacterEncoding("UTF-8");
//		PrintWriter out = response.getWriter();
//		out.println("<h1>LOGIN OK</h1>");
//		out.println("<h1>"+id+"님 환영합니다.</h1>");
//		out.close();
		
		
	}
	

}
