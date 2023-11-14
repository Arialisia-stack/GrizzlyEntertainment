package domain;

import java.io.Serializable;
import java.sql.Date;

public class Invoice implements Serializable{
	private static final long serialVersionUID = 3145082846227260366L;
	
	private String invoiceId;
	private String transactionId;
	private Date invoiceDate;
	private float amount;
	
	public Invoice() {
	
	}

	public Invoice(String invoiceId, String transactionId, Date invoiceDate, float amount) {
		this.invoiceId = invoiceId;
		this.transactionId = transactionId;
		this.invoiceDate = invoiceDate;
		this.amount = amount;
	}

	public String getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(String invoiceId) {
		this.invoiceId = invoiceId;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public Date getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}
}
