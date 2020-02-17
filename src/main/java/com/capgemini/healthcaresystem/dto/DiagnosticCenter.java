package com.capgemini.healthcaresystem.dto;

import java.util.*;

public class DiagnosticCenter {
	private String centerName,centerId;
	private List<Test> ListOfTests=new ArrayList();
	
	public DiagnosticCenter(String centerName, String centerId, List<Test> listOfTests) {
		super();
		this.centerName = centerName;
		this.centerId = centerId;
		this.ListOfTests = listOfTests;
	}

	public String getCenterName() {
		return centerName;
	}
	public void setCenterName(String centerName) {
		this.centerName = centerName;
	}
	public String getCenterId() {
		return centerId;
	}
	public void setCenterId(String centerId) {
		this.centerId = centerId;
	}
	public List<Test> getListOfTests() {
		return ListOfTests;
	}
	public void setListOfTests(List<Test> listOfTests) {
		ListOfTests = listOfTests;
	}
	

	
}
