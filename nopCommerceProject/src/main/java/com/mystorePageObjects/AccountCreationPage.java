package com.mystorePageObjects;

import org.openqa.selenium.WebDriver;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myStoreBasePackage.BaseClass;
import com.mystoreActionDriver.Actoin;

public class AccountCreationPage extends BaseClass{

	Actoin action=new Actoin();

	@FindBy(xpath="//h1[text()=\"Register\"]") WebElement FormTitle;

	@FindBy(xpath="//input[@id=\"gender-male\"]") WebElement Male;

	@FindBy(xpath="//input[@id=\"gender-female\"]") WebElement FeMale;

	@FindBy(xpath="//input[@id=\"FirstName\"]") WebElement FirstName;

	@FindBy(xpath="//input[@id=\"LastName\"]") WebElement LastName;

	@FindBy(xpath="//select[@name=\"DateOfBirthDay\"]") WebElement Day;

	@FindBy(xpath="//select[@name=\"DateOfBirthMonth\"]") WebElement Month;

	@FindBy(xpath="//select[@name=\"DateOfBirthYear\"]") WebElement Year;

	@FindBy(xpath="//input[@id=\"Email\"]") WebElement Email;

	@FindBy(xpath="//input[@id=\"Company\"]") WebElement CompanyName;

	@FindBy(xpath="//input[@id=\"Password\"]") WebElement Password;

	@FindBy(xpath="//input[@id=\"ConfirmPassword\"]") WebElement ConfirmPassword;

	@FindBy(xpath="//button[@id=\"register-button\"]") WebElement Registerbtn;

	@FindBy(xpath="//a[@class='button-1 register-continue-button']") WebElement Registercontinue;

	public AccountCreationPage(WebDriver getDriver) {

		PageFactory.initElements(getDriver(), this);
	}


	public void createAccount(String gender,String fName, 
			String lName, 

			String day, 
			String month, 
			String year,
			String comPany, 
			String email,String pswd, String confirmpwd
			)  {

		//		if(gender.equalsIgnoreCase("Male")) {
		//			action.click(getDriver(), Male);
		//		} else {
		//			action.click(getDriver(), FeMale);
		//		}

        action.implicitWait(getDriver(), 10);
       
		action.JSClick(getDriver(), Male);
		action.type(FirstName, fName);
		action.type(LastName, lName);

		action.selectByValue(Day, day);
		action.selectByValue(Month, month);
		action.selectByValue(Year, year);
		action.type(Email, email);
		action.type(CompanyName, comPany);
		action.type(Password, pswd);
		action.type(ConfirmPassword, confirmpwd);
		action.JSClick(getDriver(), Registerbtn);
	}

	public HomePage validateRegistration() throws Throwable {
		
		action.JSClick(getDriver(), Registercontinue);
		return new HomePage(getDriver());
	}

	public boolean validateAcountCreatePage() throws Throwable {
		return action.isDisplayed(getDriver(), FormTitle);
	}


}
