package beans;

public class GradingReference 
{
	private int ID;
	private String descrip;
	private String presentation;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getDescrip() {
		return descrip;
	}
	public void setDescrip(String descrip) {
		this.descrip = descrip;
	}
	public String getPresentation() {
		return presentation;
	}
	public void setPresentation(String presentation) {
		this.presentation = presentation;
	}
	public GradingReference(int iD, String descrip, String presentation) {
		super();
		ID = iD;
		this.descrip = descrip;
		this.presentation = presentation;
	}
	public GradingReference()
	{
		super();
	}
}
