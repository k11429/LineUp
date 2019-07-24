package com.skcc.any.lineup.lineup.application.proxy.feign;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.netflix.feign.FeignClientProperties.FeignClientConfiguration;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.skcc.any.lineup.lineup.application.proxy.feign.dto.account.Account;

@Service
public class AccountProxy {

	@Autowired
	private AccountClient accountClient;
	
	public Account findAccount(String id) {
		return accountClient.findAccount(id).getContent();
	}

	public Collection<Account> findAllAccounts() {
		return accountClient.findAllAccounts().getContent();
	}
	
	public Collection<Account> findAllAccounts(int size) {
		return accountClient.findAllAccounts(size).getContent();
	}
	
	public Account findAccounByName(String name) {
		return accountClient.findAccountName(name);
	}

	@FeignClient(name="account", url="http://localhost:11001", configuration=FeignClientConfiguration.class)
	interface AccountClient {
		@GetMapping("account/{id}")
		Resource<Account> findAccount(@PathVariable("id") String id);
		
		@GetMapping("account")
		Resources<Account> findAllAccounts();
		
		@GetMapping("account")
		Resources<Account> findAllAccounts(@RequestParam("size") int size);
		
		@GetMapping("account/search/name")
		Account findAccountName(@RequestParam(value="name", required=true) String name);
	}
}

