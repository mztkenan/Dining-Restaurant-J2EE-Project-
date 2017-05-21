package com.cugb.javaee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cugb.javaee.bean.OrderInfomation;
import com.cugb.javaee.bean.User;
import com.cugb.javaee.utils.JDBCUtils;

public class OrderInfomationDaoImpl implements IOrderInfomationDao {

	@Override
	public ArrayList<OrderInfomation> findOrderInfomations() {
		// TODO Auto-generated method stub
		ArrayList<OrderInfomation> orderInfomations = new ArrayList(); 
		try {
			String sql = "select * from orderInfomation";
			Connection conn = JDBCUtils.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				OrderInfomation orderInfomation = new OrderInfomation();
				orderInfomation.setOrderId(rs.getString(1));
				orderInfomation.setUserId(rs.getString(2));
				orderInfomation.setOrderAddress(rs.getString(3));
				orderInfomation.setOrderPhone(rs.getString(4));
				orderInfomation.setOrderDate(rs.getTimestamp(5));
				orderInfomation.setOrderPrice(rs.getFloat(6));
				orderInfomation.setOrderState(rs.getString(7));
				orderInfomation.setOrderRemark(rs.getString(8));
				orderInfomations.add(orderInfomation);
			}
			JDBCUtils.free(rs, ps, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return orderInfomations;
	}

	@Override
	public boolean findOrderInfomation(OrderInfomation orderInfomation) {
		// TODO Auto-generated method stub
		boolean ret = false;
		try {
			String sql = "select * from orderInfomation where orderId=? and userId=?";
			Connection conn = JDBCUtils.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, orderInfomation.getOrderId());
			ps.setString(2, orderInfomation.getUserId());
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
	public int insertOrderInfomation(OrderInfomation orderInfomation) {
		// TODO Auto-generated method stub
		try {
			String sql = "insert into orderInfomation values(?,?,?,?,?,?,?,?)";
			Connection conn = JDBCUtils.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, orderInfomation.getOrderId());
			ps.setString(2, orderInfomation.getUserId());
			ps.setString(3, orderInfomation.getOrderAddress());
			ps.setString(4, orderInfomation.getOrderPhone());
			//ps.setTimestamp(5, orderInfomation.getOrderDate());
			ps.setFloat(6, orderInfomation.getOrderPrice());
			ps.setString(7, orderInfomation.getOrderState());
			ps.setString(8, orderInfomation.getOrderRemark());
			int rs = ps.executeUpdate();
			JDBCUtils.free(rs, ps, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateOrderInfomation(OrderInfomation orderInfomation) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteOrderInfomation(OrderInfomation orderInfomation) {
		// TODO Auto-generated method stub
		return 0;
	}

}