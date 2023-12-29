package com.mystorePageObjects;

import org.openqa.selenium.WebDriver;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myStoreBasePackage.BaseClass;
import com.mystoreActionDriver.Actoin;

public class AddressPage extends BaseClass {

	Actoin action=new Actoin();
	
	@FindBy(xpath="//select[@id=\"BillingNewAddress_CountryId\"]") WebElement Countrydrp;
	
	@FindBy(xpath="//input[@id=\"BillingNewAddress_City\"]") WebElement CityTextbox;
	
	@FindBy(xpath="//input[@id=\"BillingNewAddress_Address1\"]") WebElement Address1;
	
	@FindBy(xpath="//input[@id=\"BillingNewAddress_ZipPostalCode\"]") WebElement zipCode;
	
	@FindBy(xpath="//input[@id=\"BillingNewAddress_PhoneNumber\"]") WebElement Phonenumber;
	
	@FindBy(xpath="//button[@onclick='if (!window.__cfRLUnblockHandlers) return false; Billing.save()']")
	WebElement Continue;
	
	
	
	
	
	
	public AddressPage(WebDriver getDriver) {
		
		PageFactory.initElements(getDriver(), this);
	}
	
	public ShippingPage SelectCountry(String country,String city,String address, String zipcode,String phn) {
		
		action.implicitWait(getDriver(), 40);
		action.selectByVisibleText(country, Countrydrp);
		
		action.type(CityTextbox, city);
		action.type(Address1, address);
		action.type(zipCode, zipcode);
		action.type(Phonenumber, phn);
		
		action.JSClick(getDriver(), Continue);
		
		return new ShippingPage(getDriver());
	}
}
