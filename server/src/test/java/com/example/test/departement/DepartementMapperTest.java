package com.example.test.departement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DepartementMapperTest {	

	@Autowired
	private DepartementMapper departementMapper;
	
	@Test
	public void testFromEntity() {
		String code = "14";
		String name = "Calvados";
		String countryCode = "28";
		DepartementEntity departementEntity = new DepartementEntity(code, name, countryCode);
		Departement departement = departementMapper.toDTO(departementEntity);
		assertEquals(code, departement.getCode());
		assertEquals(name, departement.getNom());
		assertEquals(countryCode, departement.getCodeRegion());
	}
	
	@Test
	public void testFromNullEntity() {
		assertNull(departementMapper.toDTO(null));
	}
}
