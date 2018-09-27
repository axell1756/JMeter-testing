package com.cognizant.assessmentJUnit;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class SingleOwnerPage {

	@FindBy(xpath = "/html/body/app-root/app-owner-detail/div/div/table[1]/tbody/tr[1]/td/b")
	public WebElement ownersName;

	@FindBy(xpath = "/html/body/app-root/app-owner-detail/div/div/button[2]")
	private WebElement editOwnerButton;

	@FindBy(xpath = "/html/body/app-root/app-owner-detail/div/div/table[2]/tbody/tr/app-pet-list/table/tbody/tr/td[1]/dl/button[2]")
	private WebElement deletePetButton;

	@FindBy(xpath = "/html/body/app-root/app-owner-detail/div/div/button[3]")
	private WebElement addPetButton;

	public void editOwnerDetails(WebDriver driver, ExtentTest test) {
		test.log(LogStatus.INFO, "Navigating to an individual owner edit page");
		Actions action = new Actions(driver);

		action.moveToElement(editOwnerButton).click().perform();
	}

	public Boolean evaluate(WebDriver driver, ExtentTest test) throws Exception {
		Boolean status = false;
		List<WebElement> allNames = driver.findElements(
				By.xpath("/html/body/app-root/app-owner-detail/div/div/table[2]/tbody/tr/app-pet-list/table/tbody/tr"));

		for (WebElement ele : allNames) {
			if (ele.getText().equals("Leo")) {
				status = false;
				
				test.log(LogStatus.FAIL, "Pet is still there" + test
						.addScreenCapture(Helpers.takeScreenshot(driver, Const.SCREENSHOT_PATH + "U3 - pet deletion.png")));
				
			} else {
				status = true;
				
				test.log(LogStatus.PASS, "Pet has been deleted" + test
						.addScreenCapture(Helpers.takeScreenshot(driver, Const.SCREENSHOT_PATH + "U3 - pet deletion.png")));
			}

		}
		return status;
	}
	
	public Boolean deletePet(WebDriver driver, ExtentTest test) throws Exception {

		test.log(LogStatus.INFO, "Deleting a pet");
		Actions action = new Actions(driver);

		action.moveToElement(deletePetButton).click().perform();

		return evaluate(driver, test);

	}

	public void addNewPet(WebDriver driver, ExtentTest test) {

		test.log(LogStatus.INFO, "Navigating to add new pet");
		Actions action = new Actions(driver);

		action.moveToElement(addPetButton).click().perform();
		
	}
}
