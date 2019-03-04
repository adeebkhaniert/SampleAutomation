/*
 * @author Adeeb
 * 
 */

package com.appToTest.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.appToTest.framework.BasePage;

public class AppPage extends BasePage{
	
	public AppPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//input[@name='q']")
	private WebElement GoogleSearchField;

	@FindBy(xpath = "//ul[@role='listbox']")
	private WebElement registerButton;

	

	@FindBy(xpath = "//i[@class='caret pull-right']")
	private List<WebElement> selectDropDownIcon;

	

	public void navigateToGoole(){
		driver.get("https://www.google.com");
	}
	
	public void enterAnyKeyInGoogleSearch(String keyToSearch){
		GoogleSearchField.sendKeys(keyToSearch);
	}
	
	public void storeAllOptionsInListAndAssertKey(String keyToSearch){
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		List allOptions = driver.findElements(By.xpath("//ul[@role='listbox']/li"));
		
		for (int i = 0; i < allOptions.size(); i++) {
			String option = ((WebElement) allOptions.get(i)).getText();
			System.out.println(option);
			Assert.assertTrue(option.contains(keyToSearch), "Option doesn't contain searched key");
		}
	}
}
