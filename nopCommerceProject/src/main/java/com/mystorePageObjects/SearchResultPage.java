package com.mystorePageObjects;

import org.openqa.selenium.WebDriver;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myStoreBasePackage.BaseClass;
import com.mystoreActionDriver.Actoin;

public class SearchResultPage extends BaseClass{

	Actoin action=new Actoin();
	
	
	@FindBy(xpath="//h2[@class=\"product-title\"]/a[normalize-space()='Nike Floral Roshe Customized Running Shoes']")
	WebElement ProductResult;
	
	public SearchResultPage(WebDriver getDriver) {
		
		PageFactory.initElements(getDriver(), this);
	}
	
	
	public boolean isProductAvailable() {
		
		return action.isDisplayed(getDriver(), ProductResult);
	}
	
	public AddtoCartPage clickonProduct()
	{
		action.implicitWait(getDriver(), 30);
		action.JSClick(getDriver(), ProductResult);
		return new AddtoCartPage(getDriver());
	}
}
