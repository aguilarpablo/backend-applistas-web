package com.suez.service;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.suez.entity.Estacion;
import com.suez.mapper.EstacionMapper;
import com.suez.mapper.SeñalMapper;
import com.suez.model.CreateEstacionInfo;
import com.suez.model.EstacionBasicInfo;
import com.suez.model.EstacionInfo;
import com.suez.model.SeñalInfo;
import com.suez.repository.EstacionRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EstacionService {
	
	private final EstacionRepository estacionRepository;
	private final EstacionMapper estacionMapper;
	private final SeñalMapper señalMapper;
	
	public Collection<EstacionBasicInfo> findAll() {
		return estacionMapper.toBasicDtos(estacionRepository.findAll());
	}
	
	public EstacionInfo findSeñalesAndEstacionById(Integer id) {
		return estacionMapper.toDto(estacionRepository.findById(id).get());
	}
	
	public Collection<SeñalInfo> findSeñalesEstacionById(Integer id) {
		return señalMapper.toDtos(estacionRepository.findById(id).get().getSeñales());
	}
	
	@Transactional
	public void create(CreateEstacionInfo dto) {
		estacionRepository.save(estacionMapper.toCreateEntity(dto));
	}
	
	@Transactional
	public void update(EstacionBasicInfo dto, Integer id) {
		Estacion estacion = estacionRepository.findById(id).get();
		estacion.setMaxRaw(dto.getMaxRaw());
		estacion.setMinRaw(dto.getMinRaw());
		estacion.setNumero(dto.getNumero());
		estacion.setNumeroEsclavo(dto.getNumeroEsclavo());
		estacion.setProtocoloComunicacion(dto.getProtocoloComunicacion());
		estacionRepository.save(estacion);
	}
	
	@Transactional
	public void deleteById(Integer id) {
		estacionRepository.deleteById(id);
	}

}
