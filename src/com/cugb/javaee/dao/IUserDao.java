package com.cugb.javaee.dao;

import java.util.ArrayList;

import com.cugb.javaee.bean.User;

public interface IUserDao {
	public ArrayList<User> findUsers();
	public boolean findUser(User user);
	public User findUser(String username);
	public int insertUser(User user);
	public int updateUser(User user);
	public int deleteUser(User user);
	public boolean login(User user,String password);
	public boolean findUsername(String username);
	public int countRows();
}
