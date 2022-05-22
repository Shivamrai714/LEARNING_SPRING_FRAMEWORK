package zpracticemvc.dao;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import zpracticemvc.model.User;

@Repository            //spirng shortcut to understand sping that he need to create obj of this class and inject it, instead of declareing it as bean class in .xml
public class UserDao 
{
    //Dao accesses the DATABASE USING Hibernate template
	@Autowired            // spring ; automatically inject obj of it , just need to decalre the bean of its class in .xml file
	HibernateTemplate hibernateTemplate;
	
	@Transactional
	public int saveUser(User user)
	{
		int id=(Integer)this.hibernateTemplate.save(user) ;
	return id;   //return id of saved user.
	}
	
}
