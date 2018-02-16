package com.demo.pageobjectmodel.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.demo.pageobjectmodel.pages.Launchpage;
import com.demo.pageobjectmodel.pages.Loginpage;
import com.demo.pageobjectmodel.testcases.base.Basetest;
import com.relevantcodes.extentreports.LogStatus;

public class LandingpageTest extends Basetest {
  
	@Test
	public void testlandingpage()
	{
		
		//System.setProperty("webdriver.chrome.driver", "D://Drivers//chromedriver.exe");
	    //WebDriver driver = new ChromeDriver();
		test = extent.startTest("LaunchPage", "This test case will launch the page");
		test.log(LogStatus.INFO, "launching the browser");
		openBrowser("Chrome");
		Launchpage launch= PageFactory.initElements(driver, Launchpage.class);
		Loginpage login= launch.gotopage();
		login.entercredentails();
		
	}
	
}
