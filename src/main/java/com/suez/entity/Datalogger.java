package com.suez.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "datalogger")
public class Datalogger {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nombre;
	
	private Integer numeroPunto;
	
	private Integer numeroAgrupacion;
	
	private Integer numeroDatalogger;
	
	private String direccionIp;
	
	private Integer puerto;
	
	private String tipo;
	
	private String horasComunicacion;
	
	private String zonaSectorizacion;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "id_explotacion", referencedColumnName = "id")
	private Explotacion explotacion;
	
	@OneToMany(cascade = CascadeType.REMOVE, mappedBy = "datalogger")
	private Set<Señal> señales = new HashSet<Señal>();

}
