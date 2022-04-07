package com.suez.controller;

import static com.suez.constants.Constants.ESTACIONES_URI;
import static com.suez.constants.Constants.SEÑALES_URI;
import static com.suez.constants.Constants.ID_URI;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.Collection;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.suez.model.CreateEstacionInfo;
import com.suez.model.EstacionBasicInfo;
import com.suez.model.EstacionInfo;
import com.suez.service.EstacionService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = ESTACIONES_URI, produces = APPLICATION_JSON_VALUE)
public class EstacionController {
	
	private final EstacionService estacionService;

	@GetMapping
	public Collection<EstacionBasicInfo> findAll() {
		return estacionService.findAll();
	}
	
	@GetMapping(ID_URI + SEÑALES_URI)
	public EstacionInfo findSeñalesEstacionById(@PathVariable Integer id) {
		return estacionService.findSeñalesAndEstacionById(id);
	}
	
	@PostMapping
	public void createEstacion(@RequestBody CreateEstacionInfo dto) {
		estacionService.create(dto);
	}
	
	@PutMapping(ID_URI)
	public void update(@PathVariable Integer id, @RequestBody EstacionBasicInfo dto) {
		estacionService.update(dto, id);
	}
	
	@DeleteMapping(ID_URI)
	public void delete(@PathVariable Integer id) {
		estacionService.deleteById(id);
	}
}
