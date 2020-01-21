package com.example.test.departement;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartementServiceImpl implements DepartementService{
	@Autowired 
	DepartementRepository departementRepository;
	
	@Autowired
	DepartementMapper departementMapper;
	
	@Override
	public List<Departement> getAll() {
		return departementRepository.findAll().stream().map(departementEntity -> departementMapper.toDTO(departementEntity)).collect(Collectors.toList());
	}

	@Override
	public Departement findByCode(String code) {
		return departementMapper.toDTO(departementRepository.findByCode(code));
	}
	
	
}
