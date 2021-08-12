package com.kiranaher.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
	public class Allergy {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name="allergy_id")
	private String allergy_id;
	@Column(name="allergy_type")
	private String type;
	@Column(name="allergy_name")
	private String name;
	@Column(name="allergy_source")
	private String source;
	@Column(name="isoform")
	private String isoform;
	@Column(name="allerginicity")
	private String allerginicity;

}
