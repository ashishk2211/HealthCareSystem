package com.capgemini.healthcaresystem.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.capgemini.healthcaresystem.dto.DiagnosticCenter;
import com.capgemini.healthcaresystem.exception.DiagnosticCenterException;
import com.capgemini.healthcaresystem.util.DiagnosticCenterDB;
import com.capgemini.healthcaresystem.util.DiagnosticCenterRepositery;

public class DiagnosticCenterDao {
	
	public boolean addCenter(DiagnosticCenter center)
	{	
		boolean result=DiagnosticCenterDB.getDiagnosticMap().put(center.getCenterId(),center)==null;
				if(result)
				return true;
		else
			return false;
	
	}
	
	public DiagnosticCenter displayDiagnosticCenter(String centerId) throws DiagnosticCenterException
	{
		Map<String,DiagnosticCenter> centerMap=new HashMap<String,DiagnosticCenter>();
		centerMap=DiagnosticCenterDB.getDiagnosticMap();
		 for (Map.Entry<String,DiagnosticCenter> entry : centerMap.entrySet())
		 {
			 if(entry.getKey().equals(centerId));
			 	return entry.getValue();
		 }
		 throw new DiagnosticCenterException("CenterId not present");
	}
	

	public boolean removeCenter(String centerId)
	{
   
		Map<String,DiagnosticCenter> map=new HashMap<String,DiagnosticCenter>();
		map=DiagnosticCenterDB.getDiagnosticMap();
		for(Map.Entry<String,DiagnosticCenter> entry: map.entrySet())
		{
			if(entry.getKey().equals(centerId))
			{
				map.remove(entry.getKey(),entry.getValue());
				return true;
			}
		}
		return false;
		
	}

}
