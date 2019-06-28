package com.product;

import java.sql.Date;

import com.frame.Biz;
import com.vo.Product;

public class UpdateTest {

	public static void main(String[] args) {
		Product p = new Product(105, "blackjean", 50000, new Date(06/28/2019), "black.jpg");
//		(int id, String name, double price, Date regdate, String imgname)
		Biz<Integer,Product> biz = new ProductBiz();

		try {
			biz.modify(p);
			System.out.println("ok");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
