package com.barclays.store.service;

import java.util.List;

import com.barclays.store.dto.CartDTO;

public interface CartService {
	public void addProductToCart(String customerEmailId, CartDTO customerCart) throws Exception;
	public List<CartDTO> getCustomerCarts(String customerEmailId) throws Exception;
	public void modifyQuantityOfProductInCart(Integer cartId, Integer quantity, Integer productId) throws Exception;
	public void deleteProductFromCart(String customerEmailId, Integer cartId);
}
