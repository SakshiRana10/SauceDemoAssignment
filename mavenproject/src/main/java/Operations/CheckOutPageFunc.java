package Operations;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Pages.CheckoutPage;
import Pages.HomePage;

public class CheckOutPageFunc extends Actions{

	public CheckOutPageFunc(WebDriver driver) {
		super(driver);
	}
	
	public boolean cartPageTitle() {
		if(elementfind(CheckoutPage.cartPageTitle)) {
			return(true);
		}
		else {
			return(false);
		}
	}
	
	public int getCartItemsCount() {
		ArrayList<WebElement> cartItems = GetList(CheckoutPage.cartItems);
		return cartItems.size();
	}
	
	public void clickCheckOutBtn() {
		click(CheckoutPage.checkOutButton);
	}

}
