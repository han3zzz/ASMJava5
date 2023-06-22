package com.spring.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import com.spring.entities.KichThuoc;
import com.spring.repository.KichThuocRepository;
import com.spring.services.KichThuocService;
@Service
public class IKichThuocService implements KichThuocService{
	@Autowired
	private KichThuocRepository repo;

	@Override
	public Page<KichThuoc> getAll(Integer pageNum, Integer pageSize) {
		// TODO Auto-generated method stub
		Pageable pageable = PageRequest.of(pageNum, pageSize);
		return repo.phantrang(pageable);
	}

	@Override
	public List<KichThuoc> count() {
		// TODO Auto-generated method stub
		return repo.countPhanTrang();
	}

	@Override
	public Optional<KichThuoc> getById(Integer id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}

	@Override
	public KichThuoc add(KichThuoc kichThuoc) {
		// TODO Auto-generated method stub
		return repo.save(kichThuoc);
	}

	@Override
	public KichThuoc update(KichThuoc kichThuoc) {
		// TODO Auto-generated method stub
		KichThuoc kt = repo.getById(kichThuoc.getIdKichThuoc());
		kt.setTenKichThuoc(kichThuoc.getTenKichThuoc());
		return repo.save(kt);
	}

	@Override
	public KichThuoc delete(KichThuoc kichThuoc) {
		// TODO Auto-generated method stub
		KichThuoc kt = repo.getById(kichThuoc.getIdKichThuoc());
		kt.setTrangThai(1);
		return repo.save(kt);
	}

	@Override
	public KichThuoc getKichThuocbyId(Integer id) {
		// TODO Auto-generated method stub
		return repo.getById(id);
	}

	@Override
	public KichThuoc getKichThuocbyName(String name) {
		// TODO Auto-generated method stub
		return repo.getByName(name);
	}
}
