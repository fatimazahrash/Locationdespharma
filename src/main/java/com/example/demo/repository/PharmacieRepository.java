package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Pharmacie;

public interface PharmacieRepository extends JpaRepository<Pharmacie, Integer> {
	
	Pharmacie findById(int ind);
	List<Pharmacie> findPharmacieByZoneNom(String nom);

}
