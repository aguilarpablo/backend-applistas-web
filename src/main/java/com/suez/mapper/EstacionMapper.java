package com.suez.mapper;

import static java.util.stream.Collectors.toList;

import java.util.Collection;

import org.mapstruct.Mapper;

import com.suez.entity.Estacion;
import com.suez.model.CreateEstacionInfo;
import com.suez.model.EstacionBasicInfo;
import com.suez.model.EstacionInfo;

@Mapper
public interface EstacionMapper {
	
	EstacionInfo toDto(Estacion source);
	
	EstacionBasicInfo toBasicDto(Estacion source);
	
	Estacion toEntity(EstacionInfo source);
	
	Estacion toCreateEntity(CreateEstacionInfo source);
	
	default Collection<EstacionInfo> toDtos(final Collection<Estacion> sources) {
		return sources.stream().map(this::toDto).collect(toList());
	}
	
	default Collection<EstacionBasicInfo> toBasicDtos(final Collection<Estacion> sources) {
		return sources.stream().map(this::toBasicDto).collect(toList());
	}

}
