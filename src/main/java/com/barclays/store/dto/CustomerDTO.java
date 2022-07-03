package com.barclays.store.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.barclays.store.entity.Customer;
import com.barclays.store.entity.GeoLocation;

public class CustomerDTO {

	private String emailId;
	private String name;
	private String password;
	private String phoneNumber;
	private GeoLocation geoLocation;
	private List<AddressDTO> addresses;
	private List<CartDTO> customerCarts;

	public CustomerDTO() {
		super();
	}

	public CustomerDTO(Customer customer) {
		this.emailId = customer.getEmailId();
		this.name = customer.getName();
		this.password = customer.getPassword();
		this.phoneNumber = customer.getPhoneNumber();
		this.geoLocation = customer.getGeoLocation();
		this.addresses = customer.getAddresses().stream().map(add -> new AddressDTO(add)).collect(Collectors.toList());
		this.customerCarts = customer.getCustomerCarts().stream().map(cart -> new CartDTO(cart))
				.collect(Collectors.toList());
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public GeoLocation getGeoLocation() {
		return geoLocation;
	}

	public void setGeoLocation(GeoLocation geoLocation) {
		this.geoLocation = geoLocation;
	}

	public List<AddressDTO> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<AddressDTO> addresses) {
		this.addresses = addresses;
	}

	public List<CartDTO> getCustomerCarts() {
		return customerCarts;
	}

	public void setCustomerCarts(List<CartDTO> customerCarts) {
		this.customerCarts = customerCarts;
	}

}
