package com.suez.model;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EstacionBasicInfo {
	
	private Integer id;
	@NotBlank
	private String nombre;
	@NotNull
	private Integer numero;
	private BigDecimal minRaw;
	private BigDecimal maxRaw;
	@NotBlank
	private String protocoloComunicacion;
	private Integer numeroEsclavo;

}
