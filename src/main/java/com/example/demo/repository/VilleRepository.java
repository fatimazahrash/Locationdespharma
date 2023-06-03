package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Ville;

public interface VilleRepository extends JpaRepository<Ville, Integer> {
	Ville findById(int id);
	
	

}
