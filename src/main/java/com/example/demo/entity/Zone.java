package com.example.demo.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Zone {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String nom;

	// avec pharmacie
	
	@JsonIgnore
	@OneToMany(mappedBy = "zone")
	private List<Pharmacie> pharmacie;

	// avec ville

	@ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.ALL}) /*You should include cascade="all" (if using xml) or cascade=CascadeType.ALL (if using annotations) on your collection mapping.
	This happens because you have a collection in your entity, and that collection has one or more items which are not present in the database. By specifying the above options you tell hibernate to save them to the database when saving their parent.*/
	//the error : object references an unsaved transient instance - save the transient instance before flushing
	@JoinColumn(name = "ville_id")
	private Ville ville;

	public Zone() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Pharmacie> getPharmacie() {
		return pharmacie;
	}

	public void setPharmacie(List<Pharmacie> pharmacie) {
		this.pharmacie = pharmacie;
	}

	public Ville getVille() {
		return ville;
	}

	public void setVille(Ville ville) {
		this.ville = ville;
	}

}
