package com.example.demo.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.Pharmacie;
import com.example.demo.entity.Photo;
import com.example.demo.entity.Ville;
import com.example.demo.entity.Zone;
import com.example.demo.repository.PharmacieRepository;
import com.example.demo.repository.PhotoRepository;
import com.example.demo.repository.ZoneRepository;
import com.example.demo.service.PhotoService;

@RestController
@RequestMapping("/photo")
public class PhotoController {

	@Autowired
	private PhotoService photoService;
	@Autowired
	private PhotoRepository photoRepository;
	@Autowired
	private ZoneRepository zoneRepository;

	@Autowired
	private PharmacieRepository pharmacieRepository;

	private Photo photo;

	@GetMapping
	public List<Photo> findall() {
		return photoRepository.findAll();
	}

	
	@PostMapping("/uploadImage")
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
			
			
			                   /*PHARMACIE */
			Pharmacie pharmacie = new Pharmacie();
			pharmacie.setAdresse(adresse);
			pharmacie.setEtat(etat);
			pharmacie.setLaltitude(laltitude);
			pharmacie.setLongitude(longitude);
			pharmacie.setNom(nom);
			pharmacie.setZone(entityZone);
			pharmacieRepository.save(pharmacie);
          
						/*UPLOAD PHOTO */
			Photo photo = new Photo();
			photo.setUrl(convertFile.toString());
			photo.setPharmacie(pharmacie);
			photoRepository.save(photo);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	

}
