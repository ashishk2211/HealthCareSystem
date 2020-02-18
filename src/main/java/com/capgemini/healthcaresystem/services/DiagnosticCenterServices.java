package com.capgemini.healthcaresystem.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.capgemini.healthcaresystem.dao.DiagnosticCenterDao;
import com.capgemini.healthcaresystem.dto.DiagnosticCenter;
import com.capgemini.healthcaresystem.exception.DiagnosticCenterException;


public class DiagnosticCenterServices {
	
	public boolean addDiagnosticCenter(DiagnosticCenter center) throws DiagnosticCenterException
	{
		if(new ValidateDiagnosticCenterServices().validateCenterId(center.getCenterId()))
			if(new ValidateDiagnosticCenterServices().validateCenterName(center.getCenterName()))
			{
				boolean result=new DiagnosticCenterDao().addCenter(center);
				
				if(result){
					return true;
				}
			throw new DiagnosticCenterException("Center name cannot be null");
		}
		throw new DiagnosticCenterException("Center Id cannot be null");
	}

	
	public boolean removeDiagnosticCenter(String centerId) 
	{
		if(new DiagnosticCenterDao().removeCenter(centerId))
			return true;
		else
			return false;
	}
	
	public List<DiagnosticCenter> displayList(String centerId) throws DiagnosticCenterException
	{
		List<DiagnosticCenter> centerList=new ArrayList<DiagnosticCenter>();
		
		if(centerList.add(new DiagnosticCenterDao().displayDiagnosticCenter(centerId)))
			return centerList;
		else
			throw new DiagnosticCenterException("CenterId not present");		
	}

}
