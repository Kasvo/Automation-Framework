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
	
	@Test(enabled = true)
	public void checkHomePage() throws InterruptedException {
		Log.info("Home Page Loaded",driver);
		HomePage hp = new HomePage();
		hp.clickOnBrowseByCategory();
		hp.selectCategory("Oil");
		Thread.sleep(3000);
	}
	
	@Test(enabled = false)
	public void searchForProduct() throws InterruptedException {
		HomePage hp = new HomePage();
		hp.searchforProduct("Bike Oil");
		
	}
	
	@Test(enabled = false)
	public void navigateToPDPage() throws InterruptedException {
		HomePage hp = new HomePage();
		hp.searchforProduct("Oil");
		hp.clickOnSearch();
		
		PLP plp = new PLP();
		plp.selectProduct("Prime Guard Oil Filter");
	}
	

	
	
	@AfterMethod
	public void quiteBrowser() {
		driver.quit();
	}

}
