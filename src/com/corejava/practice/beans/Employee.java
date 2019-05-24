package com.corejava.practice.beans;

/**
 * @author Bittu
 *
 */
public class Employee implements Comparable<Employee> {

	private int empID;
	private String name;
	private String project;
	private String team;
	private String designation;
	
	public Employee(int empID, String name, String project, String team, String desingnation) {
		this.empID = empID;
		this.name = name;
		this.project = project;
		this.team = team;
		this.designation = desingnation;
	}

	public int getEmpID() {
		return empID;
	}

	public String getName() {
		return name;
	}

	public String getProject() {
		return project;
	}

	public String getTeam() {
		return team;
	}

	public String getDesignation() {
		return designation;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((designation == null) ? 0 : designation.hashCode());
		result = prime * result + empID;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((project == null) ? 0 : project.hashCode());
		result = prime * result + ((team == null) ? 0 : team.hashCode());
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
		Employee other = (Employee) obj;
		if (designation == null) {
			if (other.designation != null)
				return false;
		} else if (!designation.equals(other.designation))
			return false;
		if (empID != other.empID)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (project == null) {
			if (other.project != null)
				return false;
		} else if (!project.equals(other.project))
			return false;
		if (team == null) {
			if (other.team != null)
				return false;
		} else if (!team.equals(other.team))
			return false;
		return true;
	}
	
	@Override
	public int compareTo(Employee employee) {
		
		int returnValue = this.getProject().compareToIgnoreCase(employee.getProject()); 
		if (returnValue == 0) {
			returnValue = this.getTeam().compareToIgnoreCase(employee.getTeam());
			if (returnValue == 0) {
				returnValue = this.getName().compareToIgnoreCase(employee.getName());
			}
		}
		return returnValue;
	}

	@Override
	public String toString() {
		return "Employee [empID=" + empID + ", name=" + name + ", project=" + project + ", team=" + team
				+ ", designation=" + designation + "]";
	}

}
