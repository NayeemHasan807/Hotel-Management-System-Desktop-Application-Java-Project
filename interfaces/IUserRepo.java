package interfaces;

import java.lang.*;
import entity.*;

public interface IUserRepo
{
	User getUser(String userId, String password);
	void insertUser(User u);
	void updatestatus(String id,int status);
	void updateUser(User u,String s);
	void deleteUser(String userId);
}