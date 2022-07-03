package com.barclays.store.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.barclays.store.entity.Address;

@Repository
public interface AddressRepository extends CrudRepository<Address, Integer> {

}
