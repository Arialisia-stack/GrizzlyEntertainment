package domain;

import java.io.Serializable;

public class Customer implements Serializable{
	private static final long serialVersionUID = 3145082846227260366L;
	
	private String customerId;
	private String firstName;
	private String lastName;
	private int accountNumber;
	private float accountBalance;
	
	public Customer() {

	}
	
	public Customer(String customerId, String firstName, String lastName, int accountNumber, float accountBalance) {
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.accountNumber = accountNumber;
		this.accountBalance = accountBalance;
	}
	
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
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
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public float getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(float accountBalance) {
		this.accountBalance = accountBalance;
	}
}
