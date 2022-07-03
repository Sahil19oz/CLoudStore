package com.barclays.store.dto;

import com.barclays.store.entity.itemData;

public class ProductDTO {
	private Integer productId;
	private String name;
	private Integer mrp;
	private Integer discountPercent;
	private Integer availableQuantity;
	private Integer discountedSellingPrice;
	private Double weightInGms;
	private Boolean outOfStock;
	private Integer quantity;
	
	public ProductDTO(itemData product) {
		this.productId = product.getProductId();
		this.name = product.getName();
		this.mrp = product.getMrp();
		this.discountPercent = product.getDiscountPercent();
		this.discountedSellingPrice = product.getDiscountedSellingPrice();
		this.availableQuantity = product.getAvailableQuantity();
		this.weightInGms = product.getWeightInGms();
		this.outOfStock = product.getOutOfStock();
		this.quantity = product.getQuantity();
		
	}

	public Integer getDiscountedSellingPrice() {
		return discountedSellingPrice;
	}

	public void setDiscountedSellingPrice(Integer discountedSellingPrice) {
		this.discountedSellingPrice = discountedSellingPrice;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getMrp() {
		return mrp;
	}

	public void setMrp(Integer mrp) {
		this.mrp = mrp;
	}

	public Integer getDiscountPercent() {
		return discountPercent;
	}

	public void setDiscountPercent(Integer discountPercent) {
		this.discountPercent = discountPercent;
	}

	public Integer getAvailableQuantity() {
		return availableQuantity;
	}

	public void setAvailableQuantity(Integer availableQuantity) {
		this.availableQuantity = availableQuantity;
	}

	public Double getWeightInGms() {
		return weightInGms;
	}

	public void setWeightInGms(Double weightInGms) {
		this.weightInGms = weightInGms;
	}

	public Boolean getOutOfStock() {
		return outOfStock;
	}

	public void setOutOfStock(Boolean outOfStock) {
		this.outOfStock = outOfStock;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	
}
