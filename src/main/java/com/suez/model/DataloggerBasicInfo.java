package com.suez.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DataloggerBasicInfo {
	
	private Integer id;
	@NotBlank
	private String nombre;
	private Integer numeroPunto;
	@NotNull
	private Integer numeroAgrupacion;
	@NotNull
	private Integer numeroDatalogger;
	private String direccionIp;
	private Integer puerto;
	private String tipo;
	private String horasComunicacion;
	private String zonaSectorizacion;

}
