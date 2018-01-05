package beans;

public class EventType 
{
	private int ID;
	private String eventDesc;
	private double Percent;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getEventDesc() {
		return eventDesc;
	}
	public void setEventDesc(String eventDesc) {
		this.eventDesc = eventDesc;
	}
	public double getPercent() {
		return Percent;
	}
	public void setPercent(double percent) {
		Percent = percent;
	}
	public EventType(int iD, String eventDesc, double percent) {
		super();
		ID = iD;
		this.eventDesc = eventDesc;
		Percent = percent;
	}
	public EventType() {
		super();
	}
}
