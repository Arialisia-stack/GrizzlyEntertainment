package domain;

import java.io.Serializable;

public class Employee implements Serializable{
	private static final long serialVersionUID = 3145082846227260366L;
	
	private String employeeId;
	private String firstName;
	private String lastName;
	
	public Employee() {

	}
	
	public Employee(String employeeId, String firstName, String lastName) {
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
