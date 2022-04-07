package com.suez.service;

import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.suez.entity.Explotacion;
import com.suez.mapper.DataloggerMapper;
import com.suez.mapper.EstacionMapper;
import com.suez.mapper.ExplotacionMapper;
import com.suez.model.DataloggerBasicInfo;
import com.suez.model.EstacionBasicInfo;
import com.suez.model.ExplotacionInfo;
import com.suez.repository.ExplotacionRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ExplotacionService {
	
	private final ExplotacionRepository explotacionRepository;
	private final ExplotacionMapper explotacionMapper;
	private final EstacionMapper estacionMapper;
	private final DataloggerMapper dataloggerMapper;
	
	public Collection<ExplotacionInfo> findAll() {
		return explotacionMapper.toDtos(explotacionRepository.findAll());
	}
	
	public Collection<EstacionBasicInfo> findEstacionesExplotacionById(Integer id) {
		return estacionMapper.toBasicDtos(explotacionRepository.findById(id).get().getEstaciones());
	}
	
	public Collection<DataloggerBasicInfo> findDataloggersExplotacionById(Integer id) {
		return dataloggerMapper.toBasicDtos(explotacionRepository.findById(id).get().getDataloggers());
	}
	
	@Transactional
	public void updateCebeIas(String name, String cebeIas) {
		List<Explotacion> explotaciones = explotacionRepository.findByNombre(name);
		
		for (Explotacion explotacion : explotaciones) {
			explotacion.setCebeIas(cebeIas);
			explotacionRepository.save(explotacion);
		}
	}

}
