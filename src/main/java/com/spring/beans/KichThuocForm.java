package com.spring.beans;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import com.spring.entities.KichThuoc;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class KichThuocForm {
	private Integer id ;
	@NotBlank(message = "{NotBlank.kichthuoc.ten}")
	@Length(max = 100, message = "{Length.kichthuoc.ten}")
	private String ten;
	
	public KichThuoc data(KichThuoc kichThuoc) {
		if (kichThuoc == null) {
			kichThuoc = new KichThuoc();
		}
		kichThuoc.setIdKichThuoc(this.getId());
		kichThuoc.setTenKichThuoc(this.getTen());
		return kichThuoc;
	}
}
