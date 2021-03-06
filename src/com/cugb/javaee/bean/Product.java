package com.cugb.javaee.bean;

public class Product {
	private String productId;
	private String productName;
	private float productPrice;
	private int productRemained;
	private String productDescription;
	private String productImage;
	public Product(){}
	public Product(String productId, String productName, float productPrice, int productRemained, String productDescription, String productImage){
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productRemained = productRemained;
		this.productDescription = productDescription;
		this.productImage = productImage;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public float getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(float productPrice) {
		this.productPrice = productPrice;
	}
	public int getProductRemained() {
		return productRemained;
	}
	public void setProductRemained(int productRemained) {
		this.productRemained = productRemained;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public String getProductImage() {
		return productImage;
	}
	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}
}
