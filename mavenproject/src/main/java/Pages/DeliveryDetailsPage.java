package Pages;

import org.openqa.selenium.By;

public class DeliveryDetailsPage {
	public static final By deliveryPageTitle= By.xpath("//span[@data-test='title']");
	public static final By firstName= By.xpath("//input[@id='first-name']");
	public static final By lastName= By.xpath("//input[@id='last-name']");
	public static final By zipCode= By.xpath("//input[@id='postal-code']");
	public static final By continueBtn= By.xpath("//input[@id='continue']");
}
