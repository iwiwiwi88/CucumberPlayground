package stepdefs;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageobjects.CreateUser;
import pageobjects.Credentials;
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

	@Given("^The user is on Add a User page$")
	public void userIsOnUserTheBasePage() {
		createUser.visitBasePage();
	}

	@Given("^Username and password is set to:$")
	public void userCredentialsAreSetTo(DataTable credsDataTable) throws Throwable {
		Credentials creds = credsDataTable.asList(Credentials.class).get(0);
		createUser.withAndSubmit(creds);
		createUser.visitBasePage();
	}

	@When("^The user inputs username and password:$")
	public void userInputsValidUsernameAndPassword(DataTable credsDataTable) throws Throwable {
		Credentials creds = credsDataTable.asList(Credentials.class).get(0);
		System.out.println("user inputs username and pass: " + creds.getUsername() + " " + creds.getPassword());
		createUser.with(creds);
	}

	@When("^The user inputs (.*): (.*)$")
	public void userInputsValueToTheField(String fieldName, String valueToBeInputted) {
		throw new PendingException();
	}

	@When("^The user clears (.*) field$")
	public void userClearsTheField(String fieldName) {
		throw new PendingException();
	}

	@When("^The user clicks (.*) button$")
	public void userClicksTheButton(String buttonName) {
		System.out.println("button clicked: " + buttonName);
		createUser.submit();
	}

	@Then("^The user can see this credentials set above the form:$")
	public void userCanSeeHisCredentialsOnTheForm(DataTable credsDataTable) throws Throwable {
		Credentials credsExpected = credsDataTable.asList(Credentials.class).get(0);
		Credentials credsActual = createUser.getCreds();
		assertTrue(credsExpected.equals(credsActual));
	}

	@Then("^The user can see the (.*) massage and closing it$")
	public void userCanSeeMassageAndClosingIt(String massage) {
		throw new PendingException();
	}
}
