package stepdefs;

import static org.junit.Assert.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.security.UserAndPassword;
import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageobjects.CreateUser;
import pageobjects.DriverHelper;

public class UserCreationSteps {

	static WebDriver driver;
	private static CreateUser createUser;

	@Before
	public static void setUp() {
		System.out.println("=== SETUP ===");
		driver = DriverHelper.getWebDriver("CHROME");
		createUser = new CreateUser(driver);
	}

	@After
	public static void tearDown() {
		System.out.println("=== TEARDOWN ===");
		driver.quit();
	}
	/*
	 * @Given("^The user is on CreateAUserPage$") public void
	 * userIsOnCreateUserTheBasePage() { if
	 * (!createUser.isPageLoaded("CreateUser")) { createUser.visitBasePage(); }
	 * }
	 */

	@Then("^The user is on (.*) page$")
	public void userIsOnPage(String pageShortName) {
		assertTrue("The page isn't loaded correctly!", createUser.isPageLoaded(pageShortName));
	}

	@Given("^Username and password is set to:$")
	public void userCredentialsAreSetTo(DataTable credsDataTable) throws Throwable {
		UserAndPassword creds = credsDataTable.asList(UserAndPassword.class).get(0);
		createUser.withCredentialsAndSubmit(creds);
		createUser.visitBasePage();
	}

	@When("^The user inputs username and password:$")
	public void userInputsValidUsernameAndPassword(DataTable credsDataTable) throws Throwable {
		UserAndPassword creds = credsDataTable.asList(UserAndPassword.class).get(0);
		System.out.println("user inputs username and pass: " + creds.getUsername() + " " + creds.getPassword());
		createUser.withCredentials(creds);
	}

	@When("^The user inputs (.*): (.*)$")
	public void userInputsValueToTheField(String fieldName, String valueToBeInputted) {
		createUser.inputTextIntoField(valueToBeInputted, fieldName);
	}

	@When("^The user clears (.*) field$")
	public void userClearsTheField(String fieldName) {
		createUser.clearField(fieldName);
	}

	@When("^The user clicks (.*) button$")
	public void userClicksTheButton(String buttonName) {
		System.out.println("button clicked: " + buttonName);
		createUser.submit();
	}

	@Then("^The user can see this credentials set above the form:$")
	public void userCanSeeHisCredentialsOnTheForm(DataTable credsDataTable) throws Throwable {
		UserAndPassword credsExpected = credsDataTable.asList(UserAndPassword.class).get(0);
		createUser.refresh();
		UserAndPassword credsActual = createUser.getCreds();
		assertEquals("Displayed credentials aren't correct!", createUser.credentialsToString(credsExpected),
				createUser.credentialsToString(credsActual));
	}

	@Then("^The user can see the (.*) massage and closing it$")
	public void userCanSeeMassageAndClosingIt(String messageType) {
		createUser.alertWithMsgIsDisplayed(messageType);
		createUser.acceptAlert();
	}
}
