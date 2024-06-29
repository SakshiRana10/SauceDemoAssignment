package TestCases;

import TestDataReader.TestDataReader;
import Operations.HomePageFunc;
import Operations.LoginPageFunc;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import Utils.Web_driver;
import io.qameta.allure.Allure;


public class ParentTest {

	protected WebDriver driver;
	TestDataReader TestDataReaderOBJ = new TestDataReader();
	
	 @BeforeClass
	    public void startBrowser(){
	        driver = Web_driver.getDriver();
	        driver.get(TestDataReaderOBJ.configFileReader().get("url"));
	        Allure.step("Getting the Url");
	    }
	 
	 protected static void logStep(String step){
	        Log.step(step);;
	    }


	    @AfterClass
	    public void closeBrowser(){
	        driver.quit();
	        Allure.step("Browser Closed!");
	    }
}
