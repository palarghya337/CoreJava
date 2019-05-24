package com.corejava.practice.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.corejava.practice.beans.Employee;
import com.corejava.practice.utils.Log;

public class SortByMultipleFields {

	private static final String NAME_A = "Arghya";
	private static final String NAME_J = "Jony";
	private static final String NAME_N = "Nuton";
	private static final String NAME_Z = "Zakir";
	private static final String PROJECT_A = "Project-A";
	private static final String PROJECT_J = "Project-J";
	private static final String PROJECT_N = "Project-N";
	private static final String PROJECT_Z = "Project-Z";
	private static final String TEAM_A = "Team-A";
	private static final String TEAM_J = "Team-J";
	private static final String TEAM_N = "Team-N";
	private static final String TEAM_Z = "Team-Z";
	private static final String DESIGNATION = "Software Engineer";
	
	public static void main(String[] args) {
		
		List<Employee> listOfEmployee = new ArrayList<>();
		populateProjectZ(listOfEmployee);
		populateProjectA(listOfEmployee);
		populateProjectN(listOfEmployee);
		populateProjectJ(listOfEmployee);
		
		Collections.sort(listOfEmployee);
		Log.logInfo(">>>Sorted by Department, Team and Name<<<");
		listOfEmployee.stream().forEach(emp -> Log.logInfo(emp.toString()));
		Log.logInfo("List Size: {0}", String.valueOf(listOfEmployee.size()));
	}

	private static void populateProjectZ(List<Employee> listOfEmployee) {
		listOfEmployee.add(new Employee(22100, NAME_Z, PROJECT_Z, TEAM_Z, DESIGNATION));
		listOfEmployee.add(new Employee(22101, NAME_A, PROJECT_Z, TEAM_Z, DESIGNATION));
		listOfEmployee.add(new Employee(22102, NAME_N, PROJECT_Z, TEAM_Z, DESIGNATION));
		listOfEmployee.add(new Employee(22103, NAME_J, PROJECT_Z, TEAM_Z, DESIGNATION));
		
		listOfEmployee.add(new Employee(22104, NAME_Z, PROJECT_Z, TEAM_A, DESIGNATION));
		listOfEmployee.add(new Employee(22105, NAME_A, PROJECT_Z, TEAM_A, DESIGNATION));
		listOfEmployee.add(new Employee(22106, NAME_N, PROJECT_Z, TEAM_A, DESIGNATION));
		listOfEmployee.add(new Employee(22107, NAME_J, PROJECT_Z, TEAM_A, DESIGNATION));
		
		listOfEmployee.add(new Employee(22108, NAME_Z, PROJECT_Z, TEAM_N, DESIGNATION));
		listOfEmployee.add(new Employee(22109, NAME_A, PROJECT_Z, TEAM_N, DESIGNATION));
		listOfEmployee.add(new Employee(22110, NAME_N, PROJECT_Z, TEAM_N, DESIGNATION));
		listOfEmployee.add(new Employee(22111, NAME_J, PROJECT_Z, TEAM_N, DESIGNATION));
		
		listOfEmployee.add(new Employee(22112, NAME_Z, PROJECT_Z, TEAM_J, DESIGNATION));
		listOfEmployee.add(new Employee(22113, NAME_A, PROJECT_Z, TEAM_J, DESIGNATION));
		listOfEmployee.add(new Employee(22114, NAME_N, PROJECT_Z, TEAM_J, DESIGNATION));
		listOfEmployee.add(new Employee(22115, NAME_J, PROJECT_Z, TEAM_J, DESIGNATION));
	}

	private static void populateProjectN(List<Employee> listOfEmployee) {
		
		listOfEmployee.add(new Employee(22116, NAME_Z, PROJECT_N, TEAM_Z, DESIGNATION));
		listOfEmployee.add(new Employee(22117, NAME_A, PROJECT_N, TEAM_Z, DESIGNATION));
		listOfEmployee.add(new Employee(22118, NAME_N, PROJECT_N, TEAM_Z, DESIGNATION));
		listOfEmployee.add(new Employee(22119, NAME_J, PROJECT_N, TEAM_Z, DESIGNATION));
		
		listOfEmployee.add(new Employee(22120, NAME_Z, PROJECT_N, TEAM_A, DESIGNATION));
		listOfEmployee.add(new Employee(22121, NAME_A, PROJECT_N, TEAM_A, DESIGNATION));
		listOfEmployee.add(new Employee(22122, NAME_N, PROJECT_N, TEAM_A, DESIGNATION));
		listOfEmployee.add(new Employee(22123, NAME_J, PROJECT_N, TEAM_A, DESIGNATION));
		
		listOfEmployee.add(new Employee(22124, NAME_Z, PROJECT_N, TEAM_N, DESIGNATION));
		listOfEmployee.add(new Employee(22125, NAME_A, PROJECT_N, TEAM_N, DESIGNATION));
		listOfEmployee.add(new Employee(22126, NAME_N, PROJECT_N, TEAM_N, DESIGNATION));
		listOfEmployee.add(new Employee(22127, NAME_J, PROJECT_N, TEAM_N, DESIGNATION));
		
		listOfEmployee.add(new Employee(22128, NAME_Z, PROJECT_N, TEAM_J, DESIGNATION));
		listOfEmployee.add(new Employee(22129, NAME_A, PROJECT_N, TEAM_J, DESIGNATION));
		listOfEmployee.add(new Employee(22130, NAME_N, PROJECT_N, TEAM_J, DESIGNATION));
		listOfEmployee.add(new Employee(22131, NAME_J, PROJECT_N, TEAM_J, DESIGNATION));
	}

	private static void populateProjectJ(List<Employee> listOfEmployee) {
		
		listOfEmployee.add(new Employee(22132, NAME_Z, PROJECT_J, TEAM_Z, DESIGNATION));
		listOfEmployee.add(new Employee(22133, NAME_A, PROJECT_J, TEAM_Z, DESIGNATION));
		listOfEmployee.add(new Employee(22134, NAME_N, PROJECT_J, TEAM_Z, DESIGNATION));
		listOfEmployee.add(new Employee(22135, NAME_J, PROJECT_J, TEAM_Z, DESIGNATION));
		
		listOfEmployee.add(new Employee(22136, NAME_Z, PROJECT_J, TEAM_A, DESIGNATION));
		listOfEmployee.add(new Employee(22137, NAME_A, PROJECT_J, TEAM_A, DESIGNATION));
		listOfEmployee.add(new Employee(22138, NAME_N, PROJECT_J, TEAM_A, DESIGNATION));
		listOfEmployee.add(new Employee(22139, NAME_J, PROJECT_J, TEAM_A, DESIGNATION));
		
		listOfEmployee.add(new Employee(22140, NAME_Z, PROJECT_J, TEAM_N, DESIGNATION));
		listOfEmployee.add(new Employee(22141, NAME_A, PROJECT_J, TEAM_N, DESIGNATION));
		listOfEmployee.add(new Employee(22142, NAME_N, PROJECT_J, TEAM_N, DESIGNATION));
		listOfEmployee.add(new Employee(22143, NAME_J, PROJECT_J, TEAM_N, DESIGNATION));
		
		listOfEmployee.add(new Employee(22144, NAME_Z, PROJECT_J, TEAM_J, DESIGNATION));
		listOfEmployee.add(new Employee(22145, NAME_A, PROJECT_J, TEAM_J, DESIGNATION));
		listOfEmployee.add(new Employee(22146, NAME_N, PROJECT_J, TEAM_J, DESIGNATION));
		listOfEmployee.add(new Employee(22147, NAME_J, PROJECT_J, TEAM_J, DESIGNATION));
	}

	private static void populateProjectA(List<Employee> listOfEmployee) {
		
		listOfEmployee.add(new Employee(22148, NAME_Z, PROJECT_A, TEAM_Z, DESIGNATION));
		listOfEmployee.add(new Employee(22149, NAME_A, PROJECT_A, TEAM_Z, DESIGNATION));
		listOfEmployee.add(new Employee(22150, NAME_N, PROJECT_A, TEAM_Z, DESIGNATION));
		listOfEmployee.add(new Employee(22151, NAME_J, PROJECT_A, TEAM_Z, DESIGNATION));
		
		listOfEmployee.add(new Employee(22152, NAME_Z, PROJECT_A, TEAM_A, DESIGNATION));
		listOfEmployee.add(new Employee(22153, NAME_A, PROJECT_A, TEAM_A, DESIGNATION));
		listOfEmployee.add(new Employee(22154, NAME_N, PROJECT_A, TEAM_A, DESIGNATION));
		listOfEmployee.add(new Employee(22155, NAME_J, PROJECT_A, TEAM_A, DESIGNATION));
		
		listOfEmployee.add(new Employee(22156, NAME_Z, PROJECT_A, TEAM_N, DESIGNATION));
		listOfEmployee.add(new Employee(22157, NAME_A, PROJECT_A, TEAM_N, DESIGNATION));
		listOfEmployee.add(new Employee(22158, NAME_N, PROJECT_A, TEAM_N, DESIGNATION));
		listOfEmployee.add(new Employee(22159, NAME_J, PROJECT_A, TEAM_N, DESIGNATION));
		
		listOfEmployee.add(new Employee(22160, NAME_Z, PROJECT_A, TEAM_J, DESIGNATION));
		listOfEmployee.add(new Employee(22161, NAME_A, PROJECT_A, TEAM_J, DESIGNATION));
		listOfEmployee.add(new Employee(22162, NAME_N, PROJECT_A, TEAM_J, DESIGNATION));
		listOfEmployee.add(new Employee(22163, NAME_J, PROJECT_A, TEAM_J, DESIGNATION));
	}
}
