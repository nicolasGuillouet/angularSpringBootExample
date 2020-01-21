package com.example.test.departement;

import java.util.List;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class DepartementRepositoryTest{
    @Autowired 
    private DepartementRepository departementRepository;

    @BeforeEach
	public void setUp() {
    	DepartementEntity calvados = new DepartementEntity("14", "Calvados", "28");
    	DepartementEntity manche = new DepartementEntity("50", "Manche", "28");
    	departementRepository.save(calvados);
    	departementRepository.save(manche);
	}

    @Test
    @Order(1)
    public void testAddDepartement() {
    	DepartementEntity calvados = new DepartementEntity("14", "Calvados", "28");
    	departementRepository.save(calvados);
        List<DepartementEntity> departements = departementRepository.findAll();
        assertEquals(3, departements.size());
    }
    
    @Test
    @Order(2)//Previous element is rollbacked
    public void testFindAll(){
        List<DepartementEntity> departements = departementRepository.findAll();
        assertEquals(2, departements.size());
    }
    
    @Test
    public void testFindByCode() {
    	DepartementEntity calvados = departementRepository.findByCode("14");
    	assertEquals("Calvados", calvados.getName());
    	
    	DepartementEntity notFound = departementRepository.findByCode("99");
    	assertNull(notFound);    	
    }
    

}