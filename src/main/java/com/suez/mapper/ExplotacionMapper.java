package com.suez.mapper;

import static java.util.stream.Collectors.toList;

import java.util.Collection;

import org.mapstruct.Mapper;

import com.suez.entity.Explotacion;
import com.suez.model.ExplotacionInfo;

@Mapper
public interface ExplotacionMapper {
	
	ExplotacionInfo toDto(Explotacion source);
	
	Explotacion toEntity(ExplotacionInfo source);
	
	default Collection<ExplotacionInfo> toDtos(final Collection<Explotacion> sources) {
		return sources.stream().map(this::toDto).collect(toList());
	}

}
