package com.barclays.store.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barclays.store.dto.CartDTO;
import com.barclays.store.entity.CustomerCart;
import com.barclays.store.entity.itemData;
import com.barclays.store.repository.CustomerCartRepository;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	CustomerCartRepository cartRepo;

	@Override
	public void addProductToCart(String customerEmailId, CartDTO customerCart) throws Exception {
		List<CustomerCart> customerCartsFromDB = cartRepo.findCustomerCartByCustomerEmailId(customerEmailId);

		for (CustomerCart customerCartFromDB : customerCartsFromDB) {
			if (customerCartFromDB.getProduct().getProductId().equals(customerCart.getProduct().getProductId()))
				throw new Exception("CustomerCartService.PRODUCT_PRESENT_IN_CART");
		}

		itemData productFromDao = cartRepo.getProductByCartId(customerCart.getProduct().getProductId());
		if (productFromDao.getQuantity() < customerCart.getQuantity())
			throw new Exception("CustomerCartService.INSUFFICIENT_STOCK");
		CustomerCart newWish = new CustomerCart(customerCart);
		cartRepo.save(newWish);

	}

	@Override
	public List<CartDTO> getCustomerCarts(String customerEmailId) throws Exception {
		List<CustomerCart> customerCartsFromDB = cartRepo.findCustomerCartByCustomerEmailId(customerEmailId);
		if (customerCartsFromDB == null || customerCartsFromDB.isEmpty()) {
			throw new Exception("CustomerCartService.NO_PRODUCT_ADDED_TO_CART");
		}
		List<CartDTO> allCartItems = customerCartsFromDB.stream().map(item -> new CartDTO(item))
				.collect(Collectors.toList());
		return allCartItems;
	}

	@Override
	public void modifyQuantityOfProductInCart(Integer cartId, Integer quantity, Integer productId) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteProductFromCart(String customerEmailId, Integer cartId) {
		// TODO Auto-generated method stub

	}

}
