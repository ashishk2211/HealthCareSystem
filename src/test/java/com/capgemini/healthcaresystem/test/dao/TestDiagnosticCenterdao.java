package com.capgemini.healthcaresystem.test.dao;

import com.capgemini.healthcaresystem.dao.DiagnosticCenterDao;
import com.capgemini.healthcaresystem.dto.DiagnosticCenter;
import com.capgemini.healthcaresystem.dto.DiagnosticTest;
import com.capgemini.healthcaresystem.exception.DiagnosticCenterException;
import com.capgemini.healthcaresystem.services.DiagnosticCenterServices;
import com.capgemini.healthcaresystem.util.DiagnosticCenterDB;


import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

public class TestDiagnosticCenterdao {
		@Test
		void DiagnosticCenterAddTest() {
			
			List<DiagnosticTest> testList=new ArrayList<DiagnosticTest>();
			testList.add(new DiagnosticTest("101","Blood Test"));
			testList.add(new DiagnosticTest("102","Blood Sugar"));
			testList.add(new DiagnosticTest("103","Blood Pressure"));
			//assertTrue();
			assertEquals(true,new DiagnosticCenterDao().addCenter(new DiagnosticCenter("1006","AIIMS",testList)));
			assertEquals(false,new DiagnosticCenterDao().addCenter(new DiagnosticCenter(" ","AIIMS",testList)));
		}
		
		
		@Test
	 	void removeCenterTest()
		{
			new DiagnosticCenterDB();
			String centerId="1001";
			String centerId2="101";
			assertEquals(true,new DiagnosticCenterDao().removeCenter(centerId));
			assertEquals(false,new DiagnosticCenterDao().removeCenter(centerId2));	
			
		}
		@Test
		void displayDiagnosticCenterTest() throws DiagnosticCenterException
		{
			new DiagnosticCenterDB();
			String id="1001";
			String id2="1007";
			DiagnosticCenter obj=new DiagnosticCenter("AIIMS","1001",DiagnosticCenterDB.getTestRepositery());
			//List<DiagnosticCenter> list=new ArrayList<DiagnosticCenter>();
			assertEquals(obj,new DiagnosticCenterDao().displayDiagnosticCenter(id));
			assertThrows(DiagnosticCenterException.class,()->{new DiagnosticCenterServices().displayList(id2);});
		}


}
