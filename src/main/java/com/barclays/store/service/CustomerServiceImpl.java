package com.barclays.store.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.barclays.store.dto.AddressDTO;
import com.barclays.store.dto.CustomerDTO;
import com.barclays.store.entity.Customer;
import com.barclays.store.repository.CustomerRepository;
import com.barclays.store.utility.HashingUtility;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	CustomerRepository customerRepo;
	
	@Autowired
	Environment env;
	
	
	private static final Log Logger = LogFactory.getLog(CustomerServiceImpl.class);
	
	@Override
	public String registerNewCustomer(CustomerDTO customerDTO) throws Exception {
		Logger.info("Registering new user with email "+ customerDTO.getEmailId());
		boolean ifUserExist = customerRepo.existsByEmailId(customerDTO.getEmailId());
		if(ifUserExist) return "CustomerService.EMAIL_ID_ALREADY_IN_USE";
		Customer customer = Customer.getModel(customerDTO);
		customerRepo.save(customer);
		return "CustomerService.USER_REGISTERED";
	}
	
	@Override
	public CustomerDTO authenticateCustomer(String emailId, String password) throws Exception {
		Customer customer = null;
		boolean isCustomerRegistered = customerRepo.existsByEmailId(emailId);
		if(!isCustomerRegistered) {
			Logger.info("CustomerService.SIGN_UP_FIRST");
			return null;
		}
		customer = customerRepo.findByEmailId(emailId.toLowerCase());
		//String hashedPassword = HashingUtility.getHashValue(password);
		String hashedPassword = customer.getPassword();
		if(hashedPassword.equals(password)){
			
				customer  = customerRepo.findByEmailId(emailId);
		}
		else
			throw new Exception ("CustomerService.INVALID_CREDENTIALS");
		
		return new CustomerDTO(customer);
	}


	@Override
	public Integer addShippingAddress(String customerEmailId, AddressDTO addressDTO) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AddressDTO getShippingAddress(Integer addressId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean checkIfUserExist(String emailId) {
		Logger.info("CHECKING IF USER ALREADY EXIST IN DATABASE");
		return customerRepo.existsByEmailId(emailId);
	}

}
