package repository;

import java.lang.*;

import entity.*;
import interfaces.*;

public class UserRepo implements IUserRepo
{
	DatabaseConnection dbc;
	
	public UserRepo()
	{
		dbc = new DatabaseConnection();
	}
	public User getUser(String userId, String password)
	{
		User u = null;
		String query = "Select * from user where uId = '"+userId+"' AND uPassword = '"+password+"';";
		try
		{
			System.out.println(query);
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
		
			while(dbc.result.next())
			{
				u = new User();
				u.setUId(dbc.result.getString("uId"));  /*String uid = dbc.result.getString("userId");user.setUserId(uid);*/
				u.setUPassword(dbc.result.getString("uPassword"));
				u.setUStatus(dbc.result.getInt("uStatus"));
			}
		}
        catch(Exception ex)
		{
			System.out.println("Exception1 : " +ex.getMessage());
        }
		dbc.closeConnection();
		return u;
	}
	public void insertUser(User u)
	{
		String query = "INSERT INTO user VALUES ('"+u.getUId()+"','"+u.getUPassword()+"',"+u.getUStatus()+");";
		try
		{
			System.out.println(query);
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	public void updatestatus(String id,int status)
	{
		String query = "UPDATE user SET uStatus='"+status+"' WHERE uId='"+id+"';";
		
		try
		{
			System.out.println(query);
			dbc.openConnection();
			dbc.st.executeUpdate(query);
			dbc.closeConnection();
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
	}
	public void updateUser(User u,String s)
	{
		String query = "UPDATE user SET uPassword='"+s+"' WHERE uId='"+u.getUId()+"' AND uPassword='"+u.getUPassword()+"';";
		
		try
		{
			System.out.println(query);
			dbc.openConnection();
			dbc.st.executeUpdate(query);
			dbc.closeConnection();
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
	}
	public void deleteUser(String uId)
	{
		String query = "DELETE from user  WHERE uId='"+uId+"';";
		try
		{
			System.out.println(query);
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
}