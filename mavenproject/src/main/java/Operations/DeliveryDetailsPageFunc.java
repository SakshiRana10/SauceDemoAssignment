package Operations;

import org.openqa.selenium.WebDriver;

import Pages.DeliveryDetailsPage;

public class DeliveryDetailsPageFunc extends Actions {

	public DeliveryDetailsPageFunc(WebDriver driver) {
		super(driver);
	}
	
	public boolean verifyDeliveryPageTitle() {
		if(elementfind(DeliveryDetailsPage.deliveryPageTitle)) {
			return(true);
		}
		else {
			return(false);
		}
	}
	
	public void fillDeliveryDetails(String firstName, String lastName, String zipcode) {
		Text(DeliveryDetailsPage.firstName, firstName);
		Text(DeliveryDetailsPage.lastName, lastName);
		Text(DeliveryDetailsPage.zipCode, zipcode);
	}
	
	public void clickContinueBtnOnDeliveryPage() {
		click(DeliveryDetailsPage.continueBtn);
	}

}
