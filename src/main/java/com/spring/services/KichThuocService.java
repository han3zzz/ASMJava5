package com.spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import com.spring.entities.KichThuoc;



public interface KichThuocService {
	public Page<KichThuoc> getAll(Integer pageNum , Integer pageSize);
	public List<KichThuoc> count();
	public Optional<KichThuoc> getById(Integer id);
	public KichThuoc add(KichThuoc kichThuoc);
	public KichThuoc update(KichThuoc kichThuoc);
	public KichThuoc delete(KichThuoc kichThuoc);
	public KichThuoc getKichThuocbyId(Integer id);
	public KichThuoc getKichThuocbyName(String name);
}
