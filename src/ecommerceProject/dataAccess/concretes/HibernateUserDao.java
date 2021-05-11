package ecommerceProject.dataAccess.concretes;

import ecommerceProject.dataAccess.abstracts.UserDao;
import ecommerceProject.entities.concretes.User;

public class HibernateUserDao implements UserDao {
	

	@Override
	public void add(User user) {
		System.out.println("Hibernate ile eklendi: " + user.getFirstName() + " " + user.getLastName());
		
	}

	

	

}
