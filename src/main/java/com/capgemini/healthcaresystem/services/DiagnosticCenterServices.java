package com.capgemini.healthcaresystem.services;

import java.util.List;
import java.util.Map;

import com.capgemini.healthcaresystem.dto.DiagnosticCenter;
import com.capgemini.healthcaresystem.dto.DiagnosticTest;
import com.capgemini.healthcaresystem.exception.DiagnosticCenterException;

public interface DiagnosticCenterServices {
	
	public boolean addDiagnosticCenter(DiagnosticCenter center) throws DiagnosticCenterException;
	
	public boolean removeDiagnosticCenter(String centerId) throws DiagnosticCenterException;
	
	public DiagnosticCenter displayList(String centerId) throws DiagnosticCenterException;
	
	public Map<String,DiagnosticCenter> returnRepositeryServices();
	
	public List<DiagnosticTest> returnTestRepositeryServices();

}
