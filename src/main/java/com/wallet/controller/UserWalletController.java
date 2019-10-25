package com.wallet.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wallet.dto.UserWalletDTO;
import com.wallet.entity.User;
import com.wallet.entity.UserWallet;
import com.wallet.entity.Wallet;
import com.wallet.response.Response;
import com.wallet.service.UserWalletService;

@RestController
@RequestMapping("user-wallet")
public class UserWalletController {

	@Autowired
	UserWalletService service;
	
	@PostMapping
	public ResponseEntity<Response<UserWalletDTO>> create(@Valid @RequestBody UserWalletDTO dto, BindingResult result) {
		Response<UserWalletDTO> response = new Response<UserWalletDTO>();
		
		if (result.hasErrors()) {
			result.getAllErrors().forEach(e -> response.getErrors().add(e.getDefaultMessage()));
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
		
		UserWallet userWallet = service.save(this.convertDtoToEntity(dto));
		
		response.setData(this.convertEntityToDto(userWallet));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	public UserWallet convertDtoToEntity(UserWalletDTO dto) {
		UserWallet userWallet = new UserWallet();
		
		User user = new User();
		user.setId(dto.getUser());
		
		Wallet wallet = new Wallet();
		wallet.setId(dto.getWallet());
		
		userWallet.setId(dto.getId());
		userWallet.setUser(user);
		userWallet.setWallet(wallet);
		
		return userWallet;
	}
	
	public UserWalletDTO convertEntityToDto(UserWallet user) {
		UserWalletDTO dto = new UserWalletDTO();
		
		dto.setId(user.getId());
		dto.setUser(user.getUser().getId());
		dto.setWallet(user.getWallet().getId());
		
		return dto;
	}
}
