package com.user;

import com.frame.Biz;
import com.vo.User;

public class UpdateTest {

	public static void main(String[] args) {
		User u = new User("id03", "땡칠이", "4");
		Biz<String,User> biz = new UserBiz();

		try {
			biz.modify(u);
			System.out.println("ok");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
