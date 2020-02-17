package com.capgemini.healthcaresystem.util;

import  com.capgemini.healthcaresystem.dto.Test;

import java.util.ArrayList;
import java.util.List;

public class TestRepositery {
	
	static List<Test> testRepositery=new ArrayList<Test>();

	public static List<Test> getTestRepositery()
	{
		return testRepositery;
	}

	public void putTest(Test obj)
	{
		testRepositery.add(obj);
	}	
}
