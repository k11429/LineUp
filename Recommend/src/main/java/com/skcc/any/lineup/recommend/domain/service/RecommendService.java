package com.skcc.any.lineup.recommend.domain.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.skcc.any.lineup.recommend.domain.model.Recommend;


public interface RecommendService {
	Recommend findById(Long id);
	List<Recommend> findAll();
	Page<Recommend> findAll(Pageable pageable);	
	Recommend register(Recommend Recommend);
	Recommend update(Long id, Recommend Recommend);	
	void delete(Long id);
	
	
}
