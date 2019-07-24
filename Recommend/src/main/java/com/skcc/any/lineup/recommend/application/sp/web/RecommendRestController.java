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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.skcc.any.lineup.recommend.domain.model.Recommend;
import com.skcc.any.lineup.recommend.domain.service.RecommendService;

@RestController
@RequestMapping("/v1/menu")
public class RecommendRestController implements RecommendService {
	@Autowired
	private RecommendService RecommendService;

	@Override
	@GetMapping
	public List<Recommend> findAll() {
		return RecommendService.findAll(); 
	}
	
	@Override
	@GetMapping("/{id}")
	public Recommend findById(@PathVariable("id") Long id) {
		return RecommendService.findById(id);
	}

	@Override
	@PostMapping
	public Recommend register(@RequestBody Recommend Recommend) {
		return RecommendService.register(Recommend);
	}

	@Override
	@PutMapping("/{id}")
	public Recommend update(@PathVariable("id") Long id, @RequestBody Recommend Recommend) {
		return RecommendService.update(id, Recommend);
	}


	@Override
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		RecommendService.delete(id);
	}


	@Override
	//@GetMapping
	public Page<Recommend> findAll(Pageable pageable) {
		return RecommendService.findAll(pageable); 
	}


}
