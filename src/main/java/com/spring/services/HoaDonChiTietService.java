package com.spring.services;

import java.util.List;

import com.spring.entities.HoaDonChiTiet;

public interface HoaDonChiTietService {
	public List<HoaDonChiTiet> getbyId(Integer id);
	public HoaDonChiTiet add(HoaDonChiTiet hoaDon);
}
