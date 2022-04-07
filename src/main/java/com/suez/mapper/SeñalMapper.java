package com.suez.mapper;

import static java.util.stream.Collectors.toList;

import java.util.Collection;

import org.mapstruct.Mapper;

import com.suez.entity.Señal;
import com.suez.model.CreateSeñalDataloggerInfo;
import com.suez.model.CreateSeñalEstacionInfo;
import com.suez.model.SeñalInfo;

@Mapper
public interface SeñalMapper {
	
	SeñalInfo toDto(Señal source);
	
	Señal señalEstacionToEntity(CreateSeñalEstacionInfo source);
	
	Señal señalDataloggerToEntity(CreateSeñalDataloggerInfo source);
	
	default Collection<SeñalInfo> toDtos(final Collection<Señal> sources) {
		return sources.stream().map(this::toDto).collect(toList());
	}

}
