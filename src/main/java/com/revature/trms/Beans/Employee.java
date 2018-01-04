package com.revature.trms.Beans;

public class Employee 
{
	private int ID;
	private String FName;
	private String LName;
	private int DirectSup;
	private int DepHead;
	private int BenCo;
	private String Email;
	private String Password;
	private String Description;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getFName() {
		return FName;
	}
	public void setFName(String fName) {
		FName = fName;
	}
	public String getLName() {
		return LName;
	}
	public void setLName(String lName) {
		LName = lName;
	}
	public int getDirectSup() {
		return DirectSup;
	}
	public void setDirectSup(int directSup) {
		DirectSup = directSup;
	}
	public int getDepHead() {
		return DepHead;
	}
	public void setDepHead(int depHead) {
		DepHead = depHead;
	}
	public int getBenCo() {
		return BenCo;
	}
	public void setBenCo(int benCo) {
		BenCo = benCo;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public Employee(int iD, String fName, String lName, int directSup, int depHead, int benCo, String email,
			String password, String description) {
		super();
		ID = iD;
		FName = fName;
		LName = lName;
		DirectSup = directSup;
		DepHead = depHead;
		BenCo = benCo;
		Email = email;
		Password = password;
		Description = description;
	}
	public Employee()
	{
		super();
	}
	
}
