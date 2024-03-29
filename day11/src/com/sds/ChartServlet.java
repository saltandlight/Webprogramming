package com.sds;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * Servlet implementation class ChartServlet
 */
@WebServlet({ "/ChartServlet", "/musicchart" })
public class ChartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		//make json data
		JSONArray ja = new JSONArray();
		
		Random r = new Random();
		

		for(int i=0;i<10;i++) {
			int temp=r.nextInt(10)+1;
			JSONObject jo = new JSONObject();
			jo.put("rank", i+1);
			
			if((i*101+37)%3==0) {
				jo.put("keyword", "윤하");
			}else if((i*101+37)%3==1) {
				jo.put("keyword", "K.will");
			}else {
				jo.put("keyword", "XIA");
			}
			if(temp%2==0) {
				jo.put("type", "up");
			}else {
				jo.put("type", "down");
			}
			
		
			jo.put("cnt", i*101+37);
			ja.add(jo);
		}		
		//and respond calient
		
		out.print(ja.toJSONString());	
		//out.print(ja.toString());		
		out.close();
		//open했으면 꼬옥 close해줘야 함 잘 안해주면 3~4일 후에 뻗음
	}



}
