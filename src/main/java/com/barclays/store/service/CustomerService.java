package com.barclays.store.service;

import com.barclays.store.dto.AddressDTO;
import com.barclays.store.dto.CustomerDTO;

public interface CustomerService {

	public CustomerDTO authenticateCustomer(String emailId, String password) throws Exception;

	public String registerNewCustomer(CustomerDTO customerDTO) throws Exception;

	public Integer addShippingAddress(String customerEmailId, AddressDTO addressDTO) throws Exception;

	public AddressDTO getShippingAddress(Integer addressId) throws Exception;

	public boolean checkIfUserExist(String emailId);
}
