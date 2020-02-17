package com.capgemini.healthcaresystem.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.capgemini.healthcaresystem.dto.DiagnosticCenter;
import com.capgemini.healthcaresystem.util.DiagnosticCenterRepositery;

public class DiagnosticCenterDao {
	
	public boolean addCenter(DiagnosticCenter center)
	{	if(new ValidateDiagnosticCenterDao().validateCenterId(center.getCenterId()))
		{	
			if(new ValidateDiagnosticCenterDao().validateCenterId(center.getCenterName()))
			{
				new DiagnosticCenterRepositery().putDiagnosticCenter(center);
			}
		else	
			return false;
	}
	return false;
	
	}
	public List<DiagnosticCenter> displayList()
	{
		List<DiagnosticCenter> centerList=new ArrayList<DiagnosticCenter>();
		Map<String,DiagnosticCenter> centerMap=new HashMap<String,DiagnosticCenter>();
		centerMap=new DiagnosticCenterRepositery().getDiagnosticMap();
		 for (Map.Entry<String,DiagnosticCenter> entry : centerMap.entrySet())
		 {
			 centerList.add(entry.getValue());
		 }
		 return centerList;	
	}
	
	public boolean searchDiagnosticCenter(String centerId)
	{
		Map<String,DiagnosticCenter> centerMap=new HashMap<String,DiagnosticCenter>();
		centerMap=new DiagnosticCenterRepositery().getDiagnosticMap();
		 for (Map.Entry<String,DiagnosticCenter> entry : centerMap.entrySet())
		 {
			 if(entry.getKey().equals(centerId));
			 	return true;
		 }
		 return false;
	}
	

	
	public boolean removeCenter(String centerId)
	{
		  Iterator<Map.Entry<String,DiagnosticCenter> > 
          iterator = new DiagnosticCenterRepositery().getDiagnosticMap().entrySet().iterator(); 
 
      while (iterator.hasNext()) { 

          Map.Entry<String,DiagnosticCenter>  entry  = iterator.next(); 

          if (centerId == entry.getKey()) { 

              iterator.remove(); 
              return true;
          } 
      } 
      return false;
	}

}
