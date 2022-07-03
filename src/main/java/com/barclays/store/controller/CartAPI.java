package com.barclays.store.controller;

import java.util.List;

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
import org.springframework.web.server.ResponseStatusException;

import com.barclays.store.dto.CartDTO;
import com.barclays.store.service.CartService;

@CrossOrigin
@RestController
@RequestMapping("cart-api/")
public class CartAPI {

	@Autowired
	private CartService customerCartService;
	
	@Autowired
	private Environment environment;

	@PostMapping(value = "addProductToCart/{customerEmailId:.+}")
	public ResponseEntity<String> addProductToCart(@RequestBody CartDTO customerCart,
			@PathVariable("customerEmailId") String customerEmailId) throws Exception {
		try {
			customerCartService.addProductToCart(customerEmailId, customerCart);
			String message = environment.getProperty("CustomerCartAPI.PRODUCT_ADDED_TO_CART");
			return new ResponseEntity<String>(message, HttpStatus.OK);

		} catch (Exception e) {

			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, environment.getProperty(e.getMessage()));
		}
	}

	@GetMapping(value = "getCustomerCart/{customerEmailId:.+}/")
	public ResponseEntity<List<CartDTO>> getCustomerCart(@PathVariable("customerEmailId") String customerEmailId)
			throws Exception {
		List<CartDTO> list = null;
		try {

			list = customerCartService.getCustomerCarts(customerEmailId);
			ResponseEntity<List<CartDTO>> response = new ResponseEntity<List<CartDTO>>(list, HttpStatus.OK);
			return response;
		} catch (Exception e) {

			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, environment.getProperty(e.getMessage()));
		}
	}

	@PostMapping(value = "modifyQuantityOfProductInCart")
	public ResponseEntity<String> modifyQuantityOfProductInCart(@RequestBody CartDTO customerCart) throws Exception {

		try {
			customerCartService.modifyQuantityOfProductInCart(customerCart.getCartId(), customerCart.getQuantity(),
					customerCart.getProduct().getProductId());
			;

			String message = environment.getProperty("CustomerCartAPI.QUANTITY_UPDATE_SUCCESS");

			return new ResponseEntity<String>(message, HttpStatus.OK);
		} catch (Exception e) {

			throw new ResponseStatusException(HttpStatus.PRECONDITION_FAILED, environment.getProperty(e.getMessage()));
		}
	}

	@PostMapping(value = "deleteProductFromCart/{customerEmailId:.+}")
	public ResponseEntity<String> deleteProductFromCart(@PathVariable("customerEmailId") String customerEmailId,
			@RequestBody String cartId) throws Exception {

		try {
			customerCartService.deleteProductFromCart(customerEmailId, Integer.parseInt(cartId));

			String message = environment.getProperty("CustomerCartAPI.PRODUCT_DELETED_FROM_CART_SUCCESS");

			return new ResponseEntity<String>(message, HttpStatus.OK);
		} catch (Exception e) {

			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, environment.getProperty(e.getMessage()));
		}
	}
}
