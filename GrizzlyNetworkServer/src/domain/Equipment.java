package domain;

import java.io.Serializable;

public class Equipment implements Serializable{
	private static final long serialVersionUID = 3145082846227260366L;
	
	private String equipmentId;
	private String equipmentName;
	private String type;
	private String status;
	
	public Equipment() {
		
	}

	public Equipment(String equipmentId, String equipmentName, String type, String status) {
		this.equipmentId = equipmentId;
		this.equipmentName = equipmentName;
		this.status = status;
		this.type = type;
	}

	public String getEquipmentId() {
		return equipmentId;
	}

	public void setEquipmentId(String equipmentId) {
		this.equipmentId = equipmentId;
	}

	public String getEquipmentName() {
		return equipmentName;
	}

	public void setEquipmentName(String equipmentName) {
		this.equipmentName = equipmentName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
