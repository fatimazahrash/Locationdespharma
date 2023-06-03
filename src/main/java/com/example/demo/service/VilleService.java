package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Pharmacie;
import com.example.demo.entity.PharmacieGarde;
import com.example.demo.entity.Ville;
import com.example.demo.entity.Zone;
import com.example.demo.repository.PharmacieGardeRepository;
import com.example.demo.repository.PharmacieRepository;
import com.example.demo.repository.VilleRepository;
import com.example.demo.repository.ZoneRepository;

@Service
public class VilleService {

		@Autowired
		private VilleRepository villeRepository;
		
		@Autowired
		private ZoneRepository zoneRepository;
		
		@Autowired
		private PharmacieRepository pharmacieRepository;
		
		@Autowired
		private PharmacieGardeRepository pharmacieGardeRepository;
		
		
		public List<Ville> getAllVilles() {
			return villeRepository.findAll();
		}
	
		
		public List<Zone> getZoneByVilleNom(String nom){
			
			return zoneRepository.findZoneByVilleNom(nom);
		}
		
		
		public List<Pharmacie> getPharmacieByZoneNOM(String nom2){
			
			return pharmacieRepository.findPharmacieByZoneNom(nom2);
		}
		
		
		public List<PharmacieGarde> getPharmacieByGardeType(String periode){
			
			return pharmacieGardeRepository.findPharmacieByGardeType(periode);
		}
		
		public Ville addVilles(Ville ville) {
			return villeRepository.save(ville);
		}
}
