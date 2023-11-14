package domain;

import java.io.Serializable;
import java.sql.Date;

public class RentalRequest implements Serializable {
	private static final long serialVersionUID = 3145082846227260366L;
	
	private String requestId;
	private String customerId;
	private String equipmentId;
	private Date requestedDate;
	private String messageId;
	private String status;
	
	public RentalRequest() {
		
	}

	public RentalRequest(String requestId, String customerId, String equipmentId, Date requestedDate, String messageId, String status) {
		this.requestId = requestId;
		this.customerId = customerId;
		this.equipmentId = equipmentId;
		this.requestedDate = requestedDate;
		this.messageId = messageId;
		this.status = status;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
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

	public Date getRequestedDate() {
		return requestedDate;
	}

	public void setRequestedDate(Date requestedDate) {
		this.requestedDate = requestedDate;
	}

	public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
