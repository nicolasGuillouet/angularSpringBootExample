package com.example.test.departement;

public class Departement {
	private String nom, code, codeRegion;
	
	public Departement(String name, String code, String countryCode) {
		this.nom = name;
		this.code = code;
		this.codeRegion = countryCode;
	}

	public String getNom() {
		return nom;
	}

	public String getCode() {
		return code;
	}

	public String getCodeRegion() {
		return codeRegion;
	}
}
