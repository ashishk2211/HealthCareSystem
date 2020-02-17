package com.capgemini.healthcaresystem.util;

import java.util.HashMap;
import java.util.Map;

import com.capgemini.healthcaresystem.dto.DiagnosticCenter;

public class DiagnosticCenterRepositery {
	
	static Map<String,DiagnosticCenter> diagnosticMap=new HashMap<String,DiagnosticCenter>();

	public static Map<String, DiagnosticCenter> getDiagnosticMap() {
		return diagnosticMap;
	}

	public void putDiagnosticCenter(DiagnosticCenter obj)
	{
		diagnosticMap.put(obj.getCenterId(),obj);
	}
	
}
