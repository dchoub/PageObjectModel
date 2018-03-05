package com.demo.pageobjectmodel.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.demo.pageobjectmodel.base.Basepage;
import com.demo.pageobjectmodel.util.Constants;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Loginpage extends Basepage{
	
	@FindBy(xpath= "//input[@type='email']")
    public WebElement Email;
			
	@FindBy(xpath= "//input[@id='pass']")
    public WebElement Password;
	
	
	
	//public ExtentTest test;
	
	 public Loginpage(WebDriver driver, ExtentTest test){
		 super(driver, test);
		 
	 }
	 
	 
	 
	 public Object entercredentails(String Username, String Pass){
		 test.log(LogStatus.INFO, "entering the credenatils");
		 Email.sendKeys(Username);
		 Password.sendKeys(Pass);
		 Password.sendKeys(Keys.ENTER);
		 
		 boolean loginSuccess = isElementPresent(Constants.PROFILEPAGE_LINK);
		 if (loginSuccess){
			 
			 test.log(LogStatus.INFO, "Login is successfull");
			 Landingpage landing = new Landingpage(driver,test);
			 PageFactory.initElements(driver, landing);
			 return landing;
		 }
		 else {
			 test.log(LogStatus.INFO, "Login is not successfull");
			 
			 Loginpage login = new Loginpage(driver,test);
			 PageFactory.initElements(driver, login);
			 return login;
		 }
		 
		 
		 
		 
	 }

}
