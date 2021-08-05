package entity;
import java.lang.*;

public class Employee
{
	private String eId;
	private String eName;
	private String eJobCategory;
	private int eSalary;
	private int ePhoneNo;
	
	public void setEId(String eId)
	{
		this.eId=eId;
	}
	public void setEName(String eName)
	{
		this.eName=eName;
	}
	public void seteJobCategory(String eJobCategory)
	{
		this.eJobCategory=eJobCategory;
	}
	public void setESalary(int eSalary)
	{
		this.eSalary=eSalary;
	}
	public void setEPhoneNo(int ePhoneNo)
	{
		this.ePhoneNo=ePhoneNo;
	}
	
	
	public String getEId()
	{
		return eId;
	}
	public String getEName()
	{
		return eName;
	}
	public String getEJobCategory()
	{
		return eJobCategory;
	}
	public int getESalary()
	{
		return eSalary;
	}
	public int getEPhoneNo()
	{
		return ePhoneNo;
	}
}