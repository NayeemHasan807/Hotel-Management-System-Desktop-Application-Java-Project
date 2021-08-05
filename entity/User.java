package entity;
import java.lang.*;

public class User
{
	private String uId;
	private String uPassword;
	private int uStatus;
	
	public void setUId(String uId)
	{
		this.uId=uId;
	}
	public void setUPassword(String uPassword)
	{
		this.uPassword=uPassword;
	}
	public void setUStatus(int uStatus)
	{
		this.uStatus=uStatus;
	}
	
	public String getUId()
	{
		return uId;
	}
	public String getUPassword()
	{
		return uPassword;
	}
	public int getUStatus()
	{
		return uStatus;
	}
}