package com.revature.trms.Beans;

public class Messages 
{
	private int messageID;
	private int senderID;
	private int recieverID;
	private String message;
	private String mostRecent;
	public int getMessageID() {
		return messageID;
	}
	public void setMessageID(int messageID) {
		this.messageID = messageID;
	}
	public int getSenderID() {
		return senderID;
	}
	public void setSenderID(int senderID) {
		this.senderID = senderID;
	}
	public int getRecieverID() {
		return recieverID;
	}
	public void setRecieverID(int recieverID) {
		this.recieverID = recieverID;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getMostRecent() {
		return mostRecent;
	}
	public void setMostRecent(String mostRecent) {
		this.mostRecent = mostRecent;
	}
	public Messages(int messageID, int senderID, int recieverID, String message, String mostRecent) {
		super();
		this.messageID = messageID;
		this.senderID = senderID;
		this.recieverID = recieverID;
		this.message = message;
		this.mostRecent = mostRecent;
	}
	public Messages()
	{
		super();
	}
}
