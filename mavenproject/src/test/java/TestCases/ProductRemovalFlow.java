package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import Operations.HomePageFunc;
import Operations.LoginPageFunc;
import io.qameta.allure.Description;

public class ProductRemovalFlow extends ParentTest {
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
	
	@Test(priority=1, dependsOnMethods = "InitiateHomePage")
    @Description("Removing a product from cart")
     public void verifyAddProductToCart() {
		logStep("Click add to cart button on homepage amd add two products in cart");
		HomePageFuncOBJ.clickAddtoCartBtn(0);
		HomePageFuncOBJ.clickAddtoCartBtn(1);
		
		logStep("verify products got added into the cart - add to cart button is changed to remove button");
	    Assert.assertTrue(HomePageFuncOBJ.removeButtonVisibleOnHomePage());
	    	
	    logStep("click remove from cart button for one of the products");
	    HomePageFuncOBJ.clickRemoveBtn(1);
	    
		logStep("verify one of the product got removed from the cart - Number of products on cart is 1");
		String count = HomePageFuncOBJ.productsonCart();
		Assert.assertEquals(count, "1");
    }
}
