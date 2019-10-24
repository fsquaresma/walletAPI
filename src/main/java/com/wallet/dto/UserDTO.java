package com.wallet.dto;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

public class UserDTO {

	private Long id;
	
	@Length(min = 3, max = 50, message = "O nome deve ter entre 3 e 50 caracteres")
	private String name;

	@Email(message = "Email inválido")
	private String email;
	
	@NotNull
	@Length(min = 6, message = "A senha deve ter pelo menos 6 caracteres")
	private String password;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
