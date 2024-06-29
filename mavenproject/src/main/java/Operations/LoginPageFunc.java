package Operations;

import org.openqa.selenium.WebDriver;
import Pages.LoginPage;
import Pages.HomePage;

public class LoginPageFunc extends Actions{
	
	public LoginPageFunc(WebDriver driver) {
    	super(driver);
    }
	
	
	 public void loginFlow(String user, String password) {
		 Text(LoginPage.usernameField, user);
		 Text(LoginPage.passwordField, password);
		 click(LoginPage.loginBtn);
	    }
	
	 
	 public boolean errorMsgForLockedUser() {
	        if(elementfind(LoginPage.lockedOutPrompt)) {
	        	return(true);
	        }
	        else {
	        	return(false);
	        }

	    }

	 public boolean passwordMismatchErrorMsgForLockedUser() {
	        if(elementfind(LoginPage.passwordNotMatchingPrompt)) {
	        	return(true);
	        }
	        else {
	        	return(false);
	        }

	    }
	 
	 public boolean successfulLogin() {
	        if(elementfind(HomePage.homePageTitle)) {
	        	return(true);
	        }
	        else {
	        	return(false);
	        }

	    }
	 
	 public void cleanFields() {
		 clearText(LoginPage.usernameField);
		 clearText(LoginPage.passwordField);
	 }
	 
	 public boolean verifyLoginPageLanding() {
		 if(elementfind(LoginPage.loginLogo) && elementfind(LoginPage.loginBtn) && elementfind(LoginPage.usernameField) && elementfind(LoginPage.passwordField)) {
	        	return(true);
	        }
	        else {
	        	return(false);
	        }		 
	 }

}
