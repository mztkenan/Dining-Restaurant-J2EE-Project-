package com.cugb.javaee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cugb.javaee.bean.User;
import com.cugb.javaee.utils.JDBCUtils;

public class UserDaoImpl implements IUserDao {

	@Override
	public ArrayList<User> findUsers() {
		// TODO Auto-generated method stub
		ArrayList<User> users = new ArrayList(); 
		try {
			String sql = "select * from user";
			Connection conn = JDBCUtils.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setUserId(rs.getString(1));
				user.setUsername(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setUserType(rs.getInt(4));
				users.add(user);
			}
			JDBCUtils.free(rs, ps, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}

	@Override
	public boolean findUser(User user) {
		// TODO Auto-generated method stub
		boolean ret = false;
		try {
			String sql = "select * from user where userId=?";
			Connection conn = JDBCUtils.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUserId());
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
	public int insertUser(User user) {
		// TODO Auto-generated method stub
		try {
			String sql = "insert into user values(?,?,?,?)";
			Connection conn = JDBCUtils.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUserId());
			ps.setString(2, user.getUsername());
			ps.setString(3, user.getPassword());
			ps.setInt(4, user.getUserType());
			int rs = ps.executeUpdate();
			JDBCUtils.free(rs, ps, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateUser(User user) {
		// TODO Auto-generated method stub
		try {
			String sql = "update user set username=?,password=?,userType=? where userId=?";
			Connection conn = JDBCUtils.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setInt(3, user.getUserType());
			ps.setString(4, user.getUserId());
			int rs = ps.executeUpdate();
			JDBCUtils.free(rs, ps, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteUser(User user) {
		// TODO Auto-generated method stub
		try {
			String sql = "delete from user where userId=?";
			Connection conn = JDBCUtils.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUserId());
			int rs = ps.executeUpdate();
			JDBCUtils.free(rs, ps, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public boolean login(User user, String password) {
		// TODO Auto-generated method stub
		boolean ret = false;
		try {
			String sql = "select * from user where username=?";
			Connection conn = JDBCUtils.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ResultSet rs = ps.executeQuery();
			if (rs.next() && rs.getString(3).equals(password)){
				ret = true;
			}
			JDBCUtils.free(rs, ps, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ret;
	}

	@Override
	public boolean findUsername(String username) {
		// TODO Auto-generated method stub
		boolean ret = false;
		try {
			String sql = "select * from user where username=?";
			Connection conn = JDBCUtils.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
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
	public int countRows() {
		// TODO Auto-generated method stub
		int ret = 0;
		try {
			String sql = "select count(*) from user";
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

	@Override
	public User findUser(String username) {
		// TODO Auto-generated method stub
		User user = new User(); 
		try {
			String sql = "select * from user where username=?";
			Connection conn = JDBCUtils.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				user.setUserId(rs.getString(1));
				user.setUsername(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setUserType(rs.getInt(4));
			}
			JDBCUtils.free(rs, ps, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
}
