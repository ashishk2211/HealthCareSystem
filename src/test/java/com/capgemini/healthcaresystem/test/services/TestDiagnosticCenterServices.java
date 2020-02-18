package com.capgemini.healthcaresystem.test.services;


import com.capgemini.healthcaresystem.dao.DiagnosticCenterDao;
import com.capgemini.healthcaresystem.dto.DiagnosticCenter;
import com.capgemini.healthcaresystem.dto.DiagnosticTest;
import com.capgemini.healthcaresystem.exception.DiagnosticCenterException;
import com.capgemini.healthcaresystem.services.DiagnosticCenterServices;
import com.capgemini.healthcaresystem.util.DiagnosticCenterDB;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;
public class TestDiagnosticCenterServices {
	
	@BeforeEach
	void callDB()
	{
	new DiagnosticCenterDB();
	}
	@Test
	void addDiagnosticCenterTest() throws DiagnosticCenterException
	{
		//new DiagnosticCenterDB();
		List<DiagnosticTest> testList=new ArrayList<DiagnosticTest>();
		List<DiagnosticTest> testList2=new ArrayList<DiagnosticTest>();
		testList.add(new DiagnosticTest("101","Blood Test"));
		testList.add(new DiagnosticTest("102","Blood Sugar"));
		testList.add(new DiagnosticTest("103","Blood Pressure"));
		
		DiagnosticCenter center1=new DiagnosticCenter("AIIMS","1006",testList);
		DiagnosticCenter center2=new DiagnosticCenter("","1009",testList);
		DiagnosticCenter center3=new DiagnosticCenter("Max","",testList);
		DiagnosticCenter center4=new DiagnosticCenter("Max","1002",testList2);
		assertEquals(true,new DiagnosticCenterServices().addDiagnosticCenter(center1));
		assertThrows(DiagnosticCenterException.class,()->{new DiagnosticCenterServices().addDiagnosticCenter(center3);});
		assertThrows(DiagnosticCenterException.class,()->{new DiagnosticCenterServices().addDiagnosticCenter(center2);});
		assertThrows(DiagnosticCenterException.class,()->{new DiagnosticCenterServices().addDiagnosticCenter(center4);});	
		
	}
	
	@Test
	void removeDiagnosticCenterServices()
	{

		String centerId1="1005";
		String centerId2="101";
		
		assertEquals(true,new DiagnosticCenterServices().removeDiagnosticCenter(centerId1));
		assertEquals(false,new DiagnosticCenterServices().removeDiagnosticCenter(centerId2));
		
	}

}
