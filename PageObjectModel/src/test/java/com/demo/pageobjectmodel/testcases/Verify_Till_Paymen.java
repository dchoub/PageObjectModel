package com.demo.pageobjectmodel.testcases;

import java.util.Hashtable;

import org.openqa.selenium.support.PageFactory;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.demo.pageobjectmodel.pages.Auto_Launching;
import com.demo.pageobjectmodel.pages.Detaildpage;
import com.demo.pageobjectmodel.testcases.base.Basetest;
import com.demo.pageobjectmodel.util.Constants;
import com.demo.pageobjectmodel.util.DataUtill;
import com.relevantcodes.extentreports.LogStatus;

public class Verify_Till_Paymen extends Basetest {
	
	String testCaseName ="Verify_Till_Paymen";
	//String MounseHoverItem="Dresses";
	
	
	@Test(dataProvider="getData")
	
	public void Verify_Till_PaymentPage(Hashtable<String,String> data){
		test=extent.startTest("automation practice test");
		test.log(LogStatus.INFO, "this is automation practice testcase to verify till payment page");
		 if (!DataUtill.isTestExecutable(xls, testCaseName) || data.get(Constants.RUNMODE_COL).equals("N"))
		 {
			 test.log(LogStatus.SKIP, "Runmode is No");
			 throw new SkipException("Skipping the test case as Runmode is N");
		 }
		 
		 
		   test.log(LogStatus.INFO, "launching the browser");
		   //System.setProperty("webdriver.chrome.driver", "D://Drivers//chromedriver.exe");
		    //WebDriver driver = new ChromeDriver();
		   openBrowser("Chrome");
			 
		    Auto_Launching autolaunch = new Auto_Launching(driver,test);
		    PageFactory.initElements(driver, autolaunch);
		    autolaunch.launchpage();
		    autolaunch.verify_Logo();
		    Object page = autolaunch.Mouse_hover_on(data.get("Item"));
		    
		    if(page instanceof Auto_Launching ){
		    	test.log(LogStatus.FAIL, "user does not navigate to" +data.get("Item"));
		    	reportFailure("User does not navigate to detaild page");
		    }
		    
		    else
		    {
		    	test.log(LogStatus.PASS, "user navigate to " +data.get("Item") );
		    }
		    
		    Detaildpage detailed = new Detaildpage(driver,test);
		    PageFactory.initElements(driver, detailed);
		   // detailed.selectProduct(data.get("SelectProduct"));
		    
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
