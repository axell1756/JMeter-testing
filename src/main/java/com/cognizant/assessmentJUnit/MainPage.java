package com.cognizant.assessmentJUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class MainPage {
	
	@FindBy(xpath = "/html/body/app-root/div[1]/nav/div/ul/li[2]")
	private WebElement ownersMenu;
	
	@FindBy(xpath="/html/body/app-root/div[1]/nav/div/ul/li[2]/ul/li[1]")
	private WebElement allOwners;
	
	public void navigateToOwners(WebDriver driver, ExtentTest test) {
		
		test.log(LogStatus.INFO, "Navigation to All owners");
		Actions action = new Actions(driver);
		
		action.moveToElement(ownersMenu).click().perform();
		action.moveToElement(allOwners).click().perform();
		
	}

}
