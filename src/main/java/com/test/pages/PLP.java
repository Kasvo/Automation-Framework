package com.test.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.actiondrivers.BrowserAction;
import com.test.base.BaseClass;
import com.test.utilities.Log;

public class PLP extends BaseClass{
	
	@FindBy(xpath = "//div[contains(@class,'product-list-item')]")
	List<WebElement> plpItems ;
	
	@FindBy(css = "ol[class='breadcrumbs-list']")
	WebElement searchResult ;
	
	
	
	public PLP() {
		PageFactory.initElements(driver, this);
	}
	
	
	public void selectProduct(String productName ) {
		BrowserAction.waitForElement(driver, plpItems.get(0), 10);
		
		boolean flag = false;
		
		for(WebElement item : plpItems) {
			System.out.println(item.getText());
			if(item.getText().contains(productName)) {
				flag = true;
				item.click();
				Log.info("PDP Page", driver);
				break;
			}
		}
		if(!flag) {
			Log.fatal("Unable to Select Product");
		}
		
	}
	
	public boolean searchresult(String name) {
		BrowserAction.waitForElement(driver, searchResult, 10);
		Log.info("Results : "+searchResult.getText());
		if(searchResult.getText().toLowerCase().contains(name.toLowerCase())) {
			Log.info("Search Done",driver);
			return true;
		}
		return false;
	}
	
	

}
