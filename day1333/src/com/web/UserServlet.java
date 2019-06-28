package com.web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.frame.Biz;
import com.user.UserBiz;
import com.vo.User;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet({ "/UserServlet", "/user" })
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Biz<String, User> biz;

	// constructor는 메모리에 올라갈 떄 한 번 호출됨. 그 이후에는 service가 된다
	public UserServlet() {
		biz = new UserBiz();
	}

	//
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cmd = request.getParameter("cmd");
		String next = "";
		if (cmd.equals("add")) {
			next = "user/add";
		} else if (cmd.equals("addimpl")) {
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			String name = request.getParameter("name");

			try {
				biz.register(new User(id, name, pwd));
				// request에 id를 담아서 보낸다.
				request.setAttribute("rid", id);
				next = "user/rok";
			} catch (Exception e) {
				next = "user/rfail";
			}
		} else if (cmd.equals("list")) {
			ArrayList<User> list = null;
			try {
				list = biz.get();
//				System.out.println(list.size());
				request.setAttribute("ulist", list);
			} catch (Exception e) {
				e.printStackTrace();

			}

			next = "user/list";

		} else if (cmd.equals("detail")) {
			String id = request.getParameter("id");

			User user = null;
			try {
				user = biz.get(id);
				request.setAttribute("ud", user);
				next = "user/detail";
			} catch (Exception e) {
				e.printStackTrace();
			}

//			next="user/detail";
		} else if (cmd.equals("delete")) {
			String id = request.getParameter("id");

			try {
				//이거 약간 user쪽에서는 string이어야 하는데 여기서는 integer가 되서 에러됨.
				biz.remove(Integer.parseInt(id));
				response.sendRedirect("req?type=user&cmd=list");
				return;
			} catch (Exception e) {

			}
		} else if (cmd.equals("update")) {
			String id = request.getParameter("id");

			User user = null;
			try {
				user = biz.get(id);
				request.setAttribute("uu", user);
				next = "user/update";
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(cmd.equals("updateimpl")) {
			String id = request.getParameter("id");
			String pwd=request.getParameter("pwd");
			String name=request.getParameter("name");
			try {
				
				biz.modify(new User(id, pwd, name));
				response.sendRedirect("req?type=user&cmd=detail&id="+id);
				return;
			} catch (Exception e) {
				e.printStackTrace();
				next = "user/rfail";
			}
		}

		RequestDispatcher rd = request.getRequestDispatcher(next + ".jsp");
		rd.forward(request, response);

	}

}
