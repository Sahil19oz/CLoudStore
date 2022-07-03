package com.barclays.store.dto;

import com.barclays.store.entity.CustomerCart;

public class CartDTO {

	private Integer cartId;
	private ProductDTO product;
	private Integer quantity;
	private String customerEmailId;
	
	public CartDTO(CustomerCart cart) {
		this.cartId = cart.getCartId();
		this.product = new ProductDTO(cart.getProduct());
		this.quantity = cart.getQuantity();
		this.customerEmailId = cart.getCustomerEmailId();
	}
	public Integer getCartId() {
		return cartId;
	}
	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}
	public ProductDTO getProduct() {
		return product;
	}
	public void setProduct(ProductDTO product) {
		this.product = product;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public String getCustomerEmailId() {
		return customerEmailId;
	}
	public void setCustomerEmailId(String customerEmailId) {
		this.customerEmailId = customerEmailId;
	}
	
	
	
}
