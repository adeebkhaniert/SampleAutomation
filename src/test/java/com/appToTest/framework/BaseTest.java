package com.appToTest.framework;

import java.util.concurrent.TimeUnit;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;


import com.appToTest.pageobjects.AppPage;


public abstract class BaseTest {
	
	static
	WebDriver driver;

	private static final Logger logger = LoggerFactory.getLogger(BaseTest.class);
	private static final String BREAK_LINE = "</br>";
	

	protected AppPage apppage;
	
	

	@BeforeTest
	public void browserSetUp() throws Exception {
		
	            WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                driver.manage().window().maximize();             
		
	    
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		Thread.sleep(4000);
		//define page object classes
		apppage = PageFactory.initElements(getWebDriver(), AppPage.class);
		
	}
	

	@AfterSuite
	public void tearDownSuite() {
		driver.quit();
	}
	

	public WebDriver getWebDriver() {
		return driver;
	}



	public void reportLog(String message) {
		message = BREAK_LINE + message;
		logger.info("Message: " + message);
		Reporter.log(message);
	}

	
}
