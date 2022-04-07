package com.suez.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.suez.entity.Señal;

public interface SeñalRepository extends JpaRepository<Señal, Integer> {

	public List<Señal> findByEstacionId(Integer Id);
	
	public List<Señal> findByDataloggerId(Integer Id);
	
}
