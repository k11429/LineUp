package com.skcc.any.lineup.account.domain.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Account {
	
	@Id
	private String id;
	
	private String password;
	private String name;
	
	@Enumerated(EnumType.STRING)
	private MemberType memberType;
	
	
	private Contact contact;
	
	public Account(String id, String password, String name, MemberType memberType, String email, String mobile) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.memberType = memberType;
		Contact ct = new Contact();
		ct.setEmail(email);
		ct.setMobile(mobile);
		this.contact = ct;
	}
}

