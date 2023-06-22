package com.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spring.entities.Product_KichThuoc;

@Repository
public interface ProductKichThuocRepository extends JpaRepository<Product_KichThuoc, Integer>{
	
	@Query("Select e from Product_KichThuoc e where e.product.id = :id and e.kichThuoc.idKichThuoc = :idKichThuoc")
	Product_KichThuoc getByIdProduct(@Param("id") Integer id , @Param("idKichThuoc") Integer idKt);
	@Query("Select e from Product_KichThuoc e where e.product.id = :id")
	List<Product_KichThuoc> getAllByIdProduct(@Param("id") Integer id);
}
