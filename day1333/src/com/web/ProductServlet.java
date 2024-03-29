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
import com.oreilly.servlet.MultipartRequest;
import com.product.ProductBiz;
import com.vo.Product;
import com.vo.User;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet({ "/ProductServlet", "/product" })
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    Biz<Integer, Product> biz;
    
    public ProductServlet() {
        biz = new ProductBiz();
        
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getParameter("cmd");
		String next="";
		if(cmd.equals("add")) {
			next="product/add";
		}else if(cmd.equals("addimpl")) { 
			MultipartRequest mr = 
					new MultipartRequest(request, 
							"C:\\web\\day1333\\web\\img\\", 
							1024*1024*100,
							"UTF-8");
			String name = mr.getParameter("name");
			String price = mr.getParameter("price");
			String imgname = mr.getOriginalFileName("imgname");
			
			try {
				biz.register(new Product(name, Double.parseDouble(price), imgname));
				next="product/pok";
			}catch (Exception e) {
				next="product/pfail";
				e.printStackTrace();
			}
//			System.out.println(name+' '+price+' '+imgname);
		}else if(cmd.equals("list")) {
			ArrayList<Product> list = null;
			try {
				list = biz.get();
//				System.out.println(list.size());
				request.setAttribute("plist", list);
			} catch (Exception e) {
				e.printStackTrace();

			}

			next="product/list";
			
		}else if (cmd.equals("detail")) {
			String id = request.getParameter("id");

			Product prd = null;
			try {
				prd = biz.get(Integer.parseInt(id));
				request.setAttribute("pd", prd);
				next = "product/detail";
			} catch (Exception e) {
				e.printStackTrace();
			}

		}else if (cmd.equals("delete")) {
			String id = request.getParameter("id");

			try {
				biz.remove(Integer.parseInt(id));
				response.sendRedirect("req?type=product&cmd=list");
				return;
			} catch (Exception e) {

			}
		}else if(cmd.equals("update")) {
			String id=request.getParameter("id");
			Product prd = null;
			try {
				prd = biz.get(Integer.parseInt(id));
				request.setAttribute("pp", prd);
				next = "product/update";
//				return;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(cmd.equals("updateimpl")) {
			MultipartRequest mr = 
					new MultipartRequest(request, 
							"C:\\web\\day1333\\web\\img\\", 
							1024*1024*100,
							"UTF-8");
		
			
			String id=mr.getParameter("id");
			String name=mr.getParameter("name");
			String price=mr.getParameter("price");
			String imgname=mr.getParameter("imgname");
			String newimgname=mr.getOriginalFileName("newimgname");
			
			System.out.println(id+" "+name+" "+price+" "+imgname+" "+newimgname);
			
			if(newimgname==null || newimgname.equals("")) {
				try {
					
					biz.modify(new Product(Integer.parseInt(id), name, Double.parseDouble(price), imgname));
				} catch (Exception e) {
					
					e.printStackTrace();
				}
			}else {
				try {
					biz.modify(new Product(Integer.parseInt(id), name, Double.parseDouble(price), newimgname));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}response.sendRedirect("req?type=product&cmd=detail&id="+id);
			return;
		}
		
		RequestDispatcher rd=request.getRequestDispatcher(next+".jsp");
		rd.forward(request, response);
		
	}

}
