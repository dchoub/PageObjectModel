package com.demo.pageobjectmodel.testcases.base;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import com.demo.pageobjectmodel.util.Constants;
import com.demo.pageobjectmodel.util.ExtentManager;
import com.demo.pageobjectmodel.util.Xls_Reader;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Basetest {
	
	public ExtentReports extent = ExtentManager.getInstance();
	public ExtentTest test;

	public WebDriver driver;
	public Xls_Reader xls = new Xls_Reader (Constants.Data_Path);
	
	
	
	public void openBrowser(String browserType){

		if (!Constants.GRID_RUN){
			if(browserType.equals("Mozilla")){
				driver = new FirefoxDriver();

			}else if(browserType.equals("Chrome")){
				System.setProperty("webdriver.chrome.driver",Constants.CHROME_DRIVER_EXE);

				driver=new ChromeDriver();
			}

			else if(browserType.equals("IE")){
				// set the IE server exe path and initialize
			}
		}
		else{//Grid
			DesiredCapabilities  cap = null;
			if(browserType.equals("Mozilla")){
				cap = DesiredCapabilities.firefox();
				cap.setBrowserName("firefox");
				cap.setJavascriptEnabled(true);
				cap.setPlatform(org.openqa.selenium.Platform.WINDOWS);
			}else if(browserType.equals("Chrome")){
				cap = DesiredCapabilities.chrome();
				cap.setBrowserName("chrome");
				cap.setPlatform(org.openqa.selenium.Platform.WINDOWS);

			}
			try{
				driver= new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
			}
			catch (Exception e){
				e.printStackTrace();
			}
		}

		// max
		driver.manage().window().maximize();
		// implicit wait
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
     
     public void reportFailure(String failmessage){
    	 test.log(LogStatus.FAIL, failmessage);
    	 takeScreenShot();
    	 Assert.fail(failmessage);
    	 
    	 
     }
     
     public void takeScreenShot(){
 		Date d=new Date();
 		String screenshotFile=d.toString().replace(":", "_").replace(" ", "_")+".png";
 		String filePath=Constants.REPORTS_PATH+"screenshots//"+screenshotFile;
 		// store screenshot in that file
 		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

 		try {
 			FileUtils.copyFile(scrFile, new File(filePath));
 		} catch (IOException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
 		test.log(LogStatus.INFO,test.addScreenCapture(filePath));
 	}
     
    
}
