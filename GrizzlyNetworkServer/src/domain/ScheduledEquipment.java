package domain;

import java.io.Serializable;
import java.sql.Date;

public class ScheduledEquipment implements Serializable{
	private static final long serialVersionUID = 3145082846227260366L;
	
	private String scheduledId;
	private String eventId;
	private String equipmentId;
	private Date eventDate;

	public ScheduledEquipment() {

	}

	public ScheduledEquipment(String scheduledId, String eventId, String equipmentId, Date eventDate) {
		this.scheduledId = scheduledId;
		this.eventId = eventId;
		this.equipmentId = equipmentId;
		this.eventDate = eventDate;
	}

	public String getScheduledId() {
		return scheduledId;
	}

	public void setScheduledId(String scheduledId) {
		this.scheduledId = scheduledId;
	}

	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	public String getEquipmentId() {
		return equipmentId;
	}

	public void setEquipmentId(String equipmentId) {
		this.equipmentId = equipmentId;
	}

	public Date getEventDate() {
		return eventDate;
	}

	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
