package com.barclays.store.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.barclays.store.dto.AddressDTO;
import com.barclays.store.dto.CustomerDTO;
import com.barclays.store.service.CustomerService;

@CrossOrigin
@RestController
@Validated
@RequestMapping(value = "/customer-api")
public class CustomerAPI {

	@Autowired
	CustomerService customerService;

	@Autowired
	Environment env;

	public static Log Logger = LogFactory.getLog(CustomerAPI.class);

	@PostMapping(value = "/sign-up")
	public ResponseEntity<String> registerCustomer(@RequestBody CustomerDTO customerDTO) throws Exception {
		String message = customerService.registerNewCustomer(customerDTO);
		return new ResponseEntity<String>(message, HttpStatus.OK);
	}

	@PostMapping(value = "/login")
	public ResponseEntity<CustomerDTO> authenticateCustomer(@RequestBody CustomerDTO customerDTO) throws Exception {
		 Logger.info(customerDTO.getEmailId() + " is trying to login to system. VALIDATING CREDENTIALS... ");
		CustomerDTO objectFromDB = customerService.authenticateCustomer(customerDTO.getEmailId(),
				customerDTO.getPassword());
		return new ResponseEntity<CustomerDTO>(objectFromDB, HttpStatus.OK);
	}

	@PostMapping(value = "add-address/{emailId}")
	public ResponseEntity<String> addShippingAddress(@RequestBody AddressDTO addressDTO, @PathVariable String emailId)
			throws Exception {
		boolean doesEmailExist = customerService.checkIfUserExist(emailId);
		if (!doesEmailExist)
			return new ResponseEntity<String>("User does not exist", HttpStatus.FORBIDDEN);
		int addressId = customerService.addShippingAddress(emailId, addressDTO);
		return new ResponseEntity<String>("Address Registered with Id : " + addressId, HttpStatus.OK);

	}

	@GetMapping(value = "getShippingAddress/{addressId}")
	public ResponseEntity<AddressDTO> getShippingAddress(@PathVariable("addressId") String addressId)
			throws Exception {
		Integer id = Integer.parseInt(addressId);
		AddressDTO address = customerService.getShippingAddress(id);
		return new ResponseEntity<AddressDTO>(address, HttpStatus.OK);
	}

}
