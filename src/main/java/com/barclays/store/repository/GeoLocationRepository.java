package com.barclays.store.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.barclays.store.entity.GeoLocation;

@Repository
public interface GeoLocationRepository extends CrudRepository<GeoLocation, Integer> {

}
