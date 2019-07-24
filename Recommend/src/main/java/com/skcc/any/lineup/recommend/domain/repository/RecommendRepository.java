package com.skcc.any.lineup.recommend.domain.repository;

import java.util.List;

import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.querydsl.core.types.Predicate;
import com.skcc.any.lineup.recommend.domain.model.Recommend;

@RepositoryRestResource
public interface RecommendRepository extends PagingAndSortingRepository<Recommend, Long>,
                                           QueryDslPredicateExecutor<Recommend> {
	List<Recommend> findAll(Predicate predicate); 
	List<Recommend> findAll(); 
	
/*
	List<Menu> findByOwnerAccountIdAndStoreName(@Param("id") String id, @Param("name") String name);
	Menu findByOwnerAccountIdAndStoreNameAndMenuName(@Param("id") String id, @Param("storenm") String storenm, @Param("menunm") String menunm);

	void deleteByOwnerAccountIdAndStoreNameAndMenuName(@Param("id") String id, @Param("storenm") String storenm, @Param("menunm") String menunm);
*/
}
