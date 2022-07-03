package com.barclays.store.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.barclays.store.dto.ProductDTO;

@Entity
@Table(name = "PRODUCT")
public class itemData {
	
	@Id
	@Column(name="PRODUCT_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer productId;
	
	private String name;
	
	private Integer mrp;
	
	private Integer discountPercent;
	
	private Integer availableQuantity;
	
	private Integer discountedSellingPrice;
	
	private Double weightInGms;
	
	private Boolean outOfStock;
	
	private Integer quantity;

	public itemData(ProductDTO product) {
		this.name = product.getName();
		this.mrp = product.getMrp();
		this.discountPercent = product.getDiscountPercent();
		this.availableQuantity = product.getAvailableQuantity();
		this.discountedSellingPrice = product.getDiscountedSellingPrice();
		this.weightInGms = product.getWeightInGms();
		this.outOfStock = product.getOutOfStock();
		this.quantity = product.getQuantity();
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	
	public Integer getDiscountedSellingPrice() {
		return discountedSellingPrice;
	}

	public void setDiscountedSellingPrice(Integer discountedSellingPrice) {
		this.discountedSellingPrice = discountedSellingPrice;
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
