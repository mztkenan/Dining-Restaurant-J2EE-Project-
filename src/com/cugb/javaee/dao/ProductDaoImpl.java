package com.cugb.javaee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cugb.javaee.bean.Product;
import com.cugb.javaee.bean.Product;
import com.cugb.javaee.utils.DaoFactory;
import com.cugb.javaee.utils.JDBCUtils;

public class ProductDaoImpl extends BaseDAO implements IProductDao {

	//XXX ï¿½ï¿½ï¿½Ú¼Ì³ï¿½ï¿½ï¿½baseDaoï¿½ï¿½ï¿½Ô¼ï¿½
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
			if (rs.next()){
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

	@Override
	public int getTotalNum() {
		// XXX ÖØ¸´
		String sqlTable="product";
		return getTotalRecords(sqlTable);
	}

	@Override
	public ArrayList<Product> findDishesBySize(String strsql, Object[] params) {
		// TODO Auto-generated method stub
		return findObjs(strsql,params,Product.class);
	}

	public Product findProduct(String productid) {
		// TODO Auto-generated method stub
		Product product = new Product();
		try {
			String sql = "select * from product where productId=?";
			Connection conn = JDBCUtils.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, productid);
			ResultSet rs = ps.executeQuery();
			if (rs.next()){
				product.setProductId(rs.getString(1));
				product.setProductName(rs.getString(2));
				product.setProductPrice(rs.getFloat(3));
				product.setProductRemained(rs.getInt(4));
				product.setProductDescription(rs.getString(5));
				product.setProductImage(rs.getString(6));
			}
			JDBCUtils.free(rs, ps, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return product;
	}

	@Override
	public boolean updateProductNumber(String productid, int number) {
		// TODO Auto-generated method stub
		IProductDao iProductDao = (IProductDao) DaoFactory.newInstance("IProductDao");
		Product product = iProductDao.findProduct(productid);
		try {
			String sql = "update product set productRemained=? where productId=?";
			Connection conn = JDBCUtils.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, product.getProductRemained()-number);
			ps.setString(2, product.getProductId());
			int rs = ps.executeUpdate();
			JDBCUtils.free(rs, ps, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public int countRows() {
		// XXX ¿ÉÒÔÊ¹ÓÃ¸¸Àà
		int ret = 0;
		try {
			String sql = "select count(*) from product";
			Connection conn = JDBCUtils.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs.next()){
				ret = rs.getInt(1);
			}
			JDBCUtils.free(rs, ps, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ret;
	}

}
