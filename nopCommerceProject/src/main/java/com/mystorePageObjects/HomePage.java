package com.mystorePageObjects;

import org.openqa.selenium.WebDriver;


import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myStoreBasePackage.BaseClass;
import com.mystoreActionDriver.Actoin;

public class HomePage extends BaseClass {

	Actoin action=new Actoin();
	
	@FindBy(xpath="//a[@class='ico-login']") WebElement SignIn;
	@FindBy(xpath="//span[@class=\"wishlist-label\"]") WebElement Whistlist;
	@FindBy(xpath="//span[@class=\"cart-label\"]") WebElement ShoppingCart;
	@FindBy(xpath="//a[@class=\"ico-account\"]") WebElement MyAccount;
	@FindBy(xpath="//a[text()=\"Log out\"]") WebElement logoutbtn;
	@FindBy(xpath="//input[@id=\"small-searchterms\"]") WebElement Searchbox;
	
	@FindBy(xpath="//button[@class=\"button-1 search-box-button\"]") WebElement searchbtn;
	
	
	public HomePage(WebDriver gerDriver) {
		
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean validatelogoutbtn() {
	
		return action.isDisplayed(getDriver(), logoutbtn);
	}

	public boolean ValidateCheckwhislt() {
		
		return action.isDisplayed(getDriver(), Whistlist);
	}
	
	public boolean ValidateShoppingCart() {
		
		return action.isDisplayed(getDriver(), ShoppingCart);
	}
	
	public String getCurrenturl() {
		
		String HomePAge=action.getCurrentURL(getDriver());
		return HomePAge;
	}
	
public SearchResultPage productsearch(String productName) {
		
		action.type(Searchbox, productName);
		
		action.JSClick(getDriver(), searchbtn);
		return new SearchResultPage(getDriver());
	}
	
	

}
