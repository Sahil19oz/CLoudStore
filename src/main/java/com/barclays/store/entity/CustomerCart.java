package com.barclays.store.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.barclays.store.dto.CartDTO;

@Entity
public class CustomerCart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cartId;
	@JoinColumn(name = "PRODUCT_ID")
	@OneToOne(cascade = CascadeType.ALL)
	private itemData product;
	private Integer quantity;
	private String customerEmailId;
	
	public CustomerCart() {
		super();
	}
	public CustomerCart(CartDTO cart) {
		this.cartId = cart.getCartId();
		this.product = new itemData(cart.getProduct());
		this.quantity = cart.getQuantity();
		this.customerEmailId = cart.getCustomerEmailId();
	}
	public Integer getCartId() {
		return cartId;
	}
	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}
	public itemData getProduct() {
		return product;
	}
	public void setProduct(itemData product) {
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
