package com.example.test.departement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartementRepository extends JpaRepository<DepartementEntity, Long> {

	DepartementEntity findByCode(String code);
}

