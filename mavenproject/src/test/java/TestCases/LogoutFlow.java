package TestCases;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Test;

import Operations.HomePageFunc;
import Operations.LoginPageFunc;
import io.qameta.allure.Description;

public class LogoutFlow extends ParentTest {

	LoginPageFunc loginFlowFuncOBJ;
	HomePageFunc HomePageFuncOBJ;
	
	@Test(priority=0)
    public void InitiateHomePage(){
		HomePageFuncOBJ = new HomePageFunc(driver);
		loginFlowFuncOBJ = new 	LoginPageFunc(driver);
		String username = TestDataReaderOBJ.configFileReader().get("StandardUsername");
		String password = TestDataReaderOBJ.configFileReader().get("password");
		loginFlowFuncOBJ.loginFlow(username, password);
    }
	
	@Test(dependsOnMethods = "InitiateHomePage", priority=1)
    @Description("Verify logout flow")
     public void verifyLogOutFlow() {
		logStep("Click on side bar on Home page");
		HomePageFuncOBJ.clickSideBar();
				
		logStep("Click on log out link");
		HomePageFuncOBJ.clicklogOutLink();
		
		logStep("Verify user is logged out and lands on login page again");
		boolean flag = loginFlowFuncOBJ.verifyLoginPageLanding();
		Assert.assertTrue(flag);
		
    }
	
	
}
