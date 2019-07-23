package com.sk.ani.lineup.store.domain.model;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
@Entity
public class Menu extends AbstractEntity implements AggregateRoot {
	private String ownerAccountId;
	private String storeName;
	private String menuName;
	private Integer price;
	private MenuType menuType;
	
			
	public Menu(String ownerAccountId, String storeName, String menuName,Integer price,MenuType menuType) {
		this.ownerAccountId = ownerAccountId;
		this.storeName = storeName;
		this.menuName = menuName;
		this.price = price;
		this.menuType = menuType;
	}

}

