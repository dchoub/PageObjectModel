package com.demo.pageobjectmodel.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.demo.pageobjectmodel.pages.Launchpage;
import com.demo.pageobjectmodel.pages.Loginpage;
import com.demo.pageobjectmodel.testcases.base.Basetest;
import com.relevantcodes.extentreports.LogStatus;

public class Landingpagetest extends Basetest {
	WebDriver driver;
	
  
	@Test
	public void testlandingpage()
	{
		
		System.setProperty("webdriver.chrome.driver", "D://Drivers//chromedriver.exe");
	    WebDriver driver = new ChromeDriver();
		test = extent.startTest("LaunchPage", "This test case will launch the page");
		test.log(LogStatus.INFO, "launching the browser");
		//openBrowser("Chrome");
		Launchpage launchpage = new Launchpage(driver,test);
		PageFactory.initElements(driver, launchpage);
		//Launchpage launch= PageFactory.initElements(driver, Launchpage.class);
		Loginpage login= launchpage.gotopage();
		//login.entercredentails(String Username, String password);
		
	}
	
	@AfterMethod
	public void quit(){
		if(extent!=null){
			extent.endTest(test);
			extent.flush();
		}
		
	}
	
	
	
}
