package TestCases;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Test;

import Operations.HomePageFunc;
import Operations.LoginPageFunc;
import io.qameta.allure.Description;

public class HomePageFlow extends ParentTest{
HomePageFunc HomePageFuncOBJ;
LoginPageFunc loginFlowFuncOBJ;
	
	@Test(priority=0)
    public void InitiateHomePage(){
		HomePageFuncOBJ = new 	HomePageFunc(driver);
		loginFlowFuncOBJ = new 	LoginPageFunc(driver);
		String username = TestDataReaderOBJ.configFileReader().get("StandardUsername");
		String password = TestDataReaderOBJ.configFileReader().get("password");
		loginFlowFuncOBJ.loginFlow(username, password);
    }
	

	@Test(dependsOnMethods = "InitiateHomePage", priority=1)
    @Description("Verify product cards are in correct order and visible after filtering low to high")
     public void verifycorrectOrderOfProductsFromLowtoHigh() {
		logStep("Filtering products low to high");
		HomePageFuncOBJ.filterProducts("lohi");
		
		
		logStep("Verifying Items are in correct order of prices");
		ArrayList<Float> pricesList = HomePageFuncOBJ.getProductPrices();
		Assert.assertTrue(HomePageFuncOBJ.ascendingCheck(pricesList));
    }
	
	@Test(dependsOnMethods = "InitiateHomePage", priority=2)
    @Description("Verify product cards are in correct order after filtering A to Z")
     public void verifycorrectOrderOfProductsFromHighToLow() {
		logStep("Filtering products  A to Z");
		HomePageFuncOBJ.filterProducts("az");
		
		logStep("Verifying Items are in correct order of names");
		ArrayList<String> namesList = HomePageFuncOBJ.getProductNames();
		Assert.assertTrue(HomePageFuncOBJ.ascendingCheckForString(namesList));
    }
	
	@Test(dependsOnMethods = "InitiateHomePage", priority=3)
    @Description("Verify Add to cart button on product cards")
     public void verifyCartBtnOnProductCards() {
		logStep("Getting the number of add to cart buttons");
		int btnCount = HomePageFuncOBJ.getAddToCartButtonCount();
		Assert.assertEquals(btnCount, 6);
    }
	
	@Test(dependsOnMethods = "InitiateHomePage", priority=4)
    @Description("Verify Clicking products takes to one view of product")
     public void verifyOneViewOfProducts() {
		logStep("Getting list of all products on the home page and clicking on product names");
		boolean flag = HomePageFuncOBJ.getProductCardsAndClickForOneView();
		
		logStep("Verifying one view was visible for all the product cards");
		Assert.assertTrue(flag);
    }
}
