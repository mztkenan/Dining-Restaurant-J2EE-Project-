package com.cugb.javaee.bean;

public class OrderItem {
	private String productId;
	private String orderId;
	private String orderItemId;
	private int productNum;
	private float orderItemSubtotal;
	public OrderItem(){}
	public OrderItem(String productId, String orderId, String orderItemId, int productNum, float orderItemSubtotal){
		this.productId = productId;
		this.orderId = orderId;
		this.orderItemId = orderItemId;
		this.productNum = productNum;
		this.orderItemSubtotal = orderItemSubtotal;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getOrderItemId() {
		return orderItemId;
	}
	public void setOrderItemId(String orderItemId) {
		this.orderItemId = orderItemId;
	}
	public int getProductNum() {
		return productNum;
	}
	public void setProductNum(int productNum) {
		this.productNum = productNum;
	}
	public float getOrderItemSubtotal() {
		return orderItemSubtotal;
	}
	public void setOrderItemSubtotal(float orderItemSubtotal) {
		this.orderItemSubtotal = orderItemSubtotal;
	}
}
