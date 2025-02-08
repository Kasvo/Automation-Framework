package com.test.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.actiondrivers.BrowserAction;
import com.test.base.BaseClass;

public class PLP extends BaseClass{
	
	@FindBy(xpath = "//div[contains(@class,'product-list-item')]")
	List<WebElement> plpItems ;
	
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
				break;
			}
		}
		if(!flag)System.out.println("Item not found");
		
	}
	
	

}
