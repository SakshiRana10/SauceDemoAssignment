package Utils;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Web_driver {
	
	 public static WebDriver getDriver(){
		   System.setProperty("webdriver.chrome.driver","C://Users//Sakshi.Rana//eclipse-workspace//mavenproject//resources//chromedriver.exe");
	        WebDriver driver = new ChromeDriver();
	        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	        driver.manage().window().maximize();
	        return driver;

	    }

}
