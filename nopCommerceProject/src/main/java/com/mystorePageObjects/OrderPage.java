package com.mystorePageObjects;

import org.openqa.selenium.WebDriver;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myStoreBasePackage.BaseClass;
import com.mystoreActionDriver.Actoin;

public class OrderPage extends BaseClass {

	Actoin action=new Actoin();

	@FindBy(xpath="//span[@class=\"cart-label\"]") WebElement ShoppingCart;

	@FindBy(xpath="//button[normalize-space()='Go to cart']") WebElement GotoCart;

	@FindBy(xpath="//span[@class=\"product-unit-price\"]") WebElement UnitPrice;

	@FindBy(xpath="//span[@class='value-summary']//strong[contains(text(),'$120.00')]") WebElement TotalPrice;

	@FindBy(xpath="//input[@id=\"termsofservice\"]") WebElement checkbox;
	
	@FindBy(xpath="//button[@id=\"checkout\"]") WebElement Checkout;

	public OrderPage(WebDriver getDriver) {

		PageFactory.initElements(getDriver(), this);
	}

	public void shopingcart() {

		action.implicitWait(getDriver(), 10);
		action.JSClick(getDriver(), ShoppingCart);
	}

	
	public double getUnitPrice() {

		String unitPrice1=UnitPrice.getText();
		String unit=unitPrice1.replaceAll("[^a-zA-Z0-9]","");
		double finalUnitPrice=Double.parseDouble(unit);
		return finalUnitPrice/100;
	}

	public double getTotalPrice() {

		String totalPrice1=TotalPrice.getText();
		String tot=totalPrice1.replaceAll("[^a-zA-Z0-9]","");
		double finalTotalPrice=Double.parseDouble(tot);
		return finalTotalPrice/100;
	}
	
	public void clickonCheckbox() {
		
		action.JSClick(getDriver(), checkbox);
	}

	public AddressPage clickOnCheckOut() throws Throwable {
		action.JSClick(getDriver(), Checkout);
		return new AddressPage(getDriver());
	}

}
