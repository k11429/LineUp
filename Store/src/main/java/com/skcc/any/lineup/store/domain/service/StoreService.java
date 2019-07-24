package com.skcc.any.lineup.store.domain.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.skcc.any.lineup.store.domain.model.Address;
import com.skcc.any.lineup.store.domain.model.Store;
import com.skcc.any.lineup.store.domain.model.StoreDescription;


public interface StoreService {
	Store findById(Long id);
	List<Store> findAll();
	Page<Store> findAll(Pageable pageable);
	
	List<Store> findStoreByStoreName(String name);
	Store findStoreByOwnerID(String id);
	Store findStoreByOwnerIDAndStoreName(String ownerAccountId, String storeName);
	
	Store register(Store store);
	Store update(Long id, Store store);	
	void delete(Long id);
	
	Store updateByOwnerAccountIdAndStoreName(String id, String name, Address address, StoreDescription sd);
	void deleteByOwnerAccountIdAndStoreName(String id, String name);
	
}
