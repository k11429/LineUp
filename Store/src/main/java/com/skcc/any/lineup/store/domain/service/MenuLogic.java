package com.skcc.any.lineup.store.domain.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skcc.any.lineup.store.domain.model.Menu;
import com.skcc.any.lineup.store.domain.model.MenuType;
import com.skcc.any.lineup.store.domain.repository.MenuRepository;


@Service("menuLogic")
public class MenuLogic implements MenuService {
	@Autowired
	private MenuRepository menuRepository;

	
	@Override
	@Transactional(readOnly=true)
	public Menu findById(Long id) {
		return menuRepository.findOne(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Menu> findMenuByOwnerIdAndStoreName(String id, String name) {
		return menuRepository.findByOwnerAccountIdAndStoreName(id, name);
	}

	@Override
	@Transactional(readOnly=true)
	public Menu findByOwnerAccountIdAndStoreNameAndMenuName(String id, String storeName, String menuName) {
		return menuRepository.findByOwnerAccountIdAndStoreNameAndMenuName(id, storeName, menuName);
	}
	
	@Override
	@Transactional(readOnly=true)
	public List<Menu> findAll() {
		return menuRepository.findAll();
	}

	
	@Override
	@Transactional(readOnly=true)
	public Page<Menu> findAll(Pageable pageable) {
		return menuRepository.findAll(pageable);
	}

	@Override
	@Transactional
	public Menu register(Menu menu) {
		return menuRepository.save(menu);
	}

	@Override
	@Transactional
	public Menu update(Long id, Menu newMenu) {
		Menu oldMenu = menuRepository.findOne(id);
		if(oldMenu != null) {
			BeanUtils.copyProperties(newMenu,  oldMenu, "id");
			return menuRepository.save(oldMenu);
		} else {
			return null;
		}
	}

	@Override
	@Transactional
	public Menu updateByOwnerAccountIdAndStoreNameAndMenuName(String id, String storeName, String menuName, Integer price, MenuType menuType) {
		Menu oldMenu = menuRepository.findByOwnerAccountIdAndStoreNameAndMenuName(id, storeName, menuName);
		if(oldMenu != null) {
			oldMenu.setMenuName(menuName);
			oldMenu.setPrice(price);
			oldMenu.setMenuType(menuType);
			return menuRepository.save(oldMenu);
		} else {
			return null;
		}
	}
	
	
	@Override
	@Transactional
	public void delete(Long id) {
		menuRepository.delete(id);
	}
	
	@Override
	@Transactional
	public void deleteByOwnerAccountIdAndStoreNameAndMenuName(String id, String storeName, String menuName) {
		menuRepository.deleteByOwnerAccountIdAndStoreNameAndMenuName(id,storeName, menuName);
	}
}
