package com.product;

import com.frame.Biz;
import com.vo.Product;

public class SelectTest {

	public static void main(String[] args) {
	    Product prod= new Product();
		
		Biz<Integer,Product> biz = new ProductBiz();

		try {
			prod=biz.get(100);
			System.out.println(prod.toString());
		
//			System.out.println("OK");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
