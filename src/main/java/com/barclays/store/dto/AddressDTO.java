package com.barclays.store.dto;

import com.barclays.store.entity.Address;
import com.barclays.store.entity.GeoLocation;

public class AddressDTO {

	private Integer addressId;
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String state;
	private String pin;
	private GeoLocation geoLocation;
	
	public AddressDTO(Address add) {
		this.addressId = add.getAddressId();
		this.addressLine1 = add.getAddressLine1();
		this.addressLine2 = add.getAddressLine2();
		this.city = add.getCity();
		this.state = add.getState();
		this.pin = add.getPin();
		this.geoLocation = add.getGeoLocation();
	}
	public Integer getAddressId() {
		return addressId;
	}
	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	public String getAddressLine2() {
		return addressLine2;
	}
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	public GeoLocation getGeoLocation() {
		return geoLocation;
	}
	public void setGeoLocation(GeoLocation geoLocation) {
		this.geoLocation = geoLocation;
	}
	
	
}
