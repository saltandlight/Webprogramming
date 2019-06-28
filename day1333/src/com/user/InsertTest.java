package com.user;

import com.frame.Biz;
import com.vo.User;

public class InsertTest {

	public static void main(String[] args) {
		User u = new User("4", "4", "4");
		Biz<String,User> biz = new UserBiz();

		try {
			biz.register(u);
			System.out.println("OK");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
