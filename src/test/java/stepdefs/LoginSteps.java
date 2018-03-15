package stepdefs;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.security.UserAndPassword;

import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageobjects.DriverHelper;
import pageobjects.LoginPage;

public class LoginSteps {
	static WebDriver driver;
	private static LoginPage login;

	@Before
	public static void setUp() {
		System.out.println("=== SETUP ===");
		driver = DriverHelper.getWebDriver("CHROME");
		login = new LoginPage(driver);
	}

	@After
	public static void tearDown() {
		System.out.println("=== TEARDOWN ===");
		driver.quit();
	}

	@Then("^LP The user is on (.*) page$")
	public void userIsOnPage(String pageShortName) {
		assertTrue("The page isn't loaded correctly!", login.isPageLoaded(pageShortName));
	}

	@When("^LP The user inputs username and password:$")
	public void userInputsValidUsernameAndPassword(DataTable credsDataTable) throws Throwable {
		UserAndPassword creds = credsDataTable.asList(UserAndPassword.class).get(0);
		System.out.println("user inputs username and pass: " + login.credentialsToString(creds));
		login.inputCredentials(creds);
	}

	@When("^LP The user clicks (.*) button$")
	public void userClicksTheButton(String buttonName) {
		System.out.println("button clicked: " + buttonName);
		login.submit();
	}

	@Then("^The (.*) message appears$")
	public void messageAppears(String msg) {
		if (msg.equals("Success")) {
			login.successMsgDisplayed(msg);
		} else if (msg.equals("Failure")) {
			login.failureMsgDisplayed(msg);
		}
	}
}
