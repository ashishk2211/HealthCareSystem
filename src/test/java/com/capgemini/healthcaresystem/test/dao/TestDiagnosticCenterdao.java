package com.capgemini.healthcaresystem.test.dao;

import com.capgemini.healthcaresystem.dao.DiagnosticCenterDaoImplementation;
import com.capgemini.healthcaresystem.dto.DiagnosticCenter;
import com.capgemini.healthcaresystem.dto.DiagnosticTest;
import com.capgemini.healthcaresystem.exception.DiagnosticCenterException;
import com.capgemini.healthcaresystem.services.DiagnosticCenterServicesImplementation;
import com.capgemini.healthcaresystem.util.DiagnosticCenterDB;


import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

public class TestDiagnosticCenterdao {
	
		@Test
		void DiagnosticCenterAddTest() throws DiagnosticCenterException {
			
			List<DiagnosticTest> testList=new ArrayList<DiagnosticTest>();
			testList.add(new DiagnosticTest("101","Blood Test"));
			testList.add(new DiagnosticTest("102","Blood Sugar"));
			testList.add(new DiagnosticTest("103","Blood Pressure"));
			
			assertEquals(true,new DiagnosticCenterDaoImplementation().addCenter(new DiagnosticCenter("AIIMS","1007",testList)));
			assertEquals(false,new DiagnosticCenterDaoImplementation().addCenter(new DiagnosticCenter("","AIIMS",testList)));
			assertEquals(false,new DiagnosticCenterDaoImplementation().addCenter(new DiagnosticCenter("Max","",testList)));
			assertEquals(false,new DiagnosticCenterDaoImplementation().addCenter(new DiagnosticCenter("Max","",null)));
		}
		
		
		@Test
	 	void removeCenterTest()
		{
			new DiagnosticCenterDB();
			String centerId="1001";
			String centerId2="101";
			assertEquals(true,new DiagnosticCenterDaoImplementation().removeCenter(centerId));
			assertEquals(false,new DiagnosticCenterDaoImplementation().removeCenter(centerId2));	
			
		}
		@Test
		void displayDiagnosticCenterTest() throws DiagnosticCenterException 
		{
			DiagnosticCenter obj=new DiagnosticCenter("AIIMS","1001",new DiagnosticCenterDaoImplementation().returnTestRepositery());
			String id1="1001";
			String id2="101";
			try {
			assertTrue(obj.equals(new DiagnosticCenterDaoImplementation().displayDiagnosticCenter(id1)));
			}
			catch(DiagnosticCenterException e)
			{
				
			}
			assertThrows(DiagnosticCenterException.class,()->{new DiagnosticCenterDaoImplementation().displayDiagnosticCenter(id2);});
		
		}
}