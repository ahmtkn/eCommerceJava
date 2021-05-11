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
			System.out.println("Kayýt Ýþlemi Baþarýsýz");
		}else {
			Scanner scanner = new Scanner(System.in);
			
			System.out.println("************************************************************");
			System.out.println("Ýþlem Baþarýlý");
			this.userDao.add(user);
			//this.database.emailAdd(user);
			System.out.println("************************************************************");
			
			System.out.println("Doðrulama Linki Ýçin 1'e Basýn \nÝþlemi Ýptal Etmek Ýçin 2'ye Basýn");
			int token = scanner.nextInt();
			user.setToken(token);
			this.tokenCheck(user);
		}
		
	}

	@Override
	public void logIn(User user) {
		
		if(user.getEmail().isEmpty() || userValidation.emailValidating(user)) {
			System.out.println("************************************************************");
			System.out.println("E posta Adresi Boþ Olamaz ya da Hatalý E posta Yazýmý");
		}else if(user.getPassword().isEmpty()) {
			System.out.println("************************************************************");
			System.out.println("Parola Boþ Olamaz");
		}else {
			System.out.println("************************************************************");
			System.out.println("Giriþ Ýþlemi Baþarýlý");
		}
		
	}


	@Override
	public void tokenCheck(User user) {
		if(user.getToken() == 1) {
			System.out.println("************************************************************");
			System.out.println("Üyeliðiniz Baþarýlý Bir Þekilde Doðrulandý");
			System.out.println("************************************************************");
		}else if(user.getToken() == 2) {
			System.out.println("************************************************************");
			System.out.println("Üyelik Ýþlemleri Ýptal Edildi");
			System.out.println("************************************************************");
		}
		
	}

}
