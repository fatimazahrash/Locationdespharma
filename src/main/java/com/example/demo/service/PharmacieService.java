package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Pharmacie;
import com.example.demo.repository.PharmacieRepository;

@Service
public class PharmacieService {
	
	@Autowired
	private PharmacieRepository pharmacieRepository;
	
	
	public Pharmacie getById(int id) {
		return pharmacieRepository.findById(id);
	}

	public List<Pharmacie> getAll() {
		return pharmacieRepository.findAll();
	}
}
