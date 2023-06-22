package com.spring.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "Cart")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cart implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idCart")
	private Integer idCart ;
	@ManyToOne
	@JoinColumn(name = "username" , nullable = false)
	private Account username ;
	@ManyToOne
	@JoinColumn(name = "idProduct" , nullable =  false)
	private Product product ;
	@Column(name = "soLuong")
	private Integer soLuong ;
	@Column(name = "donGia")
	private BigDecimal donGia ;
	@Column(name = "kichThuoc" , length = 50)
	private String kichThuoc ;
	
	
	
	
	
}
