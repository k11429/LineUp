package com.skcc.any.lineup.lineup.domain.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Lineup {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	protected Long id;
	
	private String accountId;
	private String storeName;
	
	private Date lineupDateTime;
	private Date CompleteDateTime;
		
	@Enumerated(EnumType.STRING)
	private LineupStat lineupStat;
	
	public Lineup(String accountId, String storeName) {
		this.accountId = accountId;
		this.storeName = storeName;
		this.lineupDateTime = new Date();
		this.CompleteDateTime = new Date();
		this.lineupStat = LineupStat.COMPLETED;
	}
}

