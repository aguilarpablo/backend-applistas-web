package com.suez.controller;

import static com.suez.constants.Constants.DATALOGGERS_URI;
import static com.suez.constants.Constants.SEÑALES_URI;
import static com.suez.constants.Constants.ID_URI;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.Collection;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.suez.model.CreateDataloggerInfo;
import com.suez.model.DataloggerBasicInfo;
import com.suez.model.DataloggerInfo;
import com.suez.service.DataloggerService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = DATALOGGERS_URI, produces = APPLICATION_JSON_VALUE)
public class DataloggerController {
	
	private final DataloggerService dataloggerService;
	
	@GetMapping
	public Collection<DataloggerBasicInfo> findAll() {
		return dataloggerService.findAll();
	}
	
	@GetMapping(ID_URI + SEÑALES_URI)
	public DataloggerInfo findSeñalesDataloggerById(@PathVariable Integer id) {
		return dataloggerService.findSeñalesAndDataloggerById(id);
	}
	
	@PostMapping
	public void createDatalogger(@RequestBody CreateDataloggerInfo dto) {
		dataloggerService.create(dto);
	}
	
	@PutMapping(ID_URI)
	public void update(@PathVariable Integer id, @RequestBody DataloggerBasicInfo dto) {
		dataloggerService.update(dto, id);
	}
	
	@DeleteMapping(ID_URI)
	public void delete(@PathVariable Integer id) {
		dataloggerService.deleteById(id);
	}

}
