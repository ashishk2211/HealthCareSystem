package com.capgemini.healthcaresystem.services;

import java.util.List;

import com.capgemini.healthcaresystem.dto.Test;

public class ValidateDiagnosticCenterServices {
	
	boolean validateCenterName(String centerName)
	{
		if(centerName.length()==0)
			return false;
		else 
			return true;
	}
	
	boolean validateCenterId(String centerId)
	{
		if(centerId.length()==0)
			return false;
		else 
			return true;
	}
	
	boolean validateTest(List<Test> test)
	{
		if(test.size()==3)
			return true;
		else
			return false;
	}
}
