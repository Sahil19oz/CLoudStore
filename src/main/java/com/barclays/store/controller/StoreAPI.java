package com.barclays.store.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.barclays.store.dto.CustomerDTO;
import com.barclays.store.dto.GeoLocationDTO;
import com.barclays.store.dto.StoreDTO;
import com.barclays.store.service.StoreService;

@CrossOrigin
@RestController
@RequestMapping(value = "/store-api")
public class StoreAPI {

	@Autowired
	StoreService storeService;

	@Autowired
	Environment env;

	public static Log Logger = LogFactory.getLog(CustomerAPI.class);

	@GetMapping(value = "/getstores")
	public ResponseEntity<List<StoreDTO>> getAllStores() throws Exception {
		Logger.info("Fetching all stores in the vicinity");
		List<StoreDTO> allStores = storeService.getAllStores();
		return new ResponseEntity<List<StoreDTO>>(allStores, HttpStatus.OK);

	}

	@PostMapping(value = "addstore")
	public ResponseEntity<String> addStore(@RequestBody StoreDTO storeDTO) throws Exception {
		Integer storeId = storeService.addStore(storeDTO);
		String message = env.getProperty("STORE.ADDED_TO_MARKET") + storeId;
		return new ResponseEntity<String>(message, HttpStatus.OK);
	}

	@GetMapping(value = "/getstore/{storeId}")
	public ResponseEntity<StoreDTO> getStoreByID(@PathVariable Integer storeId) throws Exception {
		Logger.info("Fetching the store info with store Id : " + storeId);
		StoreDTO store = storeService.getStoreById(storeId);
		return new ResponseEntity<>(store, HttpStatus.OK);

	}

	@GetMapping(value = "getnearestStore/{numberOfStores}")
	public ResponseEntity<List<StoreDTO>> getAllNearestStores(@RequestBody CustomerDTO customer,
			@PathVariable Integer numberOfStores) throws Exception {
		if(numberOfStores < 1) {
			Logger.info("Invalid Arguments recieved");
			return null;
		}
		GeoLocationDTO location = new GeoLocationDTO(customer.getAddresses().get(0).getGeoLocation());
		List<StoreDTO> allNearestStores = storeService.getNearestStore(location, numberOfStores);
		return new ResponseEntity<List<StoreDTO>>(allNearestStores,HttpStatus.OK);
	}

}
