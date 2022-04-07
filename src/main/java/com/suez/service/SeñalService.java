package com.suez.service;

import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.suez.entity.Señal;
import com.suez.mapper.SeñalMapper;
import com.suez.model.CreateSeñalDataloggerInfo;
import com.suez.model.CreateSeñalEstacionInfo;
import com.suez.model.SeñalInfo;
import com.suez.repository.SeñalRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SeñalService {
	
	private final SeñalRepository señalRepository;
	private final SeñalMapper señalMapper;
	
	public Collection<SeñalInfo> findAll() {
		return señalMapper.toDtos(señalRepository.findAll());
	}
	
	@Transactional
	public void createSeñalesEstacion(List<CreateSeñalEstacionInfo> dtos) {
		for (CreateSeñalEstacionInfo dto : dtos) {
			señalRepository.save(señalMapper.señalEstacionToEntity(dto));
		}		
	}
	
	@Transactional
	public void createSeñalesDatalogger(List<CreateSeñalDataloggerInfo> dtos) {
		for (CreateSeñalDataloggerInfo dto : dtos) {
			señalRepository.save(señalMapper.señalDataloggerToEntity(dto));
		}	
	}
	
	@Transactional
	public void update(SeñalInfo dto, Integer id) {
		Señal señal = señalRepository.findById(id).get();
		señal.setAlarma(dto.getAlarma());
		señal.setCriterioArchivo(dto.getCriterioArchivo());
		señal.setDescripcion(dto.getDescripcion());
		señal.setHistorico(dto.getHistorico());
		señal.setDireccionPlc(dto.getDireccionPlc());
		señal.setOffMsg(dto.getOffMsg());
		señal.setOnMsg(dto.getOnMsg());
		señal.setMaxEngUnits(dto.getMaxEngUnits());
		señal.setMaxRaw(dto.getMaxRaw());
		señal.setMinEngUnits(dto.getMinEngUnits());
		señal.setMinRaw(dto.getMinRaw());
		señal.setNumeroFisico(dto.getNumeroFisico());
		señal.setNumeroLogico(dto.getNumeroLogico());
		señal.setInvertida(dto.getInvertida());
		señal.setTag(dto.getTag());
		señal.setDireccionPlcAutoGen(dto.getDireccionPlcAutoGen());
		señal.setUnidad(dto.getUnidad());
		señal.setVarCero(dto.getVarCero());
		señalRepository.save(señal);
	}
	
	@Transactional
	public void deleteById(Integer id) {
		señalRepository.deleteById(id);
	}

}
