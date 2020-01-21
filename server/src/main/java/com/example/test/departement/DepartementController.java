package com.example.test.departement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class DepartementController {
	@Autowired 
	private DepartementService departementService;
	
	@CrossOrigin
	@GetMapping("/departements")
	public List<Departement> getAll(){
		return departementService.getAll();
	}
	
	@CrossOrigin
	@GetMapping("/departements/{code}")
	public Departement findByCode(@PathVariable String code){
		return departementService.findByCode(code);
	}
}
