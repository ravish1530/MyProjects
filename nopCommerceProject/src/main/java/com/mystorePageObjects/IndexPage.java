package com.mystorePageObjects;

import org.openqa.selenium.WebDriver;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myStoreBasePackage.BaseClass;
import com.mystoreActionDriver.Actoin;

public class IndexPage extends BaseClass{

	Actoin action=new Actoin();
	
	@FindBy(xpath="//a[@class='ico-login']") WebElement SignIn;
	
	@FindBy(xpath="//img[@alt=\"nopCommerce demo store\"]") WebElement nopcomLogo;
	
	@FindBy(xpath="//input[@id=\"small-searchterms\"]") WebElement Searchbox;
	
	@FindBy(xpath="//button[@class=\"button-1 search-box-button\"]") WebElement searchbtn;
	
	public IndexPage(WebDriver getDriver) {
		
		PageFactory.initElements(getDriver(), this);
	}
	
	public LoginPage ClickonLogin() {
		
		action.fluentWait(getDriver(), SignIn, 20);
		action.JSClick(getDriver(), SignIn);
		
		
		return new LoginPage(getDriver());
	}
	
	
	public void SearchProduct(String productName) {
		
		action.fluentWait(getDriver(), Searchbox, 0);
		action.JSClick(getDriver(), Searchbox);
		action.JSClick(getDriver(), searchbtn);
	}
	
	public boolean validateLogo() {
		
		return action.isDisplayed(getDriver(), nopcomLogo);
	}
	
	public String myStoreTitle() {
		
		String StoreTitle=getDriver().getTitle();
		return StoreTitle;
	}
	
	
}
