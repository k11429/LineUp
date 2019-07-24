package com.skcc.any.lineup.recommend.domain.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skcc.any.lineup.recommend.domain.model.Recommend;
import com.skcc.any.lineup.recommend.domain.repository.RecommendRepository;


@Service("menuLogic")
public class RecommendLogic implements RecommendService {
	@Autowired
	private RecommendRepository RecommendRepository;

	
	@Override
	@Transactional(readOnly=true)
	public Recommend findById(Long id) {
		return RecommendRepository.findOne(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Recommend> findAll() {
		return RecommendRepository.findAll();
	}

	
	@Override
	@Transactional(readOnly=true)
	public Page<Recommend> findAll(Pageable pageable) {
		return RecommendRepository.findAll(pageable);
	}

	@Override
	@Transactional
	public Recommend register(Recommend Recommend) {
		return RecommendRepository.save(Recommend);
	}

	@Override
	@Transactional
	public Recommend update(Long id, Recommend newRecommend) {
		Recommend oldRecommend = RecommendRepository.findOne(id);
		if(oldRecommend != null) {
			BeanUtils.copyProperties(newRecommend,  oldRecommend, "id");
			return RecommendRepository.save(oldRecommend);
		} else {
			return null;
		}
	}


	
	@Override
	@Transactional
	public void delete(Long id) {
		RecommendRepository.delete(id);
	}
	
}