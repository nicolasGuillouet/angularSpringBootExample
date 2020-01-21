package com.example.test.departement;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.test.departement.Departement;
import com.example.test.departement.DepartementService;

@SpringBootTest
public class DepartementServiceTest {
	 @Autowired
	 private DepartementService departementService;
	 
	 @Test
	 public void testGetAll() {
		 List<Departement> allDepartements = departementService.getAll();
		 assertEquals(5, allDepartements.size());
	 }
	 
	 @Test void testFindByCode() {
		 Departement foundDepartement = departementService.findByCode("14");
		 assertEquals("Calvados", foundDepartement.getNom());

		 foundDepartement = departementService.findByCode("toto");
		 assertNull(foundDepartement);
	 }
}
