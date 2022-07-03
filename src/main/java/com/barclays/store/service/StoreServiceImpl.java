package com.barclays.store.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barclays.store.dto.GeoLocationDTO;
import com.barclays.store.dto.StoreDTO;
import com.barclays.store.entity.GeoLocation;
import com.barclays.store.entity.Store;
import com.barclays.store.repository.StoreRepository;

@Service
public class StoreServiceImpl implements StoreService {

	@Autowired
	StoreRepository storeRepo;

	public static Log Logger = LogFactory.getLog(StoreServiceImpl.class);

	@Override
	public List<StoreDTO> getAllStores() throws Exception {
		Logger.info("fetching all stores in the city");
		Iterable<Store> allStore = storeRepo.findAll();
		List<StoreDTO> availableStores = StreamSupport.stream(allStore.spliterator(), false)
				.map(store -> new StoreDTO(store)).collect(Collectors.toList());
		Logger.info("There are a total of " + availableStores.size() + " Stores in our city");
		return availableStores;
	}

	@Override
	public Integer addStore(StoreDTO store) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StoreDTO getStoreById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StoreDTO> getNearestStore(GeoLocationDTO location, int closestStorestoReturn) throws Exception {
		List<StoreDTO> allAvailableStores = getAllStores();
		PriorityQueue<StoreDTO> heapQueue = new PriorityQueue<StoreDTO>(closestStorestoReturn,
				(s1, s2) -> Double.compare(calculateEuclideanDistance(s2, location),calculateEuclideanDistance(s1, location)));
		
		for(StoreDTO store : allAvailableStores) {
			heapQueue.offer(store);
			if(heapQueue.size() > closestStorestoReturn) {
				heapQueue.poll();
			}
			
		}
		List<StoreDTO> resultStore = new ArrayList<>();
		while(!heapQueue.isEmpty()) {
			resultStore.add(heapQueue.poll());
		}
		return resultStore;
	}

	public static Double calculateEuclideanDistance(StoreDTO store, GeoLocationDTO curLocation) {
		GeoLocation refLocation = store.getAddress().getGeoLocation();
		return Math.abs(refLocation.getLatitude() - curLocation.getLatitude())
				- Math.abs(refLocation.getLongitude() - curLocation.getLongitude());
	}

}
