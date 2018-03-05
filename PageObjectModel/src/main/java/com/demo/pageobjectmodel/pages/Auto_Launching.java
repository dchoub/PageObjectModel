package com.demo.pageobjectmodel.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demo.pageobjectmodel.base.Basepage;
import com.demo.pageobjectmodel.util.Constants;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Auto_Launching extends Basepage {
	
	public Auto_Launching(WebDriver driver, ExtentTest test){
		super (driver,test);
	}
	
	
	@FindBy(xpath=Constants.Logo)
	WebElement Logo_page;
	
	
	public void launchpage(){
		test.log(LogStatus.INFO, "we are opening the automationpractice url");
        driver.get(Constants.Auto_Url);
        
		
	}
	
	public void verify_Logo(){
		
	test.log(LogStatus.INFO, "verifying if page has opend successfully");
	boolean page_present = isElementPresent(Constants.Logo);
	
	if (page_present){
		test.log(LogStatus.PASS, "Page has opened successfully");
	}
	else
		test.log(LogStatus.FAIL, "Page has not opened successfully");
	takeScreenShot();
	
		
		
	}
	public Object Mouse_hover_on(String object){
		test.log(LogStatus.INFO, "user will mouse hover on top menu");

		int size= driver.findElements(By.xpath(Constants.Item_Menu)).size();
		if(size!=0){
			List<WebElement> Alllinks = driver.findElements(By.xpath(Constants.Item_Menu));
			for(int i=0; i<size; i++){

				String text = Alllinks.get(i).getText();
				test.log(LogStatus.INFO, "checking now"+text);
				if(text.equalsIgnoreCase(object)){
					MouseHoverOn(Alllinks.get(i));

					break;
				}
				else{
					test.log(LogStatus.INFO, "Element not present" +object);
				}

			}
		}
		else {
			test.log(LogStatus.INFO, "Element not present");
		}
		String Element = Constants.Breadcrumb + "[contains(text(),"+"'"+object+"'"+")]";
		boolean ClickSuccess = isElementPresent(Element);

		if (ClickSuccess){
			test.log(LogStatus.INFO, "Clicking is success on  " +object);
			Detaildpage detaild = new Detaildpage(driver,test);
			PageFactory.initElements(driver, detaild);
			return detaild;}


		else {
			test.log(LogStatus.INFO, "Clicking is not success on  " +object);
			Auto_Launching autolaunch = new Auto_Launching(driver,test);
			PageFactory.initElements(driver, autolaunch);
			return autolaunch;
		}
	}

	}
	



