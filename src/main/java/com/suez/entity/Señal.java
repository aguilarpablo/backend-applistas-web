package com.suez.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "señal")
public class Señal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String descripcion;
	
	private String tag;

	private BigDecimal minEngUnits;
	
	private BigDecimal maxEngUnits;
	
	private BigDecimal minRaw;
	
	private BigDecimal maxRaw;
	
	private String codigo;
	
	private String onMsg;
	
	private String offMsg;
	
	private String unidad;
	
	private String alarma;
	
	private String historico;
	
	private Integer numeroLogico;
	
	private Integer numeroFisico;
	
	private String invertida;
	
	private String direccionPlc;
	
	private Boolean direccionPlcAutoGen;
	
	private Boolean varCero;
	
	private Boolean criterioArchivo;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "id_estacion", referencedColumnName = "id")
	private Estacion estacion;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "id_datalogger", referencedColumnName = "id")
	private Datalogger datalogger;
	
}
