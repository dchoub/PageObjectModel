package com.demo.pageobjectmodel.base;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.demo.pageobjectmodel.common.Topmenu;
import com.demo.pageobjectmodel.util.Constants;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Basepage {
	public WebDriver driver;
	Topmenu menu;
	public ExtentTest test;
	public Basepage(){}

	public Basepage(WebDriver driver, ExtentTest test){
		this.driver=driver;
		this.test=test;
		menu = PageFactory.initElements(driver, Topmenu.class);

	}


	public Topmenu getmenu()
	{
		return menu;
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


	public boolean isElementPresent(String object){
		test.log(LogStatus.INFO, "finding element " +object);
		int size = driver.findElements(By.xpath(object)).size();

		if(size!=0)
			return true;
		else {
			return false;
		}

	}

	public void MouseHoverOn(WebElement object)  {
		test.log(LogStatus.INFO, "Driver will mouser hover on " +object);

		Actions action = new Actions(driver);
		//WebElement element =  driver.findElement(By.xpath(object));
		action.moveToElement(object).perform();
		wait(5);
		test.log(LogStatus.INFO, "Mouse hover on " +object);
		WebElement subelement = driver.findElement(By.xpath("//ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li[2]/ul/li[2]"));
		test.log(LogStatus.INFO, "click on" +subelement);
		action.moveToElement(subelement).click(subelement).build().perform();
		
	
		wait(5);



	}

	public void wait(int timeToWaitinSec){
		try{
			Thread.sleep(timeToWaitinSec *1000);
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void click_on_link(String object){
		test.log(LogStatus.INFO, "In click function for " +object);

		if (isElementPresent(object)){
			WebElement  cb = driver.findElement(By.xpath(object));
			cb.click();
			wait(2);
		}
		else{
			test.log(LogStatus.FAIL, "Element is not present" +object);

		}


	}


}
