package com.example.test.departement;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.example.test.departement.Departement;

public class DepartementTest {
	
	@Test
	public void shouldGetFields() {
		String name = "one name";
		String code = "one code";
		String countryCode = "one country code";
		Departement departement = new Departement(name, code, countryCode);
		assertEquals(name, departement.getNom());
		assertEquals(code, departement.getCode());
		assertEquals(countryCode, departement.getCodeRegion());
	}
}
