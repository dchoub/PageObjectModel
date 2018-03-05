package com.demo.pageobjectmodel.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.demo.pageobjectmodel.base.Basepage;
import com.demo.pageobjectmodel.util.Constants;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Launchpage extends Basepage{
	//ExtentTest test;
	
	public Launchpage(WebDriver driver, ExtentTest test){
	    super(driver,test);
	}
	    
	
	public Loginpage gotopage(){
	    
		test.log(LogStatus.INFO, "now we are launchin the page");
		driver.get(Constants.url);
		
		Loginpage login = new Loginpage(driver, test);
		PageFactory.initElements(driver, login);
		return login;
		
	}
	
	
	
	
}
