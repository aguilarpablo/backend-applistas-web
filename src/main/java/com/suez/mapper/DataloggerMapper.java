package com.suez.mapper;

import java.util.Collection;

import org.mapstruct.Mapper;

import com.suez.entity.Datalogger;
import com.suez.model.CreateDataloggerInfo;
import com.suez.model.DataloggerBasicInfo;
import com.suez.model.DataloggerInfo;

import static java.util.stream.Collectors.toList;

@Mapper
public interface DataloggerMapper {
	
	DataloggerBasicInfo toBasicDto(Datalogger source);
	
	DataloggerInfo toDto(Datalogger source);
	
	Datalogger toEntity(DataloggerInfo source);
	
	Datalogger toCreateEntity(CreateDataloggerInfo source);
	
	default Collection<DataloggerInfo> toDtos(final Collection<Datalogger> sources) {
		return sources.stream().map(this::toDto).collect(toList());
	}
	
	default Collection<DataloggerBasicInfo> toBasicDtos(final Collection<Datalogger> sources) {
		return sources.stream().map(this::toBasicDto).collect(toList());
	}
	
}
