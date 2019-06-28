package com.product;

import com.frame.Biz;
import com.vo.Product;

public class DeleteTest {

	public static void main(String[] args) {
		
		Biz<Integer, Product> biz = new ProductBiz();

		try {
			biz.remove(100);
			System.out.println("ok");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
