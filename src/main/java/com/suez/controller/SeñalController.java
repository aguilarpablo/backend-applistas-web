package com.suez.controller;

import static com.suez.constants.Constants.SEÑALES_URI;
import static com.suez.constants.Constants.ID_URI;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.suez.model.CreateSeñalEstacionInfo;
import com.suez.model.SeñalInfo;
import com.suez.service.SeñalService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = SEÑALES_URI, produces = APPLICATION_JSON_VALUE)
public class SeñalController {
	
	private final SeñalService señalService;
	
	@PostMapping
	public void createListaSeñalesEstacion(List<CreateSeñalEstacionInfo> señales) {
		señalService.createSeñalesEstacion(señales);
	}
	
	@PutMapping(ID_URI) 
	public void update(@PathVariable Integer id, @RequestBody SeñalInfo señal) {
		señalService.update(señal, id);
	}
	
	@DeleteMapping(ID_URI)
	public void delete(@PathVariable Integer id) {
		señalService.deleteById(id);
	}

}
