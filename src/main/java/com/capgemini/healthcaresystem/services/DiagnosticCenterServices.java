package com.capgemini.healthcaresystem.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.capgemini.healthcaresystem.dao.DiagnosticCenterDao;
import com.capgemini.healthcaresystem.dto.DiagnosticCenter;
import com.capgemini.healthcaresystem.dto.DiagnosticTest;
import com.capgemini.healthcaresystem.exception.DiagnosticCenterException;
import com.capgemini.healthcaresystem.util.DiagnosticCenterDB;


public class DiagnosticCenterServices {
	
	public boolean addDiagnosticCenter(DiagnosticCenter center) throws DiagnosticCenterException
	{
		if(new ValidateDiagnosticCenterServices().validateCenterId(center.getCenterId()))
		{
			if(new ValidateDiagnosticCenterServices().validateCenterName(center.getCenterName()))
			{
				if(new ValidateDiagnosticCenterServices().validateTest(center.getListOfTests()))
				{
				boolean result=new DiagnosticCenterDao().addCenter(center);
				if(result){
					return true;
				}

		}
				throw new DiagnosticCenterException("Test cannot be null");
			}
		throw new DiagnosticCenterException("Center Id cannot be null");
		}
		throw new DiagnosticCenterException("Center name cannot be null");
	}

	
	public boolean removeDiagnosticCenter(String centerId) 
	{
		if(new DiagnosticCenterDao().removeCenter(centerId))
			return true;
		else
			return false;
	}
	
	public DiagnosticCenter displayList(String centerId) throws DiagnosticCenterException
	{
		try {
			return new DiagnosticCenterDao().displayDiagnosticCenter(centerId);
			}
		catch(DiagnosticCenterException e)
		{
			throw new DiagnosticCenterException("CenterId not present");	
		}
				
	}
	public Map<String,DiagnosticCenter> returnRepositeryServices()
	{
		return new DiagnosticCenterDao().returnRepositery();
	}
	public List<DiagnosticTest> returnTestRepositeryServices()
	{
		return new DiagnosticCenterDao().returnTestRepositery();
	}

}
