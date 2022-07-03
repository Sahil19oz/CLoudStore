package com.barclays.store.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.barclays.store.entity.CustomerCart;
import com.barclays.store.entity.itemData;

@Repository
public interface CustomerCartRepository extends CrudRepository<CustomerCart, Integer> {

	public List<CustomerCart> findCustomerCartByCustomerEmailId(String emailCustomerId);
	public itemData getProductByCartId(Integer productID);
}
