package ecommerceProject.business.abstracts;

import ecommerceProject.entities.concretes.User;

public interface UserService {
	void register(User user);
	void logIn(User user);
	void tokenCheck(User user);
	

}
