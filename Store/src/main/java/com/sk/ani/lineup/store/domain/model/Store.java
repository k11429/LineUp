package com.sk.ani.lineup.store.domain.model;

import javax.persistence.Entity;


import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
@Entity
public class Store  extends AbstractEntity implements AggregateRoot {
	
	private String ownerAccountId;
	private String storeName;
	private StoreDescription storeDescription;
	private Address storeAddress;
	
	public Store(String ownerAccountId, String storeName, StoreDescription storeDescription) {
		this.ownerAccountId = ownerAccountId;
		this.storeName = storeName;
		this.storeDescription = storeDescription;
	}

			
	public Store(String ownerAccountId, String storeName, StoreDescription storeDescription,Address storeAddress) {
		this.ownerAccountId = ownerAccountId;
		this.storeName = storeName;
		this.storeDescription = storeDescription;
		this.storeAddress = storeAddress;
	}

}
