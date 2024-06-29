package TestCases;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Operations.HomePageFunc;
import Operations.LoginPageFunc;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.model.Status;

public class LoginPageFlow extends ParentTest{
	
	LoginPageFunc loginPageFuncOBJ;
	
	
	@Test
    public void InitiateLoginPage(){
		loginPageFuncOBJ = new 	LoginPageFunc(driver);
    }
	

	@Test(dependsOnMethods = "InitiateLoginPage")
    @Description("verify locked out message for locked_out_user trying to log in")
     public void verifyPromptMessageForLockedOutUser() {
		loginPageFuncOBJ.cleanFields();
		logStep("Getting logged in");
		String username = TestDataReaderOBJ.configFileReader().get("lockedUsername");
		String password = TestDataReaderOBJ.configFileReader().get("password");
		loginPageFuncOBJ.loginFlow(username, password);
		
		logStep("Verify Error message");
		Assert.assertTrue(loginPageFuncOBJ.errorMsgForLockedUser());
    }
	
	@Test(dependsOnMethods = "InitiateLoginPage")
    @Description("verify password not matching prompt for wrong username and correct password for locked_out_user")
     public void verifyPromptMessageForWrongUsernameForLockedOutUser() {
		loginPageFuncOBJ.cleanFields();
		logStep("Getting logged in");
		String username = TestDataReaderOBJ.configFileReader().get("lockedUsername");
		String password = TestDataReaderOBJ.configFileReader().get("password");
		loginPageFuncOBJ.loginFlow(username+"wrong", password);
		
		logStep("Verify Password Mismatching Error message");
		Assert.assertTrue(loginPageFuncOBJ.passwordMismatchErrorMsgForLockedUser());
    }
	
	@Test(dependsOnMethods = "InitiateLoginPage")
    @Description("verify password not matching prompt for correct username and wrong password for locked_out_user")
     public void verifyPromptMessageForWrongPasswordForLockedOutUser() {
		loginPageFuncOBJ.cleanFields();
		logStep("Getting logged in");
		String username = TestDataReaderOBJ.configFileReader().get("lockedUsername");
		String password = TestDataReaderOBJ.configFileReader().get("password");
		loginPageFuncOBJ.loginFlow(username, password+"wrong");
		
		logStep("Verify Password Mismatching Error message");
		Assert.assertTrue(loginPageFuncOBJ.passwordMismatchErrorMsgForLockedUser());
    }

	@Test(dependsOnMethods = "InitiateLoginPage")
    @Description("verify successful login for standard_user")
     public void verifysuccessLoginForStandardUser() {
		loginPageFuncOBJ.cleanFields();
		HomePageFunc homePageOBJ = new HomePageFunc(driver);
		logStep("Getting logged in");
		String username = TestDataReaderOBJ.configFileReader().get("StandardUsername");
		String password = TestDataReaderOBJ.configFileReader().get("password");
		loginPageFuncOBJ.loginFlow(username, password);

		logStep("Verify successful login");
		Assert.assertTrue(loginPageFuncOBJ.successfulLogin());
		Assert.assertTrue(homePageOBJ.productTitle());
    }
	
	//Other scenarios for login page which are not supported on the website - 
	//1. verify unique error message for alphanumeric username typed in username field 
	//2. verify unique error message for alphanumeric password typed in password field 
	//3. verify remember me checkbox is visible to user and clickable
	//4. verify unique error message for a different username other than mentioned ones 
	
    	
    }
    
    

