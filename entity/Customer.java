package entity;
import java.lang.*;

public class Customer
{
	private String cId;
	private String cName;
	private int cRoomNumber;
	private String cCheckIn;
	private String cCheckOut;
	
	public void setCId(String cId)
	{
		this.cId=cId;
	}
	public void setCName(String cName)
	{
		this.cName=cName;
	}
	public void setCRoomNumber(int cRoomNumber)
	{
		this.cRoomNumber=cRoomNumber;
	}
	public void setCCheckIn(String cCheckIn)
	{
		this.cCheckIn=cCheckIn;
	}
	public void setCCheckOut(String cCheckOut)
	{
		this.cCheckOut=cCheckOut;
	}
	
	
	public String getCId()
	{
		return cId;
	}
	public String getCName()
	{
		return cName;
	}
	public int getCRoomNumber()
	{
		return cRoomNumber;
	}
	public String getCCheckIn()
	{
		return cCheckIn;
	}
	public String getCCheckOut()
	{
		return cCheckOut;
	}
}