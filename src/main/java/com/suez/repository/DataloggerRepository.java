package com.suez.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.suez.entity.Datalogger;

public interface DataloggerRepository extends JpaRepository<Datalogger, Integer> {
	
	public List<Datalogger> findByExplotacionIdOrderByNumeroDatalogger(Integer id);

}
