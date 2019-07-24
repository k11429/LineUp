package com.skcc.any.lineup.recommend.application.proxy.feign;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.netflix.feign.FeignClientProperties.FeignClientConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.skcc.any.lineup.recommend.application.proxy.feign.dto.account.Account;


@Service
public class AccountProxy {
	@Autowired
	private AccountClient accountClient;
	
	public Account findAccount(Long id) {
		return accountClient.findAccount(id).getContent();
	}

	public Collection<Account> findAllaccount() {
		return accountClient.findAllaccount().getContent();
	}
	
	public Collection<Account> findAllaccount(int size) {
		return accountClient.findAllaccount(size).getContent();
	}
	
	public Account findAccountByName(String name) {
		return accountClient.findAccount(name);
	}

	public Account findById(String accountId) {
		return accountClient.findById(accountId);
	}

	public Account findByContactMobile(String mobile) {
		return accountClient.findByContactMobile(mobile);
	}

	@FeignClient(name="v1/account", url="http://localhost:11001", configuration=FeignClientConfiguration.class)
	interface AccountClient {
		
		@GetMapping("v1/account/{accountId}")
		Account findById(@PathVariable("accountId") String accountId);

		@GetMapping("v1/account/search/name")
		Resource<Account> findByNameLike(@RequestParam(value="name", required=true) String name);
		
		@GetMapping("v1/account/search/mobile")
		Account findByContactMobile(@RequestParam(value="mobile", required=true) String mobile);
		
		
		//default  생성자
		@GetMapping("v1/account/{id}")
		Resource<Account> findAccount(@PathVariable("id") Long id);
		
		@GetMapping("v1/account")
		Resources<Account> findAllaccount();
		
		@GetMapping("v1/account")
		Resources<Account> findAllaccount(@RequestParam("size") int size);
		
		@GetMapping("v1/account/search/findByName")
		Account findAccount(@RequestParam(value="name", required=true) String name);

	}
}

