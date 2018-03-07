package com.demo.pageobjectmodel.util;

public class Constants {

	
	//Path
	public static final String CHROME_DRIVER_EXE="D://Drivers//chromedriver.exe";
	public static final String REPORTS_PATH = "D://reports//";
	public static final String Data_Path = System.getProperty("user.dir")+"//Data//Data.xlsx";
	
	//Locators
	public static final String LOGIN_USERNAME = "//*[@id='email']";
	public static final String LOGIN_PASSWORD = "//*[@id='pass']";
	public static final String PROFILEPAGE_LINK = "//*[@id='pagelet_welcome_box']/ul/li[1]/div/a";
	public static final String NAVIGATION_LABEL = "html/body/div[1]/div[1]/div/div[1]/div/div/div/div[2]/div[3]/div[2]/div/div/a";
	public static final String SETTINGS_LINK = "//span[text()='Settings']";
	public static final String PASSWORD_CHANGE = "//*[@id='SettingsPage_Content']/ul/li[4]/a";
	public static final String Logo = "//img[@class='img-responsive']";
	public static final String Item_Menu = "//ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li";
	public static final String Breadcrumb = "//div[@class='breadcrumb clearfix']/a";
	//page
	public static final String url = "https://www.facebook.com";
	public static final String TESTDATA_SHEET = "TestData";
	public static final String Auto_Url = "http://automationpractice.com";
	
	
	//column
	public static final String  RUNMODE_COL ="Runmode";
	public static final String TESTCASE_SHEET = "TestCases";
	
	//Grid
	public static final boolean GRID_RUN =true;
	
	

	
}
