package com.skcc.any.lineup.recommend.application.sp.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skcc.any.lineup.recommend.application.proxy.feign.dto.account.Account;
import com.skcc.any.lineup.recommend.domain.model.Recommend;
import com.skcc.any.lineup.recommend.domain.service.RecommendService;

@RestController
@RequestMapping("/v1/recommend")
public class RecommendRestController implements RecommendService {
	@Autowired
	private RecommendService RecommendService;

	@Override
	@GetMapping
	public List<Recommend> findAll() {
		return RecommendService.findAll(); 
	}

	@Override
	@GetMapping("/getName/{storeName}")
	public List<Recommend> findByStoreName(@PathVariable("storeName") String storeName) {
		return RecommendService.findByStoreName(storeName); 
	}
	
	@Override
	@GetMapping("/getId/{id}")
	public Recommend findById(@PathVariable("id") Long id) {
		return RecommendService.findById(id);
	}

	@Override
	@PostMapping
	public Recommend register(@RequestBody Recommend Recommend) {
		return RecommendService.register(Recommend);
	}

	@Override
	@PutMapping("/putId/{id}")
	public Recommend update(@PathVariable("id") Long id, @RequestBody Recommend Recommend) {
		return RecommendService.update(id, Recommend);
	}


	@Override
	@DeleteMapping("/deleteId/{id}")
	public void delete(@PathVariable("id") Long id) {
		RecommendService.delete(id);
	}


	@Override
	//@GetMapping
	public Page<Recommend> findAll(Pageable pageable) {
		return RecommendService.findAll(pageable); 
	}
	
	@Override
	//@GetMapping
	public Account checkAccount(String accountId) {
		return RecommendService.checkAccount(accountId);
	}


}
