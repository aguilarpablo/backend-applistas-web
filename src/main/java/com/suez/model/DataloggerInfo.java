package com.suez.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DataloggerInfo extends DataloggerBasicInfo {
	
	private List<SeñalInfo> señales;
	
	private ExplotacionInfo explotacion;
	
}
