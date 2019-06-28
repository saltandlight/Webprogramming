package com.user;

import java.util.ArrayList;

import com.frame.Biz;
import com.vo.User;

public class SelectAllTest {

	public static void main(String[] args) {
		ArrayList<User> list = new ArrayList<>();
		
		Biz<String,User> biz = new UserBiz();

		try {
			list=biz.get();
			for(User item:list) {
				System.out.println(item.toString());
			}
			System.out.println("OK");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
