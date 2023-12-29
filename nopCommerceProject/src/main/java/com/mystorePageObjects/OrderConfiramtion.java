package com.mystorePageObjects;

import org.openqa.selenium.WebDriver;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myStoreBasePackage.BaseClass;
import com.mystoreActionDriver.Actoin;

public class OrderConfiramtion extends BaseClass{

	Actoin action=new Actoin();
	
	@FindBy(xpath="//button[@onclick=\"if (!window.__cfRLUnblockHandlers) return false; ConfirmOrder.save()\"]")
	WebElement Confirm;
	
	@FindBy(xpath="//strong[normalize-space()=\"Your order has been successfully processed!\"]")
	WebElement Successmsg;		
	
	@FindBy(xpath="//button[normalize-space()='Continue']") WebElement Continue;
	
	public OrderConfiramtion(WebDriver getDriver) {
		
		PageFactory.initElements(getDriver(), this);
		
		}
	
	public void clickonConfirm() {
		action.JSClick(getDriver(), Confirm);
	}
	
	public String validatemsg() {
		
		String confirmmsg=Successmsg.getText();
		return confirmmsg;
		
		
	}
	
	public void clickonContinue() {
		
		action.click(getDriver(), Continue);
	}
}
