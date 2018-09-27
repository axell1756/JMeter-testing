package com.cognizant.assessmentJUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class NewOwnerPage {

	@FindBy(id = "firstName")
	private WebElement firstName;
	
	@FindBy(id = "lastName")
	private WebElement lastName;
	
	@FindBy(id = "address")
	private WebElement address;
	
	@FindBy(id = "city")
	private WebElement city;
	
	@FindBy(id = "telephone")
	private WebElement telephone;
	
	public void newOwner(WebDriver driver, ExtentTest test, String first, String last, String addr, String c, String tel) throws Exception {
		
		test.log(LogStatus.INFO, "Adding new owner's details");
		
		firstName.sendKeys(first);
		lastName.sendKeys(last);
		address.sendKeys(addr);
		city.sendKeys(c);
		telephone.sendKeys(tel);
		
		test.log(LogStatus.INFO, "New details entered" + test
				.addScreenCapture(Helpers.takeScreenshot(driver, Const.SCREENSHOT_PATH + "U5 - name before.png")));
		
	}
	
}
