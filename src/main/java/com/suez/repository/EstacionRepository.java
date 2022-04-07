package com.suez.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.suez.entity.Estacion;

public interface EstacionRepository extends JpaRepository<Estacion, Integer> {
	
	public List<Estacion> findByExplotacionIdOrderByNumero(Integer id);

}
