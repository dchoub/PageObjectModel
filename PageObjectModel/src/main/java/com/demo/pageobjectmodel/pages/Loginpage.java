package com.demo.pageobjectmodel.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.demo.pageobjectmodel.base.Basepage;

public class Loginpage extends Basepage{
	
	@FindBy(xpath= "//input[@type='email']")
    public WebElement Email;
			
	@FindBy(xpath= "//input[@id='pass']")
    public WebElement Password;
	
	
	
	 public Loginpage(WebDriver driver){
		 super(driver);
		 
	 }
	 
	 
	 
	 public void entercredentails(){
		 Email.sendKeys("dhwani.chidiya@gmail.com");
		 Password.sendKeys("radheradhe");
		 
	 }

}
