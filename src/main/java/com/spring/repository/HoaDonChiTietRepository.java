package com.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;


import com.spring.entities.HoaDonChiTiet;

@Controller
public interface HoaDonChiTietRepository extends JpaRepository<HoaDonChiTiet, Integer>{
	@Query("Select e from HoaDonChiTiet e where hoaDon.idHoaDon = :hd")
	List<HoaDonChiTiet> getAllById(@Param("hd") Integer id);
}
