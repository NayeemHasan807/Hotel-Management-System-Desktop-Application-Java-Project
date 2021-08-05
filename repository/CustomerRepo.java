package repository;

import java.lang.*;
import java.util.ArrayList;

import entity.*;
import interfaces.*;

public class CustomerRepo implements ICustomerRepo
{
	DatabaseConnection dbc;
	
	public CustomerRepo()
	{
		dbc = new DatabaseConnection();
	}
	
	public void insertInDB(Customer c)
	{
		String query = "INSERT INTO customer VALUES ('"+c.getCId()+"','"+c.getCName()+"','"+c.getCRoomNumber()+"','"+c.getCCheckIn()+"','"+c.getCCheckOut()+"');";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
	}
	public void deleteFromDB(String cId)
	{
		String query = "DELETE from customer WHERE customerId='"+cId+"';";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	public void updateInDB(Customer c)
	{
		String query = "UPDATE customer SET Name='"+c.getCName()+"', RoomNumber= '"+c.getCRoomNumber()+"', CheckInTime = '"+c.getCCheckIn()+"', CheckOutTime='"+c.getCCheckOut()+"' WHERE cId='"+c.getCId()+"'";
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
	public Customer searchCustomer(String cId)
	{
		Customer c = null;
		String query = "SELECT `Name`, `RoomNumber`, `CheckInTime`, `CheckOutTime` FROM `customer` WHERE `CustomerId`='"+cId+"';";     
		try
		{
		
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
		
			while(dbc.result.next())
			{
				
				String cName = dbc.result.getString("Name");
				int cRoomNumber = dbc.result.getInt("RoomNumber");
				String cCheckIn = dbc.result.getString("CheckInTime");
				String cCheckOut = dbc.result.getString("CheckOutTime");
				
				c = new Customer();
				c.setCId(cId);
				c.setCName(cName);
				c.setCRoomNumber(cRoomNumber);
				c.setCCheckIn(cCheckIn);
				c.setCCheckOut(cCheckOut);
			}
			
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		dbc.closeConnection();
		return c;
	}
	public String[][] getAllCustomer()
	{
		ArrayList<Customer> ar = new ArrayList<Customer>();
		String query = "SELECT * FROM customer;";  
		try
		{
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
			while(dbc.result.next())
			{
				String cId = dbc.result.getString("CustomerId");
				String cName = dbc.result.getString("Name");
				int cRoomNumber = dbc.result.getInt("RoomNumber");
				String cCheckIn = dbc.result.getString("CheckInTime");
				String cCheckOut = dbc.result.getString("CheckOutTime");
			
				Customer c = new Customer();
				c.setCId(cId);
				c.setCName(cName);
				c.setCRoomNumber(cRoomNumber);
				c.setCCheckIn(cCheckIn);
				c.setCCheckOut(cCheckOut);
				ar.add(c);
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		dbc.closeConnection();
		
		
		Object obj[] = ar.toArray();
		String data[][] = new String[ar.size()][5];
		
		for(int i=0;i<obj.length;i++)
		{
			data[i][0] = ((Customer)obj[i]).getCId();
			data[i][1] = ((Customer)obj[i]).getCName();
			data[i][2] = Integer.toString(((Customer)obj[i]).getCRoomNumber());
			data[i][3] = (((Customer)obj[i]).getCCheckIn())+"";
 			data[i][4] = (((Customer)obj[i]).getCCheckOut())+"";
		}
		return data;
	}
}