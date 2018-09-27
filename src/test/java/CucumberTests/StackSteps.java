package CucumberTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.cognizant.assessmentJUnit.Const;
import com.cognizant.assessmentJUnit.EditOwnerPage;
import com.cognizant.assessmentJUnit.Helpers;
import com.cognizant.assessmentJUnit.MainPage;
import com.cognizant.assessmentJUnit.NewOwnerPage;
import com.cognizant.assessmentJUnit.NewPetPage;
import com.cognizant.assessmentJUnit.OwnersPage;
import com.cognizant.assessmentJUnit.SingleOwnerPage;
import com.cognizant.assessmentJUnit.TestSuite;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import io.restassured.specification.RequestSpecification;

public class StackSteps {
	private WebDriver driver;

	public ExtentTest test;

	public RequestSpecification req;

	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", Const.DRIVER_PATH + "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Given("^a vet$")
	public void a_vet() throws Throwable {
		test = TestSuite.report.startTest("U1 - Displaying visits available for a pet");
		driver.get(Const.INDEX_URL);

	}

	@When("^I navigate to All Owners$")
	public void i_navigate_to_all_owners() throws Throwable {
		MainPage index = PageFactory.initElements(driver, MainPage.class);

		index.navigateToOwners(driver, test);

	}

	@When("^I select any owner$")
	public void i_select_any_owner() throws Throwable {
		OwnersPage owners = PageFactory.initElements(driver, OwnersPage.class);
		owners.selectIndividualOwner(driver, test);
	}

	@Then("^I can see the visits available for animals$")
	public void i_can_see_the_care_available_for_animals() throws Throwable {
		SingleOwnerPage owner = PageFactory.initElements(driver, SingleOwnerPage.class);

		if (owner.ownersName.getText().equals("George Franklin")) {
			test.log(LogStatus.PASS, "Visits page displayed successfully" + test
					.addScreenCapture(Helpers.takeScreenshot(driver, Const.SCREENSHOT_PATH + "U1 - details.png")));
		} else {
			test.log(LogStatus.FAIL, "Visits page is not visible" + test
					.addScreenCapture(Helpers.takeScreenshot(driver, Const.SCREENSHOT_PATH + "U1 - details.png")));
		}

		TestSuite.report.endTest(test);
		assertEquals("Visits page is not visible", "George Franklin", owner.ownersName.getText());

	}

	@Given("^an admin$")
	public void an_admin() throws Throwable {

		driver.get(Const.INDEX_URL);
	}

	@When("^I update a record$")
	public void i_update_a_record() throws Throwable {

		test = TestSuite.report.startTest("U2 - Upadting details");
		
		MainPage index = PageFactory.initElements(driver, MainPage.class);

		index.navigateToOwners(driver, test);

		OwnersPage owners = PageFactory.initElements(driver, OwnersPage.class);

		owners.selectIndividualOwner(driver, test);

		SingleOwnerPage owner = PageFactory.initElements(driver, SingleOwnerPage.class);

		owner.editOwnerDetails(driver, test);

		EditOwnerPage edit = PageFactory.initElements(driver, EditOwnerPage.class);

		edit.changeFirstName(driver, test, "Mark");

		TestSuite.report.endTest(test);

	}

	@Then("^the correct details are now shown$")
	public void the_correct_details_are_now_shown() throws Throwable {

		
		SingleOwnerPage owner = PageFactory.initElements(driver, SingleOwnerPage.class);
		
		if (owner.ownersName.getText().equals("Mark Franklin")) {
			test.log(LogStatus.PASS, "Name has been changed successfully" + test
					.addScreenCapture(Helpers.takeScreenshot(driver, Const.SCREENSHOT_PATH + "U2 - details.png")));
		} else {
			test.log(LogStatus.FAIL, "Name has been changed unsuccessfully" + test
					.addScreenCapture(Helpers.takeScreenshot(driver, Const.SCREENSHOT_PATH + "U2 - details.png")));
		}
	}

	@When("^I delete a animal$")
	public void i_delete_a_animal() throws Throwable {
		
		test = TestSuite.report.startTest("U£ - Deleting Animal");
		
		MainPage index = PageFactory.initElements(driver, MainPage.class);

		index.navigateToOwners(driver, test);

		OwnersPage owners = PageFactory.initElements(driver, OwnersPage.class);

		owners.selectIndividualOwner(driver, test);

		SingleOwnerPage owner = PageFactory.initElements(driver, SingleOwnerPage.class);
		
		owner.deletePet(driver, test);
		
	}

	@Then("^animal is not displayed anymore$")
	public void animal_is_not_displayed_anymore() throws Throwable {
		
		SingleOwnerPage owner = PageFactory.initElements(driver, SingleOwnerPage.class);
		
		assertTrue(owner.deletePet(driver, test));
		
	}

	@When("^I add new records$")
	public void i_add_new_records() throws Throwable {
		
		test = TestSuite.report.startTest("U4 - Adding new record");
		MainPage index = PageFactory.initElements(driver, MainPage.class);

		index.navigateToOwners(driver, test);

		OwnersPage owners = PageFactory.initElements(driver, OwnersPage.class);

		owners.selectIndividualOwner(driver, test);

		SingleOwnerPage owner = PageFactory.initElements(driver, SingleOwnerPage.class);
		
		owner.addNewPet(driver, test);
		
		NewPetPage petPage = PageFactory.initElements(driver, NewPetPage.class);
		
		petPage.createNewPet(driver, test, "Leo", "2010/08/09");
		
	}

	@Then("^the records are correct$")
	public void the_records_are_correct() throws Throwable {
		SingleOwnerPage owner = PageFactory.initElements(driver, SingleOwnerPage.class);
		
		assertFalse(owner.evaluate(driver, test));
	}

	@When("^I add new owners to the records$")
	public void i_add_new_owners_to_the_records() throws Throwable {
		
		test = TestSuite.report.startTest("U5 - Adding new owner");
		MainPage index = PageFactory.initElements(driver, MainPage.class);

		index.navigateToOwners(driver, test);
		
		OwnersPage owners = PageFactory.initElements(driver, OwnersPage.class);
		
		owners.addNewOwner(driver, test);
		
		NewOwnerPage newOwner = PageFactory.initElements(driver, NewOwnerPage.class);
		
		newOwner.newOwner(driver, test, "Marks", "Gniteckis", "Test", "Test Test", "012458769");
	}

	@Then("^the details show the change$")
	public void the_details_show_the_change() throws Throwable {
		OwnersPage owners = PageFactory.initElements(driver, OwnersPage.class);
		
		assertTrue(owners.validateNewOwner(driver, test));
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
		TestSuite.report.flush();
	}

}