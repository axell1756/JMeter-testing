package com.cognizant.assessmentJUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class EditOwnerPage {

	@FindBy(id = "firstName")
	private WebElement firstName;

	@FindBy(xpath = "/html/body/app-root/app-owner-edit/div/div/form/div[7]/div/button[2]")
	private WebElement submitButton;

	public void changeFirstName(WebDriver driver, ExtentTest test, String newName) throws Exception {
		
		System.out.println(newName);

		test.log(LogStatus.INFO, "First name before changed" + test
				.addScreenCapture(Helpers.takeScreenshot(driver, Const.SCREENSHOT_PATH + "U2 - name before.png")));

		Actions action = new Actions(driver);

		// firstName.setAttribute("value", "");

		action.moveToElement(firstName).click().sendKeys(Keys.CONTROL).sendKeys("a").sendKeys(Keys.BACK_SPACE)
				.perform();
		
		firstName.sendKeys(newName);

		test.log(LogStatus.INFO, "First name after changed" + test
				.addScreenCapture(Helpers.takeScreenshot(driver, Const.SCREENSHOT_PATH + "U2 - name after.png")));
		
		action.moveToElement(submitButton).click().perform();

		Thread.sleep(3000);

	}

}
