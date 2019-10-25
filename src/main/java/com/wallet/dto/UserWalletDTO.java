package com.wallet.dto;

import javax.validation.constraints.NotNull;

public class UserWalletDTO {
	
	private Long id;
	
	@NotNull(message = "Informe o ID usuário")
	private Long user;
	
	@NotNull(message = "Informe a ID carteira")
	private Long wallet;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUser() {
		return user;
	}
	public void setUser(Long user) {
		this.user = user;
	}
	public Long getWallet() {
		return wallet;
	}
	public void setWallet(Long wallet) {
		this.wallet = wallet;
	}
	
}
