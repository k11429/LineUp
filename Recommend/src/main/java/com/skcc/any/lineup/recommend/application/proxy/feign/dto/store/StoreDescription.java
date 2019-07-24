package com.skcc.any.lineup.recommend.application.proxy.feign.dto.store;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Embeddable
public class StoreDescription implements ValueObject{
	private String storeIntro;
	
	@Enumerated(EnumType.STRING)
	private StoreType storeType;

	public StoreDescription() {
	}

	public StoreDescription(String storeIntro, StoreType storeType) {
		this.storeIntro = storeIntro;
		this.storeType = storeType;
	}

}
