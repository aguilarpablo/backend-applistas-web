package com.suez.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "explotacion")
public class Explotacion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nombre;
	
	private String cebeAquacis;
	
	private String sitAquacis;
	
	private String cebeIas;

	private String explotacionIas;
	
	private String servicioIas;
	
	private String observaciones;
	
	@OneToMany(cascade = CascadeType.REMOVE, mappedBy = "explotacion")
	private Set<Estacion> estaciones = new HashSet<Estacion>();
	
	@OneToMany(cascade = CascadeType.REMOVE, mappedBy = "explotacion")
	private Set<Datalogger> dataloggers = new HashSet<Datalogger>();
	
}
