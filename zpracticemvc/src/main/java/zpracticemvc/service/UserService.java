package zpracticemvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zpracticemvc.dao.UserDao;
import zpracticemvc.model.User;

@Service                //spring shortcut : instred of declareing bean in xml we can use this annotaion so whenever it requires to inject obj this will help
public class UserService {

	@Autowired
	private UserDao userDao;  // service layer user userDao obj to access database indrireclty
	public int createUser(User user)
	{	return this.userDao.saveUser(user);	
	}
	
	
}
