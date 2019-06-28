package com.user;

import java.util.ArrayList;

import com.frame.Biz;
import com.vo.User;

public class SelectTest {

	public static void main(String[] args) {
	    User user= new User();
		
		Biz<String,User> biz = new UserBiz();

		try {
			user=biz.get("ID12");
			System.out.println(user.toString());
		
//			System.out.println("OK");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
