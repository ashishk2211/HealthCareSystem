package com.capgemini.healthcaresystem.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.capgemini.healthcaresystem.dto.DiagnosticCenter;
import com.capgemini.healthcaresystem.dto.DiagnosticTest;
import com.capgemini.healthcaresystem.exception.DiagnosticCenterException;
import com.capgemini.healthcaresystem.services.DiagnosticCenterServices;
import com.capgemini.healthcaresystem.util.DiagnosticCenterDB;


public class UserInterface {
	DiagnosticCenterDB db=new DiagnosticCenterDB();
	void mainFunction() throws DiagnosticCenterException
	{
		
		Scanner sc=new Scanner(System.in);
		Scanner scint=new Scanner(System.in);
		
		System.out.println("Press 1 to Add Diagnostic Center");
		System.out.println("Press 2 to Remove Diagnostic Center");
		System.out.println("Press 3 to terminate the session");
		System.out.println("Press 4 to display the repositery");
		int choice=scint.nextInt();
		switch(choice)
		{
		case 1: System.out.println("Enter the Center Id");
				String	centerId=sc.nextLine();
				System.out.println("Enter the Center Name");
				String	centerName=sc.nextLine();
				try {
					if(new DiagnosticCenterServices().addDiagnosticCenter(new DiagnosticCenter(centerName,centerId,
							new DiagnosticCenterServices().returnTestRepositeryServices())))
					{
						System.out.println("DiagnosticCenter Added Succescfully");
					}
				}
				catch(DiagnosticCenterException e) {
					System.out.println(e.getMessage());
				}
				 
			
				mainFunction();
				break;
			
				
		case 2: System.out.println("Enter centerId to remove:");
				String id=sc.nextLine();
				try {
				DiagnosticCenter obj=new DiagnosticCenterServices().displayList(id);
				}
				catch(DiagnosticCenterException e) {
					System.out.println(e.getMessage());
				}
				System.out.println("Press 1 to delete the above Diagnostic Center");
				int enter=scint.nextInt();
				if(enter==1) {
					try {
				if(new DiagnosticCenterServices().removeDiagnosticCenter(id))
					System.out.println("Deletion successfull");
					}
					catch(DiagnosticCenterException e) {
						System.out.println(e.getMessage());
					}
				}
				mainFunction();
				break;
		
		case 3: System.out.println("Terminated");
				return;
		
		case 4: Map<String,DiagnosticCenter> map=new HashMap<String,DiagnosticCenter>();
				map=new DiagnosticCenterServices().returnRepositeryServices();
				for(Map.Entry<String,DiagnosticCenter> entry:map.entrySet())
				{
					System.out.println(entry.getKey()+" "+entry.getValue().getCenterName());

				}
				mainFunction();
				break;
		
		
				
		default: System.out.println("Invalid input");
					mainFunction();
					break;
			
		}
		
	}

	public static void main(String[] args) throws DiagnosticCenterException {
	
		new UserInterface().mainFunction();
		
}
}
