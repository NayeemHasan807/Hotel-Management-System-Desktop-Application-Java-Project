package repository;

import java.lang.*;
import java.util.ArrayList;

import entity.*;
import interfaces.*;

public class EmployeeRepo implements IEmployeeRepo
{
	DatabaseConnection dbc;
	
	public EmployeeRepo()
	{
		dbc = new DatabaseConnection();
	}
	
	public void insertInDB(Employee e)
	{
		String query = "INSERT INTO employee VALUES ('"+e.getEId()+"','"+e.getEName()+"','"+e.getEJobCategory()+"','"+e.getESalary()+"','"+e.getEPhoneNo()+"');";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	public void deleteFromDB(String empId)
	{
		String query = "DELETE from employee WHERE EmployeeId='"+empId+"';";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception e){System.out.println(e.getMessage());}
	}
	public void updateInDB(Employee e)
	{
		String query = "UPDATE employee SET Name='"+e.getEName()+"', JobCategory= '"+e.getEJobCategory()+"', Salary = '"+e.getESalary()+"', Phone='"+e.getEPhoneNo()+"' WHERE EmployeeId='"+e.getEId()+"'";
		
		try
		{
			dbc.openConnection();
			dbc.st.executeUpdate(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	public Employee searchEmployee(String empId)
	{
		Employee emp = null;
		String query = "SELECT `Name`, `JobCategory`, `Salary`, `Phone` FROM `employee` WHERE `EmployeeId`='"+empId+"';";     
		try
		{
		
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
		
			while(dbc.result.next())
			{
				
				String eName = dbc.result.getString("Name");
				String eJobCategory = dbc.result.getString("JobCategory");
				int eSalary = dbc.result.getInt("Salary");
				int phone=dbc.result.getInt("Phone");
				
				emp = new Employee();
				emp.setEId(empId);
				emp.setEName(eName);
				emp.seteJobCategory(eJobCategory);
				emp.setESalary(eSalary);
				emp.setEPhoneNo(phone);
			}
			
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		dbc.closeConnection();
		return emp;
	}
	public String[][] getAllEmployee()
	{
		ArrayList<Employee> ar = new ArrayList<Employee>();
		String query = "SELECT * FROM employee;";  
		
		try
		{
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
			
		
			while(dbc.result.next())
			{
				String empId = dbc.result.getString("EmployeeId");
				String name = dbc.result.getString("Name");
				String ejobCategory = dbc.result.getString("JobCategory");
				int salary = dbc.result.getInt("Salary");
				int phoneNo=dbc.result.getInt("Phone");
			
				Employee e = new Employee();
				e.setEId(empId);
				e.setEName(name);
				e.seteJobCategory(ejobCategory);
				e.setESalary(salary);
				e.setEPhoneNo(phoneNo);
				ar.add(e);
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		dbc.closeConnection();
		
		
		Object obj[] = ar.toArray();
		String data[][] = new String [ar.size()][5];
		
		for(int i=0; i<obj.length; i++)
		{
			data[i][0] = ((Employee)obj[i]).getEId();
			data[i][1] = ((Employee)obj[i]).getEName();
			data[i][2] = ((Employee)obj[i]).getEJobCategory();
			data[i][3] = (((Employee)obj[i]).getESalary())+"";
 			data[i][4] = (((Employee)obj[i]).getEPhoneNo())+"";
		}
		return data;
	}
}