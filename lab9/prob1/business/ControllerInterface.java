package lab9.prob1.business;

import java.util.List;

import lab9.prob1.business.Book;
import lab9.prob1.dataaccess.DataAccess;
import lab9.prob1.dataaccess.DataAccessFacade;

public interface ControllerInterface {
	public void login(String id, String password) throws LoginException;
	public List<String> allMemberIds();
	public List<String> allBookIds();
	
}
