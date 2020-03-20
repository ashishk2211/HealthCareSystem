package com.capgemini.healthcaresystem.dao;

import java.util.List;
import java.util.Map;

import com.capgemini.healthcaresystem.dto.DiagnosticCenter;
import com.capgemini.healthcaresystem.dto.DiagnosticTest;
import com.capgemini.healthcaresystem.exception.DiagnosticCenterException;

public interface DiagnosticCenterDao {
	
	public boolean addCenter(DiagnosticCenter center);
	
	public DiagnosticCenter displayDiagnosticCenter(String centerId) throws DiagnosticCenterException;
	
	public Map<String,DiagnosticCenter> returnRepositery();
	
	public boolean removeCenter(String centerId);
	
	public List<DiagnosticTest> returnTestRepositery();

}
