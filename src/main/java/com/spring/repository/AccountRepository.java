package com.spring.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spring.entities.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer>{
	
	@Query("Select e from Account e where e.active = 0")
	Page<Account> phantrang(Pageable pageable);
	@Query("Select e from Account e where e.active = 0")
	List<Account> countPhanTrang();
	@Query("Select e from Account e where e.username like :keyword")
	Account getByUsername(@Param("keyword") String username);
	
}
