package web.component;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.dispatcher.UI;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet({ "/ProductServlet", "/product" })
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProductServlet() {
        super();
    }
    
    protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String view = request.getParameter("view");
		String next = "main.jsp";
		if (view != null) {
			UI.build(request,view);
			/* center와 navi만들어지고 main으로 간다. */
		}
		RequestDispatcher rd = request.getRequestDispatcher(next);
		rd.forward(request, response);
	}

}
