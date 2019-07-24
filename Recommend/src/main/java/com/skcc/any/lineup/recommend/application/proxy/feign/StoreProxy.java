package com.skcc.any.lineup.recommend.application.proxy.feign;

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

import com.skcc.any.lineup.recommend.application.proxy.feign.dto.store.Store;


@Service
public class StoreProxy {
 
	@Autowired
	private StoreClient storeClient;
	
	public Store findStore(Long id) {
		return storeClient.findStore(id).getContent();
	}

	public Collection<Store> findAllStores() {
		return storeClient.findAllStores().getContent();
	}
	
	public Collection<Store> findAllStores(int size) {
		return storeClient.findAllStores(size).getContent();
	}
	
	public Store findStoreByName(String name) {
		return storeClient.findStore(name);
	}


	public Store findStoreByOwnerID(String ownerAccountId) {
		return storeClient.findStore(ownerAccountId);
	}

		
	
	
	@FeignClient(name="store", url="http://localhost:11002", configuration=FeignClientConfiguration.class)
	interface StoreClient {
		
		@GetMapping("/search/name")
		Store findStoreByStoreName(@RequestParam(value="name", required=true) String name);

		@GetMapping("/search/id")
		Store findStoreByOwnerID(@RequestParam(value="ownerAccountId", required=true) String ownerAccountId);	
		
		@GetMapping("/search/id-name")
		Store findStoreByOwnerIDAndStoreName(@RequestParam(value="ownerAccountId", required=true) String ownerAccountId
								, @RequestParam(value="storeName", required=true) String storeName);	

		/*   기본 생성 목록   */
		@GetMapping("store/{id}")
		Resource<Store> findStore(@PathVariable("id") Long id);
		
		@GetMapping("store")
		Resources<Store> findAllStores();
		
		@GetMapping("store")
		Resources<Store> findAllStores(@RequestParam("size") int size);
		
		@GetMapping("store/search/findByName")
		Store findStore(@RequestParam(value="name", required=true) String name);
	}
}

