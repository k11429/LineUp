package com.skcc.any.lineup.lineup.application.proxy.feign;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.netflix.feign.FeignClientProperties.FeignClientConfiguration;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.skcc.any.lineup.lineup.application.proxy.feign.dto.store.Store;

@Service
public class StoreProxy {
 
	@Autowired
	private StoreClient storeClient;
	
	public Store findProduct(Long id) {
		return storeClient.findProduct(id).getContent();
	}

	public Collection<Store> findAllProducts() {
		return storeClient.findAllProducts().getContent();
	}
	
	public Collection<Store> findAllProducts(int size) {
		return storeClient.findAllProducts(size).getContent();
	}
	
	public Store findProductByName(String name) {
		return storeClient.findProduct(name);
	}

	@FeignClient(name="store", url="http://localhost:11002", configuration=FeignClientConfiguration.class)
	interface storeClient {
		@GetMapping("store/{id}")
		Resource<Store> findStore(@PathVariable("id") Long id);
		
		@GetMapping("store")
		Resources<Store> findAllStores();
		
		@GetMapping("store")
		Resources<Store> findAllStores(@RequestParam("size") int size);
		
		@GetMapping("store/search/name")
		Store findStore(@RequestParam(value="name", required=true) String name);
	}
}

