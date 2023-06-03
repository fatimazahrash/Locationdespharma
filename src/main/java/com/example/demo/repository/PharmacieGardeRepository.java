package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Garde;
import com.example.demo.entity.Pharmacie;
import com.example.demo.entity.PharmacieGarde;

public interface PharmacieGardeRepository extends JpaRepository<PharmacieGarde, Integer> {
	
	PharmacieGarde findById(int id);
	List<PharmacieGarde> findPharmacieByGardeType(String periode);
	

}
