package com.cugb.javaee.dao;

import java.util.ArrayList;

import com.cugb.javaee.bean.OrderInfomation;

public interface IOrderInfomationDao {
	public ArrayList<OrderInfomation> findOrderInfomations();
	public boolean findOrderInfomation(OrderInfomation orderInfomation);
	public int insertOrderInfomation(OrderInfomation orderInfomation);
	public int updateOrderInfomation(OrderInfomation orderInfomation);
	public int deleteOrderInfomation(OrderInfomation orderInfomation);
	public boolean updateOrderInfomation(String userId,String orderId,String oldType,String newType);
	public String countOrderInfomation() ;
	public ArrayList<OrderInfomation> findOrderInfomationsForUser(String UID);
}
