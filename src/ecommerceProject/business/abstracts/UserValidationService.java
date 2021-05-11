package ecommerceProject.business.abstracts;

import ecommerceProject.entities.concretes.User;

public interface UserValidationService {
	boolean validation(User user); 
	boolean emailValidation(User user);
	boolean emailValidating(User user);

}
