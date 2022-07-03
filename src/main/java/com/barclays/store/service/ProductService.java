package com.barclays.store.service;

import java.util.List;

import com.barclays.store.dto.ProductDTO;

public interface ProductService {
	public List<ProductDTO> getAllProduct() throws Exception;
	public ProductDTO findByItemName(String itemName) throws Exception;
}
