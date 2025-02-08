package com.test.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.test.base.BaseClass;
import com.test.pages.HomePage;
import com.test.pages.PLP;
import com.test.utilities.Log;

public class TestCases extends BaseClass {
	
	@BeforeMethod
	public void setUp() {
		launchBrowser();
		
	}
	
	@Test(enabled = false)
	public void validateAboutPage() throws InterruptedException {
		Log.info("Home Page Loaded",driver);
		HomePage hp = new HomePage();
		hp.clickOnAboutPage();
		if(driver.getCurrentUrl().contains("aboutus")) {
			Log.info("User is in About page",driver);
		}else {
			Log.fatal("User is not in About Page");
			Assert.fail();
		}
	}
	
	@Test(enabled = false ,description = "Valid Wrong Credentials Error Message")
	public void checkErrorMessageForWrongCreds() {
		Log.info("Home Page Loaded",driver);
		HomePage hp = new HomePage();
		hp.login("test@gmail.com", "apple@!23");
		
		Assert.assertTrue(hp.validateIncorrectCredsAlert(), "No Alert showed up");
		

	}
	
	@Test(enabled = false)
	public void selectAnyCategory() throws InterruptedException {
		Log.info("Home Page Loaded",driver);
		HomePage hp = new HomePage();
		hp.clickOnBrowseByCategory();
		hp.selectCategory("Oil");
	}
	
	@Test(enabled = true)
	public void searchForProduct() throws InterruptedException {
		HomePage hp = new HomePage();
		PLP plp = new PLP();
		String searchFor = "Castor Oil";
		hp.searchforProduct(searchFor);
		hp.clickOnSearch();
		
		Assert.assertTrue(plp.searchresult(searchFor), "Search Fail");
		
		
	}
	
	@Test(enabled = true)
	public void navigateToPDPage() throws InterruptedException {
		HomePage hp = new HomePage();
		hp.searchforProduct("Oil");
		hp.clickOnSearch();
		
		PLP plp = new PLP();
		plp.selectProduct("Prime Guard Oil Filter");
	}
	
	@AfterMethod
	public void quiteBrowser() {
//		driver.quit();
	}

}
