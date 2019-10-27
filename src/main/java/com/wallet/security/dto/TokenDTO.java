package com.wallet.security.dto;

public class TokenDTO {
	
	public TokenDTO(String token) {
		this.token = token;
	}

	private String token;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
}
