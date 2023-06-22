package com.spring.beans;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartForm {
	private Integer id;
	private String username;
	private Integer idProduct ;
	private Integer kichthuoc;
	private Integer soluong;
	private BigDecimal dongia;
}
