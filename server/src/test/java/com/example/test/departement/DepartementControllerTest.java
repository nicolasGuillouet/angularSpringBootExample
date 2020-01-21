package com.example.test.departement;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import com.example.test.departement.Departement;
import com.example.test.departement.DepartementController;
import com.example.test.departement.DepartementService;

@WebMvcTest(DepartementController.class)
@ContextConfiguration
public class DepartementControllerTest {
    private List<Departement> allDepartements;
    private Departement oneDepartement;
	
	@Autowired
    private MockMvc mvc;    

    @MockBean
    DepartementService departementService;
	
    @BeforeEach
    public void init() {
    	Departement calvados = new Departement("Calvados", "14", "28");
    	Departement orne = new Departement("Calvados", "14", "28");
    	
    	allDepartements = new ArrayList();
    	allDepartements.add(calvados);
    	allDepartements.add(orne);
    	
    	oneDepartement = calvados;
    }

    @Test
    public void shouldFindDepartementByCode() throws Exception {
    	when(departementService.findByCode("14")).thenReturn(oneDepartement);
        this.mvc.perform(get("/departements/14"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nom", is("Calvados")));
    }
    
    @Test
    public void shouldFindAllDepartements() throws Exception {
    	when(departementService.getAll()).thenReturn(allDepartements);
        this.mvc.perform(get("/departements"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()", is(2)))
                .andExpect(jsonPath("$.[0].nom", is("Calvados")));
    }
}
