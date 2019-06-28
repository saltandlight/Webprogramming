package com.frame;

public class Sql {
		
		public static String insertUser				// Static ������ ��ü���� ���ص� ��..
		= "INSERT INTO T_USER VALUES(?,?,?)";
		public static String insertDelete
		= "DELETE FROM T_USER WHERE ID = ?";
		public static String insertUpdate
		= "UPDATE T_USER SET PWD=?,NAME=? WHERE ID =?";
		public static String insertSelect
		= "SELECT * FROM T_USER WHERE ID = ?";
		public static String insertSelectall
		= "SELECT * FROM T_USER";
		
		public static String insertProduct				// Static 변수는 객체생성 안해도 댐..
		= "INSERT INTO T_PRODUCT VALUES (PSEQ.NEXTVAL,?,?,SYSDATE, ?)";
		public static String insertDeleteProduct
		= "DELETE FROM T_PRODUCT WHERE ID = ?";
		public static String insertUpdateProduct
		= "UPDATE T_PRODUCT SET NAME=?,PRICE=?, IMGNAME=? WHERE ID =?";
		public static String insertSelectProduct
		= "SELECT * FROM T_PRODUCT WHERE ID = ?";
		public static String insertSelectallProduct
		= "SELECT * FROM T_PRODUCT";
		
		
}
