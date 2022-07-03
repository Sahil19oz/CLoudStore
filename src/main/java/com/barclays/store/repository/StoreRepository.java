package com.barclays.store.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.barclays.store.entity.Store;

@Repository
public interface StoreRepository extends CrudRepository<Store, Integer> {

}
