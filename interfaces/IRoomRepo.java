package interfaces;

import java.lang.*;

import entity.*;

public interface IRoomRepo
{
	public Room searchRoom(int rRoomNumber);
	public void updateAvailability(int roomno,int availability);
	public void updateRoom(Room r);
	public String[][] getAllRoom();
}