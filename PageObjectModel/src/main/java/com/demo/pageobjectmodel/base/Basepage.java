package com.demo.pageobjectmodel.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.demo.pageobjectmodel.common.Topmenu;

public class Basepage {
public WebDriver driver;
Topmenu menu;

public Basepage(WebDriver driver){
	this.driver=driver;
	menu = PageFactory.initElements(driver, Topmenu.class);
	
}


   public Topmenu getmenu()
   {
	   return menu;
   }


}
