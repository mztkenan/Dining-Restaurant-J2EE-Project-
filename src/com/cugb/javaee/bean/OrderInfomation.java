package com.cugb.javaee.bean;

import java.sql.Timestamp;

public class OrderInfomation {
	private String orderId;
	private String userId;
	private String orderAddress;
	private String orderPhone;
	private Timestamp orderDate;   
	private float orderPrice;
	private String orderState;
	private String orderRemark;
	public OrderInfomation(){}
	public OrderInfomation(String orderId, String userId, String orderAddress,
			String orderPhone, Timestamp orderDate, float orderPrice,String orderState, 
			String orderRemark){
		this.orderId = orderId;
		this.userId = userId;
		this.orderAddress = orderAddress;
		this.orderPhone = orderPhone;
		this.orderDate = orderDate;      
		this.orderPrice = orderPrice;;
		this.orderState = orderState;
		this.orderRemark = orderRemark;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getOrderAddress() {
		return orderAddress;
	}
	public void setOrderAddress(String orderAddress) {
		this.orderAddress = orderAddress;
	}
	public String getOrderPhone() {
		return orderPhone;
	}
	public void setOrderPhone(String orderPhone) {
		this.orderPhone = orderPhone;
	}
	public Timestamp getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Timestamp timestamp) {
		this.orderDate = timestamp;
	}
	public float getOrderPrice() {
		return orderPrice;
	}
	public void setOrderPrice(float orderPrice) {
		this.orderPrice = orderPrice;
	}
	public String getOrderState() {
		return orderState;
	}
	public void setOrderState(String orderState) {
		this.orderState = orderState;
	}
	public String getOrderRemark() {
		return orderRemark;
	}
	public void setOrderRemark(String orderRemark) {
		this.orderRemark = orderRemark;
	}
	
}
