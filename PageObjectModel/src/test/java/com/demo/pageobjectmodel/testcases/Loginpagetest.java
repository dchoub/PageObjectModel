package com.demo.pageobjectmodel.testcases;

import java.util.Hashtable;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.demo.pageobjectmodel.pages.Landingpage;
import com.demo.pageobjectmodel.pages.Launchpage;
import com.demo.pageobjectmodel.pages.Loginpage;
import com.demo.pageobjectmodel.testcases.base.Basetest;
import com.demo.pageobjectmodel.util.Constants;
import com.demo.pageobjectmodel.util.DataUtill;
import com.relevantcodes.extentreports.LogStatus;

public class Loginpagetest extends Basetest {
public String  testCaseName = "Loginpagetest";
	
	
	@Test(dataProvider = "getData")
	public void verifylogin(Hashtable<String,String> data){
		test = extent.startTest("Loginpage", "verifying the loginfunctionality");
		//checking runmode of test case and data
		if(!DataUtill.isTestExecutable(xls, testCaseName)  || data.get(Constants.RUNMODE_COL).equals("N")){
			test.log(LogStatus.SKIP, "Runmode is No");
		    throw new SkipException("Skipping the test case as Runmode is N");
		    
		    
		}
		//test = extent.startTest("Loginpage", "verifying the loginfunctionality");
		test.log(LogStatus.INFO, "launching the browser");
		System.setProperty("webdriver.chrome.driver", "D://Drivers//chromedriver.exe");
	    WebDriver driver = new ChromeDriver();
		
		Launchpage launchpage = new Launchpage(driver, test);
		PageFactory.initElements(driver, launchpage);
		Loginpage login= launchpage.gotopage();
		String actual_result ="";
		Object page = login.entercredentails(data.get("Username"), data.get("Password"));
		
		if (page instanceof Landingpage){
			actual_result = "Success";
			test.log(LogStatus.PASS, "login is successfull" +actual_result);
		}
		else{
			actual_result = "unsuccess";
			test.log(LogStatus.FAIL, "login is not successfull" +actual_result);
			login.takeScreenShot();
			
		}
			
		
		
	}
	@DataProvider
	public Object [][] getData()
	{
		return DataUtill.getData(xls, testCaseName);
	}
	
	@AfterMethod
	public void quit(){
		if(extent!=null){
			extent.endTest(test);
			extent.flush();
		}
		if(driver!=null)
			driver.quit();
	}
	
	
	
	
	
}
