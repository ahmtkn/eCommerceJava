package ecommerceProject.business.concretes;

import java.util.Scanner;

import ecommerceProject.business.abstracts.UserService;
import ecommerceProject.core.abstracts.GoogleService;
import ecommerceProject.core.concretes.GoogleManagerAdapter;
import ecommerceProject.dataAccess.concretes.HibernateUserDao;
import ecommerceProject.entities.concretes.User;

public class Consol {
	
	UserService userManager = new UserManager(new UserValidation(),new HibernateUserDao());
	User user = new User();
	
	
	public void homePage() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Giri� ��lemi ��in 1'e \nKay�t ��lemleri ��lemi ��in 2'ye Bas�n");
		int islem = scanner.nextInt();
		
		if(islem == 1) {
			this.logInPage();
		}else if(islem == 2) {
			this.registerPage();
		}
	}

	public void registerPage() {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Google �le Kay�t Olmak ��in 1'e Bas�n \nKay�t Olma Ad�mlar� ��in 2'ye Bas�n");
		int sorgu = scanner.nextInt();
		scanner.nextLine();
		
		
		if(sorgu == 1) {
			GoogleService googleService = new GoogleManagerAdapter();
			googleService.registerToSystem();
			
		}else if(sorgu == 2) {
			
			Scanner scann = new Scanner(System.in);
			
			System.out.println("Ad�n�z� Giriniz:");
			String firstName = scanner.nextLine();
			
			System.out.println("Soyad�n�z� Giriniz:");
			String lastName = scanner.nextLine();
			
			System.out.println("Mail Adresi Giriniz:");
			String mail = scanner.nextLine();
	
			
			System.out.println("Parolan�z� Giriniz:");
			String password = scanner.nextLine();
			

			//User user = new User();
			user.setFirstName(firstName);
			user.setLastName(lastName);
			user.setEmail(mail);
			user.setPassword(password);
			

			//UserService userManager = new UserManager(new UserValidation(),new HibernateUserDao());
			userManager.register(user);
			
		}
		
	}
	
	public void logInPage() {
		Scanner scan = new Scanner(System.in);
		System.out.println("E posta adresinizi giriniz");
		String mail = scan.nextLine();
		
		System.out.println("�ifrenizi Girin");
		String password = scan.nextLine();
		
		user.setEmail(mail);
		user.setPassword(password);
		
		userManager.logIn(user);
		
	}
}
