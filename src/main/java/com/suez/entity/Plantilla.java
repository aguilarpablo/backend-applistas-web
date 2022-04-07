package com.suez.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "plantilla")
public class Plantilla {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nombrePlantilla;
	
	private String nombreAtributo;
	
	private String descripcion;
	
	private String tipo;
	
	private BigDecimal maxCuentas;
	
	private BigDecimal minCuentas;
	
	private BigDecimal maxRango;
	
	private BigDecimal minRango;

	private String unidad;
	
	private String historico;
	
	private String alarma;
	
	private String observaciones;
	
	private String tipoPlantilla;
	
	private String shortDesc;
	
}
