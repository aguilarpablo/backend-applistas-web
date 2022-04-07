package com.suez.controller;

import static com.suez.constants.Constants.PLANTILLAS_URI;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.Collection;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.suez.entity.Plantilla;
import com.suez.service.PlantillaService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = PLANTILLAS_URI, produces = APPLICATION_JSON_VALUE)
public class PlantillaController {
	
	private final PlantillaService plantillaService;
	
	@GetMapping
	public Collection<Plantilla> findAll() {
		return plantillaService.findAll();
	}

}
