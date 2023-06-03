package com.example.demo.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.Pharmacie;
import com.example.demo.entity.Photo;
import com.example.demo.entity.Zone;
import com.example.demo.repository.PharmacieRepository;
import com.example.demo.repository.PhotoRepository;
import com.example.demo.repository.ZoneRepository;
import com.example.demo.service.PharmacieService;

@RestController
@RequestMapping("/api/pharmacies")
public class PharmacieController {

	@Autowired
	private PharmacieService pharmacieService;

	@Autowired
	private PhotoRepository photoRepository;
	@Autowired
	private ZoneRepository zoneRepository;

	@Autowired
	private PharmacieRepository pharmacieRepository;

	@GetMapping
	public List<Pharmacie> findall() {
		return pharmacieService.getAll();
	}

	@GetMapping("/{id}")
	public Pharmacie findbyid(@PathVariable int id) {
		return pharmacieService.getById(id);
	}

	@PostMapping("/add")
	public void uploadImage(@RequestParam("adresse") String adresse, @RequestParam("etat") int etat,
			@RequestParam("laltitude") double laltitude, @RequestParam("longitude") double longitude,
			@RequestParam("nom") String nom, @RequestParam("zone") String zone,
			@RequestParam("file") MultipartFile file) throws IOException {

		File convertFile = new File(
				"C:\\Users\\Fatima Ezzahra\\Desktop\\frontpharmacifati\\pharmacie\\src\\images/" + file.getOriginalFilename());
		convertFile.createNewFile();
		

		try (FileOutputStream fout = new FileOutputStream(convertFile)) {
			fout.write(file.getBytes());

			/* ZONE */
			Zone entityZone = zoneRepository.findZoneByNom(zone);
			String nomZone = entityZone.getNom();
			System.out.println(nomZone);

			/* PHARMACIE */
			Pharmacie pharmacie = new Pharmacie();
			pharmacie.setAdresse(adresse);
			pharmacie.setEtat(etat);
			pharmacie.setLaltitude(laltitude);
			pharmacie.setLongitude(longitude);
			pharmacie.setNom(nom);
			pharmacie.setZone(entityZone);
			pharmacieRepository.save(pharmacie);

			/* UPLOAD PHOTO */
			Photo photo = new Photo();
			photo.setUrl(file.getOriginalFilename().toString());
			photo.setPharmacie(pharmacie);
			photoRepository.save(photo);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@PutMapping("/add/{id}")
	public Pharmacie updating(@PathVariable int id, @RequestParam(value = "adresse") String adresse,
			@RequestParam("etat") int etat, @RequestParam("laltitude") double laltitude,
			@RequestParam("longitude") double longitude, @RequestParam("nom") String nom,
			@RequestParam("zone") String zone) {

		Pharmacie existingPharmacie = pharmacieRepository.findById(id);
		if (existingPharmacie != null) {

			existingPharmacie.setAdresse(adresse);
			existingPharmacie.setEtat(etat);
			existingPharmacie.setLaltitude(laltitude);
			existingPharmacie.setLongitude(longitude);
			existingPharmacie.setNom(nom);
			existingPharmacie.getZone().setNom(zone);
			existingPharmacie.setUsers(null);
			System.out.println(adresse + etat + laltitude + longitude + nom + zone);
			return pharmacieRepository.save(existingPharmacie);
		}
		return null;
	}

	@DeleteMapping("/add/{id}")
	public void deleteCity(@PathVariable int id) {
		photoRepository.deleteById(id);
		pharmacieRepository.deleteById(id);
	}
}
