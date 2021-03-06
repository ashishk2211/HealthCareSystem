package com.capgemini.healthcaresystem.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.capgemini.healthcaresystem.dao.DiagnosticCenterDaoImplementation;
import com.capgemini.healthcaresystem.dto.DiagnosticCenter;
import com.capgemini.healthcaresystem.dto.DiagnosticTest;
import com.capgemini.healthcaresystem.exception.DiagnosticCenterException;
import com.capgemini.healthcaresystem.util.DiagnosticCenterDB;


public class DiagnosticCenterServicesImplementation implements DiagnosticCenterServices{
	
		
	public boolean addDiagnosticCenter(DiagnosticCenter center) throws DiagnosticCenterException
		{
		if(new ValidateDiagnosticCenterServices().validateCenterId(center.getCenterId()))
		{
			if(new ValidateDiagnosticCenterServices().ValidateCenterIsPresent(center.getCenterId()))
			{
				if(new ValidateDiagnosticCenterServices().validateCenterName(center.getCenterName()))
				{
					if(new ValidateDiagnosticCenterServices().validateTest(center.getListOfTests()))
					{
						boolean result=new DiagnosticCenterDaoImplementation().addCenter(center);
						if(result){ 
							return true;
						}
					}
					throw new DiagnosticCenterException("Test cannot be null");
				}
				throw new DiagnosticCenterException("Center name cannot be null");
			}
			throw new DiagnosticCenterException("CenterId already present");
		}
		throw new DiagnosticCenterException("Center Id cannot be null");
	}

	


	
	public boolean removeDiagnosticCenter(String centerId) throws DiagnosticCenterException 
	{
		if(new DiagnosticCenterDaoImplementation().removeCenter(centerId))
			return true;
		else
			throw new DiagnosticCenterException("Center Id not present");
	}
	
	public DiagnosticCenter displayList(String centerId) throws DiagnosticCenterException
	{
		try {
			return new DiagnosticCenterDaoImplementation().displayDiagnosticCenter(centerId);
			}
		catch(DiagnosticCenterException e)
		{
			throw new DiagnosticCenterException("CenterId not present");	
		}
				
	}
	public Map<String,DiagnosticCenter> returnRepositeryServices()
	{
		return new DiagnosticCenterDaoImplementation().returnRepositery();
	}
	public List<DiagnosticTest> returnTestRepositeryServices()
	{
		return new DiagnosticCenterDaoImplementation().returnTestRepositery();
	}
	
	
}
