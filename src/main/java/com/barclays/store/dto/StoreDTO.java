package com.barclays.store.dto;

import com.barclays.store.entity.Store;

public class StoreDTO {
	private Integer storeId;
	private String storeName;
	private AddressDTO address;
	
	public StoreDTO() {
		super();
	}
	public StoreDTO(Store store) {
		this.storeId = store.getStoreId();
		this.storeName = store.getStoreName();
		this.address = new AddressDTO(store.getAddress());
	}
	public Integer getStoreId() {
		return storeId;
	}
	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public AddressDTO getAddress() {
		return address;
	}
	public void setAddress(AddressDTO address) {
		this.address = address;
	}
	
}
