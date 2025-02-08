package com.test.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.actiondrivers.BrowserAction;
import com.test.base.BaseClass;

public class HomePage extends BaseClass {

	@FindBy(xpath = "//*[@data-siteid='HIGHLINE-AFTERMARKET-Site']")
	WebElement searchBar ;
	
	@FindBy(xpath = "//button[@name='search']")
	WebElement searchButton ;
	
	@FindBy(xpath = "//*[name()='circle' and contains(@cx,'10')]")
	WebElement closePopup ;
	
	@FindBy(css = "a[title='Browse By Category']")
	WebElement browseByCategory ;
	
	@FindBy(xpath = "//li[@class='main-navigation-level1-item']")
	List<WebElement> browseByCategoryItems ;
	
	
	
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public void popUpClose() {
		BrowserAction.waitForElement(driver, closePopup,10);
		closePopup.click();
	}
	
	public void searchforProduct(String itemName){
		searchBar.sendKeys(itemName);
	}
	
	public void clickOnSearch() {
		BrowserAction.waitForElement(driver, searchButton, 20);
		searchButton.click();
		
	}
	
	public void clickOnBrowseByCategory() {
		BrowserAction.waitForElement(driver, browseByCategory,10);
		browseByCategory.click();
	}
	
	public void selectCategory(String categoryName) {
		BrowserAction.waitForElement(driver, browseByCategoryItems.get(0), 10);
		
		boolean flag = false;
		for(WebElement item : browseByCategoryItems) {
			if(item.getText().contains(categoryName)) {
				flag= true;
				item.click();
				break;
			}
		}
		
		if(!flag)System.out.println("category not found");
	}
	
	public void selectCategory(String categoryName , String subCategoryName) {
		BrowserAction.waitForElement(driver, browseByCategoryItems.get(0), 10);
		
		boolean flag = false;
		
		for(WebElement item : browseByCategoryItems) {
			System.out.println(item.getText());
			if(item.getText().contains(categoryName)) {
				flag = true;
				item.click();
				break;
			}
		}
		if(!flag)System.out.println("category not found");
		
	}
	

}
