package com.cognizant.assessmentJUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class NewPetPage {

	@FindBy(id = "name")
	public WebElement petsName;

	@FindBy(xpath = "/html/body/app-root/app-pet-add/div/div/form/div[4]/input")
	private WebElement petsDob;

	@FindBy(id = "type")
	private WebElement petsType;
	
	@FindBy(xpath = "/html/body/app-root/app-pet-add/div/div/form/div[6]/div/button[2]")
	private WebElement submitButton;

	public void createNewPet(WebDriver driver, ExtentTest test, String name, String dob) throws Exception {
		test.log(LogStatus.INFO, "Adding details of a pet");
		Actions action = new Actions(driver);

		action.moveToElement(petsName).click().sendKeys(name).perform();

		action.moveToElement(petsDob).click().sendKeys(dob).perform();
		
		action.moveToElement(petsType).click().perform();

		action.sendKeys("c").sendKeys(Keys.ENTER).perform();
		
		test.log(LogStatus.INFO, "New pet's details" + test
				.addScreenCapture(Helpers.takeScreenshot(driver, Const.SCREENSHOT_PATH + "U4 - name before.png")));

		action.moveToElement(submitButton).click().perform();
	}
}
