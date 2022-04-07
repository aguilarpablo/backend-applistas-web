package com.suez.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.suez.entity.Explotacion;

public interface ExplotacionRepository extends JpaRepository<Explotacion, Integer> {
	
	public List<Explotacion> findByNombre(String nombre);

}
