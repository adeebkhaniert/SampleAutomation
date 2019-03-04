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

public class AppTest{
	
	public WebDriver driver;
	
  @Test
  public void googletest() throws InterruptedException 
  {
	
	//AppPage apppage = PageFactory.initElements(driver, AppPage.class);
	//driver.navigate().to("https://www.google.com");
	AppPage apppage =new AppPage();
	
	apppage.navigateToGoole();
	
	apppage.enterAnyKeyInGoogleSearch("wedding");

	apppage.storeAllOptionsInListAndAssertKey("wedding");
  }
	  @BeforeClass
  public void beforeClass() {
	  
	  WebDriverManager.chromedriver().setup();
      driver = new ChromeDriver();
      driver.manage().window().maximize();
	  
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}