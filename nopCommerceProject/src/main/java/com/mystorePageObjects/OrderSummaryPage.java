package com.mystorePageObjects;

import org.openqa.selenium.WebDriver;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myStoreBasePackage.BaseClass;
import com.mystoreActionDriver.Actoin;

public class OrderSummaryPage extends BaseClass {

	
	Actoin action=new Actoin();
	

	@FindBy(xpath="//button[@class=\"button-1 payment-info-next-step-button\"]") WebElement Continue;
	
	public OrderSummaryPage(WebDriver getDriver) {
		
		PageFactory.initElements(getDriver(), this);
	}
	
	
	public OrderConfiramtion clickonContinue() {
		
		action.implicitWait(getDriver(), 30);
		action.Alert(getDriver());
		action.JSClick(getDriver(), Continue);
		
		return new OrderConfiramtion(getDriver());
	}
}
