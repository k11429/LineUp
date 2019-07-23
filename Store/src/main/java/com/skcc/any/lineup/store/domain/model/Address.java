package com.skcc.any.lineup.store.domain.model;

import javax.persistence.Embeddable;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Embeddable
public class Address implements ValueObject {
	private Integer zipCode;
	private String storeAddress;
	
	public Address() {
	}
	
	public Address(Integer zipCode, String storeAddress) {
		this.zipCode = zipCode;
		this.storeAddress = storeAddress;
	}
}
