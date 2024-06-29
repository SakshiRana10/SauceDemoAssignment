package Operations;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class Actions {
	
	protected final WebDriver driver;
    protected Actions(WebDriver driver){
        this.driver=driver;
    }
    
    public void click(By element) {
        driver.findElement(element).click();    //click action
    }

    public void Text(By element, String text) {
        driver.findElement(element).sendKeys(text);    //writing data into fields 
    }
    
    public String GetText(By element){
        return driver.findElement(element).getText();   //retrieving text from pages to validate correct page is landed
    }
    
    public boolean elementfind(By element) {            //seeing if element is actually present or not 
        if(driver.findElement(element)!=null)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public boolean TextEquals(String data, By element){      //matching texts
        String text= GetText(element);
        System.out.println(text);
        System.out.print(data);
        if(text.equals(data)){
            return true;
        }
        else{
            return false;
        }
    }
    
    public void clearText(By element) {
    	driver.findElement(element).clear();
    }

    public ArrayList<WebElement> GetList(By element) {
    	ArrayList<WebElement> list = (ArrayList<WebElement>) driver.findElements(element);
    	return list;
    }
    
    public void selectFromDropdown(By element, String value) {
    	WebElement ele = driver.findElement(element);
    	Select select = new Select(ele);
    	select.selectByValue(value);
    }
   
}

