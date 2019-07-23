package com.skcc.any.lineup.store.domain.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skcc.any.lineup.store.domain.model.Address;
import com.skcc.any.lineup.store.domain.model.Store;
import com.skcc.any.lineup.store.domain.model.StoreDescription;
import com.skcc.any.lineup.store.domain.repository.MenuRepository;
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
	public Store findStoreByOwnerID(String email) {
		return storeRepository.findByOwnerAccountId(email);
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
	public Store updateByOwnerAccountIdAndStoreName(String id, String name,  Address address, StoreDescription sd) {
		Store oldStore = storeRepository.findByOwnerAccountIdAndStoreName(id, name);
		if(oldStore != null) {
			oldStore.setStoreName(name);
			oldStore.setStoreAddress(address);
			oldStore.setStoreDescription(sd);
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
