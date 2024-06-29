package Pages;

import org.openqa.selenium.By;
public class HomePage {
	//elements are found here, all by xpaths:
	public static final By homePageTitle= By.xpath("//title[contains(text(), 'Swag Labs')]");
	public static final By productTitle= By.xpath("//div[@class='header_secondary_container']//span[@class='title']");
	public static final By productSort= By.xpath("//select[@class='product_sort_container']");
	public static final By inventoryList= By.xpath("//div[@class='inventory_list']//div[@class='inventory_item']");
	public static final By productItemPrice= By.xpath("//div[@class='inventory_list']//div[@class='pricebar']//div[@class='inventory_item_price']");
	public static final By productItemName= By.xpath("//div[@class='inventory_list']//div[@class='inventory_item_name']");	
	public static final By addToCartBtn= By.xpath("//button[@class='btn btn_primary btn_small btn_inventory ']");	
	public static final By itemContainer= By.xpath("//div[@id='inventory_item_container']");
	public static final By removeBtn= By.xpath("//button[@class='btn btn_secondary btn_small btn_inventory ']");
	public static final By productsOnCart= By.xpath("//span[@class='shopping_cart_badge']");
	public static final By cartBtn= By.xpath("//a[@class='shopping_cart_link']");
	public static final By sideBar = By.xpath("//button[@id='react-burger-menu-btn']");
	public static final By logoutLink = By.xpath("//a[@data-test='logout-sidebar-link']");
	
    
 }
