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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.barclays.store.dto.ProductDTO;
import com.barclays.store.service.ProductService;

@CrossOrigin
@RestController
@RequestMapping(value = "/product-api")
public class ProductAPI {

	@Autowired
	ProductService productService;

	@Autowired
	Environment env;

	public static Log Logger = LogFactory.getLog(CustomerAPI.class);
	
	@GetMapping(value = "/getproducts")
	public ResponseEntity<List<ProductDTO>> getAllProducts() throws Exception{
		Logger.info("Fetching all Products available in the store");
		List<ProductDTO> allProduct = productService.getAllProduct();
		return new ResponseEntity<List<ProductDTO>>(allProduct,HttpStatus.OK);
		
	}
	
	@GetMapping(value = "/findproduct/{itemName}")
	public ResponseEntity<ProductDTO> findProductByName(@PathVariable String itemName) throws Exception{
		ProductDTO product = productService.findByItemName(itemName);
		return new ResponseEntity<ProductDTO>(product,HttpStatus.OK);
	}
	
}
