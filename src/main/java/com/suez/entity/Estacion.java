package com.suez.entity;

import java.math.BigDecimal;
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
@Table(name = "estacion")
public class Estacion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nombre;
	
	private Integer numero;
	
	private BigDecimal minRaw;
	
	private BigDecimal maxRaw;
	
	private String protocoloComunicacion;
	
	private Integer numeroEsclavo;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "id_explotacion", referencedColumnName = "id")
	private Explotacion explotacion;
	
	@OneToMany(cascade = CascadeType.REMOVE, mappedBy = "estacion")
	private Set<Señal> señales = new HashSet<Señal>();

}
