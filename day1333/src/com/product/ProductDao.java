package com.product;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.frame.Dao;
import com.frame.Sql;
import com.vo.Product;

public class ProductDao extends Dao<Integer, Product> {

	@Override
	public void insert(Product v, Connection con) throws Exception {
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(Sql.insertProduct);
//			pstmt.setString(1, v.getId());
			pstmt.setString(1, v.getName());
			pstmt.setDouble(2, v.getPrice());
			pstmt.setString(3, v.getImgname());

			pstmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			close(pstmt);
		}
	}

	@Override
	public void delete(Integer k, Connection con) throws Exception {
		PreparedStatement pstmt = null;

		try {
			pstmt = con.prepareStatement(Sql.insertDeleteProduct);
			pstmt.setInt(1, k);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

	}

	@Override
	public void update(Product v, Connection con) throws Exception {

		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(Sql.insertUpdateProduct);
			System.out.println(v.getName());
			System.out.println(v.getPrice());
			System.out.println(v.getImgname());
			System.out.println(v.getId());
			pstmt.setString(1, v.getName());
			pstmt.setDouble(2, v.getPrice());
			pstmt.setString(3, v.getImgname());
			pstmt.setInt(4, v.getId());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			close(pstmt);
		}
	}

	@Override
	public Product select(Integer k, Connection con) throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Product p = null;
		try {
			pstmt = con.prepareStatement(Sql.insertSelectProduct);
			pstmt.setInt(1, k);
			rset = pstmt.executeQuery(); // 받는거임
			rset.next();
			int pid = rset.getInt("ID");
			String pname = rset.getString("NAME");
			Double pprice = rset.getDouble("PRICE");
			Date rdate = rset.getDate("REGDATE");
			String pimgname = rset.getString("IMGNAME");
			p = new Product(pid, pname, pprice, rdate, pimgname);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return p;

	}

	@Override
	public ArrayList<Product> select(Connection con) throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Product> list = new ArrayList<Product>();
		try {
			pstmt = con.prepareStatement(Sql.insertSelectallProduct);
			rset = pstmt.executeQuery();
			rset.next();

			while (rset.next()) {
				Integer pid = rset.getInt("ID");
				String pname = rset.getString("NAME");
				Double pprice = rset.getDouble("PRICE");
				Date rdate = rset.getDate("REGDATE");
				String pimgname = rset.getString("IMGNAME");
				Product p = new Product(pid, pname, pprice, rdate, pimgname);
				list.add(p);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return list;
	}

}
