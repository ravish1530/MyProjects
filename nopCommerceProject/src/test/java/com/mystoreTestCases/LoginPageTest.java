package com.mystoreTestCases;


import org.testng.Assert;






import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.myStoreBasePackage.BaseClass;
import com.mystoreDataProvider.DataProviders;
//import com.mystorePageObjects.HomePage;
import com.mystorePageObjects.IndexPage;
import com.mystorePageObjects.LoginPage;
import com.mystorePageObjects.OrderConfiramtion;
import com.mystorePageObjects.OrderPage;
import com.mystorePageObjects.OrderSummaryPage;
import com.mystorePageObjects.PaymentPage;
import com.mystorePageObjects.HomePage;
import com.mystorePageObjects.AccountCreationPage;
import com.mystorePageObjects.AddressPage;
import com.mystorePageObjects.AddtoCartPage;
import com.mystorePageObjects.SearchResultPage;
import com.mystorePageObjects.ShippingPage;
import com.mystoreUtility.Log;

public class LoginPageTest extends BaseClass{
	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homepage;
	AccountCreationPage accountpage;
	SearchResultPage searchresultpage;
	AddtoCartPage addtocart;
	OrderPage orderpage;
	AddressPage addresspage;
	ShippingPage shippingpage;
	PaymentPage paymentpage;
	OrderSummaryPage ordersummarypage;
	OrderConfiramtion orderconfirmationpage;

	@Parameters("browser")
	@BeforeMethod (groups = {"Smoke","Sanity"})
	public void setup(String browser) {
		launchApp(browser); 
		loadConfig();
	}

	@AfterMethod (groups = {"Smoke","Sanity"})
	public void tearDown() {
		getDriver().quit();
	}

	@Test   (dataProvider = "getProduct", dataProviderClass = DataProviders.class)
	public void loginTest(String productName,String size, String color,String labelcolor,String qty) throws Throwable 
	{

		Log.startTestCase("Login Test");
		indexPage=new IndexPage(getDriver());
//		loginPage=new LoginPage(getDriver());
//		homepage=new  HomePage(getDriver());
//		accountpage=new AccountCreationPage(getDriver());
//		searchresultpage=new SearchResultPage(getDriver()) ;
//		addtocart=new AddtoCartPage (getDriver());
//		orderpage=new OrderPage(getDriver());
//		addresspage=new AddressPage(getDriver());
//		shippingpage=new ShippingPage(getDriver()) ;
//		paymentpage=new PaymentPage(getDriver()) ;
//		ordersummarypage=new OrderSummaryPage(getDriver()) ;
//		orderconfirmationpage=new OrderConfiramtion(getDriver()); 


		loginPage=indexPage.ClickonLogin();
		//accountpage=loginPage.CreatteNewAccount();
		//accountpage.createAccount("Male", "Ravi", "User", "1", "1", "2000", "useradmin", "ravishinde1514@gmail.com", "user@123", "user@123");
		//homepage=accountpage.validateRegistration();
		
		homepage=loginPage.Login("ravishinde1514@gmail.com", "user@123");
		homepage.ValidateCheckwhislt();
		homepage.ValidateShoppingCart();
		boolean logout=homepage.validatelogoutbtn();
		Assert.assertTrue(logout);

		searchresultpage=homepage.productsearch(productName);
		boolean product=searchresultpage.isProductAvailable();
		Assert.assertTrue(product);

		addtocart=searchresultpage.clickonProduct();
		addtocart.selectSize(size);
		addtocart.selectColor(color);
		addtocart.selecPrintclr(labelcolor);
		addtocart.EnterQuanity(qty);
		addtocart.clickonAddtoCart();
		boolean cart=addtocart.validateAddtoCart();

		Assert.assertTrue(cart);

		orderpage=addtocart.clickonClsmsg();

		orderpage.shopingcart();
		double unitPrice= orderpage.getUnitPrice();
		double totalPrice=orderpage.getTotalPrice();
		double totalexpectedprice=(unitPrice*(Double.parseDouble(qty)));
		

		Assert.assertEquals(totalPrice, totalexpectedprice);

		orderpage.clickonCheckbox();
		addresspage=orderpage.clickOnCheckOut();

		shippingpage=addresspage.SelectCountry("India", "Mumbai", "Ghatkopar West", "400084", "9988777889");

		paymentpage=shippingpage.selectshippingMethod(qty);
		ordersummarypage=paymentpage.clickonPaymentMethod();
		orderconfirmationpage=ordersummarypage.clickonContinue();
		orderconfirmationpage.clickonConfirm();
		orderconfirmationpage.clickonContinue();


		



	}



}
