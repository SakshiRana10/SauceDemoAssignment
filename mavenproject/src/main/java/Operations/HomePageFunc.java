package Operations;


import Pages.HomePage;
import Pages.LoginPage;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

public class HomePageFunc extends Actions{
	
	public HomePageFunc(WebDriver driver) {     
		super(driver);
	}
	
	
	public boolean productTitle() {
        if(elementfind(HomePage.productTitle)) {
        	return(true);
        }
        else {
        	return(false);
        }

    }
	
	public void filterProducts(String order) {
		selectFromDropdown(HomePage.productSort, order);
	}
	
	
	public ArrayList<Float> getProductPrices() {
		ArrayList<WebElement> priceList = GetList(HomePage.productItemPrice);
		ArrayList<Float> prices = new ArrayList<Float>();
		for (int i = 0; i < priceList.size(); i++) {
			prices.add(Float.parseFloat(priceList.get(i).getText().replace("$", ""))); 
		}
		return prices;
	}
	
	public ArrayList<String> getProductNames() {
		ArrayList<WebElement> NameList = GetList(HomePage.productItemName);
		ArrayList<String> names = new ArrayList<String>();
		for (int i = 0; i < NameList.size(); i++) {
			names.add(NameList.get(i).getText()); 
		}
		return names;
	}
	
	public boolean getProductCardsAndClickForOneView() {
		boolean flag = true;
		ArrayList<WebElement>List = GetList(HomePage.productItemName);
		for (int i = 0; i < List.size(); i++) {
			List.get(i).click();
			if(!elementfind(HomePage.itemContainer)) {
				flag = false;
			}
		}
		return flag;
	}
	
	public int getAddToCartButtonCount() {
		ArrayList<WebElement> cartBtnList = GetList(HomePage.addToCartBtn);
		return cartBtnList.size();
	}
	
	public void clickAddtoCartBtn(int productNumber) {
		ArrayList<WebElement> cartBtnList = GetList(HomePage.addToCartBtn);
		cartBtnList.get(productNumber).click();
	}
	
	public void clickCartBtn() {
		click(HomePage.cartBtn);
	}
	
	public void clickRemoveBtn(int productNumber) {
		ArrayList<WebElement> removeBtnList = GetList(HomePage.removeBtn);
		removeBtnList.get(productNumber).click();
	}
	
	public void clickSideBar() {
		click(HomePage.sideBar);
	}
	
	public void clicklogOutLink() {
		click(HomePage.logoutLink);
	}
	
	public boolean ascendingCheck(ArrayList<Float> data){         
        for (int i = 0; i < data.size()-1; i++) {
            if (data.get(i) > data.get(i+1)) {
                return false;
            }       
         }
        return true;		
	}
	
	public boolean ascendingCheckForString(ArrayList<String> data) {
		boolean isSorted = true;
		for(int i = 0; i < data.size() - 1; i++) {
		   if(data.get(i).compareToIgnoreCase(data.get(i + 1)) > 0) { 
		       isSorted = false;
		       break;
		   }
		}
		return isSorted;
	}
	
	public boolean removeButtonVisibleOnHomePage() {
        if(elementfind(HomePage.removeBtn)) {
        	return(true);
        }
        else {
        	return(false);
        }

    }
	
	public String productsonCart() {
		String countOfProducts = GetText(HomePage.productsOnCart);
		return countOfProducts;	
	}
	

}
