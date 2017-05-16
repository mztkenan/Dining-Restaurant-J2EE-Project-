package com.cugb.javaee.dao;

import java.util.ArrayList;

import com.cugb.javaee.bean.User;

public interface IUserDao {
	public ArrayList<User> findUsers();
	public boolean findUser(User user);
	public int insertUser(User user);
	public int updateUser(User user);
	public int deleteUser(User user);
}
