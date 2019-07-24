package com.skcc.any.lineup.account;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.skcc.any.lineup.account.domain.model.Account;
import com.skcc.any.lineup.account.domain.model.Contact;
import com.skcc.any.lineup.account.domain.model.MemberType;
import com.skcc.any.lineup.account.domain.repository.AccountRepository;

@SpringBootApplication
public class AccountApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner execSampleCode(AccountRepository accountRepository) {	
		return (args) -> {
			insertAccounts(accountRepository);
			displayAccounts(accountRepository);
		};
	}
	
	public void insertAccounts(AccountRepository accountRepository) {
		Account account1 = new Account("honggd", "1234", "홍길동",MemberType.PERSONAL,"honggd@naver.com","011-2222-3333");
		accountRepository.save(account1);
		Account account2 = new Account("kimcs", "1234", "김철수",MemberType.PERSONAL,"kimcs@naver.com","010-4561-6541");
		accountRepository.save(account2);
		Account account3 = new Account("IU", "1234", "아이유",MemberType.PERSONAL,"IU@naver.com","010-1231-0151");
		accountRepository.save(account3);
		Account account4 = new Account("Sushi", "1234", "스시천국사장님",MemberType.STORE,"Sushi@naver.com","010-2323-6345");
		accountRepository.save(account4);
		Account account5 = new Account("Manri", "1234", "만리장성사장님",MemberType.STORE,"Manri@naver.com","010-1232-4152");
		accountRepository.save(account5);
	}
	
	public void displayAccounts(AccountRepository accountRepository) {
		
		Iterable<Account> accountList = accountRepository.findAll();
		System.out.println("***************************************************************");	
		for(Account account : accountList) {
			System.out.println(account.toString());
		}
		System.out.println("***************************************************************");	
	}	
/*
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
*/
}
