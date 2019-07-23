package com.skcc.any.lineup.store.domain.model;


import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;



import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
@Entity
public class Menu  extends AbstractEntity implements AggregateRoot  {
	private String ownerAccountId;
	private String storeName;
	private String menuName;
	private String menuInfo;
	private Integer price;
	
	@Enumerated(EnumType.STRING)
	private MenuType menuType;
	
	public Menu() {
	}
	
	public Menu(String ownerAccountId, String storeName, String menuName, String menuInfo,Integer price,MenuType menuType) {
		this.ownerAccountId = ownerAccountId;
		this.storeName = storeName;
		this.menuName = menuName;
		this.menuInfo = menuInfo;
		this.price = price;
		this.menuType = menuType;
	}

}

