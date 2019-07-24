package com.skcc.any.lineup.store.application.sp.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.skcc.any.lineup.store.domain.model.Address;
import com.skcc.any.lineup.store.domain.model.Store;
import com.skcc.any.lineup.store.domain.model.StoreDescription;
import com.skcc.any.lineup.store.domain.service.StoreService;

@RestController
@RequestMapping("/v1/store")
public class StoreRestController implements StoreService {
	@Autowired
	private StoreService storeService;

	@Override
	@GetMapping
	public List<Store> findAll() {
		return storeService.findAll(); 
	}
	
	@Override
	@GetMapping("/{id}")
	public Store findById(@PathVariable("id") Long id) {
		return storeService.findById(id);
	}

	@Override
	@PostMapping
	public Store register(@RequestBody Store store) {
		return storeService.register(store);
	}

	@Override
	@PutMapping("/{id}")
	public Store update(@PathVariable("id") Long id, @RequestBody Store store) {
		return storeService.update(id, store);
	}

	@Override
	@PutMapping("/storeUpdate")
	public Store updateByOwnerAccountIdAndStoreName(@RequestParam("ownerAccountId") String ownerAccountId,
													@RequestParam("name") String name,	
													@RequestParam("address") Address address,		
													@RequestParam("sd") StoreDescription sd) {	
	return storeService.updateByOwnerAccountIdAndStoreName(ownerAccountId, name, address, sd);
	}	
	
	@Override
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		storeService.delete(id);
	}

	@Override
	@DeleteMapping("/storeDelete")
	public void deleteByOwnerAccountIdAndStoreName(@RequestParam("ownerAccountId") String ownerAccountId, @RequestParam("name") String name) {
		storeService.deleteByOwnerAccountIdAndStoreName(ownerAccountId,name);
	}
	
	
	@Override
	@GetMapping("/search/name")
	public List<Store> findStoreByStoreName(@RequestParam("name") String name) {
		return storeService.findStoreByStoreName(name);
	}

	@Override
	@GetMapping("/search/id")
	public Store findStoreByOwnerID(@RequestParam("ownerAccountId") String ownerAccountId) {
		return storeService.findStoreByOwnerID(ownerAccountId);
	}

	@Override
	@GetMapping("/search/id-name")
	public Store findStoreByOwnerIDAndStoreName(@RequestParam("ownerAccountId") String ownerAccountId
														, @RequestParam("storeName") String storeName) {
		return storeService.findStoreByOwnerIDAndStoreName(ownerAccountId,storeName);
	}

	@Override
	//@GetMapping
	public Page<Store> findAll(Pageable pageable) {
		return storeService.findAll(pageable); 
	}


}
