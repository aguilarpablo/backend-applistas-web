package com.suez.controller;

import static com.suez.constants.Constants.AGRUPACIONES_URI;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.Collection;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.suez.entity.Agrupacion;
import com.suez.service.AgrupacionService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = AGRUPACIONES_URI, produces = APPLICATION_JSON_VALUE)
public class AgrupacionController {

	private final AgrupacionService agrupacionService;
	
	@GetMapping
	public Collection<Agrupacion> findAll() {
		return agrupacionService.findAll();
	}
	
}
