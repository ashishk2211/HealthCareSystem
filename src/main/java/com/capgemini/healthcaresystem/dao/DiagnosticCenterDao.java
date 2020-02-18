package com.capgemini.healthcaresystem.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.capgemini.healthcaresystem.dto.DiagnosticCenter;
import com.capgemini.healthcaresystem.exception.DiagnosticCenterException;
import com.capgemini.healthcaresystem.util.DiagnosticCenterDB;


public class DiagnosticCenterDao {
	
	public boolean addCenter(DiagnosticCenter center) throws DiagnosticCenterException
	{	
		if(new ValidateDiagnosticCenterDao().validateCenterName(center.getCenterName()))
		{
			if(new ValidateDiagnosticCenterDao().validateCenterId(center.getCenterId()))
			{
				if(new ValidateDiagnosticCenterDao().validateTest(center.getListOfTests()))
				{
					DiagnosticCenterDB.getDiagnosticMap().put(center.getCenterId(),center);
					if(DiagnosticCenterDB.getDiagnosticMap().containsKey(center.getCenterId()))
						return true;
				}
			throw new DiagnosticCenterException("Test cannot be null");
	}
			 throw new DiagnosticCenterException("Center Id cannot be null");
	}
		throw new DiagnosticCenterException("Center name cannot be null");
	}
	
	public DiagnosticCenter displayDiagnosticCenter(String centerId) throws DiagnosticCenterException
	{
		Map<String,DiagnosticCenter> centerMap=new HashMap<String,DiagnosticCenter>();
		centerMap=DiagnosticCenterDB.getDiagnosticMap();
			if(centerMap.containsKey(centerId))
				return centerMap.get(centerId);
		 throw new DiagnosticCenterException("CenterId not present");
	}
	

	public boolean removeCenter(String centerId)
	{
   
		Map<String,DiagnosticCenter> map=new HashMap<String,DiagnosticCenter>();
		map=DiagnosticCenterDB.getDiagnosticMap();
		if(map.containsKey(centerId))
		{
			map.remove(centerId);
			return true;
		}
		else
		return false;
		
	}

}
