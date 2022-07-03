package com.barclays.store.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.barclays.store.entity.itemData;

@Repository
public interface ProductRepository extends CrudRepository<itemData, Integer> {

}
