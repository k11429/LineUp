package com.skcc.any.lineup.store.domain.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.skcc.any.lineup.store.domain.model.Menu;
import com.skcc.any.lineup.store.domain.model.MenuType;


public interface MenuService {
	Menu findById(Long id);
	List<Menu> findAll();
	Page<Menu> findAll(Pageable pageable);
	
	List<Menu> findMenuByOwnerIdAndStoreName(String id, String storeName);
	
	Menu findByOwnerAccountIdAndStoreNameAndMenuName(String id, String storeName, String menuName);
	
	Menu register(Menu menu);
	Menu update(Long id, Menu menu);	
	void delete(Long id);
	
	Menu updateByOwnerAccountIdAndStoreNameAndMenuName(String id, String storeName, String menuName, Integer price, MenuType menuType, String menuInfo);
	void deleteByOwnerAccountIdAndStoreNameAndMenuName(String id, String storeName, String menuName);
	
}
