package com.capgemini.healthcaresystem.test.services;


import com.capgemini.healthcaresystem.dao.DiagnosticCenterDao;
import com.capgemini.healthcaresystem.dto.DiagnosticCenter;
import com.capgemini.healthcaresystem.dto.DiagnosticTest;
import com.capgemini.healthcaresystem.exception.DiagnosticCenterException;
import com.capgemini.healthcaresystem.services.DiagnosticCenterServices;
import com.capgemini.healthcaresystem.util.DiagnosticCenterDB;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;
public class TestDiagnosticCenterServices {
	
	@Test
	void addDiagnosticCenterTest() throws DiagnosticCenterException
	{
		new DiagnosticCenterDB();
		List<DiagnosticTest> testList=new ArrayList<DiagnosticTest>();
		testList.add(new DiagnosticTest("101","Blood Test"));
		testList.add(new DiagnosticTest("102","Blood Sugar"));
		testList.add(new DiagnosticTest("103","Blood Pressure"));
		DiagnosticCenter center=new DiagnosticCenter("1006","AIIMS",testList);
		DiagnosticCenter center2=new DiagnosticCenter(" ","AIIMS",testList);
		DiagnosticCenter center3=new DiagnosticCenter("1007"," ",testList);
		
		assertEquals(true,new DiagnosticCenterServices().addDiagnosticCenter(center));	
		assertEquals(false,new DiagnosticCenterServices().addDiagnosticCenter(center2));
		assertEquals(false,new DiagnosticCenterServices().addDiagnosticCenter(center2));
		assertThrows(DiagnosticCenterException.class,()->{new DiagnosticCenterServices().addDiagnosticCenter(center3);});
	}
	
	@Test
	void removeDiagnosticCenterServices()
	{
		new DiagnosticCenterDB();
		String centerId="1001";
		String centerId2="101";
		assertEquals(true,new DiagnosticCenterServices().removeDiagnosticCenter(centerId));
		assertEquals(false,new DiagnosticCenterDao().removeCenter(centerId2));				
	}
	
	@Test
	void displayDiagnosticCenterTest() throws DiagnosticCenterException
	{
		new DiagnosticCenterDB();
		String id="1001";
		String id2="1007";
		List<DiagnosticCenter> list=new ArrayList<DiagnosticCenter>();
		assertEquals(list,new DiagnosticCenterServices().displayList(id));
		assertThrows(DiagnosticCenterException.class,()->{new DiagnosticCenterServices().displayList(id2);});
	}

}
