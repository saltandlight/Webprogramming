package web.component;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.frame.Biz;
import com.user.UserBiz;
import com.vo.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet({ "/LoginServlet", "/login" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Biz<String, User> biz;

	public LoginServlet() {
		biz = new UserBiz();
	}

	// logout 처리
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session != null) {
			//server에서 깃발 꽃은 것 뺀 것 의미함.
			session.invalidate();
		}
		response.sendRedirect("main.jsp");
	}

	// login 처리
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String center = "";

		User user = null;
		try {
			user = biz.get(id);
			if (user.getPwd().equals(pwd)) {
				
				center = "loginok";
				// session은 서버에 있음.
				// setattribute로 나 로그인했다~ 라고 깃발 꽃기
				// session에 들어있는 값도 el로 꺼낼 수 있다. 
				HttpSession session = request.getSession();
				session.setAttribute("loginuser", user);
			} else {
				center = "loginfail";
			}
		} catch (Exception e) {
			center = "loginfail";
			e.printStackTrace();
		}

		request.setAttribute("center", center);
		RequestDispatcher rd = request.getRequestDispatcher("main.jsp");
		rd.forward(request, response);
	}

}
