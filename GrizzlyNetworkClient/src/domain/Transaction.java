package domain;

import java.io.Serializable;
import java.sql.Date;

public class Transaction implements Serializable{
	private static final long serialVersionUID = 3145082846227260366L;
	
	private String transactionId;
	private String customerId;
	private String equipmentId;
	private java.util.Date rentalDate;
	private java.util.Date returnDate;
	private float totalCost;
	
	public Transaction() {
	
	}

	public Transaction(String transactionId, String customerId, String equipmentId, java.util.Date rentalDate, java.util.Date returnDate, float totalCost) {
		this.transactionId = transactionId;
		this.customerId = customerId;
		this.equipmentId = equipmentId;
		this.rentalDate = rentalDate;
		this.returnDate = returnDate;
		this.totalCost = totalCost;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getEquipmentId() {
		return equipmentId;
	}

	public void setEquipmentId(String equipmentId) {
		this.equipmentId = equipmentId;
	}

	public java.util.Date getRentalDate() {
		return rentalDate;
	}

	public void setRentalDate(Date rentalDate) {
		this.rentalDate = rentalDate;
	}

	public java.util.Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public float getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(float totalCost) {
		this.totalCost = totalCost;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
