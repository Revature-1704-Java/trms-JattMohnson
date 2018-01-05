package beans;

public class ReimbursementStatus 
{
	private int ID;
	private String statusDescrip;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getStatusDescrip() {
		return statusDescrip;
	}
	public void setStatusDescrip(String statusDescrip) {
		this.statusDescrip = statusDescrip;
	}
	public ReimbursementStatus(int iD, String statusDescrip) {
		super();
		ID = iD;
		this.statusDescrip = statusDescrip;
	}
	public ReimbursementStatus()
	{
		super();
	}
}
