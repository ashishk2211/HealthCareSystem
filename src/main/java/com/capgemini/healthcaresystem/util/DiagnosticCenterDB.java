package com.capgemini.healthcaresystem.util;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.healthcaresystem.dto.DiagnosticCenter;
import com.capgemini.healthcaresystem.dto.Test;
import com.capgemini.healthcaresystem.util.DiagnosticCenterRepositery;
import com.capgemini.healthcaresystem.util.TestRepositery;

public class DiagnosticCenterDB {
    static int randomDiagnosticCenterId=1000;


    
    public DiagnosticCenterDB() {

            Test testobj1=new Test("101","Blood Group");
            Test testobj2=new Test("102","Blood Sugar");
            Test testobj3=new Test("103","Blood Pressure");
            new TestRepositery().putTest(testobj1);
            new TestRepositery().putTest(testobj2);
            new TestRepositery().putTest(testobj3);
                   
            DiagnosticCenter object1=new DiagnosticCenter("AIIMS",generateDiagnosticCenterId(),new TestRepositery().getTestRepositery());
            DiagnosticCenter object2=new DiagnosticCenter("MAX",generateDiagnosticCenterId(),new TestRepositery().getTestRepositery());
            DiagnosticCenter object3=new DiagnosticCenter("Apolo",generateDiagnosticCenterId(), new TestRepositery().getTestRepositery());
            DiagnosticCenter object4=new DiagnosticCenter("Fortis",generateDiagnosticCenterId(),new TestRepositery().getTestRepositery());
            DiagnosticCenter object5=new DiagnosticCenter("Trauma Center",generateDiagnosticCenterId(),new TestRepositery().getTestRepositery());
            new DiagnosticCenterRepositery().putDiagnosticCenter(object1);
            new DiagnosticCenterRepositery().putDiagnosticCenter(object2);
            new DiagnosticCenterRepositery().putDiagnosticCenter(object3);
            new DiagnosticCenterRepositery().putDiagnosticCenter(object4);
            new DiagnosticCenterRepositery().putDiagnosticCenter(object5);
    }
    
  
   
   //method to randomly generate Diagnostic centerId.
public String generateDiagnosticCenterId() {
   
        randomDiagnosticCenterId+=1;
        return Integer.toString(randomDiagnosticCenterId);
}

}
