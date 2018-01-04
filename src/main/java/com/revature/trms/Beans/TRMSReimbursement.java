package com.revature.trms.Beans;

import java.sql.Blob;
import java.sql.Date;

public class TRMSReimbursement 
{
	private int ID;
	private int empID;
	private Date startDate;
	private double startTime;
	private Date approvalDate;
	private String location;
	private String classDescrip;
	private double cost;
	private int gradingType;
	private int eventType;
	private String justification;
	private Blob attachment;
	private int hoursMissed;
	private String urgency;
	private int statusID;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public int getEmpID() {
		return empID;
	}
	public void setEmpID(int empID) {
		this.empID = empID;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public double getStartTime() {
		return startTime;
	}
	public void setStartTime(double startTime) {
		this.startTime = startTime;
	}
	public Date getApprovalDate() {
		return approvalDate;
	}
	public void setApprovalDate(Date approvalDate) {
		this.approvalDate = approvalDate;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getClassDescrip() {
		return classDescrip;
	}
	public void setClassDescrip(String classDescrip) {
		this.classDescrip = classDescrip;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public int getGradingType() {
		return gradingType;
	}
	public void setGradingType(int gradingType) {
		this.gradingType = gradingType;
	}
	public int getEventType() {
		return eventType;
	}
	public void setEventType(int eventType) {
		this.eventType = eventType;
	}
	public String getJustification() {
		return justification;
	}
	public void setJustification(String justification) {
		this.justification = justification;
	}
	public Blob getAttachment() {
		return attachment;
	}
	public void setAttachment(Blob attachment) {
		this.attachment = attachment;
	}
	public int getHoursMissed() {
		return hoursMissed;
	}
	public void setHoursMissed(int hoursMissed) {
		this.hoursMissed = hoursMissed;
	}
	public String getUrgency() {
		return urgency;
	}
	public void setUrgency(String urgency) {
		this.urgency = urgency;
	}
	public int getStatusID() {
		return statusID;
	}
	public void setStatusID(int statusID) {
		this.statusID = statusID;
	}
	public TRMSReimbursement(int iD, int empID, Date startDate, double startTime, Date approvalDate, String location,
			String classDescrip, double cost, int gradingType, int eventType, String justification, Blob attachment,
			int hoursMissed, String urgency, int statusID) {
		super();
		ID = iD;
		this.empID = empID;
		this.startDate = startDate;
		this.startTime = startTime;
		this.approvalDate = approvalDate;
		this.location = location;
		this.classDescrip = classDescrip;
		this.cost = cost;
		this.gradingType = gradingType;
		this.eventType = eventType;
		this.justification = justification;
		this.attachment = attachment;
		this.hoursMissed = hoursMissed;
		this.urgency = urgency;
		this.statusID = statusID;
	}
	public TRMSReimbursement()
	{
		super();
	}
	
}
