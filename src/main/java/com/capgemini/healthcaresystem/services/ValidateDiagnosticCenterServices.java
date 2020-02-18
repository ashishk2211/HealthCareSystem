package com.capgemini.healthcaresystem.services;

import java.util.List;

import com.capgemini.healthcaresystem.dto.DiagnosticTest;

public class ValidateDiagnosticCenterServices {
	
	boolean validateCenterName(String centerName)
	{
		if(centerName.isEmpty())
			return false;
		else 
			return true;
	}
	
	boolean validateCenterId(String centerId)
	{
		if(centerId.isEmpty())
			return false;
		else 
			return true;
	}
	
	boolean validateTest(List<DiagnosticTest> test)
	{
		if(test.size()==3)
			return true;
		else
			return false;
	}
}
