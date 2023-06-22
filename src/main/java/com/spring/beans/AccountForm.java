package com.spring.beans;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import com.spring.entities.Account;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountForm {
	
	@NotBlank(message = "{NotBlank.account.username}")
	@Length(max = 15, message = "{Length.account.username}")
	private String username;
	@NotBlank(message = "{NotBlank.account.password}")
	@Length(min = 8 , message = "{Length.account.passwordMin}")
	@Length(max = 16 , message = "{Length.account.passwordMax}")
	private String password;
	@NotBlank(message = "{NotBlank.account.email}")
	@Length(max = 100,message = "{Length.account.email}")
	private String email;
	private Integer role;
	
	public Account data(Account account) {
		if (account == null) {
			account = new Account();
		}
		account.setUsername(this.getUsername());
		account.setPassword(this.getPassword());
		account.setEmail(this.getEmail());
		account.setRole(this.getRole());
		
		return account;
	}
}
