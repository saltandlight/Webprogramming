package com.product;

import java.util.ArrayList;

import com.frame.Biz;
import com.vo.Product;
import com.vo.User;

public class SelectAllTest {

	public static void main(String[] args) {
		ArrayList<Product> list = new ArrayList<>();
		
		Biz<Integer, Product> biz = new ProductBiz();

		try {
			list=biz.get();
			for(Product item:list) {
				System.out.println(item.toString());
			}
			System.out.println("OK");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
