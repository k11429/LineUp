package com.skcc.any.lineup.recommend.domain.model;



import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(callSuper=true)
@Entity
public class Recommend  extends AbstractEntity implements AggregateRoot {


	private Long id;
	
	//private Account account;
	private String accountId;
	//private Store store;
	private String storeOwnerAccountId;
	private String storeName;
	@Enumerated(EnumType.STRING)
	private ScoreType scoreType;


	private String review;


	public Recommend() {
	}	
	
	public Recommend(Long id, String accountId, String storeOwnerAccountId,String storeName, ScoreType scoreType, String review) {
		this.id = id;
		this.accountId = accountId;
		this.storeOwnerAccountId = storeOwnerAccountId;
		this.storeName = storeName;
		this.scoreType = scoreType;
		this.review = review;
	}

}
