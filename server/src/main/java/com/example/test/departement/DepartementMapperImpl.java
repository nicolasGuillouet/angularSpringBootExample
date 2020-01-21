package com.example.test.departement;

import org.springframework.stereotype.Component;

@Component
public class DepartementMapperImpl implements DepartementMapper {

	@Override
	public Departement toDTO(DepartementEntity departementEntity) {
		Departement departement = null;
		if(departementEntity != null) {
			departement = new Departement(departementEntity.getName(), departementEntity.getCode(), departementEntity.getCountryCode());
		} 
		return departement;
	}

}
