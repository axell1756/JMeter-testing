package com.cognizant.assessmentJUnit;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class OwnersPage {

	@FindBy(xpath = "/html/body/app-root/app-owner-list/div/div/div/div/button")
	private WebElement newOwnerButton;

	public void selectIndividualOwner(WebDriver driver, ExtentTest test) {

		test.log(LogStatus.INFO, "Navigating to an individual owner");
		Actions action = new Actions(driver);

		WebElement manageOwner = (new WebDriverWait(driver, 10))
				.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(
						"body > app-root > app-owner-list > div > div > div > table > tbody > tr:nth-child(1) > td.ownerFullName > a")));

		action.moveToElement(manageOwner).click().perform();

	}

	public void addNewOwner(WebDriver driver, ExtentTest test) {

		test.log(LogStatus.INFO, "Navigate to adding new owner");
		Actions action = new Actions(driver);

		action.moveToElement(newOwnerButton).click().perform();

	}

	public Boolean validateNewOwner(WebDriver driver, ExtentTest test) {
		
		test.log(LogStatus.INFO, "Validating new owner's existance");

		Boolean status = true;
		List<WebElement> allNames = driver.findElements(By.xpath("/html/body/app-root/app-owner-list/div/div/div"));

		for (WebElement ele : allNames) {
			if (ele.getText().equals("Marks Gniteckis")) {
				status = true;
			} else {
				status = false;
			}
		}
		return status;

	}
}
