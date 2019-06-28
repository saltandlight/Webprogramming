package com.product;

import com.frame.Biz;
import com.vo.Product;

public class InsertTest {

	public static void main(String[] args) {
		Product p = new Product("Tshirt", 20000, "blue.jpg");
				
		Biz<Integer, Product> biz = new ProductBiz();

		try {
			biz.register(p);
			System.out.println("OK");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
