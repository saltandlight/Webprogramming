package web.component;

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

import web.dispatcher.UI;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet({ "/UserServlet", "/user" })
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Biz<String, User> biz;
	
	
	public UserServlet() {
		biz=new UserBiz();

	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String view = request.getParameter("view");
		String cmd=request.getParameter("cmd");
		String next = "main.jsp";
		if (view != null) {
			UI.build(request,view);
			/* center와 navi만들어지고 main으로 간다. */
		}else if (cmd != null) {
			if(cmd.equals("userlist")) {
				ArrayList<User> list = null;
				try {
					list=biz.get();
					request.setAttribute("ulist", list);
					UI.build(request, cmd);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		}
		RequestDispatcher rd = request.getRequestDispatcher(next);
		rd.forward(request, response);
	}

}
