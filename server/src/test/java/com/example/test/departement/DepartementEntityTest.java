package com.example.test.departement;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

//@RunWith(SpringRunner.class)
@DataJpaTest
public class DepartementEntityTest {
    @Autowired
	private TestEntityManager entityManager;

    @Test
    public void testSave(){
        String code = "14";
        String name = "Calvados";
        String countryCode = "28";
        DepartementEntity departementEntity = new DepartementEntity(code, name, countryCode);
        DepartementEntity savedDepartementEntity = this.entityManager.persistAndFlush(departementEntity);
        assertEquals(code, savedDepartementEntity.getCode());
        assertEquals(name, savedDepartementEntity.getName());
        assertEquals(countryCode, savedDepartementEntity.getCountryCode());
    }
    
    @Test
    public void testDefaultConstructor() {
    	DepartementEntity departementEntity = new DepartementEntity();
    	assertNull(departementEntity.getCode());
    	assertNull(departementEntity.getName());
    	assertNull(departementEntity.getCountryCode());
    }
}