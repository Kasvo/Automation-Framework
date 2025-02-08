package com.test.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.test.actiondrivers.BrowserAction;
import com.test.utilities.ExtentManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static Properties prop ;
	public static WebDriver driver ;
	
	
	@BeforeSuite
	public void loadconfig() {
		
		ExtentManager.setExtent();
		
		
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "/Configuration/config.properties");
			prop.load(ip);
		
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	
	public static void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		String browserName = prop.getProperty("browser");
		
		if(browserName.contains("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		
		//Maximize the screen
		driver.manage().window().maximize();
		//Delete all the cookies

		BrowserAction action = new BrowserAction();
		action.pageLoadTimeOut(driver, 20);
		action.implicitWait(driver, 10);
		//Launching the URL
		driver.get(prop.getProperty("url"));
	}
	
	@AfterSuite
	public void afterSuite() {
		ExtentManager.endReport();
	}

}
