package com.test.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.actiondrivers.BrowserAction;
import com.test.base.BaseClass;
import com.test.utilities.Log;

public class HomePage extends BaseClass {

	@FindBy(xpath = "//*[@data-siteid='HIGHLINE-AFTERMARKET-Site']")
	WebElement searchBar ;
	
	@FindBy(xpath = "//button[@name='search']")
	WebElement searchButton ;
	
	@FindBy(xpath = "//*[name()='circle' and contains(@cx,'10')]")
	WebElement closePopup ;
	
	@FindBy(css = "a[title='Browse By Category']")
	WebElement browseByCategory ;
	
	@FindBy(xpath = "//li[@class='main-navigation-level1-item']/div/a")
	List<WebElement> browseByCategoryItems ;
	
	@FindBy(css = "a[title='About']")
	WebElement aboutPage ;
	
	@FindBy(id = "ShopLoginForm_Login")
	WebElement usernameField ;
	
	@FindBy(name = "ShopLoginForm_Password")
	WebElement passwordField ;
	
	@FindBy(name = "login")
	WebElement loginButton ;
	
	@FindBy(css = "div[role='alert']")
	WebElement incorrectCredsAlert ;
	
	
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public void login(String username , String password) {
		BrowserAction.waitForElement(driver, usernameField,10);
		usernameField.sendKeys(username);
		Log.info("Username Entered");
		passwordField.sendKeys(password);
		Log.info("Password Entered");
		
		loginButton.click();
		Log.info("Login Button clicked");
		
	}
	
	public boolean validateIncorrectCredsAlert() {
		
		if(BrowserAction.waitForElement(driver, incorrectCredsAlert,20)) {
			Log.info("Alert showed up for Incorrect credentials",driver);
			return true;
		}
		
		return false;
	}
	
	public void popUpClose() {
		BrowserAction.waitForElement(driver, closePopup,10);
		closePopup.click();
	}
	
	public void searchforProduct(String itemName){
		BrowserAction.waitForElement(driver, searchBar,10);
		searchBar.sendKeys(itemName);
		Log.info("Enter search value : "+itemName);
	}
	
	public void clickOnSearch() {
		BrowserAction.waitForElement(driver, searchButton, 20);
		searchButton.click();
		Log.info("Search Button Clicked");
		
	}
	
	public void clickOnBrowseByCategory() {
		BrowserAction.waitForElement(driver, browseByCategory,10);
		browseByCategory.click();
		Log.info("BrowseByCategory Selected");
	}
	
	public void selectCategory(String categoryName) throws InterruptedException {
		BrowserAction.waitForElement(driver, browseByCategoryItems.get(0), 10);
		
		boolean flag = false;
		System.out.println("No. of items :" +browseByCategoryItems.size());
		for(WebElement item : browseByCategoryItems) {
			if(item.getText().toLowerCase().contains(categoryName.toLowerCase())) {
				flag = true;
				Log.info(item.getText() + " selected");
				item.click();

				break;
			}
		}
		
		if(!flag) {
			Log.fatal(categoryName+" not found");;
		}
	}
	

	
	public void clickOnAboutPage() {
		BrowserAction.waitForElement(driver, aboutPage, 10);
		aboutPage.click();
		Log.info("About section clicked");
	}
	

}
