package com.skcc.any.lineup.lineup.application.sp.web;

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

import com.skcc.any.lineup.lineup.domain.model.Lineup;
import com.skcc.any.lineup.lineup.domain.service.LineupService;

@RestController
@RequestMapping("/v1/lineup")
public class LineupRestController implements LineupService {
	@Autowired
	private LineupService lineupService;

	@Override
	@GetMapping
	public List<Lineup> findAll() {
		return lineupService.findAll(); 
	}
	
	@Override
	@GetMapping("/{id}")
	public Lineup findById(@PathVariable("id") Long id) {
		return lineupService.findById(id);
	}

	@Override
	@PostMapping
	public Lineup register(@RequestBody String accountId, String storeName) {
		return lineupService.register(accountId, storeName);
	}

	@Override
	@PutMapping("/cancel/{id}")
	public Lineup cancel(@PathVariable("id") Long id) {
		return lineupService.cancel(id);
	}
	
	@Override
	@PutMapping("/enter/{id}")
	public Lineup enter(@PathVariable("id") Long id) {
		return lineupService.enter(id);
	}
	
	@Override
	@PutMapping("/{id}")
	public Lineup update(@PathVariable("id") Long id, @RequestBody Lineup Lineup) {
		return lineupService.update(id, Lineup);
	}

	@Override
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		lineupService.delete(id);
	}
	
	@Override
	@GetMapping("/search/store")
	public List<Lineup> findByStoreNameLike(@RequestParam("name") String name) {
		return lineupService.findByStoreNameLike(name);
	}

	@Override
	@GetMapping("/search/account")
	public List<Lineup> findByAccountId(@RequestParam("id") String id) {
		return lineupService.findByAccountId(id);
	}

	@Override
	//@GetMapping
	public Page<Lineup> findAll(Pageable pageable) {
		return lineupService.findAll(pageable); 
	}


}
