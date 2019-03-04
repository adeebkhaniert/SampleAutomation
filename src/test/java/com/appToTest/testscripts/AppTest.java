package com.appToTest.testscripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.appToTest.framework.BaseTest;
import com.appToTest.pageobjects.AppPage;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class AppTest extends BaseTest{
	
	
	
  @Test
  public void googletest() throws InterruptedException 
  {
	
	reportLog("Navigate to Google");
	apppage.navigateToGoole();
	
	reportLog("Enter Wedding Keyword");
	apppage.enterAnyKeyInGoogleSearch("wedding");
	
	reportLog("Select all options in list and assert that all option contain search keyword");
	apppage.storeAllOptionsInListAndAssertKey("wedding");
  }


}