package interfaces;

import java.lang.*;

import entity.*;

public interface IEmployeeRepo
{
	public void insertInDB(Employee e);
	public void deleteFromDB(String eId);
	public void updateInDB(Employee e);
	public Employee searchEmployee(String eId);
	public String[][] getAllEmployee();
}