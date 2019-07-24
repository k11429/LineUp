package com.skcc.any.lineup.lineup.application.proxy.feign.dto.account;

import javax.persistence.Embeddable;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Embeddable
public class Contact {
	private String email;
	private String mobile;
	
	public Contact() {
	}
	
	public Contact(String email, String mobile) {
		this.email = email;
		this.mobile = mobile;
	}
}
