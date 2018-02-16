package com.demo.pageobjectmodel.testcases.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.demo.pageobjectmodel.util.Constants;
import com.demo.pageobjectmodel.util.ExtentManager;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class Basetest {
	
	public ExtentReports extent = ExtentManager.getInstance();
	public ExtentTest test;
	public WebDriver driver;
	
	WebDriver mozilla=null;
	WebDriver chrome=null;
	WebDriver ie=null;
	
     public void openBrowser(String browserType){
		
		
		if(browserType.equals("Mozilla") && mozilla==null){
			driver = new FirefoxDriver();
			mozilla=driver;
		}else if(browserType.equals("Mozilla") && mozilla!=null){
			driver=mozilla;
		}else if(browserType.equals("Chrome") && chrome==null){
		System.setProperty("webdriver.chrome.driver",Constants.CHROME_DRIVER_EXE);
			
			driver=new ChromeDriver();
			chrome=driver;
			
		}else if(browserType.equals("Chrome") && chrome!=null){
			driver=chrome;
		}
		
		else if(browserType.equals("IE")){
			// set the IE server exe path and initialize
		}
		// max
		driver.manage().window().maximize();
		// implicit wait
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

}
