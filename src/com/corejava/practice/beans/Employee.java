package com.corejava.practice.beans;

/**
 * This class implements {@linkplain Comparable} interface for sorting purpose.
 * At the time of sorting this class object it will sort by project, team and
 * name respectively.
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

  /* Why do we need setter methods when we can easily expose the fields?
   * Answer: If you expose the fields then you cannot add any logic in
   * future if needed to validate the data. Let say you want to restrict
   * to set the empID, it should be greater than 20000. You can not do
   * that if you expose the fields but if you have setter method then you
   * can achieve this.
   * Another scenario is when you want your Class to be immutable, if you
   * allow field access then you are breaking the immutability of your
   * class since values can be changed. But if you carefully design your
   * class with getters and no setters you keep the immutability intact.
   * Though in such cases you have to be careful in getter method to ensure
   * you don't give out reference of objects(in case your class have
   * object as instances).
   **/
  public void setEmpID(int empID) {
    this.empID = empID;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setProject(String project) {
    this.project = project;
  }

  public void setTeam(String team) {
    this.team = team;
  }

  public void setDesignation(String designation) {
    this.designation = designation;
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
