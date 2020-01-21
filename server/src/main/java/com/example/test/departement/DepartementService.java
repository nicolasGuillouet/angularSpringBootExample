package com.example.test.departement;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface DepartementService {
	public List<Departement> getAll();
	public Departement findByCode(String code);
}
