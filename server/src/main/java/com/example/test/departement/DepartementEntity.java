package com.example.test.departement;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;

@Entity
@Getter
@Table(name="departement")
public class DepartementEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String code, name, countryCode;


	public DepartementEntity() {
	}
	
    public DepartementEntity(String code, String name, String countryCode){
    	this.code = code;
    	this.name = name;
    	this.countryCode = countryCode;
    }

}