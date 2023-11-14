package domain;

import java.io.Serializable;
import java.sql.Timestamp;

public class Message implements Serializable{
	private static final long serialVersionUID = 3145082846227260366L;
	
	private String messageId;
	private String senderId;
	private String receiverId;
	private String messageContent;
	private Timestamp timestamp;
	
	public Message() {
		
	}

	public Message(String messageId, String senderId, String receiverId, String messageContent, Timestamp timestamp) {
		this.messageId = messageId;
		this.senderId = senderId;
		this.receiverId = receiverId;
		this.messageContent = messageContent;
		this.timestamp = timestamp;
	}

	public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	public String getSenderId() {
		return senderId;
	}

	public void setSenderId(String senderId) {
		this.senderId = senderId;
	}

	public String getReceiverId() {
		return receiverId;
	}

	public void setReceiverId(String receiverId) {
		this.receiverId = receiverId;
	}

	public String getMessageContent() {
		return messageContent;
	}

	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
