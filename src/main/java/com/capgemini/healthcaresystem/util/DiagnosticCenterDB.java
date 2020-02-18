package com.capgemini.healthcaresystem.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.capgemini.healthcaresystem.dto.DiagnosticCenter;
import com.capgemini.healthcaresystem.dto.DiagnosticTest;


public class DiagnosticCenterDB {
    static int randomDiagnosticCenterId=1000;

	static Map<String,DiagnosticCenter> diagnosticMap=new HashMap<String,DiagnosticCenter>();
	
	public static Map<String, DiagnosticCenter> getDiagnosticMap() {
		return diagnosticMap;
	}	
	static List<DiagnosticTest> testRepositery=new ArrayList<DiagnosticTest>();

	public static List<DiagnosticTest> getTestRepositery()
	{
		return testRepositery;
	}
    
    public DiagnosticCenterDB() {
    	
    
    	

            DiagnosticTest testobj1=new DiagnosticTest("101","Blood Group");
            DiagnosticTest testobj2=new DiagnosticTest("102","Blood Sugar");
            DiagnosticTest testobj3=new DiagnosticTest("103","Blood Pressure");
            
            getTestRepositery().add(testobj1);
            getTestRepositery().add(testobj2);
            getTestRepositery().add(testobj3);
            
                   
            DiagnosticCenter object1=new DiagnosticCenter("AIIMS",generateDiagnosticCenterId(),getTestRepositery());
            DiagnosticCenter object2=new DiagnosticCenter("MAX",generateDiagnosticCenterId(),getTestRepositery());
            DiagnosticCenter object3=new DiagnosticCenter("Apolo",generateDiagnosticCenterId(),getTestRepositery());
            DiagnosticCenter object4=new DiagnosticCenter("Fortis",generateDiagnosticCenterId(),getTestRepositery());
            DiagnosticCenter object5=new DiagnosticCenter("Trauma Center",generateDiagnosticCenterId(),getTestRepositery());
            
      
            
            getDiagnosticMap().put(object1.getCenterId(),object1);
            getDiagnosticMap().put(object2.getCenterId(),object2);
            getDiagnosticMap().put(object3.getCenterId(),object3);
            getDiagnosticMap().put(object4.getCenterId(),object4);
            getDiagnosticMap().put(object5.getCenterId(),object5);
        
            
            
    }
    
  
   
   //method to randomly generate Diagnostic centerId.
public String generateDiagnosticCenterId() {
   
        randomDiagnosticCenterId+=1;
        return Integer.toString(randomDiagnosticCenterId);
}

}
