package com.skcc.any.lineup.lineup.domain.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skcc.any.lineup.lineup.domain.model.Lineup;
import com.skcc.any.lineup.lineup.domain.model.LineupStat;
import com.skcc.any.lineup.lineup.domain.repository.LineupRepository;

@Service("LineupLogic")
public class LineupLogic implements LineupService {
	@Autowired
	private LineupRepository lineupRepository;

	@Override
	@Transactional(readOnly=true)
	public Lineup findById(Long id) {
		return lineupRepository.findOne(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Lineup> findByStoreNameLike(String name) {
		return lineupRepository.findByStoreNameLike(name);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Lineup> findByAccountId(String id) {
		return lineupRepository.findByAccountId(id);
	}
	
	@Override
	@Transactional(readOnly=true)
	public List<Lineup> findAll() {
		return lineupRepository.findAll();
	}

	
	@Override
	@Transactional(readOnly=true)
	public Page<Lineup> findAll(Pageable pageable) {
		return lineupRepository.findAll(pageable);
	}

	@Override
	@Transactional
	public Lineup register(String accountId, String storeName) {
		Lineup lineup = new Lineup(accountId, storeName);
		return lineupRepository.save(lineup);
	}

	@Override
	@Transactional
	public Lineup update(Long id, Lineup newLineup) {
		Lineup oldLineup = lineupRepository.findOne(id);
		if(oldLineup != null) {
			BeanUtils.copyProperties(newLineup,  oldLineup, "id");
			return lineupRepository.save(oldLineup);
		} else {
			return null;
		}
	}

	@Override
	@Transactional
	public Lineup cancel(Long id) {
		Lineup oldLineup = lineupRepository.findOne(id);
		if(oldLineup != null) {
			if(!LineupStat.COMPLETED.equals(oldLineup.getLineupStat()))
			{
				System.err.println("대기상태의 고객이 아닙니다.");
				return null;
			}
			oldLineup.setLineupStat(LineupStat.CANCELED);
			oldLineup.setCompleteDateTime(new Date());;
			return lineupRepository.save(oldLineup);
		} else {
			return null;
		}
	}

	@Override
	@Transactional
	public Lineup enter(Long id) {
		Lineup oldLineup = lineupRepository.findOne(id);
		if(oldLineup != null) {
			if(!LineupStat.COMPLETED.equals(oldLineup.getLineupStat()))
			{
				System.err.println("대기상태의 고객이 아닙니다.");
				return null;
			}
			oldLineup.setLineupStat(LineupStat.ENTERED);
			oldLineup.setCompleteDateTime(new Date());;
			return lineupRepository.save(oldLineup);
		} else {
			return null;
		}
	}
	
	@Override
	@Transactional
	public void delete(Long id) {
		lineupRepository.delete(id);
	}
}
