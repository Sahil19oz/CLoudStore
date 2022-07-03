package com.barclays.store.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.barclays.store.dto.ProductDTO;
import com.barclays.store.entity.itemData;
import com.barclays.store.repository.ProductRepository;
import com.barclays.store.utility.JsonParser;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepo;
	
	@Autowired
	Environment env;
	
	public static Log Logger = LogFactory.getLog(ProductServiceImpl.class);
	
	@Override
	public List<ProductDTO> getAllProduct() throws Exception {
		//parseJson();
		Iterable<itemData> allProducts = productRepo.findAll();
		List<ProductDTO> products = StreamSupport.stream(allProducts.spliterator(), false).map(p -> new ProductDTO(p))
	            .collect(Collectors.toList());
		Logger.info(products.size() + " products present in the Store");
//		Iterable<itemData> products = allProducts.stream(p -> new itemData(p)).collect(Collectors.toList());
//		productRepo.saveAll(products);
		return products;
	}
	
	public List<ProductDTO> parseJson() throws Exception{
		String path = "/store/src/main/resources/items.json";
		List<JSONObject> allData = JsonParser.parseItemFile(path);
		List<ProductDTO> allProducts = null;
		for(JSONObject d : allData) {
			JSONObject obj = (JSONObject) d.get("Data");
			itemData item = null;
				item.setName((String)obj.get("name"));
				item.setMrp(Integer.parseInt((String)obj.get("mrp")));
				item.setDiscountPercent(Integer.parseInt((String)obj.get("discountPercent")));
				item.setAvailableQuantity(Integer.parseInt((String)obj.get("availableQuantity")));
				item.setDiscountedSellingPrice(Integer.parseInt((String)obj.get("discountedSellingPrice")));
				item.setWeightInGms(Double.parseDouble((String)obj.get("weightInGms")));
				item.setOutOfStock(((String)obj.get("outOfStock")).equals("false") ? false : true);
				item.setQuantity(Integer.parseInt((String)obj.get("quantity")));
			allProducts.add(new ProductDTO(item)); 
		}
		return allProducts;
	}

	@Override
	public ProductDTO findByItemName(String itemName) throws Exception {
		Logger.info("Searhing for the " + itemName +" in the Inventory");
		List<ProductDTO> allProducts = getAllProduct();
		Map<String , ProductDTO> productNameMapper = new HashMap<>();
		
		allProducts.stream().map(item -> productNameMapper.put(item.getName(),item));
		return productNameMapper.get(itemName);
	}
		 	

}
