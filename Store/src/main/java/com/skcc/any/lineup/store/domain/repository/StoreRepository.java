package com.skcc.any.lineup.store.domain.repository;

import java.util.List;

import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.querydsl.core.types.Predicate;
import com.skcc.any.lineup.store.domain.model.Store;

@RepositoryRestResource
public interface StoreRepository extends PagingAndSortingRepository<Store, Long>,
                                           QueryDslPredicateExecutor<Store> {
	List<Store> findAll(Predicate predicate); 
	List<Store> findAll();
	
	Store findByOwnerAccountId(@Param("id") String id);
	
	List<Store> findByStoreNameLike(@Param("name") String name);
	
	Store findByOwnerAccountIdAndStoreName(@Param("id") String id, @Param("name") String name);
	
	void deleteByOwnerAccountIdAndStoreName(@Param("id") String id, @Param("name") String name);
	
	
	
}
