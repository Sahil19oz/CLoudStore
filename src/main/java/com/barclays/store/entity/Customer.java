package com.barclays.store.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.barclays.store.dto.CustomerDTO;


@Entity
@Table(name = "CUSTOMER")
public class Customer {
	@Id
	@Column(name = "EMAIL_ID")
	private String emailId;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "PASSWORD")
	private String password;
	
	@Column(name = "PHONE_NUMBER")
	private String phoneNumber;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "LOC_ID")
	private GeoLocation geoLocation;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "ADDRESS_ID")
	private List<Address> addresses;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "CART_ID")
	private List<CustomerCart> customerCarts;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "ORDER_ID")
	private List<Order> orders;

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

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public List<CustomerCart> getCustomerCarts() {
		return customerCarts;
	}

	public void setCustomerCarts(List<CustomerCart> customerCarts) {
		this.customerCarts = customerCarts;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public static Customer getModel(CustomerDTO customerDTO) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
