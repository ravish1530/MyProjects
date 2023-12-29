package com.mystorePageObjects;

import org.openqa.selenium.WebDriver;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myStoreBasePackage.BaseClass;
import com.mystoreActionDriver.Actoin;

public class AddtoCartPage extends BaseClass{

   Actoin action=new Actoin();
 

	@FindBy(xpath="//select[@id=\"product_attribute_6\"]") WebElement Size;
	
	@FindBy(xpath="//select[@id=\"product_attribute_7\"]") WebElement Color;
	
	@FindBy(xpath="//label[@for=\"product_attribute_8_19\"]") WebElement LabelNatural;
	
	@FindBy(xpath="//label[@for=\"product_attribute_8_20\"]") WebElement LabelFresh;
	
	@FindBy(xpath="//input[@id=\"product_enteredQuantity_24\"]") WebElement Quantity;
	
	@FindBy(xpath="//button[@id=\"add-to-cart-button-24\"]") WebElement AddtoCart;
	
	@FindBy(xpath="//p[@class=\"content\"]") WebElement Validatecartmsg;
	
	@FindBy(xpath="//span[@class=\"close\"]") WebElement Closemsg;
	
	
	public AddtoCartPage(WebDriver getDriver) {
		
		PageFactory.initElements(getDriver(), this);
	}
	
	public void selectSize(String size
) {
		
		action.selectByVisibleText(size, Size);
		
	}
	
   public void selectColor(String color) {
		
		action.selectByVisibleText(color, Color);
	}
   
   public void selecPrintclr(String labelcolor
) {
		
		action.JSClick(getDriver(), LabelNatural);
	}
   
   public void EnterQuanity(String qty) {
	   
	   action.type(Quantity, qty);
   }

   public OrderPage clickonAddtoCart() {
	   
	  
	  action.JSClick(getDriver(), AddtoCart);
	   
	   return new OrderPage(getDriver());
	   
   }

   public boolean validateAddtoCart() {
	   action.fluentWait(getDriver(), Validatecartmsg, 10);
	   return action.isDisplayed(getDriver(), Validatecartmsg);
   }
   
   public OrderPage clickonClsmsg() {
	   
	   action.fluentWait(getDriver(), Closemsg, 10);
	   action.JSClick(getDriver(), Closemsg);
	   return new OrderPage(getDriver());
   }
}
