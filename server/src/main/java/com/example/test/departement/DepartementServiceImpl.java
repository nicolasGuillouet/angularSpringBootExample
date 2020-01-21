package com.example.test.departement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class DepartementServiceImpl implements DepartementService{
	
	private List<Departement> allDepartements; 

	public DepartementServiceImpl() {
		allDepartements = new ArrayList<>();
		allDepartements.add(new Departement("Calvados", "14", "28"));
		allDepartements.add(new Departement("Eure", "27", "28"));
		allDepartements.add(new Departement("Manche", "50", "28"));
		allDepartements.add(new Departement("Orne", "61", "28"));	
		allDepartements.add(new Departement("Seine-Maritime", "76", "28"));
	}
	
	@Override
	public List<Departement> getAll() {
		return allDepartements;
	}

	@Override
	public Departement findByCode(String code) {
		return allDepartements.stream().filter(departement -> departement.getCode().equals(code)).findFirst().orElse(null);
	}
	
	
}
