package com.capgemini.healthcaresystem.dto;

import java.util.*;

public class DiagnosticCenter {
	private String centerName,centerId;
	private List<DiagnosticTest> ListOfTests=new ArrayList();
	
	public DiagnosticCenter(String centerName, String centerId, List<DiagnosticTest> listOfTests) {
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
	public List<DiagnosticTest> getListOfTests() {
		return ListOfTests;
	}
	public void setListOfTests(List<DiagnosticTest> listOfTests) {
		ListOfTests = listOfTests;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ListOfTests == null) ? 0 : ListOfTests.hashCode());
		result = prime * result + ((centerId == null) ? 0 : centerId.hashCode());
		result = prime * result + ((centerName == null) ? 0 : centerName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DiagnosticCenter other = (DiagnosticCenter) obj;
		if (ListOfTests == null) {
			if (other.ListOfTests != null)
				return false;
		} else if (!ListOfTests.equals(other.ListOfTests))
			return false;
		if (centerId == null) {
			if (other.centerId != null)
				return false;
		} else if (!centerId.equals(other.centerId))
			return false;
		if (centerName == null) {
			if (other.centerName != null)
				return false;
		} else if (!centerName.equals(other.centerName))
			return false;
		return true;
	}
	

	
}
