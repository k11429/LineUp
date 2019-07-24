package com.skcc.any.lineup.store.domain.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skcc.any.lineup.store.domain.model.Store;
import com.skcc.any.lineup.store.domain.model.StoreType;
import com.skcc.any.lineup.store.domain.repository.StoreRepository;


@Service("storeLogic")
public class StoreLogic implements StoreService {
	@Autowired
	private StoreRepository storeRepository;

	@Override
	@Transactional(readOnly=true)
	public Store findById(Long id) {
		return storeRepository.findOne(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Store> findStoreByStoreName(String name) {
		return storeRepository.findByStoreNameLike(name);
	}

	@Override
	@Transactional(readOnly=true)
	public Store findStoreByOwnerID(String ownerAccountId) {
		return storeRepository.findByOwnerAccountId(ownerAccountId);
	}

	@Override
	@Transactional(readOnly=true)
	public Store findStoreByOwnerIDAndStoreName(String ownerAccountId, String storeName) {
		return storeRepository.findByOwnerAccountIdAndStoreName(ownerAccountId,storeName);
	}
	
	@Override
	@Transactional(readOnly=true)
	public List<Store> findAll() {
		return storeRepository.findAll();
	}

	
	@Override
	@Transactional(readOnly=true)
	public Page<Store> findAll(Pageable pageable) {
		return storeRepository.findAll(pageable);
	}

	@Override
	@Transactional
	public Store register(Store store) {
		return storeRepository.save(store);
	}

	@Override
	@Transactional
	public Store update(Long id, Store newStore) {
		Store oldStore = storeRepository.findOne(id);
		if(oldStore != null) {
			BeanUtils.copyProperties(newStore,  oldStore, "id");
			return storeRepository.save(oldStore);
		} else {
			return null;
		}
	}

	@Override
	@Transactional
	public Store updateByOwnerAccountIdAndStoreName(String ownerAccountId
												   , String storeName
												   , Integer zip
												   , String storeAddress
												   , String storeIntro
												   , StoreType storeType) {
		Store oldStore = storeRepository.findByOwnerAccountIdAndStoreName(ownerAccountId, storeName);
		if(oldStore != null) {
			oldStore.getStoreAddress().setZipCode(zip);
			oldStore.getStoreAddress().setStoreAddress(storeAddress);
			oldStore.getStoreDescription().setStoreIntro(storeIntro);
			oldStore.getStoreDescription().setStoreType(storeType);
			return storeRepository.save(oldStore);
		} else {
			return null;
		}
	}
	
	
	@Override
	@Transactional
	public void delete(Long id) {
		storeRepository.delete(id);
	}
	
	@Override
	@Transactional
	public void deleteByOwnerAccountIdAndStoreName(String id, String name) {
		storeRepository.deleteByOwnerAccountIdAndStoreName(id,name);
	}
}
