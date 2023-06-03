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
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Ville;
import com.example.demo.entity.Zone;
import com.example.demo.repository.ZoneRepository;

@RestController
@RequestMapping("/api/zones")
public class ZoneController {
	
	@Autowired
	private ZoneRepository zoneRepository;
	
	@GetMapping
	public List<Zone> findzone() {
		return zoneRepository.findAll();
	}
	
	@PostMapping("/add")
	public Zone addZone(@RequestBody Zone zone) {
		return zoneRepository.save(zone);
	}
	
	@DeleteMapping("/add/{id}")
	public void deleteZone(@PathVariable int id) {
		zoneRepository.deleteById(id);
	}
	
	   @PutMapping("/add/{id}")
	    public Zone updateZone(@PathVariable int id, @RequestBody Zone zone) {
	        Zone existingZone = zoneRepository.findById(id);
	        if (existingZone != null) {
	        	existingZone.setNom(zone.getNom());
	        	existingZone.setVille(zone.getVille());
	            return zoneRepository.save(existingZone);
	        }
	        return null;
	    }

}
