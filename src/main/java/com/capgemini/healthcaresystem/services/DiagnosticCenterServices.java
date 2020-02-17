package com.capgemini.healthcaresystem.services;

import java.util.HashMap;
import java.util.Map;

import com.capgemini.healthcaresystem.dao.DiagnosticCenterDao;
import com.capgemini.healthcaresystem.dto.DiagnosticCenter;
import com.capgemini.healthcaresystem.util.DiagnosticCenterRepositery;

public class DiagnosticCenterServices {
	
	public boolean addDiagnosticCenter(DiagnosticCenter center)
	{
		if(new ValidateDiagnosticCenterServices().validateCenterId(center.getCenterId()))
		{
			if(new ValidateDiagnosticCenterServices().validateCenterName(center.getCenterName()))
			{
				if(new DiagnosticCenterDao().addCenter(center))
				{
					return true;
				}
			}
			return false;
		}
		return false;
	}
	public boolean searchDiagnosticCenter(String centerId)
	{
		if(new DiagnosticCenterDao().searchDiagnosticCenter(centerId))
		{
			return true;
		}
		else 
			return false;
					
	}
	
	public boolean removeDiagnosticCenter(String centerId)
	{
		if(new DiagnosticCenterDao().removeCenter(centerId))
			return true;
		else
			return false;
	}

}
