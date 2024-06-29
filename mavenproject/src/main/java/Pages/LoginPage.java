package Pages;

import org.openqa.selenium.By;

public class LoginPage {
	public static final By usernameField= By.xpath("//input[@id='user-name']");
	public static final By passwordField= By.xpath("//input[@id='password']");
	public static final By loginBtn= By.xpath("//input[@id='login-button']");
	public static final By lockedOutPrompt= By.xpath("//h3[@data-test='error' and contains(text(),'Epic sadface: Sorry, this user has been locked out.')]");
	public static final By passwordNotMatchingPrompt= By.xpath("//h3[@data-test='error' and contains(text(),'Epic sadface: Username and password do not match any user in this service')]");
    public static final By loginLogo= By.xpath("//div[@class='login_logo']");
}
