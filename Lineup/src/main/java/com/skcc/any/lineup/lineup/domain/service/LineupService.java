package com.skcc.any.lineup.lineup.domain.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.skcc.any.lineup.lineup.domain.model.Account;
import com.skcc.any.lineup.lineup.domain.model.Lineup;
import com.skcc.any.lineup.lineup.domain.model.Store;


public interface LineupService {
	Lineup findById(Long id);
	List<Lineup> findAll();
	Page<Lineup> findAll(Pageable pageable);
	
	List<Lineup> findByStoreNameLike(String name);
	List<Lineup> findByAccountId(String id);
	
	Lineup register(String accountId, String storeName);
	Lineup update(Long id, Lineup lineup);

	void delete(Long id);
	Lineup cancel(Long id);
	Lineup enter(Long id);
}
