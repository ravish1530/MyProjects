/**
 * 
 */
package com.mystorePageObjects;

import org.openqa.selenium.WebDriver;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myStoreBasePackage.BaseClass;
import com.mystoreActionDriver.Actoin;

/**
 * @author ravik
 *
 */
public class PaymentPage extends BaseClass {
	Actoin action=new Actoin();
	
   @FindBy(xpath="//input[@id=\"paymentmethod_0\"]") WebElement PaybyCheck;
	
	@FindBy(xpath="//input[@id=\"paymentmethod_1\"]") WebElement PaybyCredit;
	
	@FindBy(xpath="//button[@class='button-1 payment-method-next-step-button']") WebElement Continue;

	public PaymentPage(WebDriver getDriver) {
		
		PageFactory.initElements(getDriver(), this);
	}
	
	
	public OrderSummaryPage clickonPaymentMethod() {
		
		action.JSClick(getDriver(), PaybyCheck);
		
		action.JSClick(getDriver(), Continue);
		
		return new OrderSummaryPage(getDriver());
	}

}
