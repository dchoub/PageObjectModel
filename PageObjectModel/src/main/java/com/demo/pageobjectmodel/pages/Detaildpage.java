package com.demo.pageobjectmodel.pages;

import org.openqa.selenium.WebDriver;

import com.demo.pageobjectmodel.base.Basepage;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Detaildpage extends Basepage {
	
	public Detaildpage(WebDriver driver, ExtentTest test){
	super(driver,test);
	}
	
	
	
	public void selectProduct(String object){
		
		test.log(LogStatus.INFO, "in select product");
		String Element = "//div[@class='product-image-container']/a[@title=" +"'"+object+"'"+"]";
		boolean ClickSuccess = isElementPresent(Element);
		if (ClickSuccess){
			test.log(LogStatus.INFO, "Product is present " +object);
			MouseHoverOnElement(Element);
			
			
		}
		else{
			test.log(LogStatus.FAIL, "Product is not present " +object);
		}

		
		
	}

}
