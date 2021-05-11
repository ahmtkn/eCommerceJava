package ecommerceProject.core.concretes;

import ecommerceProject.core.abstracts.GoogleService;
import ecommerceProject.googleAuth.GoogleAuthManager;

public class GoogleManagerAdapter implements GoogleService{

	@Override
	public void registerToSystem() {
		GoogleAuthManager manager = new GoogleAuthManager();
		manager.registerByGoogle();
		
	}

}
