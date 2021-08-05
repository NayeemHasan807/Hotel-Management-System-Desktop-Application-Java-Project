package interfaces;

import java.lang.*;

import entity.*;

public interface ICustomerRepo
{
	public void insertInDB(Customer c);
	public void deleteFromDB(String cId);
	public void updateInDB(Customer c);
	public Customer searchCustomer(String cId);
	public String[][] getAllCustomer();
}