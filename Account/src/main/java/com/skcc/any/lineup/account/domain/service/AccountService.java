package com.skcc.any.lineup.account.domain.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.skcc.any.lineup.account.domain.model.Account;


public interface AccountService {
	Account findById(Long id);
	List<Account> findAll();
	Page<Account> findAll(Pageable pageable);
	
	List<Account> findByNameLike(String name);
	Account findByContactMobile(String mobile);
	
	Account register(Account account);
	Account update(Long id, Account account);

	void delete(Long id);
}
