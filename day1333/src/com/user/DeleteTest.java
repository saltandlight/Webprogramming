package com.user;

import com.frame.Biz;
import com.vo.User;

public class DeleteTest {

	public static void main(String[] args) {
		
		Biz<String,User> biz = new UserBiz();

		try {
			biz.remove("id56");
			System.out.println("ok");
		} catch (Exception e) {
			e.printStackTrace();
		}


	}

}
