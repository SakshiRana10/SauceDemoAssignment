package TestCases;


import org.testng.Assert;
import org.testng.annotations.Test;

import Operations.CheckOutPageFunc;
import Operations.DeliveryDetailsPageFunc;
import Operations.HomePageFunc;
import Operations.LoginPageFunc;
import io.qameta.allure.Description;

public class CheckOutPageFlow extends ParentTest{
	
	LoginPageFunc loginFlowFuncOBJ;
	HomePageFunc HomePageFuncOBJ;
	CheckOutPageFunc CheckOutPageFuncOBJ;
	DeliveryDetailsPageFunc DeliveryDetailsPageFuncOBJ;

	@Test(priority=0)
    @Description("Login as standard user")
     public void verifyLoginAsStandardUser() {
		logStep("Filling credentials and logging into website");
		String username = TestDataReaderOBJ.configFileReader().get("StandardUsername");
		String password = TestDataReaderOBJ.configFileReader().get("password");
		loginFlowFuncOBJ = new LoginPageFunc(driver);
		HomePageFuncOBJ = new 	HomePageFunc(driver);
		loginFlowFuncOBJ.loginFlow(username, password);
		
		logStep("Verify successful login");
    	Assert.assertTrue(loginFlowFuncOBJ.successfulLogin());

    	Assert.assertTrue(HomePageFuncOBJ.productTitle()); 
    }
	
	@Test(priority=1, dependsOnMethods = "verifyLoginAsStandardUser")
    @Description("Add few products to the cart")
     public void verifyAddProductToCart() {
		HomePageFuncOBJ = new 	HomePageFunc(driver);
		logStep("Click add to cart button on homepage for product 1 and 4");
		HomePageFuncOBJ.clickAddtoCartBtn(1);
		HomePageFuncOBJ.clickAddtoCartBtn(4);
		
		logStep("verify products got added into the cart - add to cart button is changed to remove button");
	    Assert.assertTrue(HomePageFuncOBJ.removeButtonVisibleOnHomePage());
	    	
		logStep("verify products got added into the cart - Number of products on cart is 2");
		String count = HomePageFuncOBJ.productsonCart();
		Assert.assertEquals(count, "2");
    }
	
	@Test(priority=2, dependsOnMethods = "verifyLoginAsStandardUser")
    @Description("Checkout the cart")
     public void verifyCheckoutCart() {
		CheckOutPageFuncOBJ = new CheckOutPageFunc(driver);
		DeliveryDetailsPageFuncOBJ = new DeliveryDetailsPageFunc(driver);
		
		logStep("Click cart button on homepage");
		HomePageFuncOBJ.clickCartBtn();
		
		logStep("verify user landed on checkout page");
	    Assert.assertTrue(CheckOutPageFuncOBJ.cartPageTitle());
	    	
		logStep("verify products in cart as expected in number");
		int count = CheckOutPageFuncOBJ.getCartItemsCount();
		Assert.assertEquals(count, 2);
		
		logStep("Click on checkout button");
		CheckOutPageFuncOBJ.clickCheckOutBtn();
		
		logStep("verify User landed on delivery details page");
		 Assert.assertTrue(DeliveryDetailsPageFuncOBJ.verifyDeliveryPageTitle());
    }
	
	@Test(priority=3, dependsOnMethods = "verifyLoginAsStandardUser, verifyCheckoutCart")
    @Description("Add delivery details")
     public void verifyDeliveryDetails() {
		DeliveryDetailsPageFuncOBJ = new DeliveryDetailsPageFunc(driver);
		
		logStep("Fill firstname, lastname and zipcode");
		DeliveryDetailsPageFuncOBJ.fillDeliveryDetails("TestUser","TestUserSurname","110012");
		
		logStep("Click continue button");
		DeliveryDetailsPageFuncOBJ.clickContinueBtnOnDeliveryPage();
	    	
		logStep("verify products in cart as expected in number");
		int count = CheckOutPageFuncOBJ.getCartItemsCount();
		Assert.assertEquals(count, 2);
		
		logStep("Click on checkout button");
		CheckOutPageFuncOBJ.clickCheckOutBtn();
		
		logStep("verify User landed on delivery details page");
		 Assert.assertTrue(DeliveryDetailsPageFuncOBJ.verifyDeliveryPageTitle());
    }
	
	//remaining cases -  Review the checkout summary
    //                -  Place the order
    //                -  Order summary
}
