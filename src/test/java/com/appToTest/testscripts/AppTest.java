package com.appToTest.testscripts;


import org.testng.annotations.Test;

import com.appToTest.framework.BaseTest;

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