package com.demo.pageobjectmodel.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.demo.pageobjectmodel.base.Basepage;

public class Launchpage extends Basepage{
	
	
	public Launchpage(WebDriver driver){
	    super(driver);
	}
	    
	
	public Loginpage gotopage(){
	
		
		driver.get("https://www.facebook.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return PageFactory.initElements(driver, Loginpage.class);
		
	}
	
	
	
	
}
