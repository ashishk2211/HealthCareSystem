package com.capgemini.healthcaresystem.ui;

import java.util.Scanner;

import com.capgemini.healthcaresystem.dto.DiagnosticCenter;
import com.capgemini.healthcaresystem.exception.DiagnosticCenterException;
import com.capgemini.healthcaresystem.services.DiagnosticCenterServices;
import com.capgemini.healthcaresystem.util.DiagnosticCenterDB;
import com.capgemini.healthcaresystem.util.TestRepositery;

public class UserInterface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new DiagnosticCenterDB();
		Scanner sc=new Scanner(System.in);
		System.out.println("Press 1 to Add Diagnostic Center");
		System.out.println("Press 2 to Remove Diagnostic Center");
		int choice=sc.nextInt();
		switch(choice)
		{
		case 1: System.out.println("Enter the Center Id");
				String	centerId=sc.next();
				System.out.println("Enter the Center Name");
				String	centerName=sc.next();
				try {
				if(new DiagnosticCenterServices().addDiagnosticCenter(new DiagnosticCenter(centerId,centerName,
						new TestRepositery().getTestRepositery())))
				{
					System.out.println("DiagnosticCenter Added Succescfully");
				}
				else {
					throw new DiagnosticCenterException("Task couldn't be completed");
				}
				}
				
				catch(DiagnosticCenterException e)
				{
					e.getMessage();
				}
				break;
			
		case 2: System.out.println("Enter centerId to remove:");
				String id=sc.next();
				try {
				if(new DiagnosticCenterServices().removeDiagnosticCenter(id))
					System.out.println("Deletion successfull");
				else
					throw new DiagnosticCenterException("No such id present");
				}
				catch(DiagnosticCenterException e)
				{
					e.getMessage();
				}
				break;
				
		default: System.out.println("Invalid input");
				break;
			
		}
		
		

	}

}
