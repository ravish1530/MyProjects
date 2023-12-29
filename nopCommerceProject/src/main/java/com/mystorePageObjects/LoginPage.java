package com.mystorePageObjects;

import org.openqa.selenium.WebDriver;


import org.openqa.selenium.WebElement;


import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myStoreBasePackage.BaseClass;
import com.mystoreActionDriver.Actoin;

public class LoginPage extends BaseClass {

	Actoin action=new Actoin();
	
private	@FindBy(xpath="//a[@class='ico-login']") WebElement SignIn;
	
	@FindBy(xpath="//input[@id=\"Email\"]") WebElement emailField;
	
	@FindBy(xpath="//input[@id=\"Password\"]") WebElement passwordField;
	
	@FindBy(xpath="//button[@class=\"button-1 login-button\"]") WebElement Loginbtn;
	
	@FindBy(xpath="//input[@id=\"RememberMe\"]") WebElement RememberMe;
	
	@FindBy(xpath="//button[text()=\"Register\"]") WebElement Resgisterbtn;

	public  LoginPage(WebDriver getDriver) {
	
		PageFactory.initElements(getDriver(), this);
	}
	
	public HomePage Login(String Username,String	Password) {
		
	action.implicitWait(getDriver(), 70);
		
		action.JSClick(getDriver(), SignIn);
		action.type(emailField, Username);
		action.type(passwordField, Password);

		action.JSClick(getDriver(), RememberMe);
		
		action.JSClick(getDriver(), Loginbtn);
		
		
		return new HomePage(getDriver());
		  
	}
	

	
	
	
	public AccountCreationPage CreatteNewAccount() {
		
		action.click(getDriver(), SignIn);
		
		action.JSClick(getDriver(), Resgisterbtn);
		
		return new AccountCreationPage(getDriver());
	}
}
