package com.suez.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EstacionInfo extends EstacionBasicInfo {

	private List<SeñalInfo> señales;
	
	private ExplotacionInfo explotacion;
	
}
