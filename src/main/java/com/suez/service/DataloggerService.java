package com.suez.service;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.suez.entity.Datalogger;
import com.suez.mapper.DataloggerMapper;
import com.suez.mapper.SeñalMapper;
import com.suez.model.CreateDataloggerInfo;
import com.suez.model.DataloggerBasicInfo;
import com.suez.model.DataloggerInfo;
import com.suez.model.SeñalInfo;
import com.suez.repository.DataloggerRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DataloggerService {
	
	private final DataloggerRepository dataloggerRepository;
	private final DataloggerMapper dataloggerMapper;
	private final SeñalMapper señalMapper;
	
	public Collection<DataloggerBasicInfo> findAll() {
		return dataloggerMapper.toBasicDtos(dataloggerRepository.findAll());
	}
	
	public DataloggerInfo findSeñalesAndDataloggerById(Integer id) {
		return dataloggerMapper.toDto(dataloggerRepository.findById(id).get());
	}
	
	public Collection<SeñalInfo> findSeñalesDataloggerById(Integer id) {
		return señalMapper.toDtos(dataloggerRepository.findById(id).get().getSeñales());
	}
	
	@Transactional
	public void create(CreateDataloggerInfo dto) {
		dataloggerRepository.save(dataloggerMapper.toCreateEntity(dto));
	}
	
	@Transactional
	public void update(DataloggerBasicInfo dto, Integer id) {
		Datalogger datalogger = dataloggerRepository.findById(id).get();
		datalogger.setDireccionIp(dto.getDireccionIp());
		datalogger.setHorasComunicacion(dto.getHorasComunicacion());
		datalogger.setNumeroPunto(dto.getNumeroPunto());
		datalogger.setPuerto(dto.getPuerto());
		datalogger.setTipo(dto.getTipo());
		datalogger.setNumeroAgrupacion(dto.getNumeroAgrupacion());
		datalogger.setNumeroDatalogger(dto.getNumeroDatalogger());
		datalogger.setZonaSectorizacion(dto.getZonaSectorizacion());
		dataloggerRepository.save(datalogger);
	}
	
	@Transactional
	public void deleteById(Integer id) {
		dataloggerRepository.deleteById(id);
	}

}
