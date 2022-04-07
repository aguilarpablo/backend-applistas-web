package com.suez.service;

import java.util.Collection;

import org.springframework.stereotype.Service;

import com.suez.entity.Plantilla;
import com.suez.repository.PlantillaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PlantillaService {
	
	private final PlantillaRepository plantillaRepository;
	
	public Collection<Plantilla> findAll() {
		return plantillaRepository.findAll();
	}

}
