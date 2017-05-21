package com.cugb.javaee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cugb.javaee.bean.Product;
import com.cugb.javaee.bean.Product;
import com.cugb.javaee.utils.JDBCUtils;

public class ProductDaoImpl implements IProductDao {

	@Override
	public ArrayList<Product> findProducts() {
		// TODO Auto-generated method stub
		ArrayList<Product> products = new ArrayList(); 
		try {
			String sql = "select * from product";
			Connection conn = JDBCUtils.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Product product = new Product();
				product.setProductId(rs.getString(1));
				product.setProductName(rs.getString(2));
				product.setProductPrice(rs.getFloat(3));
				product.setProductRemained(rs.getInt(4));
				product.setProductDescription(rs.getString(5));
				product.setProductImage(rs.getString(6));
				products.add(product);
			}
			JDBCUtils.free(rs, ps, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return products;
	}

	@Override
	public boolean findProduct(Product product) {
		// TODO Auto-generated method stub
		boolean ret = false;
		try {
			String sql = "select * from product where productId=?";
			Connection conn = JDBCUtils.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, product.getProductId());
			ResultSet rs = ps.executeQuery();
			if (rs != null){
				ret = true;
			}
			JDBCUtils.free(rs, ps, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ret;
	}

	@Override
	public int insertProduct(Product product) {
		// TODO Auto-generated method stub
		try {
			String sql = "insert into product values(?,?,?,?,?,?)";
			Connection conn = JDBCUtils.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, product.getProductId());
			ps.setString(2, product.getProductName());
			ps.setFloat(3, product.getProductPrice());
			ps.setInt(4, product.getProductRemained());
			ps.setString(5, product.getProductDescription());
			ps.setString(6, product.getProductImage());
			int rs = ps.executeUpdate();
			JDBCUtils.free(rs, ps, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateProduct(Product product) {
		// TODO Auto-generated method stub
		try {
			String sql = "update product set productName=?,productPrice=?,productRemained=?,productDescription=?,productImage=? where productId=?";
			Connection conn = JDBCUtils.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, product.getProductName());
			ps.setFloat(2, product.getProductPrice());
			ps.setInt(3, product.getProductRemained());
			ps.setString(4, product.getProductDescription());
			ps.setString(5, product.getProductImage());
			ps.setString(6, product.getProductId());
			int rs = ps.executeUpdate();
			JDBCUtils.free(rs, ps, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteProduct(Product product) {
		// TODO Auto-generated method stub
		try {
			String sql = "delete from product where productId=?";
			Connection conn = JDBCUtils.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, product.getProductId());
			int rs = ps.executeUpdate();
			JDBCUtils.free(rs, ps, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}