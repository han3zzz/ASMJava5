package com.spring.beans;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChangeForm {
	@NotBlank(message = "{NotBlank.change.passwordcu}")
	@Length(min = 8 , message = "{Length.change.passwordcuMin}")
	@Length(max = 16 , message = "{Length.change.passwordcuMax}")
	private String passcu;
	@NotBlank(message = "{NotBlank.change.passwordmoi}")
	@Length(min = 8 , message = "{Length.change.passwordmoiMin}")
	@Length(max = 16 , message = "{Length.change.passwordmoiMax}")
	private String passmoi;
	@NotBlank(message = "{NotBlank.change.repasswordmoi}")
	@Length(min = 8 , message = "{Length.change.repasswordmoiMin}")
	@Length(max = 16 , message = "{Length.change.repasswordmoiMax}")
	private String repassmoi;
	
}
