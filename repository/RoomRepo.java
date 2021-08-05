package repository;

import java.lang.*;
import java.util.ArrayList;

import entity.*;
import interfaces.*;

public class RoomRepo implements IRoomRepo
{
	DatabaseConnection dbc;
	
	public RoomRepo()
	{
		dbc = new DatabaseConnection();
	}
	
	public Room searchRoom(int rRoomNumber)
	{
		Room r = null;
		String query = "SELECT `Availability` from room WHERE `RoomNumber`='"+rRoomNumber+"';";     
		try
		{
		
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
		
			while(dbc.result.next())
			{
				int availability = dbc.result.getInt("Availability");
				
				r = new Room();
				r.setRoomNumber(rRoomNumber);
				r.setAvailability(availability);
			}
			
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		dbc.closeConnection();
		return r;
	}
	public void updateAvailability(int roomno,int availability)
	{
		String query = "UPDATE room SET Availability='"+availability+"' WHERE RoomNumber='"+roomno+"'" ;
		
		try
		{
			dbc.openConnection();
			dbc.st.executeUpdate(query);
			dbc.closeConnection();
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}

	}
	public void updateRoom(Room r)
	{
		String query = "UPDATE room SET Availability='"+r.getAvailability()+"' WHERE RoomNumber='"+r.getRoomNumber()+"'" ;
		
		try
		{
			dbc.openConnection();
			dbc.st.executeUpdate(query);
			dbc.closeConnection();
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
	}	
	public String[][] getAllRoom()
	{
		ArrayList<Room> ar = new ArrayList<Room>();
		String query = "SELECT * FROM room;";  
		Room r;
		try
		{
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
			
		
			while(dbc.result.next())
			{
				int rRoomNumber = dbc.result.getInt("RoomNumber");
				int availability = dbc.result.getInt("Availability");
			
				r = new Room();
				r.setRoomNumber(rRoomNumber);
				r.setAvailability(availability);
				ar.add(r);
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		dbc.closeConnection();
		
		
		Object obj[] = ar.toArray();
		String data[][] = new String [ar.size()][2];
		
		for(int i=0; i<obj.length; i++)
		{
			data[i][0] =Integer.toString(((Room)obj[i]).getRoomNumber());
			data[i][1] =Integer.toString(((Room)obj[i]).getAvailability());
		}
		return data;
	}
}