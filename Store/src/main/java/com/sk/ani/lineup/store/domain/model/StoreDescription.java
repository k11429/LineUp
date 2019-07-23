package com.sk.ani.lineup.store.domain.model;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class StoreDescription implements ValueObject{
	private String storeIntro;
	
	@Enumerated(EnumType.STRING)
	private StoreType storeType;

	public StoreDescription(String storeIntro, StoreType storeType) {
		this.storeIntro = storeIntro;
		this.storeType = storeType;
	}
	
}
