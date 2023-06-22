package com.spring.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "Product")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idProduct", nullable = false)
	private Integer id;
	@Column(name = "tieude", length = 100 , nullable = false)
	private String tieuDe;
	@Column(name = "mota" , length = 255)
	private String moTa;
	@Column(name = "anh" ,length = 255)
	private String anh;
	@Column(name = "gia")
	private BigDecimal gia;
	@Column(name = "giamgia")
	private Integer giamGia;
	@Column(name = "giaDaGiam")
	private BigDecimal giaDaGiam;
	@Column(name = "phanloai" , length = 100)
	private String phanLoai;
	@Column(name = "chatlieu" , length = 100)
	private String chatLieu;
	@Column(name = "thietke" , length = 100)
	private String thietKe;
	@Column(name = "trangthai")
	private Integer trangThai;

	@ManyToOne
	@JoinColumn(name = "idCategory")
	private Category category;

	@OneToMany(mappedBy = "product" ,fetch = FetchType.LAZY)
	private List<HoaDonChiTiet> hdcts;
	@OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
	private List<Cart> carts ;
	@OneToMany(mappedBy = "product" , fetch = FetchType.LAZY)
	private List<Product_KichThuoc> kichthuocs ;
	
	
}
