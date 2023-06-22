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
@Table(name = "HoaDonChiTiet")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HoaDonChiTiet implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idHoaDonChiTiet")
	private Integer id;
	@ManyToOne
	@JoinColumn(name = "idHoaDon" , nullable = false)
	private HoaDon hoaDon ;
	@ManyToOne
	@JoinColumn(name = "idProduct" , nullable = false)
	private Product product ;
	@Column(name = "soLuong")
	private Integer soLuong;
	@Column(name = "donGia")
	private BigDecimal donGia ;
	@Column(name = "kichThuoc",  length = 50)
	private String kichThuoc;
	
	
	
	
	
	
	
}
