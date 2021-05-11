package ecommerceProject.business.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ecommerceProject.business.abstracts.UserService;
import ecommerceProject.business.abstracts.UserValidationService;
import ecommerceProject.dataAccess.abstracts.UserDao;
import ecommerceProject.entities.concretes.User;

public class UserManager implements UserService {
	
	UserDao userDao;
	UserValidationService userValidation;

	
	public UserManager(UserValidationService userValidation,UserDao userDao) {
		this.userValidation = userValidation;
		this.userDao = userDao;
	}
	

	@Override
	public void register(User user) {
		if(userValidation.validation(user) || userValidation.emailValidating(user)) {
			System.out.println("************************************************************");
			System.out.println("Kay�t ��lemi Ba�ar�s�z");
		}else {
			Scanner scanner = new Scanner(System.in);
			
			System.out.println("************************************************************");
			System.out.println("��lem Ba�ar�l�");
			this.userDao.add(user);
			//this.database.emailAdd(user);
			System.out.println("************************************************************");
			
			System.out.println("Do�rulama Linki ��in 1'e Bas�n \n��lemi �ptal Etmek ��in 2'ye Bas�n");
			int token = scanner.nextInt();
			user.setToken(token);
			this.tokenCheck(user);
		}
		
	}

	@Override
	public void logIn(User user) {
		
		if(user.getEmail().isEmpty() || userValidation.emailValidating(user)) {
			System.out.println("************************************************************");
			System.out.println("E posta Adresi Bo� Olamaz ya da Hatal� E posta Yaz�m�");
		}else if(user.getPassword().isEmpty()) {
			System.out.println("************************************************************");
			System.out.println("Parola Bo� Olamaz");
		}else {
			System.out.println("************************************************************");
			System.out.println("Giri� ��lemi Ba�ar�l�");
		}
		
	}


	@Override
	public void tokenCheck(User user) {
		if(user.getToken() == 1) {
			System.out.println("************************************************************");
			System.out.println("�yeli�iniz Ba�ar�l� Bir �ekilde Do�ruland�");
			System.out.println("************************************************************");
		}else if(user.getToken() == 2) {
			System.out.println("************************************************************");
			System.out.println("�yelik ��lemleri �ptal Edildi");
			System.out.println("************************************************************");
		}
		
	}

}
