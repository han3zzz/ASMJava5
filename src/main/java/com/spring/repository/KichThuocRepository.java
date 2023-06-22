package com.spring.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spring.entities.KichThuoc;

@Repository
public interface KichThuocRepository extends JpaRepository<KichThuoc, Integer>{
	
	@Query("Select e from KichThuoc e where e.trangThai = 0")
	Page<KichThuoc> phantrang(Pageable pageable);
	@Query("Select e from KichThuoc e where e.trangThai = 0")
	List<KichThuoc> countPhanTrang();
	@Query("Select e from KichThuoc e where e.tenKichThuoc like :kt")
	KichThuoc getByName(@Param("kt") String kt);
}
