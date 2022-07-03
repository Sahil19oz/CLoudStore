package com.barclays.store.service;

import java.util.List;

import com.barclays.store.dto.GeoLocationDTO;
import com.barclays.store.dto.StoreDTO;

public interface StoreService {
	public List<StoreDTO> getAllStores() throws Exception;
	public Integer addStore(StoreDTO store) throws Exception;
	public StoreDTO getStoreById(Integer id) throws Exception;
	public List<StoreDTO> getNearestStore(GeoLocationDTO location , int k) throws Exception;
}
