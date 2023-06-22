package com.spring.beans;

import java.math.BigDecimal;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.spring.entities.Product;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductForm {
	private Integer id;
	@NotBlank(message = "{NotBlank.product.tieude}")
	@Length(max = 100, message = "{Length.product.tieude}")
	private String tieude;
	@NotBlank(message = "{NotBlank.product.mota}")
	@Length(max = 255, message = "{Length.product.mota}")
	private String mota;
	@NotNull(message = "{NotBlank.product.gia}")
	@Min(value = 1,message = "{Negative.product.giaMin}")
	@Max(value = 999999999, message = "{Negative.product.giaMax}")
	private BigDecimal gia;
	@NotNull(message = "{NotBlank.product.giamgia}")
	@Min(value = 0,message = "{Negative.product.giamgiaMin}")
	@Max(value = 100, message = "{Negative.product.giamgiaMax}")
	private Integer giamgia;
	@NotBlank(message = "{NotBlank.product.chatlieu}")
	@Length(max = 100, message = "{Length.product.chatlieu}")
	private String chatlieu;
	@NotBlank(message = "{NotBlank.product.thietke}")
	@Length(max = 100, message = "{Length.product.thietke}")
	private String thietke;
	private String phanloai;
	public Product data(Product product) {
		
		if (product == null) {
			product = new Product();
		}
		product.setId(this.getId());
		product.setTieuDe(this.getTieude());
		product.setMoTa(this.getMota());
		product.setGia(this.getGia());
		product.setGiamGia(this.getGiamgia());
		product.setChatLieu(this.getChatlieu());
		product.setThietKe(this.getThietke());
		return product;
	}
	
	
}
