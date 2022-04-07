package com.suez.model;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SeñalInfo {
	
	private Integer id;
	@NotBlank
	private String descripcion;
	private String tag;
	private BigDecimal minEngUnits;
	private BigDecimal maxEngUnits;
	private BigDecimal minRaw;
	private BigDecimal maxRaw;
	@NotBlank
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

}
