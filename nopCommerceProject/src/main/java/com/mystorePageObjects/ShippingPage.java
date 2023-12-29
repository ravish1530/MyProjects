package com.mystorePageObjects;

import org.openqa.selenium.WebDriver;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myStoreBasePackage.BaseClass;
import com.mystoreActionDriver.Actoin;

public class ShippingPage extends BaseClass {

	Actoin action=new Actoin();
	
   @FindBy(xpath="//input[@id=\"shippingoption_0\"]") WebElement ShippingbyLand;
	
	@FindBy(xpath="//input[@id=\"shippingoption_1\"]") WebElement ShippingbyonedayAir;
	
	@FindBy(xpath="//input[@id=\"shippingoption_2\"]") WebElement ShippingbytwodayWater;
	
	@FindBy(xpath="//button[@class='button-1 shipping-method-next-step-button']") WebElement Continue;
	
	
	public ShippingPage(WebDriver getDriver) {
		
		PageFactory.initElements(getDriver(), this);
	}
	
	
	public PaymentPage selectshippingMethod(String shiping) {
		
//		if(shiping.equalsIgnoreCase("Shipping by land transport")) {
//			
//			action.click(getDriver(), ShippingbyLand);
//		}
//		else if(shiping.equalsIgnoreCase("The one day air shipping")) {
//			action.click(getDriver(), ShippingbyonedayAir);
//		}
//		else if(shiping.equalsIgnoreCase("The two day air shipping")) {
//			action.click(getDriver(), ShippingbytwodayWater);
//		}
		
		action.JSClick(getDriver(), ShippingbyLand);
		
		action.JSClick(getDriver(), Continue);
		
		return new PaymentPage(getDriver());
	}
}
