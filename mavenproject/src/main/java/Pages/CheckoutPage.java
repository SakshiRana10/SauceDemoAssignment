package Pages;

import org.openqa.selenium.By;

public class CheckoutPage {
	public static final By cartPageTitle= By.xpath("//span[@class='title']");
	public static final By cartItems= By.xpath("//div[@class='cart_list']//div[@class='cart_item']");
	public static final By checkOutButton= By.xpath("//button[@id='checkout']");
}
