package entity;
import java.lang.*;

public class Room
{
	private int roomNumber;
	private int availability;
	
	public void setRoomNumber(int roomNumber)
	{
		this.roomNumber=roomNumber;
	}
	public void setAvailability(int availability)
	{
		this.availability=availability;
	}
	public int getRoomNumber()
	{
		return roomNumber;
	}
	public int getAvailability()
	{
		return availability;
	}
}