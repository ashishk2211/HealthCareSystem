package com.capgemini.healthcaresystem.dao;
import java.util.List;

import  com.capgemini.healthcaresystem.dto.DiagnosticTest;
public class ValidateDiagnosticCenterDao {
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
	boolean validateTest(List<DiagnosticTest> test)
	{
		if(test.size()==3)
			return true;
		else
			return false;
	}

}
