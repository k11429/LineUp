package com.skcc.any.lineup.account.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.querydsl.core.types.Predicate;
import com.skcc.any.lineup.account.domain.model.Account;

@RepositoryRestResource
public interface AccountRepository extends PagingAndSortingRepository<Account, String>,
                                           QueryDslPredicateExecutor<Account> {
	
	Account findById(@Param("id") String id);
	List<Account> findByNameLike(@Param("name") String name);
	List<Account> findAll();
	
	Account findByContactMobile(@Param("mobile") String mobile);
	
	List<Account> findAll(Predicate predicate); 
	
}
