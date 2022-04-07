package com.suez.controller;

import static com.suez.constants.Constants.EXPLOTACIONES_URI;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.Collection;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.suez.model.ExplotacionInfo;
import com.suez.service.ExplotacionService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = EXPLOTACIONES_URI, produces = APPLICATION_JSON_VALUE)
public class ExplotacionController {

	private final ExplotacionService explotacionService;
	
	@GetMapping
	public Collection<ExplotacionInfo> findAll() {
		return explotacionService.findAll();
	}
	
	@PutMapping
	public void update(@RequestParam String name, @RequestBody String cebeIas) {
		explotacionService.updateCebeIas(name, cebeIas);
	}
	
}
