package com.appToTest.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.appToTest.pageobjects.AppPage;


import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
		
	public WebDriver driver;
	protected AppPage apppage = PageFactory.initElements(driver, AppPage.class);
	
//	public WebDriver getWebDriver1() {
//		return driver;
//	}
	
	
	 @BeforeClass
	  public void beforeClass() throws InterruptedException {
		  
		  WebDriverManager.chromedriver().setup();
	      driver = new ChromeDriver();
	      driver.manage().window().maximize();
		  Thread.sleep(2000);
	  }
	 
	
	
	 @AfterClass
	  public void afterClass() {
		  driver.quit();
	  }
}
