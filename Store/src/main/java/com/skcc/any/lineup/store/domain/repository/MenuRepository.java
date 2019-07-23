package com.skcc.any.lineup.store.domain.repository;

import java.util.List;

import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.querydsl.core.types.Predicate;
import com.skcc.any.lineup.store.domain.model.Menu;

@RepositoryRestResource
public interface MenuRepository extends PagingAndSortingRepository<Menu, Long>,
                                           QueryDslPredicateExecutor<Menu> {
	List<Menu> findAll(Predicate predicate); 
	List<Menu> findAll(); 
	List<Menu> findByOwnerAccountIdAndStoreName(@Param("id") String id, @Param("name") String name);
	Menu findByOwnerAccountIdAndStoreNameAndMenuName(@Param("id") String id, @Param("storenm") String storenm, @Param("menunm") String menunm);

	void deleteByOwnerAccountIdAndStoreNameAndMenuName(@Param("id") String id, @Param("storenm") String storenm, @Param("menunm") String menunm);

}
