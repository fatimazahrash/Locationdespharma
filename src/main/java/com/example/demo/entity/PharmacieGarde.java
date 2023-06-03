package com.example.demo.entity;

import java.sql.Date;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class PharmacieGarde {

	@EmbeddedId
	private PharmacieGardePK pk;

	@Temporal(TemporalType.DATE)
	private Date date_fin;

	@ManyToOne
	@JoinColumn(name = "pharmacie", insertable = false, updatable = false)
	private Pharmacie pharmacie;

	@ManyToOne
	@JoinColumn(name = "garde", insertable = false, updatable = false)
	private Garde garde;

	public PharmacieGardePK getPk() {
		return pk;
	}

	public void setPk(PharmacieGardePK pk) {
		this.pk = pk;
	}

	public Date getDate_fin() {
		return date_fin;
	}

	public void setDate_fin(Date date_fin) {
		this.date_fin = date_fin;
	}

	public Pharmacie getPharmacie() {
		return pharmacie;
	}

	public void setPharmacie(Pharmacie pharmacie) {
		this.pharmacie = pharmacie;
	}

	public Garde getGarde() {
		return garde;
	}

	public void setGarde(Garde garde) {
		this.garde = garde;
	}

	public PharmacieGarde() {
		super();
	}
}
