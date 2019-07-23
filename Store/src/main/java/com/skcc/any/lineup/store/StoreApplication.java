package com.skcc.any.lineup.store;



import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.hateoas.config.EnableHypermediaSupport;

import com.skcc.any.lineup.store.domain.model.Address;
import com.skcc.any.lineup.store.domain.model.Menu;
import com.skcc.any.lineup.store.domain.model.MenuType;
import com.skcc.any.lineup.store.domain.model.Store;
import com.skcc.any.lineup.store.domain.model.StoreDescription;
import com.skcc.any.lineup.store.domain.model.StoreType;
import com.skcc.any.lineup.store.domain.repository.MenuRepository;
import com.skcc.any.lineup.store.domain.repository.StoreRepository;



@SpringBootApplication
@EnableFeignClients
@EnableHypermediaSupport(type=EnableHypermediaSupport.HypermediaType.HAL)
public class StoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(StoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner execSampleCode(StoreRepository storeRepository, MenuRepository menuRepository) {	
		return (args) -> {
			insertStores(storeRepository);
			displayStores(storeRepository);
			storeTest01_findStoreByOwnerID(storeRepository);
			storeTest02_findStoreByStoreName(storeRepository);
			storeTest03_insertStore(storeRepository);
			storeTest04_modifyStore(storeRepository);
			storeTest05_deleteStore(storeRepository);
			menuTest01_insertDisplayMenu(menuRepository);
			menuTest02_findMenuByStoreInfo(menuRepository);
			menuTest03_modifyMenu(menuRepository);
			menuTest04_deleteMenu(menuRepository);
			menuTest05_deleteAllMenu(menuRepository);
		};
	}
	


	public void insertStores(StoreRepository storeRepository) {
		Store store1 = new Store("Nolbu", "놀부부대찌개", new StoreDescription("한식전문 놀부 부대찌개",StoreType.KOREAN),new Address(12500,"서울시 강남구 삼성동"));
		storeRepository.save(store1);
		Store store2 = new Store("Sushi", "스시천국", new StoreDescription("맛있는 스시를 제공합니다",StoreType.JAPANESE),new Address(12600,"서울시 강남구 서래마을"));
		storeRepository.save(store2);
		Store store3 = new Store("Manri", "만리장성", new StoreDescription("짜장면은 항상 옳다",StoreType.CHINESE),new Address(13400,"경기도 성남시 야탑동"));
		storeRepository.save(store3);
		Store store4 = new Store("Roman", "이딸리아", new StoreDescription("피자는 이탈리아 빈대떡",StoreType.ITALIAN),new Address(16500,"부산시 남구 용호동"));
		storeRepository.save(store4);		
	}
	
	public void displayStores(StoreRepository storeRepository) {
		
		Iterable<Store> storeList = storeRepository.findAll();
		System.out.println("***************************************************************");	
		for(Store store : storeList) {
			System.out.println(store.toString());
			System.out.println(store.getOwnerAccountId());
			System.out.println(store.getStoreName());
			System.out.println(store.getStoreDescription().getStoreIntro());
			System.out.println(store.getStoreDescription().getStoreType());
			System.out.println(store.getStoreAddress().getZipCode());
			System.out.println(store.getStoreAddress().getStoreAddress());
		}
		System.out.println("***************************************************************");	
	}	

	public void storeTest01_findStoreByOwnerID(StoreRepository storeRepository) {
		System.out.println("Find OwnerAccountId : Romantic ");
		Store store = storeRepository.findByOwnerAccountId("Romantic");
		if( store == null ) 
			System.out.println("There is No Store for Romantic");
			else System.out.println("Store of Romantic: "+ store.toString());
		System.out.println("Find OwnerAccountId : Roman ");
		store = storeRepository.findByOwnerAccountId("Roman");
		if( store == null ) 
			System.out.println("There is No Store for Roman");
			else System.out.println("Store of Romantic: "+ store.toString());
				
			
	}

	public void storeTest02_findStoreByStoreName(StoreRepository storeRepository) {
		List<Store> store = storeRepository.findByStoreNameLike("%놀%");
		System.out.println(store.toString());
	}
	
	public void storeTest03_insertStore(StoreRepository storeRepository) {
		Store store1 = storeRepository.findByOwnerAccountIdAndStoreName("Manri","만리장성");
		Store store2 = storeRepository.findByOwnerAccountIdAndStoreName("manri","만리장성");
		System.out.println("store1"+store1);
		System.out.println("store2"+store1);
	}
	
	public void storeTest04_modifyStore(StoreRepository storeRepository) {
		Store store1 = storeRepository.findByOwnerAccountIdAndStoreName("Sushi","스시천국");
		System.out.println("스시천국 주소"+ store1.getStoreAddress());
		store1.setStoreAddress(new Address(11111, "주소변경중입니다"));
		storeRepository.save(store1);
		Store store2 = storeRepository.findByOwnerAccountIdAndStoreName("Sushi","스시천국");
		System.out.println("스시천국 주소"+ store2.getStoreAddress());
		
	}

	public void storeTest05_deleteStore(StoreRepository storeRepository) {
		//storeRepository.deleteByOwnerAccountIdAndStoreName("Sushi","스시천국");
		Store store1 = storeRepository.findByOwnerAccountIdAndStoreName("Sushi","스시천국");
		storeRepository.delete(store1);
		Store store = storeRepository.findByOwnerAccountIdAndStoreName("Sushi","스시천국");
		if( store == null ) 
			System.out.println("스시천국은 없어졌습니다");
			else System.out.println("스시천국이 있네요?!! "+ store.toString());
	}
	
	public void menuTest01_insertDisplayMenu(MenuRepository menuRepository) {
		Menu menu1 = new Menu("Nolbu", "놀부부대찌개", "기본 놀부부대찌개","기본 맛입니다",12000,MenuType.MAINDISH);
		menuRepository.save(menu1);
		Menu menu2 = new Menu("Nolbu", "놀부부대찌개", "고급 놀부부대찌개","비싼 맛입니다",14000,MenuType.MAINDISH);
		menuRepository.save(menu2);
		Menu menu3 = new Menu("Nolbu", "놀부부대찌개", "파전","막걸리 안주",10000,MenuType.SIDEDISH);
		menuRepository.save(menu3);
		Menu menu4 = new Menu("Nolbu", "놀부부대찌개", "메밀전병","괜히 먹어보고 싶은 메뉴",8000,MenuType.SIDEDISH);
		menuRepository.save(menu4);
		Menu menu5 = new Menu("Nolbu", "놀부부대찌개", "막걸리","캬아~",5000,MenuType.BEVERAGE);
		menuRepository.save(menu5);
		Menu menu6 = new Menu("Manri", "만리장성", "짜장면","기본",6000,MenuType.MAINDISH);
		menuRepository.save(menu6);
		Menu menu7 = new Menu("Manri", "만리장성", "짬뽕","기본",7000,MenuType.MAINDISH);
		menuRepository.save(menu7);
		Menu menu8 = new Menu("Manri", "만리장성", "탕수육","기본",18000,MenuType.SIDEDISH);
		menuRepository.save(menu8);
		Menu menu9 = new Menu("Manri", "만리장성", "양장피","기본",24000,MenuType.SIDEDISH);
		menuRepository.save(menu9);
		Menu menu10 = new Menu("Manri", "만리장성", "고량주","기본",5000,MenuType.BEVERAGE);
		menuRepository.save(menu10);
		Iterable<Menu> menuList = menuRepository.findAll();
		System.out.println("***************************************************************");	
		for(Menu menu : menuList) {
			System.out.println(menu.toString());
			System.out.println(menu.getOwnerAccountId());
			System.out.println(menu.getStoreName());
			System.out.println(menu.getMenuName());
			System.out.println(menu.getMenuInfo());
			System.out.println(menu.getMenuType());
		}
		System.out.println("***************************************************************");	
		
	}

	public void menuTest02_findMenuByStoreInfo(MenuRepository menuRepository) {
		System.out.println("만리장성 메뉴 목록");
		Iterable<Menu> menuList = menuRepository.findByOwnerAccountIdAndStoreName("Manri","만리장성");
		System.out.println("***************************************************************");	
		for(Menu menu : menuList) {
			System.out.println(menu.toString());
			System.out.println(menu.getOwnerAccountId());
			System.out.println(menu.getStoreName());
			System.out.println(menu.getMenuName());
			System.out.println(menu.getMenuInfo());
			System.out.println(menu.getMenuType());
		}
		System.out.println("***************************************************************");			
		System.out.println("놀부부대찌개 메뉴 목록");
		menuList = menuRepository.findByOwnerAccountIdAndStoreName("Nolbu","놀부부대찌개");
		System.out.println("***************************************************************");	
		for(Menu menu : menuList) {
			System.out.println(menu.toString());
			System.out.println(menu.getOwnerAccountId());
			System.out.println(menu.getStoreName());
			System.out.println(menu.getMenuName());
			System.out.println(menu.getMenuInfo());
			System.out.println(menu.getMenuType());
		}
		System.out.println("***************************************************************");			
		System.out.println("놀부부대찌개 메뉴 목록");
	}
	
	
	public void menuTest03_modifyMenu(MenuRepository menuRepository) {
		Menu menu1 = menuRepository.findByOwnerAccountIdAndStoreNameAndMenuName("Manri","만리장성","짜장면");
		menu1.setMenuInfo("값이 올랐습니다");
		menu1.setPrice(7000);
		menuRepository.save(menu1);
		Menu menu2 = menuRepository.findByOwnerAccountIdAndStoreNameAndMenuName("Manri","만리장성","짬뽕");
		menu2.setMenuInfo("짜장면이 올라서 짬뽕도 값이 올랐습니다");
		menu2.setPrice(8000);
		menuRepository.save(menu2);
		System.out.println("만리장성 메뉴 목록");
		Iterable<Menu> menuList = menuRepository.findByOwnerAccountIdAndStoreName("Manri","만리장성");
		System.out.println("***************************************************************");	
		for(Menu menu : menuList) {
			System.out.println(menu.toString());
			System.out.println(menu.getOwnerAccountId());
			System.out.println(menu.getStoreName());
			System.out.println(menu.getMenuName());
			System.out.println(menu.getMenuInfo());
			System.out.println(menu.getMenuType());
		}				
	}

	public void menuTest04_deleteMenu(MenuRepository menuRepository) {
		Menu menu1 = menuRepository.findByOwnerAccountIdAndStoreNameAndMenuName("Manri","만리장성","짜장면");
		Menu menu2 = menuRepository.findByOwnerAccountIdAndStoreNameAndMenuName("Manri","만리장성","짬뽕");
		menuRepository.delete(menu1);
		menuRepository.delete(menu2);		
	}
	
	public void menuTest05_deleteAllMenu(MenuRepository menuRepository) {
		Iterable<Menu> menuList = menuRepository.findByOwnerAccountIdAndStoreName("Manri","만리장성");
		System.out.println("***************************************************************");	
		for(Menu menu : menuList) {
			menuRepository.delete(menu);
		}
		System.out.println("만리장성 메뉴 목록");
		Iterable<Menu> menuList2 = menuRepository.findByOwnerAccountIdAndStoreName("Manri","만리장성");
		System.out.println("***************************************************************");	
		for(Menu menu : menuList2) {
			System.out.println(menu.toString());
			System.out.println(menu.getOwnerAccountId());
			System.out.println(menu.getStoreName());
			System.out.println(menu.getMenuName());
			System.out.println(menu.getMenuInfo());
			System.out.println(menu.getMenuType());
		}		
		
	}

	
}	