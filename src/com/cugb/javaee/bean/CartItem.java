package com.cugb.javaee.bean;

public class CartItem {
	private Product dish;
	private int quantity;
	public CartItem(){}
	public CartItem(Product dishtoadd, int number){
		this.dish = dishtoadd;
		this.quantity = number;
	}
	public Product getDish() {
		return dish;
	}
	public void setDish(Product dish) {
		this.dish = dish;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
