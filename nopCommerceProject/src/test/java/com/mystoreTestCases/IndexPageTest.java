 package com.mystoreTestCases;

import org.testng.Assert;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.myStoreBasePackage.BaseClass;
import com.mystoreDataProvider.DataProviders;
import com.mystorePageObjects.IndexPage;
import com.mystoreUtility.Log;

public class IndexPageTest extends BaseClass {

	
private IndexPage indexPage;
    
	@Parameters("browser")
	@BeforeMethod (groups= {"Smoke","Sanity"})
	public void setup(String browser) {
		launchApp(browser);
		loadConfig();
	}
	
	@AfterMethod(groups = {"Smoke","Sanity"})
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test(groups = "Smoke",priority=1)

	public void verifyLogo()  {
		
		Log.startTestCase("verifyLogo");
		Log.info("VerifyLogo Smoke Test");
		indexPage= new IndexPage(getDriver());
		Log.info("User is going to click");
		boolean result=indexPage.validateLogo();
		Log.info("User clicked on sign In button");
		Assert.assertTrue(result);
		Log.endTestCase("verifyLogo");
	}
	
	@Test(dataProvider="searchProduct", dataProviderClass=DataProviders.class,groups="Sanity",priority=2)
	public void searchproduct(String productName) {
		Log.startTestCase("searchproduct");
		indexPage= new IndexPage(getDriver());
		
		Log.info("User clicked on searchbox");
		indexPage.SearchProduct(productName);
		Log.info("Product get displayed");
		Log.endTestCase("searchProduct");
	}
	
	@Test(groups = "Smoke",priority=3)
	public void verifyTitle() {
		Log.startTestCase("verifyTitle");
		Log.info("Verift Title Smoke Test");
		String actTitle=indexPage.myStoreTitle();
		Assert.assertEquals(actTitle, "nopCommerce demo store");
		Log.endTestCase("verifyTitle");
	}
}
