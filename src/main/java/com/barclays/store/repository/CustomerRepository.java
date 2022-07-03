package com.barclays.store.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.barclays.store.entity.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer>{

	public Customer findByEmailId(String email); 
	public Boolean existsByEmailId(String email);
}
