package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Garde;
import com.example.demo.entity.Pharmacie;
import com.example.demo.entity.PharmacieGarde;
import com.example.demo.entity.Ville;
import com.example.demo.entity.Zone;
import com.example.demo.repository.PharmacieGardeRepository;
import com.example.demo.repository.PharmacieRepository;
import com.example.demo.repository.VilleRepository;
import com.example.demo.repository.ZoneRepository;
import com.example.demo.service.VilleService;


@RestController
@RequestMapping("/api/villes")
public class VilleController {

	@Autowired
	private VilleService villeService;
	@Autowired
	private VilleRepository villeRepository;

	@GetMapping
	public List<Ville> findAll() {
		return villeService.getAllVilles();
	}

	@GetMapping("/{nom}/zones")
	public List<Zone> findzonebyvillenom(@PathVariable String nom) {
		return villeService.getZoneByVilleNom(nom);
	}

	@GetMapping("/{nom1}/zones/{nom2}/pharmacies")
	public List<Pharmacie> findpharmaciebyzonenom(@PathVariable String nom1, @PathVariable String nom2) {
		return villeService.getPharmacieByZoneNOM(nom2);
	}

	// pour tester
	@GetMapping("/test")
	@ResponseBody
	public String getid(@RequestParam(value = "nom") String nom) {
		return "nom" + nom;
	}

	@GetMapping("/{nom1}/zones/{nom2}/pharmacies/garde")
	@ResponseBody
	public List<PharmacieGarde> findpharmaciebygardeType(@RequestParam(value = "periode") String periode) {
		return villeService.getPharmacieByGardeType(periode);
	}

	@PostMapping("/add")
	public Ville addVilles(@RequestBody Ville ville) {
		return villeService.addVilles(ville);
	}

	@DeleteMapping("/add/{id}")
	public void deleteCity(@PathVariable int id) {
		villeRepository.deleteById(id);
	}
	
	   @PutMapping("/add/{id}")
	    public Ville updateCity(@PathVariable int id, @RequestBody Ville ville) {
	        Ville existingCity = villeRepository.findById(id);
	        if (existingCity != null) {
	            existingCity.setNom(ville.getNom());
	            return villeRepository.save(existingCity);
	        }
	        return null;
	    }

}
