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

import com.skcc.any.lineup.store.domain.model.Menu;
import com.skcc.any.lineup.store.domain.model.MenuType;
import com.skcc.any.lineup.store.domain.service.MenuService;

@RestController
@RequestMapping("/v1/menu")
public class MenuRestController implements MenuService {
	@Autowired
	private MenuService menuService;

	@Override
	@GetMapping
	public List<Menu> findAll() {
		return menuService.findAll(); 
	}
	
	@Override
	@GetMapping("/{id}")
	public Menu findById(@PathVariable("id") Long id) {
		return menuService.findById(id);
	}

	@Override
	@PostMapping
	public Menu register(@RequestBody Menu menu) {
		return menuService.register(menu);
	}

	@Override
	@PutMapping("/{id}")
	public Menu update(@PathVariable("id") Long id, @RequestBody Menu menu) {
		return menuService.update(id, menu);
	}

	@Override
	@PutMapping("/menuUpdate")
	public Menu updateByOwnerAccountIdAndStoreNameAndMenuName(@RequestParam("ownerAccountId") String ownerAccountId,
															  @RequestParam("storeName") String storeName,	
															  @RequestParam("menuName") String menuName,	
															  @RequestParam("price") Integer price,		
															  @RequestParam("menuType") MenuType menuType) {	
	return menuService.updateByOwnerAccountIdAndStoreNameAndMenuName(ownerAccountId, storeName, menuName, price, menuType);
	}	
	
	@Override
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		menuService.delete(id);
	}

	@Override
	@DeleteMapping("/menuDelete")
	public void deleteByOwnerAccountIdAndStoreNameAndMenuName(@RequestParam("id") String id,
															  @RequestParam("storeName") String storeName,	
			                                                  @RequestParam("menuName") String menuName) {
		menuService.deleteByOwnerAccountIdAndStoreNameAndMenuName(id,storeName,menuName);
	}
	
	
	@Override
	@GetMapping("/search/menuList")
	public List<Menu> findMenuByOwnerIdAndStoreName(@RequestParam("ownerAccountId") String ownerAccountId
												   ,@RequestParam("storeName") String storeName) {
		return menuService.findMenuByOwnerIdAndStoreName(ownerAccountId,storeName);
	}

	@Override
	@GetMapping("/search/specificMenu")
	public Menu findByOwnerAccountIdAndStoreNameAndMenuName(@RequestParam("ownerAccountId") String ownerAccountId, 
															@RequestParam("storeName") String storeName,
															@RequestParam("menuName") String menuName) {
		return menuService.findByOwnerAccountIdAndStoreNameAndMenuName(ownerAccountId,storeName,menuName);
	}

	@Override
	//@GetMapping
	public Page<Menu> findAll(Pageable pageable) {
		return menuService.findAll(pageable); 
	}


}
