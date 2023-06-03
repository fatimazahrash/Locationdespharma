package com.example.demo.entity;

import java.io.Serializable;
import java.sql.Date;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Embeddable
public class PharmacieGardePK implements Serializable {
	
	private int pharmacie;
	private int garde;
	
	@Temporal(TemporalType.DATE)
	private Date date_debut;

	public int getPharmacie() {
		return pharmacie;
	}

	public void setPharmacie(int pharmacie) {
		this.pharmacie = pharmacie;
	}

	public int getGarde() {
		return garde;
	}

	public void setGarde(int garde) {
		this.garde = garde;
	}

	public Date getDate_debut() {
		return date_debut;
	}

	public void setDate_debut(Date date_debut) {
		this.date_debut = date_debut;
	}

	public PharmacieGardePK() {
		super();
	}

}
