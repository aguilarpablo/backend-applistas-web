package com.suez.service;

import java.util.Collection;

import org.springframework.stereotype.Service;

import com.suez.entity.Agrupacion;
import com.suez.repository.AgrupacionRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AgrupacionService {

	private final AgrupacionRepository agrupacionRepository;
	
	public Collection<Agrupacion> findAll() {
		return agrupacionRepository.findAll();
	}
	
}
