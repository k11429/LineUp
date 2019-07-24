package com.skcc.any.lineup.lineup.domain.repository;

import java.util.List;

import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.querydsl.core.types.Predicate;
import com.skcc.any.lineup.lineup.domain.model.Lineup;

@RepositoryRestResource
public interface LineupRepository extends PagingAndSortingRepository<Lineup, Long>,
                                           QueryDslPredicateExecutor<Lineup> {
	
	Lineup findById(@Param("id") Long id);
	
	List<Lineup> findByStoreNameLike(@Param("name") String name);
	List<Lineup> findByAccountId(@Param("accountId") String id);
	
	List<Lineup> findAll();
	
	List<Lineup> findAll(Predicate predicate); 
	
}
