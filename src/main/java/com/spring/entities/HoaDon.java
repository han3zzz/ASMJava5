package com.spring.entities;

import java.io.Serializable;
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
@Table(name = "HoaDon")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HoaDon implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idHoaDon")
	private Integer idHoaDon ;
	@ManyToOne()
	@JoinColumn(name = "username" , nullable = false)
	private Account username ;
	@Column(name = "ngayTao")
	private String ngayTao;
	@Column(name = "ngayThanhToan")
	private String ngayThanhToan ;
	@Column(name = "trangThai")
	private Integer trangThai ;
	@Column(name = "nguoiNhan")
	private String nguoiNhan ;
	@Column(name = "soDienThoai")
	private String soDienThoai ;
	@Column(name = "diaChi")
	private String diaChi ;
	@OneToMany(mappedBy = "hoaDon" ,fetch = FetchType.LAZY)
	private List<HoaDonChiTiet> hdcts;
	
	
	
	
	
	
}
