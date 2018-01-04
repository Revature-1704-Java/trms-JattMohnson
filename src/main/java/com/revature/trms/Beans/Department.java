package com.revature.trms.Beans;

public class Department 
{
	private int ID;
	private String depName;
	private int depHead;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getDepName() {
		return depName;
	}
	public void setDepName(String depName) {
		this.depName = depName;
	}
	public int getDepHead() {
		return depHead;
	}
	public void setDepHead(int depHead) {
		this.depHead = depHead;
	}
	public Department(int iD, String depName, int depHead) {
		super();
		ID = iD;
		this.depName = depName;
		this.depHead = depHead;
	}
	public Department()
	{
		super();
	}
}
